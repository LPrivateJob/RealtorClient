package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;

import java.util.Arrays;
import java.util.List;

/**
 * description: 租赁信息UI
 * autour: lewish
 * created at: 2018/1/6 10:33
 */

public class RenterInfoFragment extends BaseFragment implements TagFlowLayout.OnTagClickListener {
    private List<String> mRenterMethodsList;
    private EditText mEtContentRenterName;
    private EditText mEtContentPhone;
    private EditText mEtContentIDNum;
    private EditText mEtContentCommunity;
    private EditText mEtContentHouseNum;
    private EditText mEtContentRoomNum;
    private TagFlowLayout mFLRenterMethod;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentRenterName = findViewById(R.id.mEtContentRenterName);
        mEtContentPhone = findViewById(R.id.mEtContentPhone);
        mEtContentIDNum = findViewById(R.id.mEtContentIDNum);
        mEtContentCommunity = findViewById(R.id.mEtContentCommunity);
        mEtContentHouseNum = findViewById(R.id.mEtContentHouseNum);
        mEtContentRoomNum = findViewById(R.id.mEtContentRoomNum);
        mFLRenterMethod = findViewById(R.id.mFLRenterMethod);
    }

    @Override
    protected void initListener() {
        mRenterMethodsList = Arrays.asList("整租", "合租");
        mFLRenterMethod.setAdapter(new MyTagAdapter(mRenterMethodsList, mActivity, mFLRenterMethod));
        mFLRenterMethod.setOnTagClickListener(this);
    }

    @Override
    protected void loadData() {
        super.loadData();

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_renter_info;
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        if (parent == mFLRenterMethod) {
            Toast.makeText(getActivity(), mRenterMethodsList.get(position), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
