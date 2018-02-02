package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;


/**
 * description: 引导页
 * autour: Tait
 * created at: 2018/2/2 17:36.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }, 2000);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    public void onBackPressed() {

    }
}
