package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;

/**
 * description: 上传照片UI
 * autour: lewish
 * created at: 2018/1/6 10:38
 */
public class UploadPicFragment extends BaseFragment {
    private ImageView mIvLeasingContractPH;
    private ImageView mIvAddLeasingContract;
    private ImageView mIvIDCardPH;
    private ImageView mIvAddIDCard;
    private ImageView mIvPOCPH;
    private ImageView mIvAddPOC;
    private ImageView mIvAgencyContractPH;
    private ImageView mIvAddAgencyContract;

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
    protected int getLayoutResource() {
        return R.layout.fragment_upload_pic;
    }

    public boolean saveContractInfo(){
        return true;
    }
}
