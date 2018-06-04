package com.tencent.xinge;

public class RESTAPI {

  /**
   * POST 请求方式
   */
  public static final String HTTP_POST = "POST";
  /**
   * GET 请求方式
   */
  public static final String HTTP_GET = "GET";

  public static final int DEVICE_ALL = 0;
  public static final int DEVICE_BROWSER = 1;
  public static final int DEVICE_PC = 2;
  public static final int DEVICE_ANDROID = 3;
  public static final int DEVICE_IOS = 4;
  public static final int DEVICE_WINPHONE = 5;

  public static final int IOSENV_PROD = 1;
  public static final int IOSENV_DEV = 2;

  public static final long IOS_MIN_ID = 2200000000L;

  /**
   * 接口域名
   */
  public static final String RESTAPI_DOMAINS = "http://openapi.xg.qq.com/";
  /**
   * 版本号
   */
  public static final String RESTAPI_VERSIONS = "v2";

  /**
   * 设备单推，使用指定的一个设备标识(Device Token)进行消息的推送
   */
  public static final String RESTAPI_PUSHSINGLEDEVICE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/single_device";

  /**
   * 账号单推，指对通过客户端SDK绑定接口绑定的指定单个账号的推送，iOS和Android的SDK都提供相应的接口
   */
  public static final String RESTAPI_PUSHSINGLEACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/single_account";
  
  /**
   * 账号群推，是指对通过客户端SDK绑定接口绑定的账号的群组推送，iOS和Android的SDK都提供相应的接口
   */
  public static final String RESTAPI_PUSHACCOUNTLIST =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/account_list";
  
  /**
   * 全量推送<br>
   * 此接口用于对全部设备推送消息，后台对本接口的调用频率有限制<br>
   * 1)1小时内不能推相同内容的消息<br>
   * 2)1小时内最多调用此接口30次 <br>
   */
  public static final String RESTAPI_PUSHALLDEVICE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/all_device";
  public static final String RESTAPI_PUSHTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/tags_device";
  public static final String RESTAPI_QUERYPUSHSTATUS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/get_msg_status";
  public static final String RESTAPI_QUERYDEVICECOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_device_num";
  public static final String RESTAPI_QUERYTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_app_tags";
  public static final String RESTAPI_CANCELTIMINGPUSH =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/cancel_timing_task";
  public static final String RESTAPI_BATCHSETTAG =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/batch_set";
  public static final String RESTAPI_BATCHDELTAG =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/batch_del";
  public static final String RESTAPI_QUERYTOKENTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_token_tags";
  public static final String RESTAPI_QUERYTAGTOKENNUM =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_tag_token_num";
  public static final String RESTAPI_CREATEMULTIPUSH =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/create_multipush";
  public static final String RESTAPI_PUSHACCOUNTLISTMULTIPLE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/account_list_multiple";
  public static final String RESTAPI_PUSHDEVICELISTMULTIPLE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/device_list_multiple";
  public static final String RESTAPI_QUERYINFOOFTOKEN =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_token_info";
  public static final String RESTAPI_QUERYTOKENSOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_account_tokens";
  public static final String RESTAPI_DELETETOKENOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/del_app_account_tokens";
  public static final String RESTAPI_DELETEALLTOKENSOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/del_app_account_all_tokens";

}
