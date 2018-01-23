package com.realtor.jx.manager;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * <br>包名：com.yingu.tinypocket.utils
 * <br>项目名称：Android
 * <br>描述：设备信息管理器
 * <br>创建人：BaoZhi
 * <br>创建时间：2017/8/22 0022 15:32
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
