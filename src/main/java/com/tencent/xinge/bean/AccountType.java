package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "账号类型")
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum AccountType {

    unknown(0, "unknown"),
    mobile(1, "手机号"),
    email(2, "邮箱"),
    wx_openid(1000, "微信openid"),
    qq_openid(1001, "qq openid"),
    weibo(1002, "新浪微博"),
    alipay(1003, "支付宝"),
    taobao(1004, "淘宝"),
    douban(1005, "豆瓣"),
    facebook(1006, "facebook"),
    twitter(1007, "twitter"),
    google(1008, "google"),
    baidu(1009, "百度"),
    jd(1010, "京东"),
    linkin(1011, "linkin"),
    others(1999, "其他"),
    visitors(2000, "游客登录"),;

    AccountType(int type, String name) {
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
