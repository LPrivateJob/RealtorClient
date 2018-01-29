package com.realtor.jx.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.utils.InputVerifyUtil;

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
            String pwd = mEtPassword.getText().toString();
            String phoneNum = mEtPhone.getText().toString();
            if (InputVerifyUtil.checkMobile(phoneNum)&&InputVerifyUtil.checkPassword(pwd)) {
                AppDAO.getInstance().login(phoneNum, pwd, new JsonUiCallback<UserInfoDto>(this) {
                    @Override
                    public void onSuccess(UserInfoDto result) {
                        LocalUser.getInstance().updateUserProfile(result);
                        openActivity(MainActivity.class);
                        finish();
                    }
                });
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }
}
