package com.realtor.jx.utils;

import java.text.DecimalFormat;

/**
 * author: sundong
 * created at 2017/9/9 17:54
 */
public class NullUtil {
    public static String getString(Object object) {
        if (object != null) {
            String s = object.toString();
            if (s.isEmpty()) {
                return "\"\"";
            }
            return object.toString();
        } else {
            return "--";
        }
    }

    public static String getString2(Object object){
        return getStringWithPH(object,"请输入");
    }

    public static String getStringWithPH(Object object,String placeHolder){
        if (object != null) {
            String s = object.toString();
            if (s.isEmpty()) {
                return placeHolder;
            }
            return object.toString();
        } else {
            return placeHolder;
        }
    }

    public static String convertFen2YuanStr(int num) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(num);
    }
}
