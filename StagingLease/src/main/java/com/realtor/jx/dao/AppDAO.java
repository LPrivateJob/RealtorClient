package com.realtor.jx.dao;

import com.realtor.jx.dto.CalTermDto;
import com.realtor.jx.dto.ContractDetailDto;
import com.realtor.jx.dto.ContractDto;
import com.realtor.jx.dto.OrderListDto;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.netcore.BaseDAO;
import com.realtor.jx.netcore.JsonUiCallback;
import com.realtor.jx.netcore.api.ApiKeys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * description:
 * autour: Tait
 * created at 2018/1/16 14:15
 */
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
//    public void isLogin(String userId, JsonUiCallback<UserInfoDto> callback) {
//        Map<String, Object> mapParams = getMapParams(new String[]{USER_ID}, userId);
//        sendPostFormData(User.IS_LOGIN, mapParams, callback);
//    }
    // TODO: 数据类待替换
    public void modPassword(String loginName, String oldPassword, String newPassword, JsonUiCallback<Object> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{LOGIN_NAME, OLD_PASSWORD, NEW_PASSWORD}, loginName, oldPassword, newPassword);
        sendPostFormData(User.MOD_PASSWORD, mapParams, callback);
    }

    //登出
    public void loginOut(String userId, JsonUiCallback<String> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{USER_ID}, userId);
        sendPostFormData(User.LOGOUT, mapParams, callback);
    }

    //创建合同
    public void createContract(String location, Object object, JsonUiCallback<ContractDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{LOCATION}, location);
        sendPostJson(Contract.CREATE, mapParams, object, callback);
    }

    //修改合同
    public void modifyContract(String location, Object object, JsonUiCallback<ContractDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{LOCATION}, location);
        sendPostJson(Contract.CREATE, mapParams, object, callback);
    }

    //删除合同
    public void deleteContrace(String orderId, JsonUiCallback<Object> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{ORDER_ID}, orderId);
        sendPostFormData(Contract.DELETE, mapParams, callback);
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

    //上传照片
    public void upLoadPics(String orderId, String mobileNo, Map<String, String> fileMap, JsonUiCallback<Object> callback) {
        List<MultipartBody.Part> list = new ArrayList<>();
        list.add(MultipartBody.Part.createFormData(ApiKeys.ORDER_ID, orderId));
        list.add(MultipartBody.Part.createFormData(ApiKeys.MOBILE_NUM, mobileNo));
        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            String fileKey = entry.getKey();
            String filePath = entry.getValue();
            String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
            MultipartBody.Part formData = MultipartBody.Part.createFormData(fileKey, fileName,
                    RequestBody.create(MediaType.parse("image/jpeg"), new File(filePath)));
            list.add(formData);
        }
        upLoadFile(Contract.UPLOAD_IMAGE, list, callback);
    }

    // TODO: 数据类待替换
    public void calTerm(String startDate, String endDate, JsonUiCallback<CalTermDto> callback) {
        Map<String, Object> mapParams = getMapParams(new String[]{START_DATE, END_DATE}, startDate, endDate);
        sendPostFormData(Contract.CAL_TERM, mapParams, callback);
    }
}
