package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * description: 分期信息UI
 * autour: lewish
 * created at: 2018/1/6 10:35
*/
public class InstallmentInfoFragment extends BaseFragment {

    private EditText mEtContentMonthlyRent;
    private EditText mEtContentLeaseFrom;
    private EditText mEtContentLeaseTo;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentMonthlyRent = findViewById(R.id.mEtContentMonthlyRent);
        mEtContentLeaseFrom = findViewById(R.id.mEtContentLeaseFrom);
        mEtContentLeaseTo = findViewById(R.id.mEtContentLeaseTo);
    }

    @Override
    protected void initListener() {
        mEtContentLeaseFrom.setOnClickListener(v->{
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseFrom.setText(year + "-" + month + "-" + day));
        });
        mEtContentLeaseTo.setOnClickListener(v->{
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseTo.setText(year + "-" + month + "-" + day));
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_installment_info;
    }

    public void showYearMonthDayPicker(DatePicker.OnYearMonthDayPickListener onYearMonthDayPickListener){
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
}
