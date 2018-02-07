package com.realtor.jx.netcore.utils;

import android.util.Log;

import com.realtor.jx.BuildConfig;


/**
 * description:
 * autour: Tait
 * created at 2017/5/24 15:10
 */
public class NetLogger {

    public static boolean debug = BuildConfig.DEBUG;

    private static final String TAG = "jr_online";
    private static final String NET_CORE_TAG = "NET-CORE";

    public static void i(String key, String msg) {
        if (debug) Log.i(key, msg);
    }

    public static void e(String key, String msg) {
        if (debug) Log.e(key, msg);
    }

    public static void d(String key, String msg) {
        if (debug) Log.d(key, msg);
    }

    public static void w(String key, String msg) {
        if (debug) Log.w(key, msg);
    }

    public static void v(String key, String msg) {
        if (debug) Log.v(key, msg);
    }

    public static void aipLog(String msg) {
        i(NET_CORE_TAG, msg);
    }

    public static void connLog(String msg) {
        v(NET_CORE_TAG, msg);
    }

    public static void connError(String msg) {
        e(NET_CORE_TAG, msg);
    }
}
