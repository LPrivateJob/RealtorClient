package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
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
 * description: 待修改页面
 * autour: lewish
 * created at: 2018/1/6 16:32
*/
public class WaitModifyActivity extends BaseActivity {
    private Header mHeader;
    private TextView mTvRejectedReason;
    private ContractInfoShowView mContractInfoShowView;
    private TextView mBtnViewBills;
    private TextView mBtnModify;
    private String mOrderId;
    private String mTitle;
    private int mRenterTotalAmount;
    private List<ContractDetailDto.InstalmentOrdersBean> mDataList;

    public static void open(BaseActivity activity, String orderId,String title) {
        Intent intent = new Intent(activity, WaitModifyActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ID, orderId);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_TITLE,title);
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
        mHeader = findViewById(R.id.mHeader);
        mTvRejectedReason = findViewById(R.id.mTvRejectedReason);
        mContractInfoShowView = findViewById(R.id.mContractInfoShowView);
        mBtnViewBills = findViewById(R.id.mBtnViewBills);
        mBtnModify = findViewById(R.id.mBtnModify);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBtnViewBills.setOnClickListener(v -> {
            BillActivity.open(this,mRenterTotalAmount,mDataList);
        });
        mBtnModify.setOnClickListener(v -> {
            CommitContractActivity.open(this,mOrderId);
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        mHeader.setTitle(mTitle);
        AppDAO.getInstance().queryOrderDetail(mOrderId, new JsonUiCallback<ContractDetailDto>(this) {
            @Override
            public void onSuccess(ContractDetailDto result) {
                mTvRejectedReason.setText(result.getOrder().getRefuseRemark());
                mContractInfoShowView.fillData(result);
                mRenterTotalAmount = result.getOrder().getSiteUsertotalAmt();
                mDataList = result.getInstalmentOrders();
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
        return R.layout.activity_waitmodify
                ;
    }
}
