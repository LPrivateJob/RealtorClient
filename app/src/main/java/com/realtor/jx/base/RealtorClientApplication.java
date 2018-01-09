package com.realtor.jx.base;

import android.app.Application;
import android.content.Context;

/**
 * description:
 * autour: lewish
 * created at: 2018/1/9 23:22
 */

public class RealtorClientApplication extends Application {
    private static RealtorClientApplication instannce;
    private static Context mContext;
    private static final String TAG = RealtorClientApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        instannce = this;
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
