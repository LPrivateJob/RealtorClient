package com.realtor.jx.entity;


/**
 * author: sundong
 * created at 2018/1/18 14:41
 */
public class Commons {

    public interface BASIC_INFO {
        int MIN_LOGIN_PWD_LENTH = 6;
        int MAX_LOGIN_PWD_LENTH = 16;

        int MIN_USER_NAME_LENTH = 6;
        int MAX_USER_NAME_LENTH = 20;

        int VERIFY_CODE_LENTH = 6;

        int MOBILE_LENTH = 11;

        int MAX_ID_CARD_LENTH = 18;

        /**
         * 手机号码
         * 移动：134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188,1705
         * 联通：130,131,132,152,155,156,185,186,1709
         * 电信：133,1349,153,180,189,177,1700
         */
        //    NSString * MOBILE = @"^1((3//d|5[0-35-9]|8[025-9])//d|70[059])//d{7}$";//总况

        /**
         * 10         * 中国移动：China Mobile
         * 11         * 134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188，1705
         * 12
         */
        String CM = "^1(34[0-8]|(3[5-9]|5[017-9]|8[278])\\d|705)\\d{7}$";
        /**
         * 15         * 中国联通：China Unicom
         * 16         * 130,131,132,152,155,156,185,186,1709
         * 17
         */
        String CU = "^1((3[0-2]|5[256]|8[56])\\d|709)\\d{7}$";
        /**
         * 20         * 中国电信：China Telecom
         * 21         * 133,1349,153,180,189,1700
         * 22
         */
        String CT = "^1((33|53|77|8[09])\\d|349|700)\\d{7}$";


        /**
         * 25         * 大陆地区固话及小灵通
         * 26         * 区号：010,020,021,022,023,024,025,027,028,029
         * 27         * 号码：七位或八位
         * 28
         */
        String PHS = "^0(10|2[0-5789]|\\d{3})\\d{7,8}$";


        String USERNAME_DIGITS = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        String PWD_DIGITS = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890~!@#$%^&*-_.";
        String ID_CARD_DIGITS = "1234567890Xx";
    }

    public interface BUNDLE_KEYS {
        public static final String EXTAR_INT = "key_int";
        public static final String EXTRA_TITLE = "key_title";
        public static final String EXTRA_ENUM = "key_enum";
        public static final String EXTRA_ID = "key_id";
        public static final String EXTRA_TYPE = "key_type";
        public static final String EXTRA_CONTENT = "key_content";
        public static final String EXTRA_URL = "key_url";
        public static final String EXTRA_FRAGMENT_TYPE = "key_fragment_type";
        public static final String EXTRA_EXIT_ANIM = "key_exit_anim";
        public static final String EXTRA_HOUR = "hour";
        public static final String EXTRA_MONERY = "money";
        public static final String EXTRA_LIST = "list";
        public static final String EXTRA_BEAN = "bean";
        public static final String EXTRA_BOOL = "boolean";
        public static final String EXTRA_BEAN2 = "bean2";
        public static final String EXTRA_CODE = "code";
        public static final String EXTRA_PASSWORD = "password";
        public static final String EXTRA_TXT = "key_txt";
    }

    public interface CONTRACT_STATUS {
        public static final int CONTRACT_STATE_APPLYING = 0;//申请中
        public static final int CONTRACT_STATE_WAITMODIFY = 1;//待修改
        public static final int CONTRACT_STATE_WAITSCANQRCODE = 2;//待扫码
        public static final int CONTRACT_STATE_WAITREVIEW = 3;//待审核
        public static final int CONTRACT_STATE_INREVIEW = 4;//审核中
        public static final int CONTRACT_STATE_INREPAYMENT = 5;//还款中
        public static final int CONTRACT_STATE_SETTLED = 6;//已还清
        public static final int CONTRACT_STATE_RENEGE = 7;//已违约
        public static final int CONTRACT_STATE_REJECT = 8;//审核拒绝
    }

    public interface CONTRACT_TYPE {
        public static final int ALL = 1;
        public static final int OVERDUE = 2;
    }
}
