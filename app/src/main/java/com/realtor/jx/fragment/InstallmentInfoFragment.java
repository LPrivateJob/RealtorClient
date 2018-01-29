package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
import com.realtor.jx.widget.flowlayout.TagFlowLayout;
import com.realtor.jx.widget.picker.common.util.ConvertUtils;
import com.realtor.jx.widget.picker.wheelpicker.picker.DatePicker;

import java.util.List;


/**
 * description: 分期信息UI
 * autour: lewish
 * created at: 2018/1/6 10:35
 */
public class InstallmentInfoFragment extends BaseFragment{
    private List<FlowLayoutTypeBean> mServiceFeeBearList;
    private List<FlowLayoutTypeBean> mDownPaymentsMethodList;
    private List<FlowLayoutTypeBean> mPlatformPaymentMethodList;
    private EditText mEtContentMonthlyRent;
    private TextView mEtContentLeaseFrom;
    private TextView mEtContentLeaseTo;
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
    }

    @Override
    protected void loadData() {
        super.loadData();
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        if (commitContractInfo.cash != 0) {
            mEtContentMonthlyRent.setText(NullUtil.convertFen2YuanStr(commitContractInfo.cash));
        }
        if (!StringUtil.isEmpty(commitContractInfo.startTime)) {
            mEtContentLeaseFrom.setText(commitContractInfo.startTime);
        }
        if (!StringUtil.isEmpty(commitContractInfo.endTime)) {
            mEtContentLeaseTo.setText(commitContractInfo.endTime);
        }
        mFLServiceFeeBear.getAdapter().setSelected(commitContractInfo.feeType == 0 ? 0 : commitContractInfo.feeType - 1);
        mFLDownPaymentsMethod.getAdapter().setSelected(commitContractInfo.firstPaytype == 0 ? 0 : commitContractInfo.firstPaytype - 1);
        mFLPlatformPaymentMethod.getAdapter().setSelected(commitContractInfo.platformPayType == 0 ? 0 : commitContractInfo.platformPayType - 1);
        // TODO: 期数待计算
//            mEtContentRepaymentPeriod.setText("" + commitContractInfo.payTerm);
        if (!StringUtil.isEmpty(commitContractInfo.changeNo)) {
            mEtContentAccountNum.setText(commitContractInfo.changeNo);
        }
        if (!StringUtil.isEmpty(commitContractInfo.info)) {
            mEtContentRemarks.setText(commitContractInfo.info);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_installment_info;
    }

    public void showYearMonthDayPicker(DatePicker.OnYearMonthDayPickListener onYearMonthDayPickListener) {
        final DatePicker picker = new DatePicker(mActivity);
        picker.setCanceledOnTouchOutside(false);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(mActivity, 10));
        picker.setRangeEnd(2100, 1, 1);
        picker.setRangeStart(2018, 1, 1);
        picker.setSelectedItem(2018, 1, 1);
        picker.setResetWhileWheel(false);
        picker.setOnDatePickListener(onYearMonthDayPickListener);
        picker.show();
    }

    public boolean saveContractInfo() {
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        String cash = getEditTextStr(mEtContentMonthlyRent);
        if (InputVerifyUtil.checkEmpty(cash, "月租金")) {
            commitContractInfo.cash = NullUtil.convertYuan2FenI(cash);
        } else {
            return false;
        }
        String startTime = mEtContentLeaseFrom.getText().toString();
        if (InputVerifyUtil.checkEmpty(startTime, "起租日")) {
            commitContractInfo.startTime = startTime;
        } else {
            return false;
        }
        String endTime = mEtContentLeaseTo.getText().toString();
        if (InputVerifyUtil.checkEmpty(endTime, "到租日")) {
            commitContractInfo.endTime = endTime;
        } else {
            return false;
        }
        String payTerm = getEditTextStr(mEtContentRepaymentPeriod);
        if (InputVerifyUtil.checkEmpty(payTerm, "还款期数")) {
            commitContractInfo.payTerm = Integer.parseInt(payTerm);
        } else {
            return false;
        }
        commitContractInfo.changeNo = getEditTextStr(mEtContentAccountNum);
        commitContractInfo.info = getEditTextStr(mEtContentRemarks);
        commitContractInfo.feeType = mFLServiceFeeBear.getSelected();
        commitContractInfo.firstPaytype = mFLDownPaymentsMethod.getSelected();
        commitContractInfo.platformPayType = mFLPlatformPaymentMethod.getSelected();
        return true;
    }

    @Override
    public void onStop() {
        super.onStop();
        CommitContractInfo commitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        String cash = getEditTextStr(mEtContentMonthlyRent);
        if (!StringUtil.isEmpty(cash)) {
            commitContractInfo.cash = NullUtil.convertYuan2FenI(cash);
        }
        String startTime = mEtContentLeaseFrom.getText().toString();
        if (!StringUtil.isEmpty(startTime)) {
            commitContractInfo.startTime = startTime;
        }
        String endTime = mEtContentLeaseTo.getText().toString();
        if (!StringUtil.isEmpty(endTime)) {
            commitContractInfo.endTime = endTime;
        }
        String payTerm = getEditTextStr(mEtContentRepaymentPeriod);
        if (!StringUtil.isEmpty(payTerm)) {
            commitContractInfo.payTerm = Integer.parseInt(payTerm);
        }
        commitContractInfo.changeNo = getEditTextStr(mEtContentAccountNum);
        commitContractInfo.info = getEditTextStr(mEtContentRemarks);
        commitContractInfo.feeType = mFLServiceFeeBear.getSelected();
        commitContractInfo.firstPaytype = mFLDownPaymentsMethod.getSelected();
        commitContractInfo.platformPayType = mFLPlatformPaymentMethod.getSelected();
    }

    private String getEditTextStr(EditText editText) {
        return editText.getText().toString();
    }
}
