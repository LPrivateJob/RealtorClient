package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.ContractInfoShowView;
import com.realtor.jx.widget.Header;

/**
 * description: 待扫码页
 * autour: lewish
 * created at: 2018/1/6 14:48
 */
public class WaitScanQRCodeActivity extends BaseActivity {
    private TextView mTvTips;
    private String mOrderId;
    private ContractInfoShowView mContractInfoShowView;

    public static void open(BaseActivity activity, String orderId) {
        Intent intent = new Intent(activity, WaitScanQRCodeActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ID, orderId);
        activity.startActivity(intent);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mOrderId = bundle.getString(Commons.BUNDLE_KEYS.EXTRA_ID);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTvTips = findViewById(R.id.mTvTips);
        mTvTips.setText(Html.fromHtml("<font color='#CC0000'style='font-weight:bold;'>请租户用本人微信在72小时内</font>用微信扫二维码完善确认"));
        mContractInfoShowView = findViewById(R.id.mContractInfoShowView);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.mBtnReturnHome).setOnClickListener(v -> {
            openActivity(MainActivity.class);
            finish();
        });
        ((Header) findViewById(R.id.mHeader)).setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {

            }

            @Override
            public void onDeleteClick() {
                AppDAO.getInstance().deleteContrace(mOrderId, new JsonUiCallback<Object>(WaitScanQRCodeActivity.this) {
                    @Override
                    public void onSuccess(Object result) {
                        Toast.makeText(WaitScanQRCodeActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        AppDAO.getInstance().queryOrderDetail(mOrderId, new JsonUiCallback<ContractDetailDto>(this) {
            @Override
            public void onSuccess(ContractDetailDto result) {
                mContractInfoShowView.fillData(result);
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

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_scan_qrcode;
    }


}
