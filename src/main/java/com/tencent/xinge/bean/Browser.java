package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Browser {

    @JsonProperty(value = "url", required = true)
    @ApiModelProperty(notes = "仅支持http、https")
    private String url="";

    @JsonProperty(value = "confirm", required = true)
    @ApiModelProperty(notes = "是否需要用户确认")
    private int confirm;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

}
