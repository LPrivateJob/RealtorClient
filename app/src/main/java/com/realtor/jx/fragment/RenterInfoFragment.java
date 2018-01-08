package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;

/**
 * description: 租赁信息UI
 * autour: lewish
 * created at: 2018/1/6 10:33
 */

public class RenterInfoFragment extends BaseFragment {
    private EditText mEtContentRenterName;
    private EditText mEtContentPhone;
    private EditText mEtContentIDNum;
    private EditText mEtContentCommunity;
    private EditText mEtContentHouseNum;
    private EditText mEtContentRoomNum;


    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentRenterName = findViewById(R.id.mEtContentRenterName);
        mEtContentPhone = findViewById(R.id.mEtContentPhone);
        mEtContentIDNum = findViewById(R.id.mEtContentIDNum);
        mEtContentCommunity = findViewById(R.id.mEtContentCommunity);
        mEtContentHouseNum = findViewById(R.id.mEtContentHouseNum);
        mEtContentRoomNum = findViewById(R.id.mEtContentRoomNum);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_renter_info;
    }
}
