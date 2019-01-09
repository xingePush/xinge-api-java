package com.tencent.xinge;

import com.tencent.xinge.bean.*;
import com.tencent.xinge.bean.ios.Alert;
import com.tencent.xinge.bean.ios.Aps;
import com.tencent.xinge.push.app.PushAppRequest;
import org.json.JSONObject;

import java.util.ArrayList;

public class XingeAppSimple {

    XingeApp xingeApp;

    public XingeAppSimple(String appid, String secretKey) {
        this.xingeApp = new XingeApp.Builder()
                .appId(appid)
                .secretKey(secretKey)
                .build();
    }

    public XingeAppSimple(String appid, String secretKey, String domainUrl) {
        this.xingeApp = new XingeApp.Builder()
                .appId(appid)
                .secretKey(secretKey)
                .domainUrl(domainUrl)
                .build();
    }

    /**
     * android Token 单推
     * @param title
     * @param content
     * @param token
     * @return
     */
    public JSONObject pushTokenAndroid(String title, String content, String token){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        pushAppRequest.setMessage(message);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        ArrayList<String> tokenList = new ArrayList<String>();
        tokenList.add(token);
        pushAppRequest.setToken_list(tokenList);

        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android 设备列表推送
     * @param title
     * @param content
     * @param tokens
     * @return
     */
    public JSONObject pushTokenListAndroid(String title, String content, ArrayList<String> tokens){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token_list);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);
        pushAppRequest.setToken_list(tokens);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android 账号单推
     * @param title
     * @param content
     * @param account
     * @return
     */
    public JSONObject pushAccountAndroid(String title, String content, String account){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);

        ArrayList<String> accountList = new ArrayList<String>();
        accountList.add(account);
        pushAppRequest.setAccount_list(accountList);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android  账号列表推送
     * @param title
     * @param content
     * @param accounts
     * @return
     */
    public JSONObject pushAccountListAndroid(String title, String content, ArrayList<String> accounts){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account_list);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);

        pushAppRequest.setMessage(message);
        pushAppRequest.setAccount_list(accounts);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * android  全推
     * @param title
     * @param content
     * @return
     */
    public JSONObject pushAllAndroid(String title,String content){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.all);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();


        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);
        pushAppRequest.setMessage(message);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * android  标签推送
     * @param title
     * @param content
     * @param tag
     * @return
     */
    public JSONObject pushTagAndroid(String title,String content,String tag){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.tag);
        pushAppRequest.setPlatform(Platform.android);
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);
        ClickAction action = new ClickAction();

        MessageAndroid messageAndroid = new MessageAndroid();
        messageAndroid.setAction(action);
        message.setAndroid(messageAndroid);
        pushAppRequest.setMessage(message);

        ArrayList<String> tagList = new ArrayList<String>();
        tagList.add(tag);
        TagListObject tagListObject = new TagListObject();
        tagListObject.setTags(tagList);
        tagListObject.setOp(OpType.OR);

        pushAppRequest.setTag_list(tagListObject);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * Ios 设备单推
     * @param title
     * @param content
     * @param token
     * @param environment
     * @return
     */
    public JSONObject pushTokenIos(String title, String content,String token, String environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        ArrayList<String> tokenList = new ArrayList<String>();
        tokenList.add(token);
        pushAppRequest.setToken_list(tokenList);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * IOS  设备列表推送
     * @param title
     * @param content
     * @param tokens
     * @param environment
     * @return
     */
    public JSONObject pushTokenListIos(String title, String content, ArrayList<String> tokens, String environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.token_list);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        pushAppRequest.setToken_list(tokens);
        return this.xingeApp.pushApp(pushAppRequest);
    }



    /**
     * ios 账号单推
     * @param title
     * @param content
     * @param account
     * @param environment
     * @return
     */
    public JSONObject pushAccountIos(String title, String content,String account,String environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        ArrayList<String> accountList = new ArrayList<String>();
        accountList.add(account);
        pushAppRequest.setAccount_list(accountList);
        return this.xingeApp.pushApp(pushAppRequest);
    }


    /**
     * ios 账号列表推送
     * @param title
     * @param content
     * @param accounts
     * @param environment
     * @return
     */
    public JSONObject pushAccountListIos(String title, String content,ArrayList<String> accounts,String environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.account);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        pushAppRequest.setAccount_list(accounts);
        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * ios  全推
     * @param title
     * @param content
     * @param environment
     * @return
     */
    public JSONObject pushAllIos(String title, String content, String  environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.all);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        return this.xingeApp.pushApp(pushAppRequest);
    }

    /**
     * ios  标签推送
     * @param title
     * @param content
     * @param tag
     * @param environment
     * @return
     */
    public JSONObject pushTagIos(String title, String content, String tag, String environment){
        PushAppRequest pushAppRequest = new PushAppRequest();
        pushAppRequest.setAudience_type(AudienceType.tag);
        pushAppRequest.setPlatform(Platform.ios);
        pushAppRequest.setEnvironment(Environment.valueOf(environment));
        pushAppRequest.setMessage_type(MessageType.notify);

        Message message = new Message();
        message.setTitle(title);
        message.setContent(content);

        MessageIOS messageIOS = new MessageIOS();
        Alert alert = new Alert();
        Aps aps = new Aps();
        aps.setAlert(alert);
        messageIOS.setAps(aps);
        pushAppRequest.setMessage(message);

        ArrayList<String> tagList = new ArrayList<String>();
        tagList.add(tag);
        TagListObject tagListObject = new TagListObject();
        tagListObject.setTags(tagList);
        tagListObject.setOp(OpType.OR);
        pushAppRequest.setMessage(message);
        pushAppRequest.setTag_list(tagListObject);
        return this.xingeApp.pushApp(pushAppRequest);
    }
}
