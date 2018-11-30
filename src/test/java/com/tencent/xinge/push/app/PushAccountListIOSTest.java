package com.tencent.xinge.push.app;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import com.tencent.xinge.bean.ios.Alert;
import com.tencent.xinge.bean.ios.Aps;
import org.junit.Test;

import java.util.ArrayList;

//account list推送
public class PushAccountListIOSTest extends BaseXgTest {

    @Test
    public void testPushAccountListIOS() {

        Message message = new Message();
        message.setContent("testPushAccountListIOS from Java API");
        message.setTitle("testPushAccountListIOS");
        message.setXgMediaResources("media");

        MessageIOS msgIOS = new MessageIOS();
        Alert alert = new Alert();
        alert.setTitle("alert from Java API");
        alert.setBody(" body alert from Java API");

        Aps aps = new Aps();
        aps.setBadge_type(8);
        aps.setAlert(alert);
        msgIOS.setAps(aps);

        message.setIos(msgIOS);

        ArrayList<String> accountList = new ArrayList<String>();
        accountList.add("xg_account");
        accountList.add("xg_account1");

       ArrayList<TimeInterval> accepTimeList = new ArrayList<TimeInterval>();
        TimeInterval accepTime = new TimeInterval(0,0,23,59);
        accepTimeList.add(accepTime);
        message.setAccept_time(accepTimeList);

        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.dev);
        pushAppRequest.setMessage_type(MessageType.notify);
        pushAppRequest.setMessage(message);
        pushAppRequest.setSend_time("2018-11-12 12:30:01");
        pushAppRequest.setStat_tag("test");
        pushAppRequest.setPush_id("0");
        pushAppRequest.setAccount_list(accountList);
        pushAppRequest.setAudience_type(AudienceType.account_list);

        System.out.println(pushAppRequest.toString());
        xingeIOS.setDomainUrl("http://10.242.131.147:8080/");
        System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
    }
}
