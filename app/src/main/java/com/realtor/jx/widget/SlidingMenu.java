package com.realtor.jx.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.realtor.jx.R;
import com.realtor.jx.entity.Commons;

/**
 * author: sundong
 * created at 2018/1/9 17:25
 */
public class SlidingMenu extends LinearLayout {
    private Context mContext;
    private RadioGroup mRgFilter;
    private Integer mFilterContractStateCode;
    private OnInteractListener mOnInteractListener;

    public SlidingMenu(Context context) {
        this(context, null);
    }

    public SlidingMenu(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_slidingmenu, this);
        mRgFilter = findViewById(R.id.mRgFilter);
        mRgFilter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mRbAll:
                        mFilterContractStateCode = null;
                        break;
                    case R.id.mRbApplying:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_APPLYING;
                        break;
                    case R.id.mRbWaitModify:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITMODIFY;
                        break;
                    case R.id.mRbWaitReview:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITREVIEW;
                        break;
                    case R.id.mRbInReview:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_INREVIEW;
                        break;
                    case R.id.mRbWaitScanQRcode:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_WAITSCANQRCODE;
                        break;
                    case R.id.mRbReject:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_REJECT;
                        break;
                    case R.id.mRbInRepayment:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_INREPAYMENT;
                        break;
                    case R.id.mRbSettled:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_SETTLED;
                        break;
                    case R.id.mRbRenege:
                        mFilterContractStateCode = Commons.CONTRACT_STATUS.CONTRACT_STATE_RENEGE;
                        break;
                }
                if (mOnInteractListener != null) {
                    mOnInteractListener.onChecked(mFilterContractStateCode);
                }
            }
        });
    }

    public interface OnInteractListener {
        void onChecked(Integer filterContractStateCode);
    }

    public void setOnInteractListener(OnInteractListener mOnInteractListener) {
        this.mOnInteractListener = mOnInteractListener;
    }
}
