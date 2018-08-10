package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageAndroid {

    @JsonProperty(value = "n_id", defaultValue = "0")
    @ApiModelProperty(required = true,
            value = "通知消息对象的唯一标识<br>大于0：会覆盖先前相同id的消息, " +
                    "<br>等于0：展示本条通知且不影响其他消息," +
                    "<br>等于-1：将清除先前所有消息，仅展示本条消息")
    private int n_id = 0;

    @JsonProperty(value = "builder_id", required = true)
    @ApiModelProperty(notes = "本地通知样式标识")
    private int builder_id;

    @JsonProperty(value = "ring", defaultValue = "1")
    @ApiModelProperty(name = "是否有铃声,0：没有铃声, 1：有铃声", allowableValues = "0,1")
    private int ring = 1;

    @ApiModelProperty(notes = "指定Android工程里raw目录中的铃声文件名，不需要后缀名")
    private String ring_raw;

    @JsonProperty(value = "vibrate", defaultValue = "1")
    private int vibrate = 1;

    @JsonProperty(value = "lights", defaultValue = "1")
    private int lights = 1;

    @JsonProperty(value = "clearable", defaultValue = "1")
    private int clearable = 1;

    @JsonProperty(value = "icon_type", defaultValue = "1")
    private int icon_type = 0;

    @JsonProperty(value = "icon_res")
    private String icon_res;

    @JsonProperty(value = "style_id", defaultValue = "1")
    private int  style_id =1;

    @JsonProperty(value = "small_icon")
    private String small_icon ;

    @JsonProperty(value = "action")
    @ApiModelProperty(notes = "设置点击通知栏之后的行为，默认为打开app")
    private ClickAction action;

    @JsonProperty(value = "custom_content")
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
