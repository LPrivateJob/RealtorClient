package com.realtor.jx.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.entity.LocalUser;

/**
 * author: sundong
 * created at 2018/1/18 19:46
 */

public class TestActivity extends BaseActivity {
    private TextView mTv;
    @Override
    protected void initView(Bundle savedInstanceState) {
        mTv = findViewById(R.id.mTv);
        LocalUser.getInstance().clearTest();
        mTv.setText(LocalUser.getInstance().getUserId());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_test;
    }
}
