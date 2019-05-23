package com.tencent.xinge.device.tag;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceTagResponse {

    @JsonProperty("seq")
    // @ApiModelProperty(value = "与请求包一致（如果请求包是非法json 该字段为0）", required = true)
    private int seg;

    @JsonProperty("ret_code")
    // @ApiModelProperty(value = "错误码，详细参照错误码对照表", required = true)
    private int ret_code;

    @JsonProperty("err_msg")
    // @ApiModelProperty(value = "请求出错时的错误信息")
    private String err_msg;

    @JsonProperty("result")
    // @ApiModelProperty(value = "请求正确时，若有额外数据要返回，则结果封装在该字段的json中，若无额外数据，则可能无此字段")
    private String result;

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
