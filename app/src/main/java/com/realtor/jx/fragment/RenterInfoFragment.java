package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.entity.CommitContractInfo;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.utils.NullUtil;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * description: 租赁信息UI
 * autour: lewish
 * created at: 2018/1/6 10:33
 */

public class RenterInfoFragment extends BaseFragment implements TagFlowLayout.OnTagClickListener {
    private List<FlowLayoutTypeBean> mRenterMethodsList;
    private EditText mEtContentRenterName;
    private EditText mEtContentPhone;
    private EditText mEtContentIDNum;
    private EditText mEtContentCity;
    private EditText mEtContentCommunity;
    private EditText mEtContentHouseNum;
    private EditText mEtContentRoomNum;
    private TagFlowLayout mFLRenterMethod;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentRenterName = findViewById(R.id.mEtContentRenterName);
        mEtContentPhone = findViewById(R.id.mEtContentPhone);
        mEtContentIDNum = findViewById(R.id.mEtContentIDNum);
        mEtContentCity = findViewById(R.id.mEtContentCity);
        mEtContentCommunity = findViewById(R.id.mEtContentCommunity);
        mEtContentHouseNum = findViewById(R.id.mEtContentHouseNum);
        mEtContentRoomNum = findViewById(R.id.mEtContentRoomNum);
        mFLRenterMethod = findViewById(R.id.mFLRenterMethod);
    }

    @Override
    protected void initListener() {
        // TODO: 待修改成rentType  
        mRenterMethodsList = LocalUser.getInstance().getRenterMethodList();
        mFLRenterMethod.setAdapter(new MyTagAdapter(mRenterMethodsList, mActivity, mFLRenterMethod));
        mFLRenterMethod.setOnTagClickListener(this);
    }

    public void fillData(CommitContractInfo commitContractInfo) {
        mEtContentRenterName.setText(NullUtil.getString2(commitContractInfo.tenancyName));
        mEtContentPhone.setText(NullUtil.getString2(commitContractInfo.tenancyMobile));
        mEtContentIDNum.setText(NullUtil.getString2(commitContractInfo.tenancyIdcard));
        if(commitContractInfo.tenancyType!=null&&commitContractInfo.tenancyType.getValue()!=null){
            mFLRenterMethod.getAdapter().setSelected(Integer.parseInt(commitContractInfo.tenancyType.getValue())-1);
        }
        mEtContentCity.setText(NullUtil.getString2(commitContractInfo.cityNo));
        mEtContentCommunity.setText(NullUtil.getString2(commitContractInfo.houseName));
        mEtContentHouseNum.setText(NullUtil.getString2(commitContractInfo.houseCode));
        mEtContentRoomNum.setText(NullUtil.getString2(commitContractInfo.roomNum));
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_renter_info;
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        if (parent == mFLRenterMethod) {
            Toast.makeText(getActivity(), mRenterMethodsList.get(position).getLable(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public boolean saveContractInfo(){
        return true;
    }

}
