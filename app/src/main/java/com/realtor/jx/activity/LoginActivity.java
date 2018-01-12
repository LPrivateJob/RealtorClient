package com.realtor.jx.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;

/**
 * description: 登录页
 * autour: lewish
 * created at: 2018/1/6 14:42
*/
public class LoginActivity extends BaseActivity {
    private TextInputLayout mEtPhoneTextWrapper;
    private TextInputLayout mEtWrapperPassword;
    private EditText mEtPhone;
    private EditText mEtPassword;
    private TextView mBtnConfirm;
    @Override
    protected void initView(Bundle savedInstanceState) {
        mEtPhoneTextWrapper = findViewById(R.id.mEtPhoneTextWrapper);
        mEtWrapperPassword = findViewById(R.id.mEtWrapperPassword);
        mEtPhone = findViewById(R.id.mEtPhone);
        mEtPassword = findViewById(R.id.mEtPassword);

        mBtnConfirm = findViewById(R.id.mBtnConfirm);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnConfirm.setOnClickListener(v -> {
            openActivity(MainActivity.class);
            finish();
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }
}
