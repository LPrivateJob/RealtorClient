package com.realtor.jx.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.realtor.jx.R;
import com.realtor.jx.activity.MainActivity;
import com.realtor.jx.base.BaseFragment;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import static android.app.Activity.RESULT_OK;

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
    private int REQUEST_CODE_CHOOSE=1;

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
        mIvAddLeasingContract.setOnClickListener(v->{
            Matisse.from(mActivity)
                    .choose(MimeType.ofImage(), false)
                    .countable(true)
                    .maxSelectable(9)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(REQUEST_CODE_CHOOSE);
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_upload_pic;
    }

    public boolean saveContractInfo(){
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            Log.d("Matisse", "Uris: " + Matisse.obtainResult(data));
            Log.d("Matisse", "Paths: " + Matisse.obtainPathResult(data));
        }
    }
}
