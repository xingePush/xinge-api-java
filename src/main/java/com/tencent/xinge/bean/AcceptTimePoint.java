package com.tencent.xinge.bean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2018/7/10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcceptTimePoint {

    @JsonProperty(value = "hour", required = true)
    // @ApiModelProperty(value = "时间点，小时： HH",required = true)
    public String hour;

    @JsonProperty(value = "min", required = true)
    // @ApiModelProperty(value = "时间点，分钟： mm",required = true)
    public String min;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
