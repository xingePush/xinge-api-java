package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageAndroid {

    @JsonProperty("n_id")
    @ApiModelProperty(required = true,
            value = "通知消息对象的唯一标识<br>大于0：会覆盖先前相同id的消息, " +
                    "<br>等于0：展示本条通知且不影响其他消息," +
                    "<br>等于-1：将清除先前所有消息，仅展示本条消息")
    private int n_id = 0;

    @JsonProperty("builder_id")
    private int builder_id;

    @JsonProperty("ring")
    private int ring = 1;

    private String ring_raw;

    private int vibrate = 1;

    private int lights = 1;

    private int clearable = 1;

    private int icon_type = 0;

    private String icon_res;

    private int  style_id =1;

    private String small_icon ;

    private ClickAction action;


    private String custom_content;


    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public int getBuilder_id() {
        return builder_id;
    }

    public void setBuilder_id(int builder_id) {
        this.builder_id = builder_id;
    }

    public int getRing() {
        return ring;
    }

    public void setRing(int ring) {
        this.ring = ring;
    }

    public String getRing_raw() {
        return ring_raw;
    }

    public void setRing_raw(String ring_raw) {
        this.ring_raw = ring_raw;
    }

    public int getVibrate() {
        return vibrate;
    }

    public void setVibrate(int vibrate) {
        this.vibrate = vibrate;
    }

    public int getLights() {
        return lights;
    }

    public void setLights(int lights) {
        this.lights = lights;
    }

    public int getClearable() {
        return clearable;
    }

    public void setClearable(int clearable) {
        this.clearable = clearable;
    }

    public int getIcon_type() {
        return icon_type;
    }

    public void setIcon_type(int icon_type) {
        this.icon_type = icon_type;
    }

    public String getIcon_res() {
        return icon_res;
    }

    public void setIcon_res(String icon_res) {
        this.icon_res = icon_res;
    }

    public int getStyle_id() {
        return style_id;
    }

    public void setStyle_id(int style_id) {
        this.style_id = style_id;
    }

    public String getSmall_icon() {
        return small_icon;
    }

    public void setSmall_icon(String small_icon) {
        this.small_icon = small_icon;
    }

    public ClickAction getAction() {
        return action;
    }

    public void setAction(ClickAction action) {
        this.action = action;
    }

    public String getCustom_content() {
        return custom_content;
    }

    public void setCustom_content(String custom_content) {
        this.custom_content = custom_content;
    }




}
