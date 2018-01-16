package com.realtor.jx.netcore.core;

import com.google.gson.Gson;
import com.realtor.jx.netcore.Entity.ResponseResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public abstract class JsonCallback<T> implements Callback<ResponseResult> {


    @Override
    public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {

        if (response.isSuccessful()) {
            ResponseResult result = response.body();
            if (result.getResultCode() != null && !result.getResultCode().equals("")) {
                dealResponseSuccess(result);
            } else {
                onConnectionFailed();
            }

        } else {
            onConnectionFailed();
        }
    }

    @Override
    public void onFailure(Call<ResponseResult> call, Throwable t) {
        onConnectionFailed();
    }

    public abstract void onSuccess(T result);

    public abstract void onBizFailed(String msg);

    public abstract void onConnectionFailed();

    private void dealResponseSuccess(ResponseResult result) {
        try {
            String resultCode = result.getResultCode();

            if (resultCode.equals("200")) {

                Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

                T t = new Gson().fromJson(result.getData(), type);

                onSuccess(t);
            } else {
                onBizFailed(result.getResultInfo());
            }
        } catch (Exception e) {
            onConnectionFailed();
        }
    }
}
