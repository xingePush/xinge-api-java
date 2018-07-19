package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageIOS {

    @JsonProperty(value = "aps", required = true)
    @ApiModelProperty(notes = "苹果推送服务(APNs)特有的消息体字段")
    private Aps aps;

    @JsonProperty(value = "custom")
    @ApiModelProperty(notes = "自定义下发的参数")
    private String custom;

    @JsonProperty(value = "xg")
    @ApiModelProperty(notes = "系统保留key，应避免使用")
    private String xg;


    public String  getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getXg() {
        return xg;
    }

    public void setXg(String xg) {
        this.xg = xg;
    }


    public Aps getAps() {
        return aps;
    }

    public void setAps(Aps  aps) {
        this.aps = aps;
    }

}
