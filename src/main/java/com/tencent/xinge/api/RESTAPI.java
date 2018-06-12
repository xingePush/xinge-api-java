package com.tencent.xinge.api;

/**
 * v2 REST API
 *
 */
public class RESTAPI {

  /**
   * POST 请求方式
   */
  
  public static final String HTTP_POST = "POST";
  /**
   * GET 请求方式<br>
   * v2支持， v3不支持
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
   * 版本号 v2
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

  /**
   * 标签群推<br>
   * 可以针对设置过标签的设备进行推送。如：性别、身份等<br>
   */
  public static final String RESTAPI_PUSHTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/tags_device";

  /**
   * 查询消息状态<br>
   * 此接口目前仅支持全量推送和标签群推消息的发送状态的查询，不支持其他推送方式的查询<br>
   */
  public static final String RESTAPI_QUERYPUSHSTATUS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/get_msg_status";

  /**
   * 查询应用覆盖的设备Token总数 <br>
   * 此接口用来查询指定应用的全部已注册的设备标识(Device Token)的总数
   */
  public static final String RESTAPI_QUERYDEVICECOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_device_num";

  /**
   * 查询全部标签 <br>
   * 此接口用来查询当前指定应用下被设置的全部标签数量和对应的标签名
   */
  public static final String RESTAPI_QUERYTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_app_tags";

  /**
   * 取消推送<br>
   * 目前V2版本支持根据消息ID来取消尚未触发的、定时的、全量推送或标签群推的推送消息
   */
  public static final String RESTAPI_CANCELTIMINGPUSH =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/cancel_timing_task";

  /**
   * 批量新增标签<br>
   * 批量新增标签，可以给多定的设备(Device Token)设置标签，但是一个 App 下面最多只能有1万个标签，若超出，此接口将返回失败
   */
  public static final String RESTAPI_BATCHSETTAG =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/batch_set";

  /**
   * 批量删除标签
   */
  public static final String RESTAPI_BATCHDELTAG =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/batch_del";

  /**
   * 查询单个指定设备的标签<br>
   * 此接口根据设备标识(Device Token)来查询相应设备被设置的全部标签，请务必保证设备标识（Device Token）的合法性
   */
  public static final String RESTAPI_QUERYTOKENTAGS =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_token_tags";

  /**
   * 查询单个指定标签的Token总数
   */
  public static final String RESTAPI_QUERYTAGTOKENNUM =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/tags/query_tag_token_num";

  /**
   * 超大批量账号群推
   */
  public static final String RESTAPI_CREATEMULTIPUSH =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/create_multipush";

  /**
   * 使用超大批量推送接口进行消息推送
   */
  public static final String RESTAPI_PUSHACCOUNTLISTMULTIPLE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/account_list_multiple";

  /**
   * 设备群推是指，使用设备标识(Device Token)进行消息的推送
   */
  public static final String RESTAPI_PUSHDEVICELISTMULTIPLE =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/push/device_list_multiple";

  /**
   * 查询指定设备Token的注册状态<br>
   * 此接口是为了查询指定设备(Device Token)在信鸽服务器上注册的状态，<br>
   * 设备能收到信鸽推送的消息的首要条件是设备(Device Token)已经被注册到信鸽的后台，<br>
   * 否则信鸽无法给指定设备下发消息的
   */
  public static final String RESTAPI_QUERYINFOOFTOKEN =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_token_info";

  /**
   * 查询单个账号关联的设备（暂可不用）
   */
  public static final String RESTAPI_QUERYTOKENSOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/get_app_account_tokens";

  /**
   * 删除单个账号关联的单个设备Token
   */
  public static final String RESTAPI_DELETETOKENOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/del_app_account_tokens";

  /**
   * 删除单个账号关联的全部设备Token
   */
  public static final String RESTAPI_DELETEALLTOKENSOFACCOUNT =
      RESTAPI_DOMAINS + RESTAPI_VERSIONS + "/application/del_app_account_all_tokens";

}
