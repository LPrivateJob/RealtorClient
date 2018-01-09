package com.realtor.jx.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.realtor.jx.R;

/**
 * author: sundong
 * created at 2018/1/9 17:25
 */
public class SlidingMenu extends LinearLayout {
    private Context mContext;
    public SlidingMenu(Context context) {
        this(context,null);
    }

    public SlidingMenu(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SlidingMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(mContext, R.layout.widget_slidingmenu,this);
    }
}
