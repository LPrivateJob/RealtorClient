package com.realtor.jx.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.activity.WaitScanQRCodeActivity;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.entity.Commons;
import com.realtor.jx.manager.GlideManager;
import com.realtor.jx.manager.PicCompressManager;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.netcore.api.ApiKeys;
import com.realtor.jx.utils.StringUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.HashMap;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * description: 上传照片UI
 * autour: Tait
 * created at: 2018/1/6 10:38
 */
public class UploadPicFragment extends BaseFragment implements View.OnClickListener {
    public static final int REQUEST_CODE_LEASING_CONTRACT = 1;
    public static final int REQUEST_CODE_IDCARD = 2;
    public static final int REQUEST_CODE_POC = 3;
    public static final int REQUEST_CODE_AGENCY_CONTRACT = 4;

    private String mOrderId;
    private String mMobileNo;

    private ImageView mIvLeasingContractPH;
    private ImageView mIvAddLeasingContract;
    private ImageView mIvIDCardPH;
    private ImageView mIvAddIDCard;
    private ImageView mIvPOCPH;
    private ImageView mIvAddPOC;
    private ImageView mIvAgencyContractPH;
    private ImageView mIvAddAgencyContract;

    private String mLeasingContractPath;
    private String mIDCardPath;
    private String mPOCPath;
    private String mAgencyContractPath;

    public static UploadPicFragment newInstance(String orderId, String mobileNo) {
        UploadPicFragment instance = new UploadPicFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Commons.BUNDLE_KEYS.EXTRA_ID, orderId);
        bundle.putString(Commons.BUNDLE_KEYS.EXTRA_CODE, mobileNo);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected void getIncomingValue() {
        super.getIncomingValue();
        mOrderId = getArguments().getString(Commons.BUNDLE_KEYS.EXTRA_ID);
        mMobileNo = getArguments().getString(Commons.BUNDLE_KEYS.EXTRA_CODE);
    }

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mIvLeasingContractPH = findViewById(R.id.mIvLeasingContractPH);
        mIvAddLeasingContract = findViewById(R.id.mIvAddLeasingContract);
        mIvIDCardPH = findViewById(R.id.mIvIDCardPH);
        mIvAddIDCard = findViewById(R.id.mIvAddIDCard);
        mIvPOCPH = findViewById(R.id.mIvPOCPH);
        mIvAddPOC = findViewById(R.id.mIvAddPOC);
        mIvAgencyContractPH = findViewById(R.id.mIvAgencyContractPH);
        mIvAddAgencyContract = findViewById(R.id.mIvAddAgencyContract);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mIvAddLeasingContract.setOnClickListener(this);
        mIvAddIDCard.setOnClickListener(this);
        mIvAddPOC.setOnClickListener(this);
        mIvAddAgencyContract.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_upload_pic;
    }

    public void upLoadPics() {
        if (StringUtil.isEmpty(mLeasingContractPath)) {
            Toast.makeText(mActivity, "请上传租户和公寓签署的租赁合同", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, String> fileMap = new HashMap<>();
        fileMap.put(ApiKeys.FILE_CONTRACT, mLeasingContractPath);
        if (!StringUtil.isEmpty(mIDCardPath)) {
            fileMap.put(ApiKeys.FILE_RENTER, mIDCardPath);
        }
        if (!StringUtil.isEmpty(mPOCPath)) {
            fileMap.put(ApiKeys.FILE_HOUSE, mPOCPath);
        }
        if (!StringUtil.isEmpty(mAgencyContractPath)) {
            fileMap.put(ApiKeys.FILE_AGENT, mAgencyContractPath);
        }
        AppDAO.getInstance().upLoadPics(mOrderId, mMobileNo, fileMap, new JsonUiCallback<Object>(mActivity) {
            @Override
            public void onSuccess(Object result) {
                WaitScanQRCodeActivity.open(mActivity, mOrderId);
                // TODO: 待测试  
                PicCompressManager.getInstance().deletePicFromDisk();
                mActivity.finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String path = null;
            List<String> paths = Matisse.obtainPathResult(data);
            if (!paths.isEmpty()) {
                path = paths.get(0);
            }
            switch (requestCode) {
                case REQUEST_CODE_LEASING_CONTRACT:
                    mLeasingContractPath = path;
                    PicCompressManager.getInstance().compress(mActivity, path, new PicCompressManager.OnCompressResultListener() {
                        @Override
                        public void onSuccess(String picPath) {
                            mLeasingContractPath = picPath;
                            GlideManager.getInstance().loadImage(mActivity, mIvLeasingContractPH, picPath);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                    break;
                case REQUEST_CODE_IDCARD:
                    mIDCardPath = path;
                    PicCompressManager.getInstance().compress(mActivity, path, new PicCompressManager.OnCompressResultListener() {
                        @Override
                        public void onSuccess(String picPath) {
                            mIDCardPath = picPath;
                            GlideManager.getInstance().loadImage(mActivity, mIvIDCardPH, picPath);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                    break;
                case REQUEST_CODE_POC:
                    mPOCPath = path;
                    PicCompressManager.getInstance().compress(mActivity, path, new PicCompressManager.OnCompressResultListener() {
                        @Override
                        public void onSuccess(String picPath) {
                            mPOCPath = picPath;
                            GlideManager.getInstance().loadImage(mActivity, mIvPOCPH, picPath);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                    break;
                case REQUEST_CODE_AGENCY_CONTRACT:
                    mAgencyContractPath = path;
                    PicCompressManager.getInstance().compress(mActivity, path, new PicCompressManager.OnCompressResultListener() {
                        @Override
                        public void onSuccess(String picPath) {
                            mAgencyContractPath = picPath;
                            GlideManager.getInstance().loadImage(mActivity, mIvAgencyContractPH, picPath);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
                    break;
            }
        }
    }

    /**
     * 跳到图片选择页
     */
    public void selectPics(int requestCode) {
        Matisse.from(this)
                .choose(MimeType.ofImage(), false)
                .showSingleMediaType(true)
                .countable(false)
                .capture(true)
                .captureStrategy(new CaptureStrategy(true, "$(BuildConfig.APPLICATION_ID).fileProvider"))
                .maxSelectable(1)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(requestCode);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mIvAddLeasingContract:
                selectPics(REQUEST_CODE_LEASING_CONTRACT);
                break;
            case R.id.mIvAddIDCard:
                selectPics(REQUEST_CODE_IDCARD);
                break;
            case R.id.mIvAddPOC:
                selectPics(REQUEST_CODE_POC);
                break;
            case R.id.mIvAddAgencyContract:
                selectPics(REQUEST_CODE_AGENCY_CONTRACT);
                break;
        }
    }
}
