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
    
    Message androidMessage = new Message();
    androidMessage.setType(1);
    androidMessage.setTitle("xxx");
    androidMessage.setContent( "xxxxxxxxx");
    TimeInterval acceptTime1 = new TimeInterval(13, 00, 14, 00);
    TimeInterval acceptTime2 = new TimeInterval(0, 00, 9, 00);
    androidMessage.addAcceptTime(acceptTime1);
    androidMessage.addAcceptTime(acceptTime2);
    
    ClickAction action = new ClickAction();
    action.setActionType(0);
    action.setActivity("xxx");
    action.setIntent("xxx");
    action.setActionType(0);
    androidMessage.setAction(action);
    
    Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
    androidMessage.setStyle(style);
    
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("audience_type", "all");
    jsonObj.put("platform", "android");
    jsonObj.put("message", androidMessage.toJson());
    jsonObj.put("message_type", "notify");
    jsonObj.put("seq", 123);
    jsonObj.put("environment", "product");
    jsonRequest = jsonObj.toString();
    System.out.println(xinge.pushApp(jsonRequest));
  }
}
