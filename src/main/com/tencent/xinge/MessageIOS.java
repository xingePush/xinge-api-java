package com.tencent.xinge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

public class MessageIOS {
    public static final int TYPE_APNS_NOTIFICATION = 11;
    public static final int TYPE_REMOTE_NOTIFICATION = 12;

    public MessageIOS() {
        this.m_sendTime = "2014-03-13 16:13:00";
        this.m_acceptTimes = new Vector<TimeInterval>();
        this.m_raw = "";
        this.m_alertStr = "";
        this.m_alertJo = new JSONObject();
        this.m_badge = 0;
        this.m_sound = "";
        this.m_category = "";
        this.m_loopInterval = -1;
        this.m_loopTimes = -1;
        this.m_type = TYPE_APNS_NOTIFICATION;
    }

    public void setType(int type) {
        this.m_type = type;
    }

    public int getType() {
        return m_type;
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

    public void addAcceptTime(TimeInterval acceptTime) {
        this.m_acceptTimes.add(acceptTime);
    }

    public String acceptTimeToJson() {
        JSONArray json_arr = new JSONArray();
        for (TimeInterval ti : m_acceptTimes) {
            JSONObject jtmp = ti.toJsonObject();
            json_arr.put(jtmp);
        }
        return json_arr.toString();
    }

    public JSONArray acceptTimeToJsonArray() {
        JSONArray json_arr = new JSONArray();
        for (TimeInterval ti : m_acceptTimes) {
            JSONObject jtmp = ti.toJsonObject();
            json_arr.put(jtmp);
        }
        return json_arr;
    }

    public void setCustom(Map<String, Object> custom) {
        this.m_custom = custom;
    }

    public void setRaw(String raw) {
        this.m_raw = raw;
    }

    public void setAlert(String alert) {
        m_alertStr = alert;
    }

    public void setAlert(JSONObject alert) {
        m_alertJo = alert;
    }

    public void setBadge(int badge) {
        m_badge = badge;
    }

    public void setSound(String sound) {
        m_sound = sound;
    }

    public void setCategory(String category) {
        m_category = category;
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
        if (!m_raw.isEmpty()) {
            return true;
        }
        if (m_type < TYPE_APNS_NOTIFICATION || m_type > TYPE_REMOTE_NOTIFICATION)
            return false;

        if (m_expireTime < 0 || m_expireTime > 3 * 24 * 60 * 60)
            return false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            sdf.parse(m_sendTime);
        } catch (ParseException e) {
            return false;
        }
        for (TimeInterval ti : m_acceptTimes) {
            if (!ti.isValid()) {
                return false;
            }
        }
        if (m_type == TYPE_REMOTE_NOTIFICATION) {
            return true;
        }
        return !m_alertStr.isEmpty() || m_alertJo.length() != 0;
    }

    public String toJson() {
        if (!m_raw.isEmpty()) {
            return m_raw;
        }
        JSONObject json = new JSONObject(m_custom);
        json.put("accept_time", acceptTimeToJsonArray());

        JSONObject aps = new JSONObject();
        if (m_type == TYPE_REMOTE_NOTIFICATION) {
            aps.put("content-available", 1);
        } else if (m_type == TYPE_APNS_NOTIFICATION) {
            if (m_alertJo.length() != 0) {
                aps.put("alert", m_alertJo);
            } else {
                aps.put("alert", m_alertStr);
            }
            if (m_badge != 0) {
                aps.put("badge", m_badge);
            }
            if (!m_sound.isEmpty()) {
                aps.put("sound", m_sound);
            }
            if (!m_category.isEmpty()) {
                aps.put("category", m_category);
            }
        }
        json.put("aps", aps);

        return json.toString();
    }

    private int m_expireTime;
    private String m_sendTime;
    private Vector<TimeInterval> m_acceptTimes;
    private int m_type;
    private Map<String, Object> m_custom;
    private String m_raw;
    private String m_alertStr;
    private JSONObject m_alertJo;
    private int m_badge;
    private String m_sound;
    private String m_category;
    private int m_loopInterval;
    private int m_loopTimes;
}
