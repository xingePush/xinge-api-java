package com.tencent.xinge.bean;

public enum RetCode {

    ddd(10100, "系统繁忙请稍后重试!"), ;

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


