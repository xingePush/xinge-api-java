package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class PushAllAndroidTest extends BaseXgTest {

    @Test
    public void testPushAllAndroid() {

        Message message = new Message();
        message.setTitle("testPushAllAndroid xxx");
        message.setContent("from Java SDK");

        ClickAction action = new ClickAction();
        action.setActionType(0);
        action.setActivity("xxx");
        action.setIntent("xxx");
        action.setActionType(0);

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action.toJson());

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

        String repoStr = pushAppRequest.toString();
        System.out.println(repoStr);
        System.out.println(xingeAndroid.pushApp(repoStr));

    }
}
