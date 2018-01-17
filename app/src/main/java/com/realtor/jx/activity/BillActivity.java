package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.widget.CommitContractStepIndicator;
import com.realtor.jx.widget.Header;

/**
 * description: 账单页
 * autour: lewish
 * created at: 2018/1/6 14:46
 */
public class BillActivity extends BaseActivity {
    private TextView mBtnNext;
    private Header mHeader;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findViewById(R.id.mHeader);
        mBtnNext = findViewById(R.id.mBtnNext);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mHeader.setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
                Intent intent = new Intent();
                intent.putExtra("Step", CommitContractStepIndicator.STEP.AGING);
                setResult(RESULT_OK,intent);
                finish();
            }

            @Override
            public void onDeleteClick() {

            }
        });
        mBtnNext.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("Step", CommitContractStepIndicator.STEP.PHOTO);
            setResult(RESULT_OK,intent);
            finish();
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_bill;
    }
}
