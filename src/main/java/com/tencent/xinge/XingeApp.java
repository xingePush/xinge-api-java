package com.tencent.xinge;

import java.io.*;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import com.tencent.xinge.push.app.PushAppRequest;
import okhttp3.*;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.tencent.xinge.api.RESTAPIV3;

/**
 * 提供V3接口<br>
 * 1. v3中appId是String类型，v2中是long <br>
 * 2. v3中请求信息是json类型，v2中是key-value字符串<br>
 * <p>
 * 接口文档说明请访问：<br>
 * http://xg.qq.com/docs/server_api.html
 */
public class XingeApp {

    public static MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");

    private String authString = null;
    private String authStringEnc = null;


    private RESTAPIV3 restapiV3 = new RESTAPIV3();

    private OkHttpClient client;

    /**
     * HTTP Header Authorization 的值：Basic base64_auth_string<br>
     * base64_auth_string 生成规则是：base64(appId:secretKey)<br>
     * 留意 appId 与 secretKey 中间使用 ":" 冒号隔开<br>
     *
     * @param appId     appId
     * @param secretKey secretKey
     */
    private XingeApp(String appId, String secretKey) {
        this.authString = appId + ":" + secretKey;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        authStringEnc = new String(authEncBytes);

        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                .build();
    }

    private XingeApp(Builder builder){
        this.authString = builder.appId + ":" + builder.secretKey;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        authStringEnc = new String(authEncBytes);

        client = new OkHttpClient.Builder()
                .proxy(builder.proxy)
                .connectTimeout(builder.connectTimeOut, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(builder.readTimeOut, TimeUnit.SECONDS)//设置读取超时时间
                .build();
    }



    /**
     * @param authStringEnc base64_auth_string
     */
    /**
    public XingeApp(String authStringEnc) {
        this.authStringEnc = authStringEnc;
    }**/

    /**
     * 设置信鸽api http 服务器地址
     * @param url
     */
    public void setDomainUrl(String url){
        restapiV3.setDomainUrl(url);
    }
    /**
     * @param jsonRequest jsonRequest
     * @return 通用基础返回值，是所有请求的响应中都会包含的字段
     */
    public JSONObject pushApp(String jsonRequest) {
        return callRestful(restapiV3.getRestApiPushUrl(), jsonRequest);
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
        return callRestful(restapiV3.getRestApiTagUrl(), jsonRequest);
    }

    private JSONObject callRestful(String apiAddress, String jsonRequestString) {
        JSONObject jsonRet = null;

        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, jsonRequestString);
        Request request = new Request.Builder()
                .url(apiAddress)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic " + authStringEnc)
                .post(requestBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                if(response.code() == 200){
                    String retMsg = response.body().string();
                    System.out.println(retMsg);
                    jsonRet = new JSONObject(retMsg);
                }
                else{
                    jsonRet = new JSONObject();
                    jsonRet.put("ret_code", 10101);
                    jsonRet.put("err_msg", "CallApiError,HttpStatus Code:" + response.code());
                }
            }
            response.close();
        } catch (IOException e) {
            jsonRet = new JSONObject();
            jsonRet.put("ret_code", 10100);
            jsonRet.put("err_msg", stringifyError(e));
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

    public static class Builder {
        private String appId;
        private String secretKey;
        private Proxy proxy = Proxy.NO_PROXY;
        private int connectTimeOut;
        private int readTimeOut;

        public Builder() {
            proxy = Proxy.NO_PROXY;
            connectTimeOut = 10;
            readTimeOut = 10;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder secretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder connectTimeOut(int connectTimeOut) {
            this.connectTimeOut = connectTimeOut;
            return this;
        }

        public Builder readTimeOut(int readTimeOut) {
            this.readTimeOut = readTimeOut;
            return this;
        }

        public XingeApp build() {
            if (appId == null || secretKey == null) {
                throw new IllegalArgumentException("Please set appId and secret key.");
            }

            return new XingeApp(this);
        }

    }


}
