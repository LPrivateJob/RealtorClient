package com.realtor.jx.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.widget.Header;

/**
 * description: 账单页,本页面不联网
 * autour: Tait
 * created at: 2018/1/11 18:25
 */
public class ChangePasswordActivity extends BaseActivity {
    private Header mHeader;
    private TextInputLayout mEtPhoneTextWrapper;
    private TextInputLayout mEtWrapperVerifyCode;
    private TextInputLayout mEtWraperNewPassword;
    private EditText mEtPhone;
    private EditText mEtVerifyCode;
    private EditText mEtNewPassword;
    private TextView mBtnConfirm;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findViewById(R.id.mHeader);
        mEtPhoneTextWrapper = findViewById(R.id.mEtPhoneTextWrapper);
        mEtWrapperVerifyCode = findViewById(R.id.mEtWrapperVerifyCode);
        mEtWraperNewPassword = findViewById(R.id.mEtWrapperNewPassword);
        mEtPhone = findViewById(R.id.mEtPhone);
        mEtNewPassword = findViewById(R.id.mEtNewPassword);
        mEtVerifyCode = findViewById(R.id.mEtVerifyCode);
        mBtnConfirm = findViewById(R.id.mBtnConfirm);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_change_password;
    }

}
