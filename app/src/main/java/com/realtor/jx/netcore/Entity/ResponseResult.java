package com.realtor.jx.netcore.Entity;

import com.google.gson.JsonElement;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public class ResponseResult {

    private String code;
    private String message;
    private JsonElement data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
