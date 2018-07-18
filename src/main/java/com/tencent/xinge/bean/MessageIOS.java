package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageIOS {

    @JsonProperty("aps")
    private String aps;

    @JsonProperty("custom")
    private String custom;

    @JsonProperty("xg")
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


    public String getAps() {
        return aps;
    }

    public void setAps(String  aps) {
        this.aps = aps;
    }

}
