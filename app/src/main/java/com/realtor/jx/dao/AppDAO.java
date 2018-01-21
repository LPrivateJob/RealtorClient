package com.realtor.jx.dao;

import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.dto.OrderListDto;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.netcore.BaseDAO;
import com.realtor.jx.netcore.JsonUiCallback;

import java.util.Map;

/**
 * author: sundong
 * created at 2018/1/16 14:15
 */
// TODO: 数据类待替换
public class AppDAO extends BaseDAO {
    private static class SingletonHolder {
        private static AppDAO INSTANCE = new AppDAO();
    }

    public static AppDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //登录
    public void login(String loginName, String loginPassword, JsonUiCallback<UserInfoDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{LOGIN_NAME, LOGIN_PASSWORD}, loginName, loginPassword);
        sendPostFormData(User.LOGIN, mapParams, callback);
    }

    //是否登录
    public void isLogin(String userId, JsonUiCallback<UserInfoDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{USER_ID}, userId);
        sendPostFormData(User.IS_LOGIN, mapParams, callback);
    }

    //登出
    public void loginOut(String userId, JsonUiCallback<String> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{USER_ID}, userId);
        sendPostFormData(User.LOGOUT, mapParams, callback);
    }

    //创建合同
    public void createContract(Object object, JsonUiCallback<UserInfoDto> callback) {
        sendPostJson(Contract.CREATE, object, callback);
    }

    //查询订单列表
    public void queryOrderList(String keyWords, String orderStatus, String orderType, String pageNum, String pageSize, JsonUiCallback<OrderListDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{KEYWORDS, ORDER_STATUS, ORDER_TYPE, PAGE_NUM, PAGE_SIZE}, keyWords, orderStatus, orderType, pageNum, pageSize);
        sendPostFormData(Contract.QUERY_ORDER_LIST, mapParams, callback);
    }

    //查询订单详情
    public void queryOrderDetail(String orderId, JsonUiCallback<ContractDetailDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{ORDER_ID}, orderId);
        sendPostFormData(Contract.QUERY_ORDER_DETAIL, mapParams, callback);
    }

    //获取微信二维码
    public void getWechatImage(String mobileNo, String orderId, JsonUiCallback<UserInfoDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{MOBILE_NUM, ORDER_ID}, mobileNo, orderId);
        sendPostFormData(Contract.GET_WECHAT_IMAGE, mapParams, callback);
    }
}
