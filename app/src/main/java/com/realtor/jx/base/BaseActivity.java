package com.realtor.jx.base;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * author: sundong
 * created at 2018/1/4 15:22
 */
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

    protected void loadData(){}

    protected abstract void initView(Bundle savedInstanceState);

    protected void initListener(){}

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected void onPreInit(){

    }
    @LayoutRes
    protected abstract int getLayoutResource();

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
