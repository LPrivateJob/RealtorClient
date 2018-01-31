package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.CommonMsgDialog;
import com.realtor.jx.widget.ContractInfoShowView;
import com.realtor.jx.widget.Header;

import java.util.List;

/**
 * description: 待修改页面
 * autour: Tait
 * created at: 2018/1/6 16:32
 */
public class WaitModifyActivity extends BaseActivity {
    private Header mHeader;
    private RelativeLayout mRLWlycView;
    private ImageView mRetryRefresh;
    private TextView mTvRejectedReason;
    private ContractInfoShowView mContractInfoShowView;
    private TextView mBtnViewBills;
    private TextView mBtnModify;
    private String mOrderId;
    private String mTitle;
    private int mRenterTotalAmount;
    private List<ContractDetailDto.InstalmentOrdersBean> mDataList;

    public static void open(BaseActivity activity, String orderId, String title) {
        Intent intent = new Intent(activity, WaitModifyActivity.class);
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
        mHeader = findViewById(R.id.mHeader);
        mRLWlycView = findViewById(R.id.mRLWlycView);
        mRetryRefresh = findViewById(R.id.mRetryRefresh);
        mTvRejectedReason = findViewById(R.id.mTvRejectedReason);
        mContractInfoShowView = findViewById(R.id.mContractInfoShowView);
        mBtnViewBills = findViewById(R.id.mBtnViewBills);
        mBtnModify = findViewById(R.id.mBtnModify);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mHeader.setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
                onBackPressed();
            }

            @Override
            public void onDeleteClick() {
                CommonMsgDialog.newNotice("您确定要删除此合同吗？").onInteractListener(new CommonMsgDialog.OnInteractListener() {
                    @Override
                    public void onClick(boolean flag) {
                        if (flag) {
                            AppDAO.getInstance().deleteContrace(mOrderId, new JsonUiCallback<Object>(WaitModifyActivity.this) {
                                @Override
                                public void onSuccess(Object result) {
                                    Toast.makeText(WaitModifyActivity.this, "已成功删除合同", Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                                @Override
                                public void onBizFailed(String resultCode, String resultInfo) {
                                    super.onBizFailed(resultCode,resultInfo);
                                }

                                @Override
                                public void onConnectionFailed() {
                                    super.onConnectionFailed();
                                }
                            });
                        }
                    }
                }).show(getSupportFragmentManager());
            }
        });
        mBtnViewBills.setOnClickListener(v -> {
            BillActivity.open(this, mRenterTotalAmount, mDataList);
        });
        mBtnModify.setOnClickListener(v -> {
            CommitContractActivity.open(this, mOrderId);
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
                mTvRejectedReason.setText(result.getOrder().getRefuseRemark());
                mContractInfoShowView.fillData(result);
                mRenterTotalAmount = result.getOrder().getSiteUsertotalAmt();
                mDataList = result.getInstalmentOrders();
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
        return R.layout.activity_waitmodify;
    }

    private void showNetErrorView() {
        mRLWlycView.setVisibility(View.VISIBLE);
        mHeader.setTitle("加载失败");
        mHeader.setIsShowDelete(false);
    }

    private void showNormalView() {
        mRLWlycView.setVisibility(View.GONE);
        mHeader.setTitle("待修改");
        mHeader.setIsShowDelete(true);
    }
}
