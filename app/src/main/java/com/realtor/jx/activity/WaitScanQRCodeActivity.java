package com.realtor.jx.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;

/**
 * description: 待扫码页
 * autour: lewish
 * created at: 2018/1/6 14:48
 */
public class WaitScanQRCodeActivity extends BaseActivity {
    private TextView mTvTips;
    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvTips = findViewById(R.id.mTvTips);
        mTvTips.setText(Html.fromHtml("<font color='#CC0000'style='font-weight:bold;'>请租户用本人微信在72小时内</font>用微信扫二维码完善确认"));
    }

    @Override
    protected void initListener() {
        findViewById(R.id.mBtnReturnHome).setOnClickListener(v->{
            openActivity(MainActivity.class);
            finish();
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_scan_qrcode;
    }


}
