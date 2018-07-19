package com.tencent.xinge.device.tag;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.xinge.bean.OperatorType;
import com.tencent.xinge.bean.Platform;
import com.tencent.xinge.bean.TagTokenPair;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "有多种设置、更新、删除接口")
public class DeviceTagRequest {

    @JsonProperty(value = "audience_type", required = true, defaultValue = "1")
    @ApiModelProperty(value = "推送目标", required = true)
    private int operator_type = OperatorType.ADD_MULT_TAGS_SINGLE.getType();

    @JsonProperty(value = "platform", required = true)
    private Platform platform;

    @JsonProperty(value = "token_list")
    private ArrayList<String> token_list;

    @JsonProperty(value = "tag_list")
    private ArrayList<String> tag_list;

    @JsonProperty(value = "tag_token_list")
    private ArrayList<TagTokenPair> tag_token_list;

    @JsonProperty(value = "seq")
    private int seq;

    @JsonProperty(value = "op_type")
    private String op_type;


    @JsonProperty(value = "op_id")
    private String op_id;


    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String repoStr = null;
        try {
            repoStr = mapper.writeValueAsString(this);

        } catch (Exception e) {
            //TODO do someting
        }
        return repoStr;
    }

    public int getOperator_type() {
        return operator_type;
    }

    public void setOperator_type(int operator_type) {
        this.operator_type = operator_type;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public ArrayList<String> getToken_list() {
        return token_list;
    }

    public void setToken_list(ArrayList<String> token_list) {
        this.token_list = token_list;
    }

    public ArrayList<String> getTag_list() {
        return tag_list;
    }

    public void setTag_list(ArrayList<String> tag_list) {
        this.tag_list = tag_list;
    }

    public ArrayList<TagTokenPair> getTag_token_list() {
        return tag_token_list;
    }

    public void setTag_token_list(ArrayList<TagTokenPair> tag_token_list) {
        this.tag_token_list = tag_token_list;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getOp_type() {
        return op_type;
    }

    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }

    public String getOp_id() {
        return op_id;
    }

    public void setOp_id(String op_id) {
        this.op_id = op_id;
    }


}
