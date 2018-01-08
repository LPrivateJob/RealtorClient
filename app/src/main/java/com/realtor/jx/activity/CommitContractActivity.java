package com.realtor.jx.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.widget.CommitContractStepIndicator;
import com.realtor.jx.widget.Header;

/**
 * description: 新建和修改合同页面
 * autour: lewish
 * created at: 2018/1/6 16:34
 */
public class CommitContractActivity extends BaseActivity {
    private Header mHeader;
    private CommitContractStepIndicator mStepIndicator;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findView(R.id.mHeader);
        mStepIndicator = findView(R.id.mStepIndicator);
    }

    @Override
    protected void initListener() {
        mHeader.setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
                Toast.makeText(CommitContractActivity.this, "onBackClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick() {

            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_commit_contract;
    }
}
