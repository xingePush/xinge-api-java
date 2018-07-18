package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;



import java.util.ArrayList;
import java.util.List;

public class XingeAppV3Test {

//	private XingeAppV3 xingeAndroid = null;
//	private XingeAppV3 xingeIOS = null;
//	private String appIdAndroid = "d617a675b62d0";
//	private String secretKeyAndroid = "9e05364c6d56da943783e61da091e8e5";
//	private String appIdIOS = "f248587cdc955";
//	private String secretKeyIOS = "c6bdff7314d4367c18bacc4d30c95dcf";
//
//
//	@Before
//	public void init() {
//		xingeAndroid = new XingeAppV3(appIdAndroid, secretKeyAndroid);
//		xingeIOS = new XingeAppV3(appIdIOS, secretKeyIOS);
//	}

//	@Test  //pass
//	public void testPushAllAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushAllAndroid xxx");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("all", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test  //pass
//	public void testPushAllIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushAllIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("all", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//	}
//
//	@Test  //fail
//	public void testPushTagAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushTagAndroid");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//
//		List<String> tagList = new ArrayList<>();
//		tagList.add("agtestTag");
//		tagList.add("agtestTag2");
//		JSONObject tagJsonobj = new JSONObject();
//		tagJsonobj.put("tags", tagList);
//		tagJsonobj.put("op", "OR");
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("tag", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setTag_list(tagJsonobj);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test //pass
//	public void testPushTagIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushTagIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		List<String> tagList = new ArrayList<>();
//		tagList.add("xg_tag");
//		tagList.add("xg_tag2");
//
//		JSONObject tagJsonobj = new JSONObject();
//		tagJsonobj.put("tags", tagList);
//		tagJsonobj.put("op", "OR");
//
//		PushAppRequest pushAppRequest = new PushAppRequest("tag", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setTag_list(tagJsonobj);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test  //pass
//	public void testPushSingleTokenAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushSingleTokenAndroid");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//		List<String> tokenList = new ArrayList<>();
//		tokenList.add("ece9c2a0fccc41554fcdad95b8a16fe4366d0404");
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("token", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setToken_list(tokenList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test   //pass
//	public void testPushSingleTokenIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushSingleTokenIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		List<String> tokenList = new ArrayList<>();
//		tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");
//
//		PushAppRequest pushAppRequest = new PushAppRequest("token", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//		pushAppRequest.setToken_list(tokenList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test //pass
//	public void testPushTokenListAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushSingleTokenAndroid");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//		List<String> tokenList = new ArrayList<>();
//		tokenList.add("ece9c2a0fccc41554fcdad95b8a16fe4366d0404");
//		tokenList.add("acefd718881b48556cd4b1df770401d3f88e424d");
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("token_list", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setToken_list(tokenList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test //pass
//	public void testPushTokenListIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushTokenListIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		List<String> tokenList = new ArrayList<>();
//		tokenList.add("0d7b5ab1afe4b58973b02a8c80caea51ad6e51f517de6ead3b42576653a69457");
//
//		PushAppRequest pushAppRequest = new PushAppRequest("token_list", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setToken_list(tokenList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//	}

//	@Test //pass
//	public void testPushSingleAccountAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushSingleAccountAndroid");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//
//		List<String> accountList = new ArrayList<>();
//		accountList.add("agtestAccount");
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("account", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setAccount_list(accountList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}

//	@Test //pass
//	public void testPushSingleAccountIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushSingleAccountIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		List<String> accountList = new ArrayList<>();
//		accountList.add("xg_account");
//
//		PushAppRequest pushAppRequest = new PushAppRequest("account", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setAccount_list(accountList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test //pass
//	public void testPushAccountListAndroid() {
//
//		MessageAndroid msgAndroid = new MessageAndroid();
//		msgAndroid.setType(1);
//		msgAndroid.setTitle("testPushAccountListAndroid xxx");
//		msgAndroid.setContent("from Java SDK");
//
//		ClickAction action = new ClickAction();
//		action.setActionType(0);
//		action.setActivity("xxx");
//		action.setIntent("xxx");
//		action.setActionType(0);
//		msgAndroid.setAction(action);
//
//		List<String> accountList = new ArrayList<String>();
//		accountList.add("xg_account");
//		accountList.add("xg_account1");
//
//		Style style = new Style(0, 1, 1, 1, 0, 1, 0, 1);
//		msgAndroid.setStyle(style);
//
//		PushAppRequest pushAppRequest = new PushAppRequest("account_list", "android", "notify", msgAndroid);
//		pushAppRequest.setSeq(123);
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setAccount_list(accountList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeAndroid.pushApp(pushAppRequest.toString()));
//
//	}
//
//	@Test //pass
//	public void testPushAccountListIOS() {
//
//		MessageIOS msgIOS = new MessageIOS();
//		msgIOS.setContent("testPushAccountListIOS from Java API");
//		msgIOS.setAlert("alert from Java API");
//		msgIOS.setBadge(8);
//
//		List<String> accountList = new ArrayList<>();
//		accountList.add("xg_account");
//
//		PushAppRequest pushAppRequest = new PushAppRequest("account_list", "ios", "notify", msgIOS);
//		pushAppRequest.setEnvironment("dev");
//		pushAppRequest.setPush_id("0");
//		pushAppRequest.setAccount_list(accountList);
//
//		System.out.println(pushAppRequest.toString());
//		System.out.println(xingeIOS.pushApp(pushAppRequest.toString()));
//	}

}
