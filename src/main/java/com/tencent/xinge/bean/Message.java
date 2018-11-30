package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;

@ApiModel(value = "消息体")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    @JsonProperty("title")
    @ApiModelProperty(value = "消息标题",required = true)
    @ApiParam(required = true)
    private String title;

    @JsonProperty("content")
    @ApiModelProperty(value = "消息内容",required = true)
    private String content;

    @JsonProperty("accept_time")
    private ArrayList<TimeInterval> accept_time;
//    private Object accept_time;

    @JsonProperty("xg_media_resources")
    private Object xgMediaResources;

    @JsonProperty("android")
    private MessageAndroid android;

    @JsonProperty("ios")
    private MessageIOS ios;

    public MessageAndroid getAndroid() {
        return android;
    }

    public void setAndroid(MessageAndroid android) {
        this.android = android;
    }

    public MessageIOS getIos() {
        return ios;
    }

    public void setIos(MessageIOS ios) {
        this.ios = ios;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<TimeInterval> getAccept_time() {
        return accept_time;
    }

    public void setAccept_time(ArrayList<TimeInterval> accept_time) {
        this.accept_time = accept_time;
    }

    public Object getXgMediaResources() {
        return xgMediaResources;
    }

    public void setXgMediaResources(Object xgMediaResources) {
        this.xgMediaResources = xgMediaResources;
    }
}
