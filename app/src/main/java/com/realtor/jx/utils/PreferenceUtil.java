package com.realtor.jx.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashSet;
import java.util.Set;

/**
 * <br>包名：com.yingu.tinypocket.utils
 * <br>项目名称：TinyPocket
 * <br>描述：Sharepreference工具
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/5/24 0024 19:32
 */
public class PreferenceUtil {

    private static final PreferenceUtil preferenceUtil = new PreferenceUtil();
    private SharedPreferences preferences;
    private Editor editor;
    public static final String VERSIONCODE = "versionCode";

    private PreferenceUtil() {

    }

    public static PreferenceUtil getInstance() {
        return preferenceUtil;
    }

    public void init(Context context) {
        preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void setBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public void setLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key) {
        return preferences.getLong(key, 0);
    }

    public long getLong(String key, int defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    public void setStringSet(String key, Set<String> set) {
        editor.putStringSet(key, set);
        editor.commit();
    }

    public Set<String> getStringSet(String key) {
        return preferences.getStringSet(key, new HashSet<String>());
    }

    public void removeString(String key) {
        editor.remove(key);
        editor.commit();
    }
}