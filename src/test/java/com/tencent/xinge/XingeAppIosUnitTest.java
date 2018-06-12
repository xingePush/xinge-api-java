package com.tencent.xinge;

import org.json.JSONObject;
import org.junit.Test;

import com.tencent.xinge.api.RESTAPI;
import com.tencent.xinge.bean.MessageIOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class XingeAppIosUnitTest extends XingeApp {
  public XingeAppIosUnitTest() {
    super(2200022728L, "f63ce4ce1c5c31eef138453a4ecd7b39");
  }

  @Test
  public void testQueryApi() {
    JSONObject response = queryTags();
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));

    response = queryTagTokenNum("1111");
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));
  }

  @Test
  public void testRemotePushApi() {
    MessageIOS messageIOS = new MessageIOS();
    messageIOS.setType(MessageIOS.TYPE_REMOTE_NOTIFICATION);
    Map<String, Object> custom = new HashMap<String, Object>();
    custom.put("accessname", "lyon");
    messageIOS.setCustom(custom);

    String deviceToken = "f1462334cf0a7adca2d248317580b564155565f6ad10b2d7c1b0b1940b10bf48";
    System.out.println(pushSingleDevice(deviceToken, messageIOS, RESTAPI.IOSENV_DEV));
  }

  @Test
  public void testPushApi() {
    MessageIOS messageIOS = new MessageIOS();
    messageIOS.setType(MessageIOS.TYPE_APNS_NOTIFICATION);
    messageIOS.setExpireTime(86400);
    messageIOS.setAlert("ios test");
    messageIOS.setBadge(1);
    messageIOS.setCategory("INVITE_CATEGORY");
    messageIOS.setSound("beep.wav");

    List<String> tags = new ArrayList<String>();
    tags.add("1111");
    JSONObject response = pushTags(0, tags, "OR", messageIOS, RESTAPI.IOSENV_DEV);
    System.out.println(response);
    assertEquals(0, response.getInt("ret_code"));
    Long pushTagsId = response.getJSONObject("result").getLong("push_id");
  }
}
