package com.realtor.jx.netcore;

import com.realtor.jx.netcore.Entity.ResponseResult;
import com.realtor.jx.netcore.api.ApiKeys;
import com.realtor.jx.netcore.api.ApiRoute;
import com.realtor.jx.netcore.api.ApiService;
import com.realtor.jx.netcore.core.JsonCallback;
import com.realtor.jx.netcore.core.NetEngine;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public abstract class BaseDAO extends ApiRoute implements ApiKeys {

    protected ApiService apiService;

    public BaseDAO() {
        apiService = NetEngine.getServerApi();
    }

    protected <T> void invoke(Call<ResponseResult> call, JsonCallback<T> callBack) {
        call.enqueue(callBack);
    }

    protected <T> void invoke(Call<ResponseResult> call, JsonUiCallback<T> callBack, boolean startProgress) {
        callBack.onStart(startProgress);
        invoke(call, (JsonCallback<T>) callBack);
    }

    protected <T> void invoke(Call<ResponseResult> call, JsonUiCallback<T> callBack) {
        invoke(call, callBack, true);
    }

    protected <T> void sendPostFormData(String route, Map<String, Object> paramMap, JsonUiCallback<T> callBack) {
        Call<ResponseResult> call = apiService.postFormData(route, paramMap);
        invoke(call, callBack, true);
    }

    protected <T> void sendPostJson(String route, Object object, JsonUiCallback<T> callBack) {
        Call<ResponseResult> call = apiService.postJson(route, object);
        invoke(call, callBack, true);
    }

    protected <T> void sendGet(String route, Map<String, Object> paramMap, JsonUiCallback<T> callBack) {
        Call<ResponseResult> call = apiService.get(route, paramMap);
        invoke(call, callBack, true);
    }
    protected Map<String, Object> getMapParams(String[] keys, Object... values) {

        if (keys.length != values.length) {
            throw new IllegalArgumentException("keys & values should have same length !!");
        }

        HashMap<String, Object> map = new HashMap<>();

        map.put(TIME_STAMP, System.currentTimeMillis());

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Object value = values[i];
            map.put(key, value);
        }

        return map;
    }
}
