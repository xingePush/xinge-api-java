package com.tencent.xinge;

import com.tencent.xinge.bean.ClickAction;
import com.tencent.xinge.bean.Message;
import com.tencent.xinge.bean.MessageAndroid;
import com.tencent.xinge.push.app.PushAppRequest;
import org.junit.Test;

import java.util.ArrayList;

public class PushAccountListAndroidTest extends BaseXgTest {

    @Test
    public void testPushAccountListAndroid() {

        MessageAndroid messageAndroid = new MessageAndroid();
        ClickAction action = new ClickAction();
        action.setActionType(0);
        action.setActivity("xxx");
        action.setIntent("xxx");
        action.setActionType(0);
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
        pushAppRequest.setSend_time("1111111");
        pushAppRequest.setStat_tag("test");

        System.out.println(pushAppRequest.toString());
        System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
    }
}
