package com.realtor.jx.fragment.tab;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.activity.ChangePasswordActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.Header;

/**
 * description: 我的
 * autour: Tait
 * created at: 2018/1/9 22:57
 */
public class TabMineFragment extends BaseFragment {
    private TextView mTvRealtorName;
    private TextView mTvPhone;
    private RelativeLayout mRlChangePassword;
    private TextView mBtnLogout;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mTvRealtorName = findViewById(R.id.mTvRealtorName);
        mTvPhone = findViewById(R.id.mTvPhone);
        mRlChangePassword = findViewById(R.id.mRlChangePassword);
        mBtnLogout = findViewById(R.id.mBtnLogout);

        mTvRealtorName.setText(LocalUser.getInstance().getUserBean().getName());
        mTvPhone.setText(String.format("手机号:%s", LocalUser.getInstance().getUserBean().getPhone()));
    }

    @Override
    protected void initListener() {
        super.initListener();
        ((Header) findViewById(R.id.mHeader)).setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
//                ((MainActivity) mActivity).goToContractTab();
            }

            @Override
            public void onDeleteClick() {

            }
        });
        mRlChangePassword.setOnClickListener(v -> openActivity(ChangePasswordActivity.class));
        mBtnLogout.setOnClickListener(v -> {
            AppDAO.getInstance().loginOut(LocalUser.getInstance().getUserId(), new JsonUiCallback<String>(mActivity) {
                @Override
                public void onSuccess(String result) {
                    Toast.makeText(mActivity, result, Toast.LENGTH_SHORT).show();
                    mActivity.finish();
                }
            });
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tab_mine;
    }

}
