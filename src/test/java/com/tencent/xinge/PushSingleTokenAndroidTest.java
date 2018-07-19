package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.junit.Test;

import java.util.ArrayList;

public class PushSingleTokenAndroidTest extends BaseXgTest {

    @Test
    public void testPushSingleTokenAndroid() {

        MessageAndroid messageAndroid = new MessageAndroid();
        ClickAction action = new ClickAction();
        action.setActionType(0);
        action.setActivity("xxx");
        action.setIntent("xxx");
        action.setActionType(0);
        messageAndroid.setAction(action);

        messageAndroid.setBuilder_id(0);
        messageAndroid.setRing(1);
        messageAndroid.setVibrate(1);
        messageAndroid.setClearable(1);
        messageAndroid.setN_id(0);
        messageAndroid.setLights(1);
        messageAndroid.setIcon_type(0);
        messageAndroid.setStyle_id(1);

        Message message = new Message();

        message.setAndroid(messageAndroid);
        message.setTitle("testPushSingleTokenAndroid");
        message.setContent("from Java SDK");


        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setMessage(message);
        pushAppRequest.setPush_id("0");
        pushAppRequest.setSeq(123);
        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add("ece9c2a0fccc41554fcdad95b8a16fe4366d0404");
        pushAppRequest.setToken_list(tokenList);
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");


        System.out.println(pushAppRequest.toString());
        System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));

    }
}

