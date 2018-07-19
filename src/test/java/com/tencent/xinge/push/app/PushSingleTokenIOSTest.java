package com.tencent.xinge.push.app;

import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.junit.Test;

import java.util.ArrayList;

//ios token单推
public class PushSingleTokenIOSTest extends BaseXgTest {

    @Test
    public void testPushSingleTokenIOS() {
        Message message = new Message();
        message.setContent("testPushSingleTokenIOS from Java API");
        message.setTitle("testPushSingleTokenIOS");


        MessageIOS msgIOS = new MessageIOS();
        Alert alert = new Alert();
        alert.setTitle("alert from Java API");
        alert.setBody(" body alert from Java API");

        Aps aps = new Aps();
        aps.setBadge(8);
        aps.setAlert(alert);
        msgIOS.setAps(aps);

        message.setIos(msgIOS);

        ArrayList<String> tokenList = new ArrayList<>();
        tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");

        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.dev);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setMessage(message);
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");
        pushAppRequest.setPush_id("0");
        pushAppRequest.setToken_list(tokenList);
        pushAppRequest.setAudience_type(AudienceType.token);

        System.out.println(pushAppRequest.toString());
        System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
    }
}
