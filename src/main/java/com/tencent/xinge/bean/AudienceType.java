package com.tencent.xinge.bean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "推送目标")
public enum AudienceType {

    @ApiModelProperty(value = "全量推送", required = true)
    all(0, "all"),
    @ApiModelProperty(value = "标签推送", required = true)
    tag(1, "tag"),
    token(2, "token"),
    token_list(3, "token_list"),
    account(4, "account"),
    account_list(5, "account_list"),
    ;

    AudienceType(int type, String name) {
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
