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

    /**
     * 传入元返回Long类型分
     * @param str
     * @return
     */
    public static String convertYuan2FenStr(String str) {
        if (StringUtil.isEmpty(str))
            return null;
        DecimalFormat df = new DecimalFormat("0.00");
        String content = df.format(Double.parseDouble(str));
        int length = content.length();
        int dotIndex = content.indexOf('.');
        String str1 = content.substring(0, dotIndex);
        String str2 = content.substring(dotIndex + 1, length);
        return (Long.parseLong(str1)*100+Long.parseLong(str2))+"";
    }

    public static Long convertYuan2FenL(String str){
        if (StringUtil.isEmpty(str))
            return null;
        DecimalFormat df = new DecimalFormat("0.00");
        String content = df.format(Double.parseDouble(str));
        int length = content.length();
        int dotIndex = content.indexOf('.');
        String str1 = content.substring(0, dotIndex);
        String str2 = content.substring(dotIndex + 1, length);
        return Long.parseLong(str1)*100+Long.parseLong(str2);
    }

    public static Integer convertYuan2FenI(String str){
        if (StringUtil.isEmpty(str))
            return null;
        DecimalFormat df = new DecimalFormat("0.00");
        String content = df.format(Double.parseDouble(str));
        int length = content.length();
        int dotIndex = content.indexOf('.');
        String str1 = content.substring(0, dotIndex);
        String str2 = content.substring(dotIndex + 1, length);
        return Integer.parseInt(str1)*100+Integer.parseInt(str2);
    }


    public static String convertFen2YuanStr(int num) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(num/100.00);
    }
}
