package com.realtor.jx.netcore.api;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public class ApiRoute {

    private static final String ROOT = "/CashBack";

    public final class LOGIN {
        // 登录
        public static final String LOGIN = ROOT + "/login";

        // token登录
        public static final String LOGIN_BY_TOKEN = ROOT + "/loginByToken";
    }


    public final class COUSTOMERS {
        // 客户列表
        public static final String COSTOMERS_LIST = ROOT + "/customersList";

        // 搜索客户
        public static final String SEARCH = ROOT + "/search";

        // 合同详情
//        public static final String CONTACTS_LIST = ROOT + "/contractList";
        public static final String CONTACTS_LIST = ROOT + "/contractList";
    }

    public final class COUSTOMERS_DETAILS {
        //客户经理绑卡列表
        public static final String BINDCARD_LIST = ROOT + "/bindCardList";
        //    获取短信支付码
        public static final String SMSCODE = ROOT + "/getSMSCode";
        //  确认支付
        public static final String COMFIRMPAYMENT = ROOT + "/confirmPayment";
        //  获取绑卡验证码
        public static final String BINDCARDSMMCODE = ROOT + "/getBindCardSmsCode";
        //确认绑定银行卡
        public static final String CONFIRMBINDCARD = ROOT + "/confirmBindCard";
        //解除绑定银行卡
        public static final String REMOVERBINDCARD = ROOT + "/removeBindCard";
        //获取支持银行的列表
        public static final String GETBANKLIST = ROOT + "/getBankList";
        //获取汇款银行账号
        public static final String GETACCOUNTINFO = ROOT + "/getAccountInfo";
        //提交划扣信息
        public static final String GETHUAKOUPAYMENT = ROOT + "/getHuakouPayment";

    }


}