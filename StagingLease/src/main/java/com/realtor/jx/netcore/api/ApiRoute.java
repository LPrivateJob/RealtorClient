package com.realtor.jx.netcore.api;

import com.realtor.jx.BuildConfig;

/**
 * description:
 * autour: Tait
 * created at 2018/1/4 15:10
 */
public class ApiRoute {

    public final class User {
        private static final String ROOT = BuildConfig.SERVER_ADD + "/app/user";
        // 登录
        public static final String LOGIN = ROOT + "/login";
        // 判断是否登录
        public static final String IS_LOGIN = ROOT + "/is_login";
        //登出
        public static final String LOGOUT = ROOT + "/loginOut";
        //修改密码
        public static final String MOD_PASSWORD = ROOT +"/modPassword";
    }

    public final class Contract {
        private static final String ROOT = BuildConfig.SERVER_ADD + "/app/contract";
        //创建租赁合同
        public static final String CREATE = ROOT + "/create";
        //修改租赁合同
        public static final String MODIFY = ROOT + "/modify";
        //删除合同
        public static final String DELETE = ROOT + "/delOrder";
        //查询订单详情
        public static final String QUERY_ORDER_DETAIL = ROOT + "/querOrderDetail";
        //查询订单列表
        public static final String QUERY_ORDER_LIST = ROOT + "/querOrderList";
        //上传照片
        public static final String UPLOAD_IMAGE = ROOT + "/upload";
        //计算期数
        public static final String CAL_TERM = ROOT +"/getTerms";
    }

}