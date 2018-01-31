package com.realtor.jx.netcore;

import android.content.Context;
import android.widget.Toast;

import com.realtor.jx.netcore.entity.ResponseResult;
import com.realtor.jx.netcore.core.JsonCallback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * description:
 * autour: Tait
 * created at 2018/1/4 15:10
 */
public abstract class JsonUiCallback<T> extends JsonCallback<T> {

    private Context context;

    private LoadingDialog loadingDialog;

    public JsonUiCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
        super.onResponse(call, response);

        onFinish();
    }

    @Override
    public void onFailure(Call<ResponseResult> call, Throwable t) {
        super.onFailure(call, t);

        onFinish();
    }

    public void onStart(boolean showProgress) {
        if (showProgress) {
            loadingDialog = new LoadingDialog(context);
            loadingDialog.show();
        }
    }

    @Override
    public void onBizFailed(String resultCode, String resultInfo) {
        Toast.makeText(context, "服务器内部错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed() {
        Toast.makeText(context, "网络连接异常", Toast.LENGTH_SHORT).show();
    }

    public void onFinish() {
        if (loadingDialog != null)
            loadingDialog.cancel();
    }
}
