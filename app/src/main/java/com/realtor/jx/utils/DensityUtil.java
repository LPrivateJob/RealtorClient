/**
 * Project Name:CustomAndroid
 * File Name:DensityUtil.java
 * Package Name:custom.android.util
 * Date:2014-12-1下午4:50:40
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 */

package com.realtor.jx.utils;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.realtor.jx.base.RealtorClientApplication;


/**
 * description:
 * autour: Tait
 * created at 2018/1/18 14:47
 */
public class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = RealtorClientApplication.getContext().getResources().getDisplayMetrics()
                .density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = RealtorClientApplication.getContext().getResources().getDisplayMetrics()
                .density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        final float fontScale = RealtorClientApplication.getContext().getResources()
                .getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = RealtorClientApplication.getContext().getResources()
                .getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获得状态栏的高度
     *
     * @return
     */
    public static int getStatusHeight() {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = RealtorClientApplication.getContext().getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获取手机屏宽
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = RealtorClientApplication.getContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取手机屏高
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = RealtorClientApplication.getContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static void setViewDrawableLeft(TextView view, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(drawable, null, null, null);
        } else {
            view.setCompoundDrawables(null, null, null, null);
        }
    }

    public static void setViewDrawableRight(TextView view, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(null, null, drawable, null);
        } else {
            view.setCompoundDrawables(null, null, null, null);
        }
    }
}
