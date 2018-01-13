package com.realtor.jx.fragment.tab;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.activity.ChangePasswordActivity;
import com.realtor.jx.base.BaseFragment;

/**
 * description: 我的
 * autour: lewish
 * created at: 2018/1/9 22:57
*/

public class TabMineFragment extends BaseFragment {
    private RelativeLayout mRlChangePassword;
    private TextView mBtnLogout;
    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mRlChangePassword = findViewById(R.id.mRlChangePassword);
        mBtnLogout = findViewById(R.id.mBtnLogout);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRlChangePassword.setOnClickListener(v -> openActivity(ChangePasswordActivity.class));
        mBtnLogout.setOnClickListener(v -> Toast.makeText(mActivity, "登出", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tab_mine;
    }

}
