package com.tencent.xinge.push.app;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import org.junit.Test;

import java.util.ArrayList;

public class PushAccountListAndroidTest extends BaseXgTest {

    @Test
    public void testPushAccountListAndroid() {

        MessageAndroid messageAndroid = new MessageAndroid();
        ClickAction action = new ClickAction();
        action.setAction_type(0);
        action.setActivity("xxx");
        action.setIntent("xxx");
        messageAndroid.setAction(action);
        messageAndroid.setStyle_id(1);

        ArrayList<String> accountList = new ArrayList<String>();
        accountList.add("xg_account");
        accountList.add("xg_account1");

        Message message = new Message();
        message.setTitle("testPushAccountListAndroid xxx");
        message.setContent("from Java SDK");
        message.setAndroid(messageAndroid);

        PushAppRequest pushAppRequest = new PushAppRequest();

        pushAppRequest.setSeq(123);
        pushAppRequest.setPush_id("0");
        pushAppRequest.setAccount_list(accountList);
        pushAppRequest.setAudience_type(AudienceType.account_list);
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");
        pushAppRequest.setMessage(message);
        pushAppRequest.setPlatform(Platform.android);

        System.out.println(pushAppRequest.toString());
        System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
    }
}
