package com.tencent.xinge.push.app;

import com.tencent.xinge.XingeApp;
import com.tencent.xinge.bean.*;
import org.json.JSONObject;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){
        testIOS();

    }

    public static void testIOS() {
        XingeApp xingeApp = new XingeApp.Builder()
                .appId("a27095f232151")
                .secretKey("9e08d5226d963cd54d183acd85dbab36")
                .domainUrl("https://openapi.xg.qq.com/2200271793/")
                .build();
        MessageIOS msgIOS = new MessageIOS();
        Message message = new Message();
        message.setTitle("testPushAllIOS xxx");
        message.setContent("from Java SDK");
        message.setIos(msgIOS);

        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.product);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setMessage(message);
        pushAppRequest.setAudience_type(AudienceType.token);
        ArrayList<String> tokens=new ArrayList<String>();
        tokens.add("4f7250d9a95bb2b83cb787d2a254bee3328e64bf1b940eb199ca5d4b2942077f");
        pushAppRequest.setToken_list(tokens);

        //完善PushAppRequest  消息
        JSONObject ret =  xingeApp.pushApp(pushAppRequest );
        System.out.println(ret);
        System.out.println("done");
    }

}
