package com.tencent.xinge.api;

/**
 * v3 REST API
 *
 */
public class RESTAPIV3 extends RESTAPI {

    /**
     * 版本号 v3
     */
    public static final String RESTAPI_VERSIONS = "v3";
  
    /**
     * 接口域名
     */
    public static final String RESTAPI_DOMAINS = "https://openapi.xg.qq.com/";

    /**
     * 所有推送目标都采用相同的 URL 发起请求
     */
    public static final String RESTAPI_PUSH =
            RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/app";

    /**
     * v3/tag
     */
    public static final String RESTAPI_TAG =
            RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/device/tag";

    /**
     * api  请求地址
     */
    String domainUrl = RESTAPI_DOMAINS;

    /**
     * tag 请求地址
     */
    String restApiTagUrl = RESTAPI_TAG;

    /**
     * push 请求地址
     */
    String restApiPushUrl = RESTAPI_PUSH;

    public RESTAPIV3() {
        domainUrl = RESTAPI_DOMAINS;
    }

    public RESTAPIV3(String baseUrl) {
        this.domainUrl = baseUrl;
    }

    public void setDomainUrl(String baseUrl) {
        this.domainUrl = baseUrl;
    }

    public String getRestApiTagUrl() {
        restApiTagUrl = domainUrl + RESTAPI_VERSIONS + "/device/tag";
        return restApiTagUrl;
    }

    public String getRestApiPushUrl() {
        restApiPushUrl = domainUrl + RESTAPI_VERSIONS + "/push/app";
        return restApiPushUrl;
    }


}
