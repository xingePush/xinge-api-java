package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;

//@ApiModel(description = "仅标签推送必需")
public class TagListObject {

    // @ApiModelProperty(value = "标签列表")
    @JsonProperty("tags")
    private ArrayList<String> tags;

    // @ApiModelProperty(value = "操作类型")
    @JsonProperty("op")
    private OpType op;


    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public OpType getOp() {
        return op;
    }

    public void setOp(OpType op) {
        this.op = op;
    }
}


