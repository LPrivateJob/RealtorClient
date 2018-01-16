package com.realtor.jx.utils;

/**
 * author: sundong
 * created at 2017/9/9 17:54
 */
public class NullUtil {
    public static String getString(Object object){
        if(object!=null) {
            String s = object.toString();
            if(s.isEmpty()) {
                return "\"\"";
            }
            return object.toString();
        }else {
            return "--";
        }
    }
}
