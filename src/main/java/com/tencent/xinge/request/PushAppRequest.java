package com.tencent.xinge.request;

import org.json.JSONObject;

import com.tencent.xinge.bean.Message;

public class PushAppRequest {

	/**
	 * Push API 必要参数 <br>
	 * 推送目标 all：全量推送 tag：标签推送 token：单设备推送 token_list ：设备列表推送 account：单账号推送
	 * account_list：账号列表推送
	 */
	private String audience_type;
	/**
	 * Push API 必要参数 <br>
	 * 客户端平台类型 android：安卓 ios：苹果 all：安卓&&苹果，仅支持全量推送和标签推送
	 */
	private String platform;

	/**
	 * Push API 必要参数 <br>
	 */
	private Message message;

	/**
	 * Push API 必要参数 <br>
	 * iOS平台用，必须为0，不区分通知栏消息和静默消息 1，表示Android通知栏消息 2，表示Android透传消息
	 */
	private String message_type = "notify";
	
	/**
	 * Push API 可选参数<br>
	 */
	private int expire_time = 259200;
	
	
	/**
	 * Push API 可选参数<br>
	 */
	private String send_time;
	
	
	/**
	 * Push API 可选参数<br>
	 */
	private boolean multi_pkg = false;

	private int loop_times;

	private int loop_interval;

	/**
	 * 仅iOS <br>
	 * 此字段描述的是App的环境 <br>
	 * 1，表示发布环境，对应App已经发布到AppStore <br>
	 * 2，表示开发环境，对应App仍处于调试环境 <br>
	 * (对于iOS，消息推送有两种情况：开发环境、发布环境)
	 */
	private String environment = "product";

	public PushAppRequest(String message_type, Message message) {
		this.message_type = message_type;
		this.message = message;
	}

	@Override
	public String toString() {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("audience_type", this);
		jsonObj.put("platform", "android");
		jsonObj.put("message", message.toJson());
		jsonObj.put("message_type", "notify");
		jsonObj.put("seq", 123);
		jsonObj.put("environment", "product");
		return jsonObj.toString();

	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public int getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(int expire_time) {
		this.expire_time = expire_time;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public boolean getMulti_pkg() {
		return multi_pkg;
	}

	public void setMulti_pkg(boolean multi_pkg) {
		this.multi_pkg = multi_pkg;
	}

	public int getLoop_times() {
		return loop_times;
	}

	public void setLoop_times(int loop_times) {
		this.loop_times = loop_times;
	}

	public int getLoop_interval() {
		return loop_interval;
	}

	public void setLoop_interval(int loop_interval) {
		this.loop_interval = loop_interval;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getAudience_type() {
		return audience_type;
	}

	public void setAudience_type(String audience_type) {
		this.audience_type = audience_type;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
