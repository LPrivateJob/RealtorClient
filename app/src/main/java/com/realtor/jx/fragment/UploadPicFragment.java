package com.realtor.jx.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * description: 上传照片UI
 * autour: lewish
 * created at: 2018/1/6 10:38
 */
public class UploadPicFragment extends BaseFragment implements View.OnClickListener {
    public static final int REQUEST_CODE_LEASING_CONTRACT = 1;
    public static final int REQUEST_CODE_IDCARD = 2;
    public static final int REQUEST_CODE_POC = 3;
    public static final int REQUEST_CODE_AGENCY_CONTRACT = 4;

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

    public boolean saveContractInfo() {

        return true;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String path = null;
            List<String> paths = Matisse.obtainPathResult(data);
            if(!paths.isEmpty()) {
                path = paths.get(0);
            }
            switch (requestCode) {
                case REQUEST_CODE_LEASING_CONTRACT:
                    mLeasingContractPath = path;
                    break;
                case REQUEST_CODE_IDCARD:
                    mIDCardPath = path;
                    break;
                case REQUEST_CODE_POC:
                    mPOCPath = path;
                    break;
                case REQUEST_CODE_AGENCY_CONTRACT:
                    mAgencyContractPath = path;
                    break;
            }
        }
    }

    /**
     * 跳到图片选择页
     */
    public void selectPics(int requestCode) {
        Matisse.from(mActivity)
                .choose(MimeType.ofImage(), false)
                .showSingleMediaType(true)
                .countable(false)
                .capture(true)
                .captureStrategy(new CaptureStrategy(true, "com.realtor.jx.fileprovider"))
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
