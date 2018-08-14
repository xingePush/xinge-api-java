package com.tencent.xinge.push.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.xinge.bean.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "推送请求信息")
public class PushAppRequest {

    @JsonProperty("audience_type")
    @ApiModelProperty(value = "推送目标", required = true)
    private AudienceType audience_type = AudienceType.all;

    @JsonProperty("platform")
    @ApiModelProperty(value = "客户端平台类型", required = true)
    private Platform platform = Platform.all;

    @JsonProperty("message_type")
    @ApiModelProperty(value = "消息类型", required = true)
    private MessageType message_type = MessageType.notify;

    @JsonProperty("message")
    @ApiModelProperty(value = "消息体", required = true)
    private Message message;

    /////////如下是可选的高级参数//////////

    @JsonProperty("expire_time")
    @ApiModelProperty(value = "消息离线存储时间（单位为秒）")
    private int expire_time = 259200;

    @JsonProperty("send_time")
    @ApiModelProperty(value = "指定推送时间")
    private String send_time;

    @JsonProperty("multi_pkg")
    @ApiModelProperty(value = "多包名推送")
    private boolean multi_pkg = false;

    @JsonProperty("loop_times")
    @ApiModelProperty(value = "多包名推送")
    private int loop_times = 0;

    @JsonProperty("loop_interval")
    @ApiModelProperty(value = "多包名推送")
    private int loop_interval = 0;

    @JsonProperty("environment")
    @ApiModelProperty(value = "用户指定推送环境，仅限iOS平台推送使用")
    private Environment environment = Environment.product;

    @JsonProperty("stat_tag")
    @ApiModelProperty(value = "统计标签，用于聚合统计")
    private String stat_tag;

    @JsonProperty("seq")
    @ApiModelProperty(value = "接口调用时，在应答包中信鸽会回射该字段，可用于异步请求 使用场景：异步服务中可以通过该字段找到server端返回的对应应答包\n")
    private int seq = 0;

    @JsonProperty("tag_list")
    @ApiModelProperty(value = "仅标签推送必需")
    private TagListObject tag_list;

    @JsonProperty("account_list")
    @ApiModelProperty(value = "单账号推送、账号列表推送时必需")
    private ArrayList<String> account_list = new ArrayList<String>();

    @JsonProperty("account_type")
    @ApiModelProperty(dataType = "int", value = "单账号推送时可选")
    private int account_type = AccountType.unknown.getType();

    @JsonProperty("token_list")
    @ApiModelProperty(value = "单设备推送、设备列表推送时必需")
    private ArrayList<String> token_list = new ArrayList<String>();

    @JsonProperty("push_id")
    @ApiModelProperty(value = "账号列表推送、设备列表推送时必需")
    private String push_id;


    private final static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toString() {
        String repoStr = null;
        try {
            repoStr = mapper.writeValueAsString(this);

        } catch (Exception e) {
            //TODO do someting
        }
        return repoStr;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public boolean isMulti_pkg() {
        return multi_pkg;
    }

    public void setMulti_pkg(boolean multi_pkg) {
        this.multi_pkg = multi_pkg;
    }

    public int getLoop_times() {
        return loop_times;
    }

    public void setLoop_times(int loop_times) {
        this.loop_times = loop_times;
    }

    public int getLoop_interval() {
        return loop_interval;
    }

    public void setLoop_interval(int loop_interval) {
        this.loop_interval = loop_interval;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getStat_tag() {
        return stat_tag;
    }

    public void setStat_tag(String stat_tag) {
        this.stat_tag = stat_tag;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public TagListObject getTag_list() {
        return tag_list;
    }

    public void setTag_list(TagListObject tag_list) {
        this.tag_list = tag_list;
    }

    public ArrayList<String> getAccount_list() {
        return account_list;
    }

    public void setAccount_list(ArrayList<String> account_list) {
        this.account_list = account_list;
    }

    public int getAccount_type() {
        return account_type;
    }

    public void setAccount_type(int account_type) {
        this.account_type = account_type;
    }

    public ArrayList<String> getToken_list() {
        return token_list;
    }

    public void setToken_list(ArrayList<String> token_list) {
        this.token_list = token_list;
    }

    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }


    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public AudienceType getAudience_type() {
        return audience_type;
    }

    public void setAudience_type(AudienceType audience_type) {
        this.audience_type = audience_type;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public MessageType getMessage_type() {
        return message_type;
    }


    public void setMessage_type(MessageType message_type) {
        this.message_type = message_type;
    }

    public int getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(int expire_time) {
        this.expire_time = expire_time;
    }


}
