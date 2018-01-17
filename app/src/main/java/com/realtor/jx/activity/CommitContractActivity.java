package com.realtor.jx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.entity.Constants;
import com.realtor.jx.fragment.InstallmentInfoFragment;
import com.realtor.jx.fragment.RenterInfoFragment;
import com.realtor.jx.fragment.UploadPicFragment;
import com.realtor.jx.widget.CommitContractStepIndicator;
import com.realtor.jx.widget.Header;

/**
 * description: 新建和修改合同页面
 * autour: lewish
 * created at: 2018/1/6 16:34
 */
public class CommitContractActivity extends BaseActivity {
    public static final int BILL_ACTIVITY_REQUEST_CODE = 1;
    public static final int WAIT_SCAN_QRCODE_ACTIVITY_REQUEST_CODE = 2;
    private Header mHeader;
    private CommitContractStepIndicator mStepIndicator;
    private Button mBtnNext;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private CommitContractStepIndicator.STEP mStep = CommitContractStepIndicator.STEP.LOCATION;

    public static void open(Activity act, CommitContractStepIndicator.STEP step) {
        Intent intent = new Intent(act, CommitContractActivity.class);
        intent.putExtra(Constants.EXTRA_ENUM, step);
        act.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mHeader = findView(R.id.mHeader);
        mStepIndicator = findView(R.id.mStepIndicator);
        mBtnNext = findView(R.id.mBtnNext);
        mStepIndicator.refreshUi(mStep);
        addFragment(R.id.mFragmentLayout, new RenterInfoFragment());
    }

    @Override
    protected void initListener() {
        mHeader.setOnInteractListener(new Header.OnInteractListener() {
            @Override
            public void onBackClick() {
                Toast.makeText(CommitContractActivity.this, "onBackClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick() {

            }
        });
        mBtnNext.setOnClickListener(v -> {
            switch (mStep) {
                case LOCATION:
                    mStep = CommitContractStepIndicator.STEP.AGING;
                    addFragment(R.id.mFragmentLayout, new InstallmentInfoFragment());
                    mStepIndicator.refreshUi(mStep);
                    break;
                case AGING:
                    commitSigningInfo();
                    break;
                case PHOTO:
                    upLoadPics();
                    break;
            }
        });
    }

    /**
     * 向服务器提交签约信息
     */
    private void commitSigningInfo() {
        startActivityForResult(new Intent(this, BillActivity.class), BILL_ACTIVITY_REQUEST_CODE);
    }

    private void upLoadPics() {
        openActivity(WaitScanQRCodeActivity.class);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case BILL_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    CommitContractStepIndicator.STEP step = (CommitContractStepIndicator.STEP) data.getSerializableExtra("Step");
                    if (step == CommitContractStepIndicator.STEP.PHOTO) {
                        mStep = CommitContractStepIndicator.STEP.PHOTO;
                        addFragment(R.id.mFragmentLayout, new UploadPicFragment());
                        mStepIndicator.refreshUi(mStep);
                    }
                }
                break;
            case WAIT_SCAN_QRCODE_ACTIVITY_REQUEST_CODE:
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

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (mFragmentManager.getBackStackEntryCount() == 1) {
                finish();
                return true;
            } else {
                switch (mStep) {
                    case PHOTO:

                        break;
                    case AGING:
                        mStep = CommitContractStepIndicator.STEP.LOCATION;
                        mStepIndicator.refreshUi(mStep);
                        break;
                    case LOCATION:

                        break;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
