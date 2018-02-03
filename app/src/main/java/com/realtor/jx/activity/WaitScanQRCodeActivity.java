package com.realtor.jx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
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
import com.realtor.jx.manager.GlideManager;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.utils.StringUtil;
import com.realtor.jx.widget.CommonMsgDialog;
import com.realtor.jx.widget.ContractInfoShowView;
import com.realtor.jx.widget.Header;

/**
 * description: 待扫码页
 * autour: Tait
 * created at: 2018/1/6 14:48
 */
public class WaitScanQRCodeActivity extends BaseActivity {
    private Header mHeader;
    private ImageView mIvQRCode;
    private RelativeLayout mRLWlycView;
    private ImageView mRetryRefresh;
    private TextView mTvTips;
    private String mOrderId;
    private boolean isShowBack;
    private ContractInfoShowView mContractInfoShowView;

    public static void open(BaseActivity activity, String orderId) {
        Intent intent = new Intent(activity, WaitScanQRCodeActivity.class);
        if (activity instanceof CommitContractActivity) {
            //合同页面跳转来的不可回退
            intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_BOOL, false);
        } else {
            //其他可以回退到上一级页面
            intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_BOOL, true);
        }
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ID, orderId);
        activity.startActivity(intent);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mOrderId = bundle.getString(Commons.BUNDLE_KEYS.EXTRA_ID);
        isShowBack = bundle.getBoolean(Commons.BUNDLE_KEYS.EXTRA_BOOL);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findViewById(R.id.mHeader);
        mIvQRCode = findViewById(R.id.mIvQRCode);
        mRLWlycView = findViewById(R.id.mRLWlycView);
        mRetryRefresh = findViewById(R.id.mRetryRefresh);
        mHeader.setIsShowBack(isShowBack);
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
                onBackPressed();
            }

            @Override
            public void onDeleteClick() {
                CommonMsgDialog.newNotice("您确定要删除此合同吗？").onInteractListener(new CommonMsgDialog.OnInteractListener() {
                    @Override
                    public void onClick(boolean flag) {
                        if (flag) {
                            AppDAO.getInstance().deleteContrace(mOrderId, new JsonUiCallback<Object>(WaitScanQRCodeActivity.this) {
                                @Override
                                public void onSuccess(Object result) {
                                    Toast.makeText(WaitScanQRCodeActivity.this, "已成功删除合同", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                        }
                    }
                }).show(getSupportFragmentManager());
            }
        });
        mRetryRefresh.setOnClickListener(v -> {
            loadData();
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        AppDAO.getInstance().queryOrderDetail(mOrderId, new JsonUiCallback<ContractDetailDto>(this) {
            @Override
            public void onSuccess(ContractDetailDto result) {
                String qrcodeUrl = result.getOrder().getQrcodeUrl();
                if(StringUtil.isEmpty(qrcodeUrl)) {
                    CommonMsgDialog.newTip("二维码暂未生成,请稍后到产品列表待扫码中查看。").show(getSupportFragmentManager());
                }else {
                    GlideManager.getInstance().loadImage(WaitScanQRCodeActivity.this, mIvQRCode, qrcodeUrl);
                }
                mContractInfoShowView.fillData(result);
                showNormalView();
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
        return R.layout.activity_scan_qrcode;
    }

    private void showNetErrorView() {
        mRLWlycView.setVisibility(View.VISIBLE);
        mHeader.setTitle("加载失败");
        mHeader.setIsShowDelete(false);
        mHeader.setIsShowBack(true);
    }

    private void showNormalView() {
        mRLWlycView.setVisibility(View.GONE);
        mHeader.setTitle("待扫码");
        mHeader.setIsShowBack(isShowBack);
        mHeader.setIsShowDelete(true);
    }
}
