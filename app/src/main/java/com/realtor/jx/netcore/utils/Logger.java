package com.realtor.jx.netcore.utils;

import android.util.Log;

import com.yingu.am.BuildConfig;

import java.io.FileOutputStream;

public class Logger {
    public static boolean debug = BuildConfig.DEBUG;

    private static final String TAG = "AM";

    // 根据需要将Log存放到SD卡中
    private static String path;
    private static FileOutputStream outputStream;

    public static void i(String msg) {
        if (debug) i(TAG, msg);
    }

    public static void i(String key, String msg) {
        if (debug) Log.i(key, msg);
    }

    public static void e(String msg) {
        if (debug) e(TAG, msg);
    }

    public static void e(String key, String msg) {
        if (debug) Log.e(key, msg);
    }

    public static void d(String msg) {
        if (debug) d(TAG, msg);
    }

    public static void d(String key, String msg) {
        if (debug) Log.d(key, msg);
    }

    public static void w(String key, String msg) {
        if (debug) Log.w(key, msg);
    }

    public static void w(String msg) {
        if (debug) w(TAG, msg);
    }

    public static void v(String key, String msg) {
        if (debug) Log.v(key, msg);
    }

    public static void v(String msg) {
        if (debug) Log.v(TAG, msg);
    }

}
