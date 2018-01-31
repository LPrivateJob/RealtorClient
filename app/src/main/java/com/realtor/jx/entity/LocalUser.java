package com.realtor.jx.entity;

import com.alibaba.fastjson.JSON;
import com.realtor.jx.base.RealtorClientApplication;
import com.realtor.jx.dto.FlowLayoutTypeBean;
import com.realtor.jx.dto.UserInfoDto;
import com.realtor.jx.netcore.core.cookie.CookiesManager;
import com.realtor.jx.utils.BaseUtils;
import com.realtor.jx.widget.picker.wheelpicker.entity.Province;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * autour: Tait
 * created at 2018/1/18 15:41
 */
public class LocalUser implements Serializable {
    public static final String USER_INFO_FILENAME = "userInfo";
    public static final String PROVINCE_LIST_FILENAME = "provinceList";

    private UserInfoDto profile;

    private LocalUser() {
    }

    private static class SingletonHolder {
        private static LocalUser INSTANCE = new LocalUser();
    }

    public static LocalUser getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public void updateUserProfile(UserInfoDto userInfoDto) {
        this.profile = userInfoDto;
        saveUserProfile();
        saveProvinceList(userInfoDto.getProvinceList());
    }

    private UserInfoDto getUserProfile() {
        if (profile == null) {
            loadUserProfile();
        }
        return profile;
    }

    /**
     * 保存用户数据至磁盘
     */
    public void saveUserProfile() {
        BaseUtils.EncryptObject(RealtorClientApplication.getContext(), USER_INFO_FILENAME, profile);
    }

    /**
     * 从磁盘加载用户数据
     */
    public void loadUserProfile() {
        profile = (UserInfoDto) BaseUtils.DecipherObject(RealtorClientApplication.getContext(), USER_INFO_FILENAME);
    }

    /**
     * 保存地区数据到磁盘
     */
    public void saveProvinceList(List<UserInfoDto.Province> provinceList) {
        ArrayList<Province> data = new ArrayList<>();
        data.addAll(JSON.parseArray(JSON.toJSON(provinceList).toString(), Province.class));
        BaseUtils.saveObject(RealtorClientApplication.getContext(), PROVINCE_LIST_FILENAME, data);
    }

    /**
     * 从磁盘获取地区数据
     */
    public ArrayList<Province> getProvinceList() {
        return (ArrayList<Province>) BaseUtils.restoreObject(RealtorClientApplication.getContext(), PROVINCE_LIST_FILENAME);
    }

    /**
     * 清空磁盘中保存的用户数据
     */
    public void clear() {
        this.profile = null;
        saveUserProfile();
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
     * 返会平台支持的租住方式 整租，合租
     */
    public List<FlowLayoutTypeBean> getRenterMethodList() {
        if (getUserProfile() == null) {
            return null;
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
