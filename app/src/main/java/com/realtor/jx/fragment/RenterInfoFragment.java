package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.realtor.jx.R;
import com.realtor.jx.activity.CommitContractActivity;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.entity.CommitContractInfo;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.utils.InputVerifyUtil;
import com.realtor.jx.utils.NullUtil;
import com.realtor.jx.utils.StringUtil;
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

public class RenterInfoFragment extends BaseFragment{
    private List<FlowLayoutTypeBean> mRenterMethodsList;
    private EditText mEtContentRenterName;
    private EditText mEtContentPhone;
    private EditText mEtContentIDNum;
    private EditText mTvContentCity;
    private EditText mEtContentCommunity;
    private EditText mEtContentHouseNum;
    private EditText mEtContentRoomNum;
    private TagFlowLayout mFLRenterMethod;

    private String mSelectedProvince = "";
    private String mSelectedCity = "";
    private String mSelectedRegion = "";
    private String mSelectedCityId = "";

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
        //租住方式
        mRenterMethodsList = LocalUser.getInstance().getRenterMethodList();
        mFLRenterMethod.setAdapter(new MyTagAdapter(mRenterMethodsList, mActivity, mFLRenterMethod));
        //地址选择三级联动
        mTvContentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddressPickTask task = new AddressPickTask(mActivity);
                task.setHideProvince(false);
                task.setHideCounty(false);
                task.setCallback(new AddressPickTask.Callback() {
                    @Override
                    public void onAddressInitFailed() {
                        Logger.e("地址选择器初始化失败");
                    }

                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
                        String mTvStr = "";
                        if (city == null) {
                            mTvStr = province.getAreaName() + "  ";
                            mSelectedCityId = province.getAreaId();
                        } else if (county == null) {
                            mTvStr = province.getAreaName() + "  " + city.getAreaName() + "  ";
                            mSelectedCityId = city.getAreaId();
                        } else {
                            mTvStr = province.getAreaName() + "  " + city.getAreaName() + "  " + county.getAreaName();
                            mSelectedCityId = county.getAreaId();
                        }
                        Toast.makeText(mActivity, "txt=" + mTvStr + ",id=" + mSelectedCityId, Toast.LENGTH_SHORT).show();
                        mTvContentCity.setText(mTvStr);
                    }
                });
                task.execute(mSelectedProvince, mSelectedCity, mSelectedRegion);
            }
        });
    }

    public void fillData(CommitContractInfo commitContractInfo, ContractDetailDto result) {
        //三级联动部分UI展示处理
        mSelectedCityId = NullUtil.getString(commitContractInfo.cityNo);
        ContractDetailDto.AreasBean areas = result.getAreas();
        //市、县防止后台返null，省返null就gg
        mSelectedProvince = areas.getProvince().getName();
        if (areas.getCity() != null) {
            mSelectedCity = areas.getCity().getName();
        }
        if (areas.getRegion() != null) {
            mSelectedRegion = areas.getRegion().getName();
        }
        //后台懒得直接返一个字符串，自己拼。。。
        String mTvStr;
        if (StringUtil.isEmpty(mSelectedCity)) {
            mTvStr = mSelectedProvince + "  ";
        } else if (StringUtil.isEmpty(mSelectedRegion)) {
            mTvStr = mSelectedProvince + "  " + mSelectedCity + "  ";
        } else {
            mTvStr = mSelectedProvince + "  " + mSelectedCity + "  " + mSelectedRegion;
        }
        mTvContentCity.setText(mTvStr);
        //其他UI展示
        mEtContentRenterName.setText(NullUtil.getString2(commitContractInfo.tenancyName));
        mEtContentPhone.setText(NullUtil.getString2(commitContractInfo.tenancyMobile));
        mEtContentIDNum.setText(NullUtil.getString2(commitContractInfo.tenancyIdcard));
        mFLRenterMethod.getAdapter().setSelected(commitContractInfo.tenancyType - 1);
        mEtContentCommunity.setText(NullUtil.getString2(commitContractInfo.houseName));
        mEtContentHouseNum.setText(NullUtil.getString2(commitContractInfo.houseCode));
        mEtContentRoomNum.setText(NullUtil.getString2(commitContractInfo.roomNum));
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_renter_info;
    }

    public boolean saveContractInfo() {
        String tenancyName = getEditTextStr(mEtContentRenterName);
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        if (InputVerifyUtil.checkRenterName(tenancyName)) {
            commitContractInfo.tenancyName = tenancyName;
        } else {
            return false;
        }
        String tenancyMobile = getEditTextStr(mEtContentPhone);
        if (InputVerifyUtil.checkMobile(tenancyMobile)) {
            commitContractInfo.tenancyMobile = tenancyMobile;
        } else {
            return false;
        }
        String tenancyIdcard = getEditTextStr(mEtContentIDNum);
        if (InputVerifyUtil.checkIdCard(tenancyIdcard)) {
            commitContractInfo.tenancyIdcard = tenancyIdcard;
        } else {
            return false;
        }
        if (InputVerifyUtil.checkEmpty(mSelectedCityId, "所在城市")) {
            commitContractInfo.cityNo = mSelectedCityId;
        } else {
            return false;
        }
        String houseName = getEditTextStr(mEtContentCommunity);
        if (InputVerifyUtil.checkEmpty(houseName, "小区名称")) {
            commitContractInfo.houseName = houseName;
        } else {
            return false;
        }
        String houseCode = getEditTextStr(mEtContentHouseNum);
        if (InputVerifyUtil.checkEmpty(houseCode, "门牌号")) {
            commitContractInfo.houseCode = houseCode;
        } else {
            return false;
        }
        String roomNum = getEditTextStr(mEtContentRoomNum);
        if (InputVerifyUtil.checkEmpty(roomNum, "房间号")) {
            commitContractInfo.roomNum = roomNum;
        } else {
            return false;
        }
        commitContractInfo.tenancyType = mFLRenterMethod.getSelected();
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private String getEditTextStr(EditText editText) {
        return editText.getText().toString();
    }
}
