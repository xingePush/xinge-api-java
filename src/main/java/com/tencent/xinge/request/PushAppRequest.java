package com.tencent.xinge.request;

import java.util.List;

import org.json.JSONObject;

import com.tencent.xinge.bean.Message;

public class PushAppRequest {

	private String audience_type;
	private String platform;
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

	/**
	 * Push API 可选参数<br>
	 */
	private int loop_times;

	/**
	 * Push API 可选参数<br>
	 */
	private int loop_interval;

	/**
	 * Push API 可选参数<br>
	 * 仅iOS <br>
	 * 此字段描述的是App的环境 <br>
	 * 1，表示发布环境，对应App已经发布到AppStore <br>
	 * 2，表示开发环境，对应App仍处于调试环境 <br>
	 * (对于iOS，消息推送有两种情况：开发环境、发布环境)
	 */
	private String environment = "product";

	/**
	 * Push API 可选参数<br>
	 */
	private String stat_tag;

	/**
	 * Push API 可选参数<br>
	 */
	private int seq;

	/**
	 * Push API 可选参数<br>
	 */
	private JSONObject tag_list;

	/**
	 * Push API 可选参数<br>
	 */
	private List<String> account_list;

	/**
	 * Push API 可选参数<br>
	 */
	private int account_type;

	/**
	 * Push API 可选参数<br>
	 */
	private List<String> token_list;

	/**
	 * Push API 可选参数<br>
	 */
	private String push_id;

	/**
	 * 
	 * @param audience_type
	 * @param platform
	 * @param message_type
	 * @param message
	 */
	public PushAppRequest(String audience_type, String platform, String message_type, Message message) {
		this.audience_type = audience_type;
		this.platform = platform;
		this.message_type = message_type;
		this.message = message;
	}

	@Override
	public String toString() {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("audience_type", this.getAudience_type());
		jsonObj.put("platform", this.getPlatform());
		jsonObj.put("message", this.getMessage().toString());
		jsonObj.put("message_type", this.getMessage_type());
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

	/**
	 * Push API 必要参数 <br>
	 * 
	 * @param message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

	public String getAudience_type() {
		return audience_type;
	}

	/**
	 * Push API 必要参数 <br>
	 * 
	 * account_list：账号列表推送
	 * 
	 * @param audience_type
	 *            推送目标 <br>
	 *            all：全量推送 <br>
	 *            tag：标签推送 <br>
	 *            token：单设备推送 <br>
	 *            token_list ：设备列表推送 <br>
	 *            account：单账号推送
	 */
	public void setAudience_type(String audience_type) {
		this.audience_type = audience_type;
	}

	public String getPlatform() {
		return platform;
	}

	/**
	 * Push API 必要参数 <br>
	 * 
	 * 
	 * @param platform
	 *            客户端平台类型 <br>
	 *            android：安卓 <br>
	 *            ios：苹果 <br>
	 *            all：安卓&&苹果，仅支持全量推送和标签推送
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getStat_tag() {
		return stat_tag;
	}

	public void setStat_tag(String stat_tag) {
		this.stat_tag = stat_tag;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public JSONObject getTag_list() {
		return tag_list;
	}

	public void setTag_list(JSONObject tag_list) {
		this.tag_list = tag_list;
	}

	public List<String> getAccount_list() {
		return account_list;
	}

	public void setAccount_list(List<String> account_list) {
		this.account_list = account_list;
	}

	public int getAccount_type() {
		return account_type;
	}

	/**
	 * Push API 必要参数 <br>
	 * 推送目标 <br>
	 * all：全量推送 <br>
	 * tag：标签推送 token：单设备推送 <br>
	 * token_list ：设备列表推送 <br>
	 * account：单账号推送 <br>
	 * account_list：账号列表推送
	 * 
	 * @param account_type
	 */
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public List<String> getToken_list() {
		return token_list;
	}

	/**
	 * 
	 * @param token_list
	 */
	public void setToken_list(List<String> token_list) {
		this.token_list = token_list;
	}

	public String getPush_id() {
		return push_id;
	}

	public void setPush_id(String push_id) {
		this.push_id = push_id;
	}

}
