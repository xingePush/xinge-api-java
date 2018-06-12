package com.tencent.xinge;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.tencent.xinge.bean.ClickAction;
import com.tencent.xinge.bean.MessageAndroid;
import com.tencent.xinge.bean.Style;
import com.tencent.xinge.bean.TimeInterval;

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
    
    MessageAndroid androidMessage = new MessageAndroid();
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
    jsonObj.put("message", androidMessage.toString());
    jsonObj.put("message_type", "notify");
    jsonObj.put("seq", 123);
    jsonObj.put("environment", "product");
    jsonRequest = jsonObj.toString();
    System.out.println(jsonRequest);
    System.out.println(xinge.pushApp(jsonRequest));
  }
  
  @Test 
  public void testTagAndroid() {
	  //'{"operator_type":1,"op_type":"qq","op_id":"2948181869","seq":1526903924,"platform":"android","token_list":["17f3edd107fd85bf8037a6c67437ba7838b1e5aa","9c82f0ac382e2a24671a3f8c3079bab5c726ad37"]}'
	  //{"seq":1526903924,","ret_code":10102,"err_msg":"缺少参数tag_list，请检查后重试!"}
	  
	  
	  
  }
}
