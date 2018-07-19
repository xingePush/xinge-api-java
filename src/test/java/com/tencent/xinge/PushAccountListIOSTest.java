package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import com.tencent.xinge.push.app.PushAppRequest;
import org.junit.Test;

import java.util.ArrayList;

//account list推送
public class PushAccountListIOSTest extends BaseXgTest {

    @Test
    public void testPushAccountListIOS() {

        Message message = new Message();
        message.setContent("testPushAccountListIOS from Java API");
        message.setTitle("testPushAccountListIOS");


        MessageIOS msgIOS = new MessageIOS();
        Alert alert = new Alert();
        alert.setTitle("alert from Java API");
        alert.setBody(" body alert from Java API");

        Aps aps = new Aps();
        aps.setBadge(8);
        aps.setAlert(alert);
        msgIOS.setAps(aps);

        message.setIos(msgIOS);

        ArrayList<String> accountList = new ArrayList<>();
        accountList.add("xg_account");
        accountList.add("xg_account1");

        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.dev);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setMessage(message);
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");
        pushAppRequest.setPush_id("0");
        pushAppRequest.setAccount_list(accountList);
        pushAppRequest.setAudience_type(AudienceType.account_list);

        System.out.println(pushAppRequest.toString());
        System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
    }
}
