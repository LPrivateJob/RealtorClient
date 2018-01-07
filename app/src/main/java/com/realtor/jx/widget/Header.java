package com.realtor.jx.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.realtor.jx.R;

/**
 * autour: lewish
 * created at: 2018/1/7 23:20
 */

public class Header extends RelativeLayout implements View.OnClickListener {
    private Context mContext;
    private TextView mTvTitle;

    private boolean mIsShowDelete;
    private String mStrTitle;
    private OnInteractListener mOnInteractListener;

    public Header(Context context) {
        this(context, null);
    }

    public Header(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Header(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_header, this);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Header);
        mIsShowDelete = typedArray.getBoolean(R.styleable.Header_isShowDelete, false);
        mStrTitle = typedArray.getString(R.styleable.Header_title);
        typedArray.recycle();
        findViewById(R.id.mIvBack).setOnClickListener(this);
        findViewById(R.id.mIvDelete).setOnClickListener(this);
        mTvTitle = findViewById(R.id.mTvTitle);

        findViewById(R.id.mIvDelete).setVisibility(mIsShowDelete ? VISIBLE : GONE);
    }


    @Override
    public void onClick(View v) {
        if (mOnInteractListener == null)
            return;
        switch (v.getId()) {
            case R.id.mIvBack:
                mOnInteractListener.onBackClick();
                break;
            case R.id.mIvDelete:
                mOnInteractListener.onDeleteClick();
                break;
        }
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public interface OnInteractListener {
        void onBackClick();

        void onDeleteClick();
    }

    public void setOnInteractListener(OnInteractListener mOnInteractListener) {
        this.mOnInteractListener = mOnInteractListener;
    }
}
