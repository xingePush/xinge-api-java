package com.tencent.xinge.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 消息体，即下发到客户端的消息<br>
 * 推送的消息体是 JSON 格式<br>
 * Android普通消息
 */
public class MessageAndroid extends Message {
  public static final int TYPE_NOTIFICATION = 1;
  public static final int TYPE_MESSAGE = 2;
  
  /**
   * 消息标题
   */
  private String title;
  /**
   * 消息内容
   */
  private String content;
  /**
   * 
   */
  private int m_expireTime;
  private String m_sendTime;
  /**
   * 消息将在哪些时间段允许推送给用户，建议小于10个
   */
  private Vector<TimeInterval> accept_time;
  private int type;
  private int m_multiPkg;
  private Style style;
  private ClickAction cickAction;
  private Map<String, Object> m_custom;
  private String m_raw;
  private int m_loopInterval;
  private int m_loopTimes;

  public MessageAndroid() {
    this.title = "";
    this.content = "";
    this.m_sendTime = "2013-12-20 18:31:00";
    this.accept_time = new Vector<TimeInterval>();
    this.m_multiPkg = 0;
    this.m_raw = "";
    this.m_loopInterval = -1;
    this.m_loopTimes = -1;
    this.cickAction = new ClickAction();
    this.style = new Style(0);
  }

  /**
   * 消息标题
   * 
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setExpireTime(int expireTime) {
    this.m_expireTime = expireTime;
  }

  public int getExpireTime() {
    return this.m_expireTime;
  }

  public void setSendTime(String sendTime) {
    this.m_sendTime = sendTime;
  }

  public String getSendTime() {
    return this.m_sendTime;
  }

  /**
   * 消息将在哪些时间段允许推送给用户，建议小于10个
   * 
   * @param acceptTime
   */
  public void addAcceptTime(TimeInterval acceptTime) {
    this.accept_time.add(acceptTime);
  }

  public String acceptTimeToJson() {
    JSONArray json_arr = new JSONArray();
    for (TimeInterval ti : accept_time) {
      JSONObject jtmp = ti.toJsonObject();
      json_arr.put(jtmp);
    }
    return json_arr.toString();
  }

  public JSONArray acceptTimeToJsonArray() {
    JSONArray json_arr = new JSONArray();
    for (TimeInterval ti : accept_time) {
      JSONObject jtmp = ti.toJsonObject();
      json_arr.put(jtmp);
    }
    return json_arr;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }

  public void setMultiPkg(int multiPkg) {
    this.m_multiPkg = multiPkg;
  }

  public int getMultiPkg() {
    return m_multiPkg;
  }

  public void setStyle(Style style) {
    this.style = style;
  }

  public void setAction(ClickAction action) {
    this.cickAction = action;
  }

  public void setCustom(Map<String, Object> custom) {
    this.m_custom = custom;
  }

  public void setRaw(String raw) {
    this.m_raw = raw;
  }

  public int getLoopInterval() {
    return m_loopInterval;
  }

  public void setLoopInterval(int loopInterval) {
    m_loopInterval = loopInterval;
  }

  public int getLoopTimes() {
    return m_loopTimes;
  }

  public void setLoopTimes(int loopTimes) {
    m_loopTimes = loopTimes;
  }

  public boolean isValid() {
    if (!m_raw.isEmpty()) return true;
    if (type < TYPE_NOTIFICATION || type > TYPE_MESSAGE) return false;
    if (m_multiPkg < 0 || m_multiPkg > 1) return false;
    if (type == TYPE_NOTIFICATION) {
      if (!style.isValid()) return false;
      if (!cickAction.isValid()) return false;
    }
    if (m_expireTime < 0 || m_expireTime > 3 * 24 * 60 * 60) return false;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      sdf.parse(m_sendTime);
    } catch (ParseException e) {
      return false;
    }
    for (TimeInterval ti : accept_time) {
      if (!ti.isValid()) return false;
    }
    if (m_loopInterval > 0 && m_loopTimes > 0 && ((m_loopTimes - 1) * m_loopInterval + 1) > 15) {
      return false;
    }

    return true;
  }

  public String toJson() {
    if (!m_raw.isEmpty()) return m_raw;
    JSONObject json = new JSONObject();
    if (type == TYPE_NOTIFICATION) {
      json.put("title", title);
      json.put("content", content);
      json.put("accept_time", acceptTimeToJsonArray());
      json.put("builder_id", style.getBuilderId());
      json.put("ring", style.getRing());
      json.put("vibrate", style.getVibrate());
      json.put("clearable", style.getClearable());
      json.put("n_id", style.getNId());
      json.put("ring_raw", style.getRingRaw());
      json.put("lights", style.getLights());
      json.put("icon_type", style.getIconType());
      json.put("icon_res", style.getIconRes());
      json.put("style_id", style.getStyleId());
      json.put("small_icon", style.getSmallIcon());
      json.put("action", cickAction.toJsonObject());
    } else if (type == TYPE_MESSAGE) {
      json.put("title", title);
      json.put("content", content);
      json.put("accept_time", acceptTimeToJsonArray());
    }
    json.put("custom_content", new JSONObject(m_custom));
    return json.toString();
  }


}
