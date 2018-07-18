package com.tencent.xinge.bean;

import io.swagger.annotations.ApiModelProperty;

/**
 *   客户端平台类型
 */
public enum Platform {

    @ApiModelProperty(value = "安卓&&苹果，仅支持全量推送和标签推送")
    all(0, "all"),
    @ApiModelProperty(value = "安卓")
    android(1, "android"),
    @ApiModelProperty(value = "苹果")
    ios(2, "ios"),
    wns(3, "wns"),
    web(4, "web"),
    email(5, "email"),
    sms(6, "sms"),
    ;

    Platform(int type, String name) {
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
