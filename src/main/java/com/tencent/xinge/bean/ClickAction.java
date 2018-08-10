package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClickAction {

    public static final int TYPE_ACTIVITY = 1;
    public static final int TYPE_URL = 2;
    public static final int TYPE_INTENT = 3;

    @JsonProperty(value = "action_type", required = true, defaultValue = "1")
    private int action_type = 1;

    @JsonProperty(value = "activity", required = true, defaultValue = "")
    private String activity = "";

    @JsonProperty(value = "browser", required = true)
    private Browser browser;

    @JsonProperty(value = "aty_attr", required = true)
    private AtyAttr aty_attr;

    @JsonProperty(value = "intent", required = true)
    private String intent;

    public int getAction_type() {
        return action_type;
    }

    public void setAction_type(int action_type) {
        this.action_type = action_type;
    }

    public String getActivity() {
        return activity;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public AtyAttr getAty_attr() {
        return aty_attr;
    }

    public void setAty_attr(AtyAttr aty_attr) {
        this.aty_attr = aty_attr;
    }

    public String getIntent() {
        return intent;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }


}
