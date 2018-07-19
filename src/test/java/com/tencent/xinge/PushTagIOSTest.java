package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import com.tencent.xinge.push.app.PushAppRequest;

public class PushTagIOSTest extends BaseXgTest {

    @Test
    public void testPushTagIOS() {
        //TODO

		Message message = new Message();
		message.setContent("testPushAllIOS from Java API");
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

		List<String> tagList = new ArrayList<>();
		tagList.add("xg_tag");
		tagList.add("xg_tag2");

		JSONObject tagJsonobj = new JSONObject();
		tagJsonobj.put("tags", tagList);
		tagJsonobj.put("op", "OR");

		PushAppRequest pushAppRequest = new PushAppRequest();
		pushAppRequest.setPlatform(Platform.ios);
		pushAppRequest.setEnvironment(Environment.dev);
		pushAppRequest.setMessage_type(MessageType.notify);
		pushAppRequest.setMessage(message);
		pushAppRequest.setSend_time("1111111");
		pushAppRequest.setStat_tag("test");
		pushAppRequest.setPush_id("0");
		pushAppRequest.setTag_list(tagJsonobj);
		pushAppRequest.setAudience_type(AudienceType.tag);

		System.out.println(pushAppRequest.toString());
		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));

    }
}
