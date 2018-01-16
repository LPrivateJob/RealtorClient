package com.realtor.jx.dao;

import com.realtor.jx.dto.LoginBean;
import com.realtor.jx.netcore.BaseDAO;
import com.realtor.jx.netcore.JsonUiCallback;

import java.util.Map;

/**
 * author: sundong
 * created at 2018/1/16 14:15
 */
public class AppDAO extends BaseDAO {
    private static class SingletonHolder {
        private static AppDAO INSTANCE = new AppDAO();
    }
    public AppDAO getInstance(){
        return SingletonHolder.INSTANCE;
    }
    //登录
    public void Login(String loginName, String loginPassword, JsonUiCallback<LoginBean> callback){
        Map<String, Object> mapParams = getMapParams(new String[]{LOGIN_NAME, LOGIN_PASSWORD}, loginName, loginPassword);
        invoke(apiService.post(User.LOGIN,mapParams),callback);
    }
    //是否登录
}
