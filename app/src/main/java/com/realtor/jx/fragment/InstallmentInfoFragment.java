package com.realtor.jx.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.realtor.jx.R;
import com.realtor.jx.adapter.MyTagAdapter;
import com.realtor.jx.base.BaseFragment;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.entity.LocalUser;
import com.realtor.jx.widget.flowlayout.FlowLayout;
import com.realtor.jx.widget.flowlayout.TagFlowLayout;

import java.util.List;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

/**
 * description: 分期信息UI
 * autour: lewish
 * created at: 2018/1/6 10:35
 */
public class InstallmentInfoFragment extends BaseFragment implements TagFlowLayout.OnTagClickListener {
    private List<UserInfoDto.FlowLayoutTypeBean> mServiceFeeBearList;
    private List<UserInfoDto.FlowLayoutTypeBean> mDownPaymentsMethodList;
    private List<UserInfoDto.FlowLayoutTypeBean> mPlatformPaymentMethodList;
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
}
