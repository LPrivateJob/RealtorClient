package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.realtor.jx.R;
import com.realtor.jx.activity.CommitContractActivity;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dao.AppDAO;
import com.realtor.jx.dto.CalTermDto;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.entity.CommitContractInfo;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.utils.InputVerifyUtil;
import com.realtor.jx.utils.NullUtil;
import com.realtor.jx.utils.StringUtil;
import com.realtor.jx.widget.CommonMsgDialog;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;
import com.realtor.jx.widget.picker.common.util.ConvertUtils;
import com.realtor.jx.widget.picker.wheelpicker.picker.DatePicker;

import java.util.ArrayList;
import java.util.List;


/**
 * description: 分期信息UI
 * autour: Tait
 * created at: 2018/1/6 10:35
 */
public class InstallmentInfoFragment extends BaseFragment {
    private List<FlowLayoutTypeBean> mServiceFeeBearList;
    private List<FlowLayoutTypeBean> mDownPaymentsMethodList;
    private List<FlowLayoutTypeBean> mPlatformPaymentMethodList;
    private String mStartDate;
    private String mEndDate;
    private EditText mEtContentMonthlyRent;
    private TextView mEtContentLeaseFrom;
    private TextView mEtContentLeaseTo;
    private TagFlowLayout mFLServiceFeeBear;
    private TagFlowLayout mFLDownPaymentsMethod;
    private TagFlowLayout mFLPlatformPaymentMethod;
    private EditText mEtContentAccountNum;
    private EditText mEtContentRemarks;
    private Spinner mTermSpinner;
    private List<Integer> mSpinnerList = new ArrayList<>();
    private ArrayAdapter<Integer> mSpinnerAdapter;
    private CommitContractInfo mCommitContractInfo;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentMonthlyRent = findViewById(R.id.mEtContentMonthlyRent);
        mEtContentLeaseFrom = findViewById(R.id.mEtContentLeaseFrom);
        mEtContentLeaseTo = findViewById(R.id.mEtContentLeaseTo);

        mFLServiceFeeBear = findViewById(R.id.mFLServiceFeeBear);
        mFLDownPaymentsMethod = findViewById(R.id.mFLDownPaymentsMethod);
        mFLPlatformPaymentMethod = findViewById(R.id.mFLPlatformPaymentMethod);

        mEtContentAccountNum = findViewById(R.id.mEtContentAccountNum);
        mEtContentRemarks = findViewById(R.id.mEtContentRemarks);
        mTermSpinner = findViewById(R.id.mTermSpinner);

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
            showYearMonthDayPicker((year, month, day) -> {
                mStartDate = year + "-" + month + "-" + day;
                mEtContentLeaseFrom.setText(mStartDate);
                calTerm();
            });
        });
        mEtContentLeaseTo.setOnClickListener(v -> {
            showYearMonthDayPicker((year, month, day) -> {
                mEndDate = year + "-" + month + "-" + day;
                mEtContentLeaseTo.setText(mEndDate);
                calTerm();
            });
        });
        mSpinnerAdapter = new ArrayAdapter<Integer>(mActivity, android.R.layout.simple_spinner_item, mSpinnerList);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTermSpinner.setAdapter(mSpinnerAdapter);
    }

    @Override
    protected void loadData() {
        super.loadData();
        mCommitContractInfo = ((CommitContractActivity) mActivity).getCommitContractInfo();
        if (mCommitContractInfo.cash != 0) {
            mEtContentMonthlyRent.setText(NullUtil.convertFen2YuanStr(mCommitContractInfo.cash));
        }
        if (!StringUtil.isEmpty(mCommitContractInfo.startTime)) {
            mEtContentLeaseFrom.setText(mCommitContractInfo.startTime);
        }
        if (!StringUtil.isEmpty(mCommitContractInfo.endTime)) {
            mEtContentLeaseTo.setText(mCommitContractInfo.endTime);
        }
        mFLServiceFeeBear.getAdapter().setSelected(mCommitContractInfo.feeType == 0 ? 0 : mCommitContractInfo.feeType - 1);
        mFLDownPaymentsMethod.getAdapter().setSelected(mCommitContractInfo.firstPaytype == 0 ? 0 : mCommitContractInfo.firstPaytype - 1);
        mFLPlatformPaymentMethod.getAdapter().setSelected(mCommitContractInfo.platformPayType == 0 ? 0 : mCommitContractInfo.platformPayType - 1);

        mSpinnerList.add(mCommitContractInfo.payTerm);
        mSpinnerAdapter.notifyDataSetChanged();

        if (!StringUtil.isEmpty(mCommitContractInfo.changeNo)) {
            mEtContentAccountNum.setText(mCommitContractInfo.changeNo);
        }
        if (!StringUtil.isEmpty(mCommitContractInfo.info)) {
            mEtContentRemarks.setText(mCommitContractInfo.info);
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
        int selectedTerm = (int) mTermSpinner.getSelectedItem();
        if (selectedTerm != 0) {
            commitContractInfo.payTerm = selectedTerm;
        } else {
            CommonMsgDialog.newTip("还款期数不能为0，您选择的起租日期与到租日期不正确,请重新选择").show(getChildFragmentManager());
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

        int selectedTerm = (int) mTermSpinner.getSelectedItem();
        if (selectedTerm != 0) {
            commitContractInfo.payTerm = selectedTerm;
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

    private void calTerm() {
        String startDate = mEtContentLeaseFrom.getText().toString();
        String endDate = mEtContentLeaseTo.getText().toString();
        if (!StringUtil.isEmpty(startDate) && !StringUtil.isEmpty(endDate)) {
            AppDAO.getInstance().calTerm(startDate, endDate, new JsonUiCallback<CalTermDto>(mActivity) {
                @Override
                public void onSuccess(CalTermDto result) {
                    List<Integer> terms = result.getTerms();
                    mSpinnerList.clear();
                    mSpinnerList.addAll(terms);
                    mSpinnerAdapter.notifyDataSetChanged();
                }
            });

        }
    }
}
