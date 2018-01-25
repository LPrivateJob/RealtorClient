package com.realtor.jx.base;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * author: sundong
 * created at 2018/1/4 15:22
 */
@RuntimePermissions
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreInit();
        setContentView(getLayoutResource());
        initView(savedInstanceState);
        initListener();
        loadData();
    }

    protected void loadData() {
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected void initListener() {
    }

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected void onPreInit() {

    }

    @LayoutRes
    protected abstract int getLayoutResource();

    @Override
    protected void onResume() {
        super.onResume();
        BaseActivityPermissionsDispatcher.checkPermissionsWithPermissionCheck(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        BaseActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @NeedsPermission({Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void checkPermissions() {
        Logger.d("Permission check successed " + getClass().getSimpleName());
    }

    @OnShowRationale({Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onPermissionRationale(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("住分期请求您赋予必要的访问权限，以保证相关功能的使用")
                .setPositiveButton("确认", (dialog, button) -> request.proceed())
                .setNegativeButton("取消", (dialog, button) -> request.cancel())
                .show();
    }

    @OnPermissionDenied({Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onPermissionDenied() {
        new AlertDialog.Builder(this)
                .setMessage("住分期请求您赋予必要的访问权限，以保证相关功能的使用")
                .setPositiveButton("确认", (dialog, button) -> {

                })
                .setNegativeButton("取消", (dialog, button) -> {
                    System.exit(0);
                })
                .show();
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onNeverAskAgain() {
        new AlertDialog.Builder(this)
                .setMessage("住分期请求您赋予必要的访问权限，以保证相关功能的使用")
                .setPositiveButton("确认", (dialog, button) -> {

                })
                .setNegativeButton("取消", (dialog, button) -> {
                    System.exit(0);
                })
                .show();
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    public void openSystemSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(intent);
    }
}
