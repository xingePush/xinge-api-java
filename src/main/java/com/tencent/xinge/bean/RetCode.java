package com.tencent.xinge.bean;

public enum RetCode {
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(10100, "发送provider失败l5、链接失败"),
    NETWORK_TIMEOUT(10101, "发送provider 超时"),

    ;

    RetCode(int type, String name) {
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


