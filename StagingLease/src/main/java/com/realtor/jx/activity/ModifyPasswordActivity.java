package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.utils.InputVerifyUtil;
import com.realtor.jx.utils.StringUtil;
import com.realtor.jx.widget.Header;

/**
 * description: 账单页,本页面不联网
 * autour: Tait
 * created at: 2018/1/11 18:25
 */
public class ModifyPasswordActivity extends BaseActivity {
    private Header mHeader;
    private TextInputLayout mEtPhoneTextWrapper;
    private TextInputLayout mEtWrapperVerifyCode;
    private TextInputLayout mEtWraperNewPassword;
    private EditText mEtPhone;
    private EditText mEtOldPassword;
    private EditText mEtNewPassword;
    private TextView mBtnConfirm;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findViewById(R.id.mHeader);
        mEtPhoneTextWrapper = findViewById(R.id.mEtPhoneTextWrapper);
        mEtWrapperVerifyCode = findViewById(R.id.mEtWrapperOldPassword);
        mEtWraperNewPassword = findViewById(R.id.mEtWrapperNewPassword);
        mEtPhone = findViewById(R.id.mEtPhone);
        mEtNewPassword = findViewById(R.id.mEtNewPassword);
        mEtOldPassword = findViewById(R.id.mEtOldPassword);
        mBtnConfirm = findViewById(R.id.mBtnConfirm);

    }

    @Override
    protected void initListener() {
        super.initListener();
        findViewById(R.id.mBtnConfirm).setOnClickListener(v -> {
            invokeInterface();
        });
    }

    private void invokeInterface() {
        String userName = mEtPhone.getText().toString();
        String oldPassword = mEtOldPassword.getText().toString();
        String newPassword = mEtNewPassword.getText().toString();
        if (verifyInput(userName, oldPassword, newPassword)) {
            AppDAO.getInstance().modPassword(userName, oldPassword, newPassword, new JsonUiCallback<Object>(ModifyPasswordActivity.this) {
                @Override
                public void onSuccess(Object result) {
                    Toast.makeText(ModifyPasswordActivity.this, "密码修改成功,请重新登录", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ModifyPasswordActivity.this,LoginActivity.class));
                    finish();
                }

                @Override
                public void onBizFailed(String resultCode, String resultInfo) {
                    super.onBizFailed(resultCode, resultInfo);
                }

                @Override
                public void onConnectionFailed() {
                    super.onConnectionFailed();
                }
            });
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_change_password;
    }

    public boolean verifyInput(String userName, String oldPassword, String newPassword) {
        if (StringUtil.isEmpty(userName)) {
            Toast.makeText(ModifyPasswordActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (InputVerifyUtil.checkPassword(oldPassword) && InputVerifyUtil.checkPassword(newPassword)) {
            if (oldPassword.equals(newPassword)) {
                Toast.makeText(ModifyPasswordActivity.this, "新旧密码不能相同", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
        return false;
    }
}
