package com.tencent.xinge.push.app;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.json.JSONObject;
import org.junit.Test;

public class PushAllAndroidTest extends BaseXgTest {

    @Test
    public void testPushAllAndroid() {

        Message message = new Message();
        message.setTitle("testPushAllAndroid xxx");
        message.setContent("from Java SDK");

        ClickAction action = new ClickAction();
        action.setAction_type(0);
        action.setActivity("xxx");
        action.setIntent("xxx");

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);

        messageAndroid.setBuilder_id(0);
        messageAndroid.setRing(1);
        messageAndroid.setVibrate(1);
        messageAndroid.setClearable(1);
        messageAndroid.setN_id(0);
        messageAndroid.setLights(1);
        messageAndroid.setIcon_type(0);
        messageAndroid.setStyle_id(1);

        message.setAndroid(messageAndroid);

        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setEnvironment(Environment.product);
        pushAppRequest.setMessage(message);
        pushAppRequest.setPlatform(Platform.all);
        pushAppRequest.setSeq(123);
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");


        String repoStr = pushAppRequest.toString();

        System.out.println(repoStr);

        JSONObject response = xingeAndroid.pushApp(repoStr);
        System.out.println(response);


    }
}
