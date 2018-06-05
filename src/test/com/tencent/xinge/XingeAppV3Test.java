package com.tencent.xinge;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class XingeAppV3Test {


  private XingeAppV3 xinge = null;
  private String appId = "a5b5f071ff77a";
  private String secretKey = "ea512eb7704d5fb5a6a937cafa70e771";
  private String jsonRequest = null;

  @Before
  public void init() {
    xinge = new XingeAppV3(appId, secretKey);
  }

  @Test
  public void testPushAppAndroid() {
    JSONObject androidMessageJson = new JSONObject();
    androidMessageJson.put("title", "xxx");
    androidMessageJson.put("content", "xxxxxxxxx");

    JSONObject accept_time_1 = new JSONObject();
    accept_time_1.put("start", new JSONObject().put("hour", "13").put("min", "00"));
    accept_time_1.put("end", new JSONObject().put("hour", "14").put("min", "00"));

    JSONObject accept_time_2 = new JSONObject();
    accept_time_2.put("start", new JSONObject().put("hour", "00").put("min", "00"));
    accept_time_2.put("end", new JSONObject().put("hour", "09").put("min", "00"));

    List<JSONObject> accept_timeList = new ArrayList<JSONObject>();

    accept_timeList.add(accept_time_1);
    accept_timeList.add(accept_time_2);

    androidMessageJson.put("accept_time", accept_timeList);

    JSONObject actionJson = new JSONObject();
    actionJson.put("action_type", 0);
    actionJson.put("activity", "xxx");
    actionJson.put("aty_attr", new JSONObject().put("if", 0).put("pf", 0));
    actionJson.put("browser", new JSONObject().put("url", "xxxx").put("confirm", 1));
    actionJson.put("intent", "xxx");
    actionJson.put("action_type ", 0);

    androidMessageJson.put("android",
        new JSONObject().put("n_id", 0).put("builder_id", 0).put("ring", 1).put("ring_raw", "ring")
            .put("vibrate", 1).put("lights", 1).put("clearable", 1).put("icon_type", 0)
            .put("icon_res", "xg").put("style_id", 1).put("small_icon", "xg")
            .put("action", actionJson)
            .put("custom_content", new JSONObject().put("key1", "value1").put("key2", "value2")));

    System.out.println(androidMessageJson);

    JSONObject jsonObj = new JSONObject();
    jsonObj.put("audience_type", "all");
    jsonObj.put("platform", "android");
    jsonObj.put("message", androidMessageJson.toString());
    jsonObj.put("message_type", "notify");
    jsonObj.put("seq", 123);
    jsonObj.put("environment", "product");
    jsonRequest = jsonObj.toString();
    System.out.println(xinge.pushApp(jsonRequest));
  }
}
