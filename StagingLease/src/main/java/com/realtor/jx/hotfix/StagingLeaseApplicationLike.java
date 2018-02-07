package com.realtor.jx.hotfix;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.realtor.jx.BuildConfig;
import com.realtor.jx.manager.BuglyManager;
import com.realtor.jx.manager.PhoneInfoManager;
import com.realtor.jx.netcore.NetConfig;
import com.realtor.jx.netcore.core.NetEngine;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * author: sundong
 * created at 2018/2/7 15:21
 */
public class StagingLeaseApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "StagingLeaseApplication";
    private static StagingLeaseApplication instannce;
    private static Context mContext;

    public StagingLeaseApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instannce = (StagingLeaseApplication) getApplication();
        mContext = getApplication().getApplicationContext();
        initLogger();
        initNetEngine();
        BuglyManager.getInstance().init();
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
        NetEngine.init(NetConfig.create(instannce));
    }

    public static Context getContext() {
        return mContext;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // TODO: 安装tinker
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(
            Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Beta.unInit();
    }
}
