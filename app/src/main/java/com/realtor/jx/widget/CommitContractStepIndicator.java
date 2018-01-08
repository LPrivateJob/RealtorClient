package com.realtor.jx.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtor.jx.R;

/**
 * author: sundong
 * created at 2018/1/8 14:47
 */

public class CommitContractStepIndicator extends RelativeLayout {
    private static final String NORMAL_COLOR = "#cccccc";
    private static final String SELECTED_COLOR = "#333333";

    public enum STEP {
        LOCATION, AGING, PHOTO
    }

    private Context mContext;
    private TextView mTvAging;
    private TextView mTvPhoto;
    private ImageView mIvAging;
    private ImageView mIvPhoto;
    private STEP mStep = STEP.LOCATION;

    public CommitContractStepIndicator(Context context) {
        this(context, null);
    }

    public CommitContractStepIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommitContractStepIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_commitcontract_indicator, this);
        mTvAging = findViewById(R.id.mTvAging);
        mTvPhoto = findViewById(R.id.mTvPhoto);
        mIvAging = findViewById(R.id.mIvAging);
        mIvPhoto = findViewById(R.id.mIvPhoto);

        refreshUi(mStep);
    }

    private void refreshUi(STEP mStep) {
        switch (this.mStep) {
            case LOCATION:
                mTvAging.setTextColor(Color.parseColor(NORMAL_COLOR));
                mTvPhoto.setTextColor(Color.parseColor(NORMAL_COLOR));
                mIvAging.setBackgroundResource(R.drawable.icon_aging_todo);
                mIvPhoto.setBackgroundResource(R.drawable.icon_photo_todo);
                break;
            case AGING:
                mTvAging.setTextColor(Color.parseColor(SELECTED_COLOR));
                mTvPhoto.setTextColor(Color.parseColor(NORMAL_COLOR));
                mIvAging.setBackgroundResource(R.drawable.icon_aging_done);
                mIvPhoto.setBackgroundResource(R.drawable.icon_photo_todo);
                break;
            case PHOTO:
                mTvAging.setTextColor(Color.parseColor(SELECTED_COLOR));
                mTvPhoto.setTextColor(Color.parseColor(SELECTED_COLOR));
                mIvAging.setBackgroundResource(R.drawable.icon_aging_done);
                mIvPhoto.setBackgroundResource(R.drawable.icon_photo_done);
                break;
        }
    }
}
