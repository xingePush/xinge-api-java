package com.tencent.xinge.bean;

public enum RetCode {
    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(10000, "未知异常"),
    NETWORK_TIMEOUT(10001, "超时失败,请重试"),

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


