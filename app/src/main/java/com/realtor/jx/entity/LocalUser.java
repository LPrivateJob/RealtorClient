package com.realtor.jx.entity;

import com.realtor.jx.base.RealtorClientApplication;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.netcore.core.cookie.CookiesManager;
import com.realtor.jx.utils.BaseUtils;

import java.io.Serializable;
import java.util.List;

/**
 * author: sundong
 * created at 2018/1/18 15:41
 */
public class LocalUser implements Serializable {
    private LocalUser() {
    }

    private static class SingletonHolder {
        private static LocalUser INSTANCE = new LocalUser();
    }

    public static LocalUser getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private UserInfoDto profile;

    public void updateUserProfile(UserInfoDto userInfoDto) {
        this.profile = userInfoDto;
        save();
    }

    private UserInfoDto getUserProfile() {
        if (profile == null) {
            load();
        }
        return profile;
    }

    /**
     * 保存用户数据至磁盘
     */
    public void save() {
        BaseUtils.saveObject(RealtorClientApplication.getContext(), UserInfoDto.class.getSimpleName(), profile);
    }

    /**
     * 从磁盘加载用户数据
     */
    public void load() {
        profile = (UserInfoDto) BaseUtils.getObject(RealtorClientApplication.getContext(), UserInfoDto.class.getSimpleName());
    }

    /**
     * 清空磁盘中保存的用户数据
     */
    public void clear() {
        this.profile = null;
        save();
        CookiesManager manager = new CookiesManager(RealtorClientApplication.getContext());
        manager.clearAll();
    }

    /**
     * 得到UserId
     */
    public String getUserId() {
        if (getUserProfile() == null || profile.getUser() == null) {
            return null;
        }
        return "" + profile.getUser().getId();
    }

    /**
     * 得到用户信息类
     */
    public UserInfoDto.UserBean getUserBean() {
        if (getUserProfile() == null) {
            return null;
        }
        return profile.getUser();
    }

    /**
     * 返回支持的地区列表
     */
    public List<UserInfoDto.AreasBean> getAreaList() {
        if (getUserProfile() == null) {
            return null;
        }
        return profile.getAreas();
    }

    /**
     * 返会平台支持的租住方式 整租，合租
     */
    public List<FlowLayoutTypeBean> getRenterMethodList(){
        if(getUserProfile()==null) {
            return  null;
        }
        return profile.getRentType();
    }

    /**
     * 返回平台支持的付款方式
     */
    public List<FlowLayoutTypeBean> getPlatformPaymentMethodList() {
        if (getUserProfile() == null) {
            return null;
        }
        return profile.getPayType();
    }

    /**
     * 返回平台支持的首付方式
     */
    public List<FlowLayoutTypeBean> getDownPaymentsMethodList() {
        if (getUserProfile() == null) {
            return null;
        }
        return profile.getFirstPayType();
    }

    /**
     * 返回服务费承担方List
     */
    public List<FlowLayoutTypeBean> getServiceFeeBearList() {
        if (getUserProfile() == null) {
            return null;
        }
        return profile.getFeeReceive();
    }

    public void clearTest() {
        profile = null;
    }
}
