package com.tencent.xinge.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

@ApiModel(description = "仅标签推送必需")
public class TagList {

    @ApiModelProperty(value = "标签列表")
    private ArrayList<String> tags;

    @ApiModelProperty(value = "操作类型")
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


