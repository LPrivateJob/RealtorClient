package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.ContractInfoShowView;

/**
 * description: 合同详情页
 * autour: lewish
 * created at: 2018/1/6 14:38
 */
public class ContractDetailActivity extends BaseActivity {
    private ContractInfoShowView mContractInfoShowView;
    private TextView mBtn;
    private String mOrderId;

    public void open(BaseActivity activity, String orderId) {
        Intent intent = new Intent(activity, ContractDetailActivity.class);
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
        mContractInfoShowView = findViewById(R.id.mContractInfoShowView);
        mBtn = findViewById(R.id.mBtn);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtn.setOnClickListener(v -> {

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
        return R.layout.fragment_contract_detail_normal;
    }
}
