package com.realtor.jx.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.realtor.jx.BuildConfig;
import com.realtor.jx.manager.PhoneInfoManager;
import com.realtor.jx.netcore.NetConfig;
import com.realtor.jx.netcore.core.NetEngine;

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
        initLogger();
        initNetEngine();
        PhoneInfoManager.init(mContext);
        Logger.d("Application Start!");
    }

    // Logger 初始化
    private void initLogger() {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default
                // true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset.
                // Default 5
                //.logStrategy(null)      // (Optional) Changes the log strategy to print out.
                // Default LogCat
                .tag("RealtorClient")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();


        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    // 网络引擎框架初始化
    private void initNetEngine() {
        NetEngine.init(NetConfig.create(this));
    }

    public static Context getContext() {
        return mContext;
    }
}
