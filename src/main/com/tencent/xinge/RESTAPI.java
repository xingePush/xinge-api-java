package com.tencent.xinge;

public class RESTAPI {

  public static final String HTTP_POST = "POST";
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

  public static final String RESTAPI_PUSHSINGLEDEVICE =
      "http://openapi.xg.qq.com/v2/push/single_device";
  public static final String RESTAPI_PUSHSINGLEACCOUNT =
      "http://openapi.xg.qq.com/v2/push/single_account";
  public static final String RESTAPI_PUSHACCOUNTLIST =
      "http://openapi.xg.qq.com/v2/push/account_list";
  public static final String RESTAPI_PUSHALLDEVICE = "http://openapi.xg.qq.com/v2/push/all_device";
  public static final String RESTAPI_PUSHTAGS = "http://openapi.xg.qq.com/v2/push/tags_device";
  public static final String RESTAPI_QUERYPUSHSTATUS =
      "http://openapi.xg.qq.com/v2/push/get_msg_status";
  public static final String RESTAPI_QUERYDEVICECOUNT =
      "http://openapi.xg.qq.com/v2/application/get_app_device_num";
  public static final String RESTAPI_QUERYTAGS = "http://openapi.xg.qq.com/v2/tags/query_app_tags";
  public static final String RESTAPI_CANCELTIMINGPUSH =
      "http://openapi.xg.qq.com/v2/push/cancel_timing_task";
  public static final String RESTAPI_BATCHSETTAG = "http://openapi.xg.qq.com/v2/tags/batch_set";
  public static final String RESTAPI_BATCHDELTAG = "http://openapi.xg.qq.com/v2/tags/batch_del";
  public static final String RESTAPI_QUERYTOKENTAGS =
      "http://openapi.xg.qq.com/v2/tags/query_token_tags";
  public static final String RESTAPI_QUERYTAGTOKENNUM =
      "http://openapi.xg.qq.com/v2/tags/query_tag_token_num";
  public static final String RESTAPI_CREATEMULTIPUSH =
      "http://openapi.xg.qq.com/v2/push/create_multipush";
  public static final String RESTAPI_PUSHACCOUNTLISTMULTIPLE =
      "http://openapi.xg.qq.com/v2/push/account_list_multiple";
  public static final String RESTAPI_PUSHDEVICELISTMULTIPLE =
      "http://openapi.xg.qq.com/v2/push/device_list_multiple";
  public static final String RESTAPI_QUERYINFOOFTOKEN =
      "http://openapi.xg.qq.com/v2/application/get_app_token_info";
  public static final String RESTAPI_QUERYTOKENSOFACCOUNT =
      "http://openapi.xg.qq.com/v2/application/get_app_account_tokens";
  public static final String RESTAPI_DELETETOKENOFACCOUNT =
      "http://openapi.xg.qq.com/v2/application/del_app_account_tokens";
  public static final String RESTAPI_DELETEALLTOKENSOFACCOUNT =
      "http://openapi.xg.qq.com/v2/application/del_app_account_all_tokens";

}
