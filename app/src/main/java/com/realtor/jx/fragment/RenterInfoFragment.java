package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.activity.CommitContractActivity;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.entity.CommitContractInfo;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.utils.InputVerifyUtil;
import com.realtor.jx.utils.NullUtil;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;
import com.realtor.jx.widget.picker.wheelpicker.entity.City;
import com.realtor.jx.widget.picker.wheelpicker.entity.County;
import com.realtor.jx.widget.picker.wheelpicker.entity.Province;
import com.realtor.jx.widget.regional_linkage.AddressPickTask;

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
    private TextView mTvContentCity;
    private EditText mEtContentCommunity;
    private EditText mEtContentHouseNum;
    private EditText mEtContentRoomNum;
    private TagFlowLayout mFLRenterMethod;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentRenterName = findViewById(R.id.mEtContentRenterName);
        mEtContentPhone = findViewById(R.id.mEtContentPhone);
        mEtContentIDNum = findViewById(R.id.mEtContentIDNum);
        mTvContentCity = findViewById(R.id.mTvContentCity);
        mEtContentCommunity = findViewById(R.id.mEtContentCommunity);
        mEtContentHouseNum = findViewById(R.id.mEtContentHouseNum);
        mEtContentRoomNum = findViewById(R.id.mEtContentRoomNum);
        mFLRenterMethod = findViewById(R.id.mFLRenterMethod);
    }

    @Override
    protected void initListener() {
        mRenterMethodsList = LocalUser.getInstance().getRenterMethodList();
        mFLRenterMethod.setAdapter(new MyTagAdapter(mRenterMethodsList, mActivity, mFLRenterMethod));
        mFLRenterMethod.setOnTagClickListener(this);

        mTvContentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressPickTask task = new AddressPickTask(mActivity);
                task.setHideProvince(false);
                task.setHideCounty(false);
                task.setCallback(new AddressPickTask.Callback() {
                    @Override
                    public void onAddressInitFailed() {
//                        showToast("数据初始化失败");
                    }

                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
//                        if (county == null) {
//                            showToast(province.getAreaName() + city.getAreaName());
//                        } else {
//                            showToast(province.getAreaName() + city.getAreaName() + county.getAreaName());
//                        }
                    }
                });
                task.execute("北京市", "北京市", "东城区");
            }
        });
    }

    public void fillData(CommitContractInfo commitContractInfo) {
        mEtContentRenterName.setText(NullUtil.getString2(commitContractInfo.tenancyName));
        mEtContentPhone.setText(NullUtil.getString2(commitContractInfo.tenancyMobile));
        mEtContentIDNum.setText(NullUtil.getString2(commitContractInfo.tenancyIdcard));
        mFLRenterMethod.getAdapter().setSelected(commitContractInfo.tenancyType-1);
        mTvContentCity.setText(NullUtil.getString2(commitContractInfo.cityNo));
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
        String tenancyName = getEditTextStr(mEtContentRenterName);
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        if(InputVerifyUtil.checkRenterName(tenancyName)) {
            commitContractInfo.tenancyName = tenancyName;
        }else {
            return false;
        }
        String tenancyMobile = getEditTextStr(mEtContentPhone);
        if(InputVerifyUtil.checkMobile(tenancyMobile)) {
            commitContractInfo.tenancyMobile = tenancyMobile;
        }else {
            return false;
        }
        String tenancyIdcard = getEditTextStr(mEtContentIDNum);
        if(InputVerifyUtil.checkIdCard(tenancyIdcard)) {
            commitContractInfo.tenancyIdcard = tenancyIdcard;
        }else {
            return false;
        }
        String cityNo = mTvContentCity.getText().toString();
        if(InputVerifyUtil.checkEmpty(cityNo,"所在城市")) {
            commitContractInfo.cityNo = cityNo;
        }else {
            return false;
        }
        String houseName = getEditTextStr(mEtContentCommunity);
        if(InputVerifyUtil.checkEmpty(houseName,"小区名称")) {
            commitContractInfo.houseName = houseName;
        }else {
            return false;
        }
        String houseCode = getEditTextStr(mEtContentHouseNum);
        if(InputVerifyUtil.checkEmpty(houseCode,"门牌号")) {
            commitContractInfo.houseCode = houseCode;
        }else{
            return false;
        }
        String roomNum = getEditTextStr(mEtContentRoomNum);
        if(InputVerifyUtil.checkEmpty(roomNum,"房间号")) {
            commitContractInfo.roomNum = roomNum;
        }else {
            return false;
        }
        commitContractInfo.tenancyType=mFLRenterMethod.getSelected();
        return true;
    }

    private String getEditTextStr(EditText editText){
        return editText.getText().toString();
    }
}
