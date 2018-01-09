package com.realtor.jx.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.realtor.jx.R;
import com.realtor.jx.entity.Constants;

/**
 * author: sundong
 * created at 2018/1/9 17:25
 */
public class SlidingMenu extends LinearLayout {
    private Context mContext;
    private RadioGroup mRgFilter;
    private int mFilterContractStateCode;
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
                        break;
                    case R.id.mRbWaitModify:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_WAITMODIFY;
                        break;
                    case R.id.mRbWaitReview:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_WAITREVIEW;
                        break;
                    case R.id.mRbInReview:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_INREVIEW;
                        break;
                    case R.id.mRbWaitScanQRcode:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_WAITSCANQRCODE;
                        break;
                    case R.id.mRbReject:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_REJECT;
                        break;
                    case R.id.mRbInRepayment:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_INREPAYMENT;
                        break;
                    case R.id.mRbSettled:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_SETTLED;
                        break;
                    case R.id.mRbRenege:
                        mFilterContractStateCode = Constants.CONTRACT_STATE_RENEGE;
                        break;
                }
                if (mOnInteractListener != null) {
                    mOnInteractListener.onChecked(mFilterContractStateCode);
                }
            }
        });
    }

    public interface OnInteractListener {
        void onChecked(int filterContractStateCode);
    }

    public void setOnInteractListener(OnInteractListener mOnInteractListener) {
        this.mOnInteractListener = mOnInteractListener;
    }
}
