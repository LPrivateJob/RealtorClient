package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagAdapter;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * description: 分期信息UI
 * autour: lewish
 * created at: 2018/1/6 10:35
 */
public class InstallmentInfoFragment extends BaseFragment {
    private static final String[] SERVICE_FEE_BEAR_VALS = new String[]{"租客", "中介"};
    private static final String[] DOWN_PAYMENTS_METHOD_VALS = new String[]{"押一付一"};
    private static final String[] PLATFORM_PAYMENT_METHOD_VALS = new String[]{"季付","半年付","年付"};
    private EditText mEtContentMonthlyRent;
    private EditText mEtContentLeaseFrom;
    private EditText mEtContentLeaseTo;
    private TagFlowLayout mFLServiceFeeBear;
    private TagFlowLayout mFLDownPaymentsMethod;
    private TagFlowLayout mFLPlatformPaymentMethod;

    @Override
    protected void initView(View rootView, Bundle savedInstanceState) {
        mEtContentMonthlyRent = findViewById(R.id.mEtContentMonthlyRent);
        mEtContentLeaseFrom = findViewById(R.id.mEtContentLeaseFrom);
        mEtContentLeaseTo = findViewById(R.id.mEtContentLeaseTo);

        mFLServiceFeeBear = findViewById(R.id.mFLServiceFeeBear);
        mFLDownPaymentsMethod = findViewById(R.id.mFLDownPaymentsMethod);
        mFLPlatformPaymentMethod = findViewById(R.id.mFLPlatformPaymentMethod);

        mFLServiceFeeBear.setAdapter(new TagAdapter<String>(SERVICE_FEE_BEAR_VALS) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.widget_flowlayout_tv,
                        mFLServiceFeeBear, false);
                tv.setText(s);
                return tv;
            }
        });

        mFLDownPaymentsMethod.setAdapter(new TagAdapter<String>(DOWN_PAYMENTS_METHOD_VALS) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.widget_flowlayout_tv,
                        mFLDownPaymentsMethod, false);
                tv.setText(s);
                return tv;
            }
        });

        mFLPlatformPaymentMethod.setAdapter(new TagAdapter<String>(PLATFORM_PAYMENT_METHOD_VALS) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.widget_flowlayout_tv,
                        mFLPlatformPaymentMethod, false);
                tv.setText(s);
                return tv;
            }
        });
    }

    @Override
    protected void initListener() {
        mEtContentLeaseFrom.setOnClickListener(v -> {
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseFrom.setText(year + "-" + month + "-" + day));
        });
        mEtContentLeaseTo.setOnClickListener(v -> {
            showYearMonthDayPicker((year, month, day) -> mEtContentLeaseTo.setText(year + "-" + month + "-" + day));
        });
        mFLServiceFeeBear.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getActivity(), SERVICE_FEE_BEAR_VALS[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });
        mFLDownPaymentsMethod.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(getActivity(), DOWN_PAYMENTS_METHOD_VALS[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });
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
}
