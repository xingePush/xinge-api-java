package com.tencent.xinge.bean;


//@ApiModel(value = "消息类型")
public enum MessageType {

    // @ApiModelProperty(value = "通知栏展示消息", required = true)
    notify(0, "notify"),
    // @ApiModelProperty(value = "透传消息/静默消息，通知栏不展示消息", required = true)
    message(1, "message"),;

    MessageType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    private int type;

    private String name;
}
