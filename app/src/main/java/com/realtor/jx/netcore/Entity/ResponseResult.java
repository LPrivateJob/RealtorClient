package com.realtor.jx.netcore.Entity;

import com.google.gson.JsonElement;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public class ResponseResult {

    private String result_code;
    private String result_info;
    private JsonElement data;

    public String getResultCode() {
        return result_code;
    }

    public void setResultCode(String result_code) {
        this.result_code = result_code;
    }

    public String getResultInfo() {
        return result_info;
    }

    public void setResultInfo(String result_info) {
        this.result_info = result_info;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
