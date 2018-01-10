package com.realtor.jx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.realtor.jx.R;

/**
 * description:
 * autour: lewish
 * created at: 2018/1/10 22:11
 */
public class BottomButton extends LinearLayout {
    private static final String COLOR_RED = "#cd3500";
    private static final String DEFAULT_TXT_COLOR = "#ffffff";
    private Context mContext;
    private TextView mButton;
    private int mBgColor;
    private int mTxtColor;
    private float mTxtFontSize;

    public BottomButton(Context context) {
        this(context, null);
    }

    public BottomButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        View view = inflate(context, R.layout.widget_bottom_button, this);
        mButton = view.findViewById(R.id.mButton);
        TypedArray ta = context.obtainStyledAttributes(R.styleable.BottomButton);
        mBgColor = ta.getColor(R.styleable.BottomButton_bg, Color.parseColor(COLOR_RED));
        mTxtColor = ta.getColor(R.styleable.BottomButton_txtColor, Color.parseColor(DEFAULT_TXT_COLOR));
        mTxtFontSize = ta.getDimension(R.styleable.BottomButton_txtSize, context.getResources().getDimension(R.dimen.x36));
        ta.recycle();

        mButton.setBackgroundColor(mBgColor);
        mButton.setTextColor(mTxtColor);
        mButton.setTextSize(mTxtFontSize);
    }

    public interface OnInteractListener {
        void onClick();
    }
}
