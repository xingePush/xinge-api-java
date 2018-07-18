package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "基础返回信息")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    @ApiModelProperty(value = "返回码", required = true)
    private int ret_code;

    @ApiModelProperty(value = "返回错误信息", required = true)
    private String err_msg;


    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }
}
