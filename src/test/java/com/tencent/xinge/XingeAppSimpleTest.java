package com.tencent.xinge;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class XingeAppSimpleTest {
    public XingeAppSimple xingeAndroid = null;
    public XingeAppSimple xingeIOS = null;
    private String appIdAndroid = "0e6502fdfdd10";
    private String secretKeyAndroid = "00f4272930388ad7b9d6335e51757d07";
    private String appIdIOS = "88c715375044d";
    private String secretKeyIOS = "04c86cafb4e31d583e3b843ea078a59e";
    private String url = "https://openapi.xg.qq.com/2100326304/";
    @Before
    public void init() {
        xingeAndroid = new XingeAppSimple(appIdAndroid, secretKeyAndroid, url);
        xingeIOS =  new XingeAppSimple(appIdIOS, secretKeyIOS, url);
    }

    @Test
    public void testPushTokenAndroid(){
        long start = System.currentTimeMillis();
        JSONObject jsonObject = xingeAndroid.pushTokenAndroid("测试title", "测试Token单推", "fe01f28eb56b55ba48f3b276e15597686db52402");
        long end = System.currentTimeMillis();
        System.out.println(jsonObject);
        System.out.println("send_time:" + (end-start));
    }

//    @Test
//    public void testPushTokenListAndroid(){
//        ArrayList<String> tokens = new ArrayList<String>();
//        tokens.add("fe01f28eb56b55ba48f3b276e15597686db52402");
//        JSONObject jsonObject = xingeAndroid.pushTokenListAndroid("测试title", "测试Token群推", tokens);
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public void testPushAccountAndroid(){
//        JSONObject jsonObject = xingeAndroid.pushAccountAndroid("测试title", "测试账号单推", "test");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public void testPushAccountListAndroid(){
//        ArrayList<String> accounts = new ArrayList<String>();
//        accounts.add("test");
//        JSONObject jsonObject = xingeAndroid.pushAccountListAndroid("测试title", "测试账号群推", accounts);
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public void testPushTagAndroid(){
//        JSONObject jsonObject = xingeAndroid.pushTagAndroid("测试title", "标签推送", "xgtest");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public void testPushAllAndroid(){
//        JSONObject jsonObject = xingeAndroid.pushAllAndroid("测试title", "全推送");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public  void testPushTokenIos(){
//        JSONObject jsonObject = xingeIOS.pushTokenIos("测试title", "ios Token 单推", "fe01f28eb56b55ba48f3b276e15597686db52402", "dev");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public  void testPushTokenListIos(){
//        ArrayList<String> tokenList = new ArrayList();
//        tokenList.add("fe01f28eb56b55ba48f3b276e15597686db52402");
//        JSONObject jsonObject = xingeIOS.pushTokenListIos("测试title", "ios Token 群推", tokenList, "dev");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public  void testPushAccountIos(){
//        JSONObject jsonObject = xingeIOS.pushAccountIos("测试title", "ios 账号 单推", "test", "dev");
//        System.out.println(jsonObject);
//    }
//    @Test
//    public  void testPushAccountListIos(){
//        ArrayList<String> accountList = new ArrayList<String>();
//        accountList.add("test");
//        JSONObject jsonObject = xingeIOS.pushAccountListIos("测试title", "ios 账号 群推", accountList, "dev");
//        System.out.println(jsonObject);
//    }
//
//
//    @Test
//    public  void testPushTagIos(){
//        JSONObject jsonObject = xingeIOS.pushTagIos("测试title", "ios Tag 推送", "ios", "dev");
//        System.out.println(jsonObject);
//    }
//
//    @Test
//    public  void testPushAllIos(){
//        JSONObject jsonObject = xingeIOS.pushAllIos("测试title", "ios 全 推送", "dev");
//        System.out.println(jsonObject);
//    }
}
