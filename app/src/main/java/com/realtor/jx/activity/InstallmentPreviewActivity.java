package com.realtor.jx.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;

/**
 * description: 分期预览页
 * autour: lewish
 * created at: 2018/1/6 14:42
 */
public class InstallmentPreviewActivity extends BaseActivity {
    private TextView mBtnNext;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBtnNext = findViewById(R.id.mBtnNext);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnNext.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_installment_preview;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "请点击下一步上传照片", Toast.LENGTH_SHORT).show();
    }
}
