package com.realtor.jx.dto;

import java.io.Serializable;

/**
 * author: sundong
 * created at 2018/1/23 14:33
 */
public class FlowLayoutTypeBean implements Serializable{
    private static final long serialVersionUID = 1351814118287361930L;
    private String lable;
    private String value;

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
