package com.tencent.xinge;

import com.google.common.base.Charsets;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.tencent.xinge.push.app.PushAppRequest;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.tencent.xinge.api.RESTAPI_V3;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * 提供V3接口<br>
 * 1. v3中appId是String类型，v2中是long <br>
 * 2. v3中请求信息是json类型，v2中是key-value字符串<br>
 * <p>
 * 接口文档说明请访问：<br>
 * http://xg.qq.com/docs/server_api.html
 */
public class XingeApp {


    private String authString = null;
    private String authStringEnc = null;

    /**
     * HTTP Header Authorization 的值：Basic base64_auth_string<br>
     * base64_auth_string 生成规则是：base64(appId:secretKey)<br>
     * 留意 appId 与 secretKey 中间使用 ":" 冒号隔开<br>
     *
     * @param appId     appId
     * @param secretKey secretKey
     */
    public XingeApp(String appId, String secretKey) {
        this.authString = appId + ":" + secretKey;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        authStringEnc = new String(authEncBytes);
    }

    /**
     * @param authStringEnc base64_auth_string
     */
    public XingeApp(String authStringEnc) {
        this.authStringEnc = authStringEnc;
    }

    /**
     * @param jsonRequest jsonRequest
     * @return 通用基础返回值，是所有请求的响应中都会包含的字段
     */
    public JSONObject pushApp(String jsonRequest) {

        return callRestful(RESTAPI_V3.RESTAPI_PUSHSINGLEDEVICE, jsonRequest);

    }

    /**
     *
     * @param pushAppRequest PushAppRequest
     * @return 通用基础返回值，是所有请求的响应中都会包含的字段
     */
    public JSONObject pushApp(PushAppRequest pushAppRequest) {
        String jsonRequest = pushAppRequest.toString();
       return pushApp(jsonRequest);
    }


    /**
     *
     * @param jsonRequest jsonRequest
     * @return 通用基础返回值，是所有请求的响应中都会包含的字段
     */
    public JSONObject deviceTag(String jsonRequest) {
        return callRestful(RESTAPI_V3.RESTAPI_TAG, jsonRequest);
    }

    private synchronized JSONObject callRestful(String apiAddress, String jsonRequestString) {

        URL url;
        HttpsURLConnection https = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String ret = "";
        String temp;
        JSONObject jsonRet = null;

        try {
            url = new URL(null, apiAddress, new sun.net.www.protocol.https.Handler());
            https = (HttpsURLConnection) url.openConnection();
            https.setHostnameVerifier(new TrustAnyHostnameVerifier());
            https.setRequestMethod(RESTAPI_V3.HTTP_POST);
            https.setDoOutput(true);
            https.setDoInput(true);
            https.setUseCaches(false);
            https.setConnectTimeout(10000);
            https.setReadTimeout(10000);
            https.setRequestProperty("Content-Type", "application/json");
            https.setRequestProperty("Authorization", "Basic " + authStringEnc);
            https.setRequestProperty("Connection", "Keep-Alive ");


          byte[] out = jsonRequestString.getBytes(Charsets.UTF_8);
            int length = out.length;

            https.setFixedLengthStreamingMode(length);

            https.connect();

            try {
                DataOutputStream os = new DataOutputStream(https.getOutputStream());
                os.write(out);
                os.close();

            } catch (Exception e) {

            }


            https.getOutputStream().flush();
            https.getOutputStream().close();

            InputStream in = null;
            if (https.getResponseCode() >= 400) {
              in = https.getErrorStream();
            } else {
              in = https.getInputStream();
            }
            isr = new InputStreamReader(in);

            isr = new InputStreamReader(in);
            br = new BufferedReader(isr);
            while ((temp = br.readLine()) != null) {
                ret += temp;
            }
            jsonRet = new JSONObject(ret);

        } catch (MalformedURLException e) {
            jsonRet = new JSONObject();
            jsonRet.put("ret_code", 10100);
            jsonRet.put("err_msg", stringifyError(e));

        } catch (IOException e) {
            jsonRet = new JSONObject();
            jsonRet.put("ret_code", 10101);
            jsonRet.put("err_msg", stringifyError(e));
            
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (https != null) {
                https.disconnect();
            }
        }

        return jsonRet;
    }

    public static String stringifyError(Throwable error) {
        StringWriter result = new StringWriter();
        PrintWriter printer = new PrintWriter(result);
        error.printStackTrace(printer);
        printer.close();
        return result.toString();
    }

    public class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            // 直接返回true
            return true;
        }
    }

}
