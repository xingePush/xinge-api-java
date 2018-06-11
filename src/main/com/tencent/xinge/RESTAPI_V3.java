package com.tencent.xinge;

/**
 * v3 REST API
 *
 */
public class RESTAPI_V3 extends RESTAPI {
 

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
  public static final String RESTAPI_PUSHSINGLEDEVICE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/app";

}
