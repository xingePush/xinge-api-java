package com.tencent.xinge.bean;

public enum OperatorType {

    ADD_SINGLE_TAG_SINGLE(1, "增加单个tag，对单个token而言"),
    DELE_SINGLE_TAG_SINGLE(2, "删除单个tag，对单个token而言"),
    ADD_MULT_TAGS_SINGLE(3, "增加多个tag，对单个token而言"),
    DELE_MULT_TAGS_SINGLE(4, "删除多个tag，对单个token而言"),
    DELE_ALL_TAGS_SINGLE(5, "删除所有标签，对单个token而言"),
    COVER_SINGLE_TAG(6, "签覆盖接口（支持多个标签），对单个token而言"),
    ADD_SINGLE_TAG_MULT(7, "添加单个tag，对多个token而言"),
    DELE_SINGLE_TAG_MULT(8, "删除单个tag，对多个token而言"),
    ADD_BATCH_TAGS(9, "批量添加标签（每次调用最多允许设置20对，每个对里面标签在前，token在后）"),
    DELE_BATCH_TAGS(10, "批量删除标签（每次调用最多允许设置20对，每个对里面标签在前，token在后）"),;

    OperatorType(int type, String note) {
        this.type = type;
        this.note = note;
    }

    private int type;

    private String note;


    public String getNote() {
        return note;
    }


    public int getType() {
        return type;
    }


}
