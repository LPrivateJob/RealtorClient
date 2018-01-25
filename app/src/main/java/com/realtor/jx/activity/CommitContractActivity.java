package com.realtor.jx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.dto.ContractDto;
import com.realtor.jx.entity.CommitContractInfo;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.fragment.InstallmentInfoFragment;
import com.realtor.jx.fragment.RenterInfoFragment;
import com.realtor.jx.fragment.UploadPicFragment;
import com.realtor.jx.manager.PhoneInfoManager;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.widget.CommitContractStepIndicator;
import com.realtor.jx.widget.Header;

import java.util.List;

/**
 * description: 新建和修改合同页面
 * autour: lewish
 * created at: 2018/1/6 16:34
 */
public class CommitContractActivity extends BaseActivity {
    public static final int INSTALLMENT_PREVIEW_ACTIVITY_REQUEST_CODE = 1;
    private boolean isNewOrder = true;
    private Header mHeader;
    private CommitContractStepIndicator mStepIndicator;
    private Button mBtnNext;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private CommitContractStepIndicator.STEP mStep = CommitContractStepIndicator.STEP.LOCATION;

    private String mOrderId;
    private CommitContractInfo mCommitContractInfo = new CommitContractInfo();
    private RenterInfoFragment mRenterInfoFragment;
    private InstallmentInfoFragment mInstallmentInfoFragment;
    private UploadPicFragment mUploadPicFragment;
    private int totalAmount;
    private List<ContractDto.InstalmentOrdersBean> instalmentOrders;

    /**
     * orderId为空则为新建，不为空则为修改
     */
    public static void open(Activity act,@Nullable String orderId){
        Intent intent = new Intent(act, CommitContractActivity.class);
        intent.putExtra(Commons.BUNDLE_KEYS.EXTRA_ID,orderId);
        act.startActivity(intent);
    }

    @Override
    protected void onPreInit() {
        super.onPreInit();
        Bundle bundle = getIntent().getExtras();
        mOrderId = bundle.getString(Commons.BUNDLE_KEYS.EXTRA_ID);
        isNewOrder = mOrderId==null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findView(R.id.mHeader);
        mStepIndicator = findView(R.id.mStepIndicator);
        mBtnNext = findView(R.id.mBtnNext);
        mStepIndicator.refreshUi(mStep);

        mRenterInfoFragment = new RenterInfoFragment();
        addFragment(R.id.mFragmentLayout, mRenterInfoFragment);
    }

    @Override
    protected void initListener() {
        mBtnNext.setOnClickListener(v -> {
            switch (mStep) {
                case LOCATION:
                    if(mRenterInfoFragment.saveContractInfo()) {
                        mStep = CommitContractStepIndicator.STEP.AGING;
                        mInstallmentInfoFragment = new InstallmentInfoFragment();
                        addFragment(R.id.mFragmentLayout, mInstallmentInfoFragment);
                        mStepIndicator.refreshUi(mStep);
                    }
                    break;
                case AGING:
                    if(mInstallmentInfoFragment.saveContractInfo()) {
                        commitSigningInfo();
                    }
                    break;
                case PHOTO:
                    if(mUploadPicFragment.saveContractInfo()) {
                        upLoadPics();
                    }
                    break;
            }
        });
    }

    @Override
    protected void loadData() {
        //查询详情得到之前提交的用户数据
        if(mOrderId!=null) {
            AppDAO.getInstance().queryOrderDetail(mOrderId, new JsonUiCallback<ContractDetailDto>(this) {
                @Override
                public void onSuccess(ContractDetailDto result) {
                    fillContractInfo(result);
                    mRenterInfoFragment.fillData(mCommitContractInfo);
                }
            });
        }
    }

    /**
     * 更新成员对象mCommitContractInfo
     */
    private void fillContractInfo(ContractDetailDto result) {
        ContractDetailDto.OrderBean order = result.getOrder();
        mCommitContractInfo.tenancyName = order.getTenancyName();
        mCommitContractInfo.tenancyMobile = order.getTenancyMobile();
        mCommitContractInfo.tenancyIdcard = order.getTenancyIdcard();
        mCommitContractInfo.tenancyType = order.getTenancyType();
        mCommitContractInfo.cityNo = order.getCityNo();
        mCommitContractInfo.houseName = order.getHouseName();
        mCommitContractInfo.houseCode = order.getHouseCode();
        mCommitContractInfo.roomNum = order.getRoomNum();

        mCommitContractInfo.cash = order.getCash();
        mCommitContractInfo.startTime = order.getStartTime();
        mCommitContractInfo.endTime = order.getEndTime();
        mCommitContractInfo.feeType = Integer.parseInt(result.getFeeReceive().getValue());
        mCommitContractInfo.firstPaytype = Integer.parseInt(result.getFirstPayType().getValue());
        mCommitContractInfo.platformPayType =Integer.parseInt(result.getPayType().getValue());
        mCommitContractInfo.payTerm = order.getPayTerm();
        mCommitContractInfo.changeNo = order.getChangeNo();
        mCommitContractInfo.info = order.getInfo();
    }

    /**
     * 向服务器提交签约信息
     */
    private void commitSigningInfo() {
        if(mOrderId==null) {
            //新建合同
            AppDAO.getInstance().createContract(PhoneInfoManager.getDiviceId(),mCommitContractInfo, new JsonUiCallback<ContractDto>(this) {
                @Override
                public void onSuccess(ContractDto result) {

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
        }else {
            //修改合同
            AppDAO.getInstance().modifyContract(PhoneInfoManager.getDiviceId(),mCommitContractInfo, new JsonUiCallback<ContractDto>(this) {
                @Override
                public void onSuccess(ContractDto result) {
                    totalAmount = result.getOrder().getSiteUsertotalAmt();
                    instalmentOrders = result.getInstalmentOrders();
                    InstallmentPreviewActivity.open(CommitContractActivity.this,result.getOrder().getSiteUsertotalAmt(),result.getInstalmentOrders());
                    Toast.makeText(CommitContractActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
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
    }

    private void upLoadPics() {
        openActivity(WaitScanQRCodeActivity.class);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case INSTALLMENT_PREVIEW_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    mStep = CommitContractStepIndicator.STEP.PHOTO;
                    mUploadPicFragment = new UploadPicFragment();
                    addFragment(R.id.mFragmentLayout, mUploadPicFragment);
                    mHeader.setIsShowBack(false);
                    mStepIndicator.refreshUi(mStep);
                }
                break;
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_commit_contract;
    }

    //添加fragment至BackStack
    protected void addFragment(int layoutId, BaseFragment fragment) {
        if (fragment != null) {
            if (mFragmentManager.findFragmentById(layoutId) != null) {
                //之前添加过
                mFragmentManager.beginTransaction()
                        .replace(layoutId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            } else {
                //之前未添加过
                mFragmentManager.beginTransaction()
                        .add(layoutId, fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            }

        }
    }

    //从BackStack移除fragment
    protected void removeFragment() {
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            mFragmentManager.popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            switch (mStep) {
                case LOCATION:
                    finish();
                    break;
                case AGING:
                    mStep = CommitContractStepIndicator.STEP.LOCATION;
                    removeFragment();
                    mStepIndicator.refreshUi(mStep);
                    break;
                case PHOTO:
                    Toast.makeText(CommitContractActivity.this, "请上传相关照片", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public CommitContractInfo getCommitContractInfo(){
        return mCommitContractInfo;
    }

    public boolean isNewOrder() {
        return isNewOrder;
    }
}
