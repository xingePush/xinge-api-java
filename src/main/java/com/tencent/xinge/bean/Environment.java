package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "运行的环境")
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum Environment {

    @ApiModelProperty(value = " 推送生产环境")
    product(0, "product"),
    @ApiModelProperty(value = "推送开发环境")
    dev(1, "dev"),;

    Environment(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    private int type;

    private String name;
}
