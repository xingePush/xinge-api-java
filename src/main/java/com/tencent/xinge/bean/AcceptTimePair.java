package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2018/7/10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcceptTimePair {

    @JsonProperty("start")
    // @ApiModelProperty(value = "接受时间 起始时间点",required = true)
    public AcceptTimePoint start;

    @JsonProperty("end")
    // @ApiModelProperty(value = "接受时间 结束时间点",required = true)
    public AcceptTimePoint end;

    public AcceptTimePoint getStart() {
        return start;
    }

    public void setStart(AcceptTimePoint start) {
        this.start = start;
    }

    public AcceptTimePoint getEnd() {
        return end;
    }

    public void setEnd(AcceptTimePoint end) {
        this.end = end;
    }
}
