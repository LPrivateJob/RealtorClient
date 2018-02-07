package com.realtor.jx.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * description: TagView
 * autour: Tait
 * created at 2018/1/10 9:50
 */
public class BanSlideViewPager extends ViewPager {
    public BanSlideViewPager(Context context) {
        super(context);
    }

    public BanSlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
