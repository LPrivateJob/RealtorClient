package com.realtor.jx.manager;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * description:
 * autour: Tait
 * created at 2018/1/26 14:48
 */
public class PhoneInfoManager {

    private static TelephonyManager SYS_MANAGER = null;
    private static Context CONTEXT;

    public static void init(Context c) {
        CONTEXT = c.getApplicationContext();
    }

    private static void loadSysManager() {
        SYS_MANAGER = (TelephonyManager) CONTEXT.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
    }

    public static String getDiviceId() {

        if (SYS_MANAGER == null) {
            loadSysManager();
        }

        String deviceId = SYS_MANAGER.getDeviceId();

        return deviceId == null ? "" : deviceId;
    }

    public static boolean isInit() {
        return SYS_MANAGER != null && getDiviceId() != null;
    }
}
