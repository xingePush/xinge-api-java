package com.tencent.xinge.push.app;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.junit.Test;

import java.util.ArrayList;

public class PushSingleAccountAndroidTest extends BaseXgTest {


    @Test
    public void testPushSingleAccountAndroid() {


        MessageAndroid messageAndroid = new MessageAndroid();

        ClickAction action = new ClickAction();
        action.setAction_type(0);
        action.setActivity("xxx");
        action.setIntent("xxx");

        messageAndroid.setAction(action);
        Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);

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
        message.setTitle("testPushSingleAccountAndroid");
        message.setContent("from Java SDK");


        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setEnvironment(Environment.product);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setSeq(123);
        pushAppRequest.setPush_id("0");
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");
        pushAppRequest.setMessage(message);

        ArrayList<String> accountList = new ArrayList<>();
        accountList.add("xg_account");
        pushAppRequest.setAccount_list(accountList);

        System.out.println(pushAppRequest.toString());
        System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));

    }
}
