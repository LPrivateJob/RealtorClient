package com.realtor.jx.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Author: Mr.Z
 * Date: 2017/11/15
 * Desc:
 */
public class SystemUtils {
    /**
     * 判断应用是否已经启动
     *
     * @param context
     * @param packageName 要判断应用的包名
     * @return boolean
     */
    public static boolean isAppAlive(Context context, String packageName) {
        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfos
                = activityManager.getRunningAppProcesses();
        for (int i = 0; i < processInfos.size(); i++) {
            if (processInfos.get(i).processName.equals(packageName)) {
//                Logger.d("NotificationLaunch",
//                        String.format("the %s is running, isAppAlive return true", packageName));
                return true;
            }
        }
//        Logger.d("NotificationLaunch",
//                String.format("the %s is not running, isAppAlive return false", packageName));
        return false;
    }

    /**
     *判断当前应用程序处于前台还是后台
     */
    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExsitMianActivity(Context context, Class<?> cls){
        Intent intent = new Intent(context, cls);
        ComponentName cmpName = intent.resolveActivity(context.getPackageManager());
        if (cmpName != null) { // 说明系统中存在这个activity
            ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(10);
            for (ActivityManager.RunningTaskInfo taskInfo : taskInfoList) {
                if (taskInfo.baseActivity.equals(cmpName)) { // 说明它已经启动了
                   return true;
                }
            }
        }
        return false;
    }
}
