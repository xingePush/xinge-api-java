package com.tencent.xinge;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class XingeAppAndroidUnitTest {


  private XingeApp xingev2 = null;

  private long appId = 2100001932;
  private String secretKey = "ebaf10ce868fec205efc0706e8bc5312";

  @Before
  public void init() {
    xingev2 = new XingeApp(appId, secretKey);
  }

  @Test
  public void testCallRestful() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("key1", 2);
    JSONObject json =
        xingev2.callRestful("http://10.1.152.139/v1/push/single_device", params, secretKey);
    assertEquals("{\"err_msg\":\"call restful timeout\",\"ret_code\":-1}", json.toString());
    json = xingev2.callRestful("http://10.1.152.139/v1/push/single_", params, secretKey);
    assertEquals("{\"err_msg\":\"call restful timeout\",\"ret_code\":-1}", json.toString());
    json = xingev2.callRestful("abc", params, secretKey);
    assertEquals("{\"err_msg\":\"generateSign error\",\"ret_code\":-1}", json.toString());
  }

  @Test
  public void testQueryApi() {
    JSONObject response = xingev2.queryTags();
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));

    response = xingev2.queryTagTokenNum("456");
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));

    response = xingev2.queryDeviceCount();
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));
  }

  @Test
  public void testPushApi() {
    JSONObject response;
    Message message = new Message();
    message.setContent("content");
    message.setType(Message.TYPE_MESSAGE);
    message.setExpireTime(86400);

    response = xingev2.pushSingleDevice("2a060d364fd921ec4fd8a1aaf4ea25f638f5f55f", message);
    System.out.println(response);
    assertEquals(40, response.getInt("ret_code"));

    List<String> tags = new ArrayList<String>();
    tags.add("123");
    response = xingev2.pushTags(0, tags, "OR", message);
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));
    Long pushTagsId = response.getJSONObject("result").getLong("push_id");

    response = xingev2.pushAllDevice(0, message);
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));
    Long pushAllId = response.getJSONObject("result").getLong("push_id");

    List<String> pushIdList = new ArrayList<String>();
    pushIdList.add(pushTagsId.toString());
    pushIdList.add(pushAllId.toString());
    System.out.println(xingev2.queryPushStatus(pushIdList));
    assertEquals(0, response.getInt("ret_code"));
  }

}
