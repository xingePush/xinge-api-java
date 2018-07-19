package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClickAction {

    public static final int TYPE_ACTIVITY = 1;
    public static final int TYPE_URL = 2;
    public static final int TYPE_INTENT = 3;

    @JsonProperty(value = "action_type", required = true)
    private int action_type;

    @JsonProperty(value = "activity", required = true)
    private String activity;

    private String m_url;
    private int m_confirmOnUrl;
    private String m_activity;
    private String m_intent;
    private int m_atyAttrIntentFlag;
    private int m_atyAttrPendingIntentFlag;
    private String m_packageDownloadUrl;
    private int m_confirmOnPackageDownloadUrl;
    private String m_packageName;

    public void setActionType(int actionType) {
        this.action_type = actionType;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setUrl(String url) {
        this.m_url = url;
    }

    public void setConfirmOnUrl(int confirmOnUrl) {
        this.m_confirmOnUrl = confirmOnUrl;
    }

    public void setIntent(String intent) {
        this.m_intent = intent;
    }

    public void setAtyAttrIntentFlag(int atyAttrIntentFlag) {
        this.m_atyAttrIntentFlag = atyAttrIntentFlag;
    }

    public void setAtyAttrPendingIntentFlag(int atyAttrPendingIntentFlag) {
        this.m_atyAttrPendingIntentFlag = atyAttrPendingIntentFlag;
    }

    public void setPackageDownloadUrl(String packageDownloadUrl) {
        this.m_packageDownloadUrl = packageDownloadUrl;
    }

    public void setConfirmOnPackageDownloadUrl(int confirmOnPackageDownloadUrl) {
        this.m_confirmOnPackageDownloadUrl = confirmOnPackageDownloadUrl;
    }

    public void setPackageName(String packageName) {
        this.m_packageName = packageName;
    }

    public String toJson() {
        JSONObject json = new JSONObject();
        json.put("action_type", action_type);
        JSONObject browser = new JSONObject();
        browser.put("url", m_url);
        browser.put("confirm", m_confirmOnUrl);
        json.put("browser", browser);
        json.put("activity", activity);
        json.put("intent", m_intent);

        JSONObject aty_attr = new JSONObject();
        aty_attr.put("if", m_atyAttrIntentFlag);
        aty_attr.put("pf", m_atyAttrPendingIntentFlag);
        json.put("aty_attr", aty_attr);

        return json.toString();
    }

    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("action_type", action_type);
        JSONObject browser = new JSONObject();
        browser.put("url", m_url);
        browser.put("confirm", m_confirmOnUrl);
        json.put("browser", browser);
        json.put("activity", activity);
        json.put("intent", m_intent);

        JSONObject aty_attr = new JSONObject();
        aty_attr.put("if", m_atyAttrIntentFlag);
        aty_attr.put("pf", m_atyAttrPendingIntentFlag);
        json.put("aty_attr", aty_attr);

        return json;
    }

    public boolean isValid() {
        if (action_type < TYPE_ACTIVITY || action_type > TYPE_INTENT)
            return false;

        if (action_type == TYPE_URL) {
            if (m_url.isEmpty() || m_confirmOnUrl < 0 || m_confirmOnUrl > 1)
                return false;
            return true;
        }
        if (action_type == TYPE_INTENT) {
            if (m_intent.isEmpty())
                return false;
            return true;
        }
        return true;
    }

    public ClickAction() {
        m_url = "";
        action_type = 1;
        activity = "";

        m_atyAttrIntentFlag = 0;
        m_atyAttrPendingIntentFlag = 0;

        m_packageDownloadUrl = "";
        m_confirmOnPackageDownloadUrl = 1;
        m_packageName = "";
    }


}
