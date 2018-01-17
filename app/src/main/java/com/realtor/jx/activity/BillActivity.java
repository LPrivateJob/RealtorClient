package com.realtor.jx.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;

/**
 * description: 账单页
 * autour: lewish
 * created at: 2018/1/6 14:46
 */
public class BillActivity extends BaseActivity {
    private TextView mTvTitlePlatformRepayAmount;
    private TextView mTvTitleRenterRepayAmount;

    private ListView mListViewPlatform;
    private ListView mListViewRenter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvTitlePlatformRepayAmount = findViewById(R.id.mTvTitlePlatformRepayAmount);
        mTvTitleRenterRepayAmount = findViewById(R.id.mTvTitleRenterRepayAmount);
        mListViewPlatform = findViewById(R.id.mListViewPlatform);
        mListViewRenter = findViewById(R.id.mListViewRenter);

        mTvTitlePlatformRepayAmount.setText(Html.fromHtml(String.format("平台付款共计<font color=\"#d40000\">%s</font>元", 30000)));
        mTvTitleRenterRepayAmount.setText(Html.fromHtml(String.format("租户应还共计<font color=\"#d40000\">%s</font>元", 30000)));
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_bill;
    }
}
