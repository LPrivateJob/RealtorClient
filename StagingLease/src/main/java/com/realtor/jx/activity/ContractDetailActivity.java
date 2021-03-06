package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.ContractInfoShowView;
import com.realtor.jx.widget.Header;

import java.util.List;

/**
 * description: 合同详情页
 * autour: Tait
 * created at: 2018/1/6 14:38
 */
public class ContractDetailActivity extends BaseActivity {
    private ContractInfoShowView mContractInfoShowView;
    private TextView mBtn;
    private String mOrderId;
    private String mTitle;
    private int mRenterTotalAmount;
    private List<ContractDetailDto.InstalmentOrdersBean> mDataList;
    private Header mHeader;
    private RelativeLayout mRLWlycView;
    private ImageView mRetryRefresh;

    public static void open(BaseActivity activity, String orderId, String title) {
        Intent intent = new Intent(activity, ContractDetailActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ID, orderId);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_TITLE, title);
        activity.startActivity(intent);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mOrderId = bundle.getString(Commons.BUNDLE_KEYS.EXTRA_ID);
        mTitle = bundle.getString(Commons.BUNDLE_KEYS.EXTRA_TITLE);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mContractInfoShowView = findViewById(R.id.mContractInfoShowView);
        mHeader = findViewById(R.id.mHeader);
        mRLWlycView = findViewById(R.id.mRLWlycView);
        mRetryRefresh = findViewById(R.id.mRetryRefresh);
        mBtn = findViewById(R.id.mBtn);
        mBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtn.setOnClickListener(v -> {
            BillActivity.open(this, mRenterTotalAmount, mDataList);
        });
        mRetryRefresh.setOnClickListener(v -> {
            loadData();
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        mHeader.setTitle(mTitle);
        AppDAO.getInstance().queryOrderDetail(mOrderId, new JsonUiCallback<ContractDetailDto>(this) {
            @Override
            public void onSuccess(ContractDetailDto result) {
                showNormalView();
                mContractInfoShowView.fillData(result);
                mRenterTotalAmount = result.getOrder().getSiteUsertotalAmt();
                mDataList = result.getInstalmentOrders();
                mBtn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onBizFailed(String resultCode, String resultInfo) {
                super.onBizFailed(resultCode, resultInfo);
                showNetErrorView();
            }

            @Override
            public void onConnectionFailed() {
                super.onConnectionFailed();
                showNetErrorView();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_contract_detail_normal;
    }

    private void showNetErrorView() {
        mRLWlycView.setVisibility(View.VISIBLE);
        mHeader.setTitle("加载失败");
    }

    private void showNormalView() {
        mRLWlycView.setVisibility(View.GONE);
        mHeader.setTitle(mTitle);
    }
}
