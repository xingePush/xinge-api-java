package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClickAction {

    public static final int TYPE_ACTIVITY = 1;
    public static final int TYPE_URL = 2;
    public static final int TYPE_INTENT = 3;

    @JsonProperty(value = "action_type", required = true, defaultValue = "1")
    @ApiModelProperty(notes = "动作类型，1，打开activity或app本身；2，打开浏览器；3，打开Intent")
    private int action_type = ActionType.OPEN_ACTIVITY_OR_APP.getType();

    @JsonProperty(value = "activity", required = true, defaultValue = "")
    @ApiModelProperty(notes = "MyActivityClassName")
    private String activity = "";

    @JsonProperty(value = "browser", required = true)
    private Browser browser;

    @JsonProperty(value = "aty_attr", required = true)
    @ApiModelProperty(notes = "activity属性，只针对action_type=1的情况")
    private AtyAttr aty_attr;

    @JsonProperty(value = "intent", required = true)
    @ApiModelProperty(notes = "客户端 Android SDK版本需要大于等于3.2.3，然后在客户端的intent配置data标签，并设置scheme属性")
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
