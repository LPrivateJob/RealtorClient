package com.realtor.jx.utils;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.LoginFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.realtor.jx.base.RealtorClientApplication;
import com.realtor.jx.entity.Commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: sundong
 * created at 2018/1/18 14:47
 */
public class InputVerifyUtil implements Commons.BASIC_INFO {
    private static Context mApplicationContext = RealtorClientApplication.getContext();
    private static final String NAME = "姓名";
    private static final String USER_NAME = "用户名";
    private static final String PASSWORD = "密码";
    private static final String VERIFY_CODE = "验证码";
    private static final String MOBILE = "手机号";
    private static final String BANK_NAME = "银行名称";
    private static final String BANK_CARD_NUM = "银行卡号";
    private static final String ID_CARD_NUM = "身份证号";
    private static final String LENTH_TIP_FORMAT = "%s必须为%d位";
    private static final String EMPTY_TIP_FORMAT = "请输入%s";
    private static final String WRONG_TIP_FORMAT = "请正确输入%s";
    private static final String LENTH_RANGE_FORMAT = "%s必须为%d~%d位字符";
    private static final String EMPTY_FORMAT = "%s不得为空";

    public static boolean checkRenterName(String name){
        if(!checkEmpty(name, NAME)){
            return false;
        }
        return true;
//        if (name.contains("·") || name.contains("•")){
//            if (name.matches("^[\\u4e00-\\u9fa5]+[·•][\\u4e00-\\u9fa5]+$")){
//                return true;
//            }else {
//                Toast.makeText(mApplicationContext, "您输入的姓名格式不正确", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }else {
//            if (name.matches("^[\\u4e00-\\u9fa5]+$")){
//                return true;
//            }else {
//                Toast.makeText(mApplicationContext, "您输入的姓名格式不正确", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }
    }

    public static boolean checkUserName(String userName) {

        if (!checkEmpty(userName, USER_NAME)) {
            return false;
        }

        if (!checkLenthRange(userName, USER_NAME, MIN_USER_NAME_LENTH, MAX_USER_NAME_LENTH)) {
            return false;
        }

        return true;
    }

    public static boolean checkPassword(String pwd) {
        if (!checkEmpty(pwd, PASSWORD)) {
            return false;
        }

        if (!checkLenthRange(pwd, PASSWORD, MIN_LOGIN_PWD_LENTH, MAX_LOGIN_PWD_LENTH)) {
            return false;
        }

        return true;
    }

    public static boolean checkPasswordSame(String... pwds) {
        String base = null;

        for (String pwd : pwds) {
            if (base == null) {
                base = pwd;
            }

            if (!TextUtils.equals(base, pwd)) {
                Toast.makeText(mApplicationContext, "密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    public static boolean checkVerifyCode(String code) {
        return checkLenth(code, VERIFY_CODE, VERIFY_CODE_LENTH);
    }

    public static boolean checkMobile(String mobile) {
        if (!checkLenth(mobile, MOBILE, MOBILE_LENTH)) {
            return false;
        }

//        if (!checkMobileRule(mobile)) {
//            Toast.makeText(c, "请输入合规的手机号码", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    /**
     * 检测身份证
     *
     * @param num
     * @return
     */
    public static boolean checkIdCard(String num) {
        if (!checkEmpty(num, ID_CARD_NUM)) {
            return false;
        }

        if (num.length() != 15 && num.length() != 18) {
            Toast.makeText(mApplicationContext, ID_CARD_NUM + "输入有误", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * 检测银行卡
     * 银行卡位数 16 -19
     *
     * @return
     */
    public static boolean checkBankNumber(String input, String formatError) {
        if (!checkEmptyNoneFormat(input, String.format(EMPTY_FORMAT, BANK_CARD_NUM))) {
            return false;
        }
        if (!checkLenthRangeNoneFormat(input, formatError, 16, 19)) {
            return false;
        }
        return true;
    }

    /**
     * 银行卡名称检测
     *
     * @param input
     * @param tip
     * @return
     */
    public static boolean chekBankName(String input, String tip) {
        return checkEmptyNoneFormat(input, tip);
    }


    public static boolean checkLenth(String input, String name, int minLen) {
        if (!checkEmpty(input, name)) {
            return false;
        }

        if (input.length() < minLen) {
            String strToast = String.format(LENTH_TIP_FORMAT, name, minLen);
            Toast.makeText(mApplicationContext, strToast, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    public static boolean checkWrong(String input, String name, int minLen) {
        if (!checkEmpty(input, name)) {
            return false;
        }

        if (input.length() < minLen) {
            String strToast = String.format(WRONG_TIP_FORMAT, name);
            Toast.makeText(mApplicationContext, strToast, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public static boolean checkEmpty(String input, String name) {
        if (TextUtils.isEmpty(input)) {
            String strToast = String.format(EMPTY_TIP_FORMAT, name);
            Toast.makeText(mApplicationContext, strToast, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public static boolean checkEmptyNoneFormat(String input, String name) {
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(mApplicationContext, name, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public static boolean checkLenthRange(String input, String name, int min, int max) {
        if (input.length() < min || input.length() > max) {

            String strToast = String.format(LENTH_RANGE_FORMAT, name, min, max);
            Toast.makeText(mApplicationContext, strToast, Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    public static boolean checkLenthRangeNoneFormat(String input, String name, int min, int max) {
        if (input.length() < min || input.length() > max) {

            Toast.makeText(mApplicationContext, name, Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    private static boolean checkMobileRule(String mobile) {

        if (mobile.matches(CM)
                || mobile.matches(CU)
                || mobile.matches(CT)
                || mobile.matches(PHS)) {
            return true;
        } else {
            return false;
        }
    }

    public static InputFilter[] getDigitFilter(String digits) {
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new DigitsInputFilter(digits);
        return filters;
    }

    public static InputFilter[] getExceptFilter(String digits) {
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new ExceptInputFilter(digits);
        return filters;
    }

    private static class DigitsInputFilter extends LoginFilter.UsernameFilterGeneric {
        private String mAllowedDigits;

        public DigitsInputFilter(String digits) {
            mAllowedDigits = digits;
        }

        @Override
        public boolean isAllowed(char c) {
            if (mAllowedDigits.indexOf(c) != -1) {
                return true;
            }
            return false;
        }
    }

    private static class ExceptInputFilter extends LoginFilter.UsernameFilterGeneric {
        private String mAllowedDigits;

        public ExceptInputFilter(String except) {
            mAllowedDigits = except;
        }

        @Override
        public boolean isAllowed(char c) {
            if (mAllowedDigits.indexOf(c) != -1) {
                return false;
            }
            return true;
        }
    }

    public static void textLeadEnable(final View view, final EditText... ets) {

        view.setEnabled(false);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                boolean enable = true;

                for (EditText et : ets) {
                    enable = enable && !TextUtils.isEmpty(et.getText().toString());
                }

                if (view.getTag(view.getId()) == null) {
                    view.setEnabled(enable);
                } else {
                    view.setEnabled(false);
                }

            }
        };

        for (EditText et : ets) {
            et.addTextChangedListener(watcher);
        }
    }

    public static void textLeadVisible(final View view, final EditText et) {
        view.setVisibility(View.INVISIBLE);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                view.setVisibility(TextUtils.isEmpty(et.getText().toString()) ? View.INVISIBLE : View.VISIBLE);
            }
        };

        et.addTextChangedListener(watcher);
    }

    public static void setupPwdEt(EditText et) {
        et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        et.setFilters(new InputFilter[]{new DigitsInputFilter(PWD_DIGITS), new InputFilter.LengthFilter(MAX_LOGIN_PWD_LENTH)});
    }

    public static void setupUserNameEt(EditText et) {
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        et.setFilters(new InputFilter[]{new DigitsInputFilter(USERNAME_DIGITS), new InputFilter.LengthFilter(MAX_USER_NAME_LENTH)});
    }

    public static void setupVerifyCodeEt(EditText et) {
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
    }

    public static void setupMobileEt(EditText et) {
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
    }

    public static void setupIDCardEt(EditText et) {
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        et.setFilters(new InputFilter[]{new DigitsInputFilter(ID_CARD_DIGITS), new InputFilter.LengthFilter(Commons.BASIC_INFO.MAX_ID_CARD_LENTH)});
    }

    //验证是否数字
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

}
