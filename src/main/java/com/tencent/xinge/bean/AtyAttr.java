package com.tencent.xinge.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtyAttr {

    @JsonProperty(value = "if", required = true, defaultValue = "0")
    private int atyAttrIntentFlag = 0;


    @JsonProperty(value = "pf", required = true, defaultValue = "0")
    private int atyAttrPendingIntentFlag = 0;

    public int getIf() {
        return atyAttrIntentFlag;
    }

    public void setIf(int m_if) {
        this.atyAttrIntentFlag = m_if;
    }

    public int getPf() {
        return atyAttrPendingIntentFlag;
    }

    public void setPf(int atyAttrPendingIntentFlag) {
        this.atyAttrPendingIntentFlag = atyAttrPendingIntentFlag;
    }


}
