package com.tencent.xinge.push.app;

import com.tencent.xinge.BaseXgTest;
import com.tencent.xinge.bean.*;
import org.junit.Test;

import java.util.ArrayList;

import com.tencent.xinge.push.app.PushAppRequest;

public class PushTagIOSTest extends BaseXgTest {

    @Test
    public void testPushTagIOS() {

		Message message = new Message();
		message.setContent("testPushTagIOS from Java API");
		message.setTitle("testtest");


		MessageIOS msgIOS = new MessageIOS();
		Alert alert = new Alert();
		alert.setTitle("alert from Java API");
		alert.setBody(" body alert from Java API");

		Aps aps = new Aps();
		aps.setBadge(8);
		aps.setAlert(alert);
		msgIOS.setAps(aps);

		message.setIos(msgIOS);

        ArrayList<String> tagList = new ArrayList<>();
		tagList.add("xg_tag");
		tagList.add("xg_tag2");

		TagListObject tagListl = new TagListObject();
        tagListl.setOp(OpType.OR);
        tagListl.setTags(tagList);

		PushAppRequest pushAppRequest = new PushAppRequest();
		pushAppRequest.setPlatform(Platform.ios);
		pushAppRequest.setEnvironment(Environment.dev);
		pushAppRequest.setMessage_type(MessageType.notify);
		pushAppRequest.setMessage(message);
		pushAppRequest.setSend_time("1111111");
		pushAppRequest.setStat_tag("test");
		pushAppRequest.setPush_id("0");
		pushAppRequest.setTag_list(tagListl);
		pushAppRequest.setAudience_type(AudienceType.tag);

		System.out.println(pushAppRequest.toString());
		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));

    }
}
