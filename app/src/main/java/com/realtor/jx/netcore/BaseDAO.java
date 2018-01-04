package com.realtor.jx.netcore;

import com.realtor.jx.netcore.Entity.ResponseResult;
import com.realtor.jx.netcore.api.ApiKeys;
import com.realtor.jx.netcore.api.ApiRoute;
import com.realtor.jx.netcore.api.ApiService;
import com.realtor.jx.netcore.core.JsonCallback;
import com.realtor.jx.netcore.core.NetEngine;

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

    protected <T> void invoke(Call<ResponseResult> call, JsonUiCallback<T> callBack) {
        invoke(call, callBack, true);
    }

    protected <T> void invoke(Call<ResponseResult> call, JsonUiCallback<T> callBack, boolean startProgress) {
        callBack.onStart(startProgress);
        invoke(call, (JsonCallback<T>) callBack);
    }
}
