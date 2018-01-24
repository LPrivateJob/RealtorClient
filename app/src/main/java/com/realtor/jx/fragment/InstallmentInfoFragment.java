package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
import com.realtor.jx.utils.StringUtil;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;
import com.realtor.jx.widget.picker.common.util.ConvertUtils;
import com.realtor.jx.widget.picker.wheelpicker.picker.DatePicker;

import java.util.List;


/**
 * description: 分期信息UI
 * autour: lewish
 * created at: 2018/1/6 10:35
 */
public class InstallmentInfoFragment extends BaseFragment implements TagFlowLayout.OnTagClickListener {
    private List<FlowLayoutTypeBean> mServiceFeeBearList;
    private List<FlowLayoutTypeBean> mDownPaymentsMethodList;
    private List<FlowLayoutTypeBean> mPlatformPaymentMethodList;
    private EditText mEtContentMonthlyRent;
    private EditText mEtContentLeaseFrom;
    private EditText mEtContentLeaseTo;
    private TagFlowLayout mFLServiceFeeBear;
    private TagFlowLayout mFLDownPaymentsMethod;
    private TagFlowLayout mFLPlatformPaymentMethod;
    private EditText mEtContentRepaymentPeriod;
    private EditText mEtContentAccountNum;
    private EditText mEtContentRemarks;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentMonthlyRent = findViewById(R.id.mEtContentMonthlyRent);
        mEtContentLeaseFrom = findViewById(R.id.mEtContentLeaseFrom);
        mEtContentLeaseTo = findViewById(R.id.mEtContentLeaseTo);

        mFLServiceFeeBear = findViewById(R.id.mFLServiceFeeBear);
        mFLDownPaymentsMethod = findViewById(R.id.mFLDownPaymentsMethod);
        mFLPlatformPaymentMethod = findViewById(R.id.mFLPlatformPaymentMethod);

        mEtContentRepaymentPeriod = findViewById(R.id.mEtContentRepaymentPeriod);
        mEtContentAccountNum = findViewById(R.id.mEtContentAccountNum);
        mEtContentRemarks = findViewById(R.id.mEtContentRemarks);

        mServiceFeeBearList = LocalUser.getInstance().getServiceFeeBearList();
        mDownPaymentsMethodList = LocalUser.getInstance().getDownPaymentsMethodList();
        mPlatformPaymentMethodList = LocalUser.getInstance().getPlatformPaymentMethodList();
        mFLServiceFeeBear.setAdapter(new MyTagAdapter(mServiceFeeBearList, mActivity, mFLServiceFeeBear));
        mFLDownPaymentsMethod.setAdapter(new MyTagAdapter(mDownPaymentsMethodList, mActivity, mFLDownPaymentsMethod));
        mFLPlatformPaymentMethod.setAdapter(new MyTagAdapter(mPlatformPaymentMethodList, mActivity, mFLPlatformPaymentMethod));

    }

    @Override
    protected void initListener() {
        mEtContentLeaseFrom.setOnClickListener(v -> {
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseFrom.setText(year + "-" + month + "-" + day));
        });
        mEtContentLeaseTo.setOnClickListener(v -> {
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseTo.setText(year + "-" + month + "-" + day));
        });
        mFLServiceFeeBear.setOnTagClickListener(this);
        mFLDownPaymentsMethod.setOnTagClickListener(this);
        mFLPlatformPaymentMethod.setOnTagClickListener(this);
    }

    @Override
    protected void loadData() {
        super.loadData();
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        if(commitContractInfo.isLoadFromNet) {
            mEtContentMonthlyRent.setText(NullUtil.convertFen2YuanStr(commitContractInfo.cash));
            mEtContentLeaseFrom.setText(commitContractInfo.startTime);
            mEtContentLeaseTo.setText(commitContractInfo.endTime);
            if(commitContractInfo.feeType!=null&& !StringUtil.isEmpty(commitContractInfo.feeType.getValue())) {
                mFLServiceFeeBear.getAdapter().setSelected(Integer.parseInt(commitContractInfo.feeType.getValue())-1);
            }
            if(commitContractInfo.firstPaytype!=null&&!StringUtil.isEmpty(commitContractInfo.firstPaytype.getValue())) {
                mFLDownPaymentsMethod.getAdapter().setSelected(Integer.parseInt(commitContractInfo.firstPaytype.getValue())-1);
            }
            if(commitContractInfo.platformPayType!=null&&!StringUtil.isEmpty(commitContractInfo.platformPayType.getValue())) {
                mFLPlatformPaymentMethod.getAdapter().setSelected(Integer.parseInt(commitContractInfo.platformPayType.getValue())-1);
            }
            mEtContentRepaymentPeriod.setText(""+commitContractInfo.payTerm);
            mEtContentAccountNum.setText(commitContractInfo.changeNo);
            mEtContentRemarks.setText(commitContractInfo.info);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_installment_info;
    }

    public void showYearMonthDayPicker(DatePicker.OnYearMonthDayPickListener onYearMonthDayPickListener) {
        final DatePicker picker = new DatePicker(mActivity);
        picker.setCanceledOnTouchOutside(true);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(mActivity, 10));
        picker.setRangeEnd(2100, 1, 1);
        picker.setRangeStart(2018, 1, 1);
        picker.setSelectedItem(2018, 1, 1);
        picker.setResetWhileWheel(false);
        picker.setOnDatePickListener(onYearMonthDayPickListener);
        picker.show();
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        if (parent == mFLServiceFeeBear) {
            //服务费承担方
            Toast.makeText(mActivity, mServiceFeeBearList.get(position).getLable(), Toast.LENGTH_SHORT).show();
        } else if (parent == mFLDownPaymentsMethod) {
            //租客首付方式
            Toast.makeText(mActivity, mDownPaymentsMethodList.get(position).getLable(), Toast.LENGTH_SHORT).show();
        } else if (parent == mFLPlatformPaymentMethod) {
            //平台付款方式
            Toast.makeText(mActivity, mPlatformPaymentMethodList.get(position).getLable(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public boolean saveContractInfo(){
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        String cash = getEditTextStr(mEtContentMonthlyRent);
        if(InputVerifyUtil.checkEmpty(cash,"月租金")) {
            commitContractInfo.cash=NullUtil.convertYuan2FenI(cash);
        }else {
            return false;
        }
        String startTime = getEditTextStr(mEtContentLeaseFrom);
        if(InputVerifyUtil.checkEmpty(startTime,"起租日")) {
            commitContractInfo.startTime = startTime;
        }else {
            return false;
        }
        String endTime = getEditTextStr(mEtContentLeaseTo);
        if(InputVerifyUtil.checkEmpty(endTime,"到租日")) {
            commitContractInfo.endTime = endTime;
        }else {
            return false;
        }
        String payTerm = getEditTextStr(mEtContentRepaymentPeriod);
        if(InputVerifyUtil.checkEmpty(payTerm,"还款期数")) {
            commitContractInfo.payTerm = Integer.parseInt(payTerm);
        }else {
            return false;
        }
        return true;
    }

    private String getEditTextStr(EditText editText){
        return editText.getText().toString();
    }
}
