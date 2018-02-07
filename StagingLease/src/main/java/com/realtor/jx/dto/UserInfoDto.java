package com.realtor.jx.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * description:
 * autour: Tait
 * created at 2018/1/16 15:45
 */
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = -3608193019132763660L;
    /**
     * payType : [{"lable":"季付","value":"1"},{"lable":"半年付","value":"2"},{"lable":"年付","value":"3"}]
     * rentType : [{"lable":"整租","value":"1"},{"lable":"合租","value":"2"}]
     * feeReceive : [{"lable":"用户","value":"1"},{"lable":"公寓","value":"2"}]
     * provinceList : [{"id":"000086","name":"北京","cityList":[{"id":"000087","name":"北京","cityList":[{"id":"000088","name":"朝阳","cityList":""},{"id":"000089","name":"西城","cityList":""},{"id":"000090","name":"海淀","cityList":""}]}]},{"id":"100087","name":"湖北","cityList":[{"id":"010087","name":"襄阳","cityList":[{"id":"020087","name":"樊城","cityList":""},{"id":"020088","name":"襄州","cityList":""},{"id":"020089","name":"襄城","cityList":""},{"id":"020090","name":"老河口","cityList":""},{"id":"020091","name":"枣阳","cityList":""},{"id":"020092","name":"黄龙","cityList":""},{"id":"020093","name":"玉山","cityList":""},{"id":"020094","name":"耿集","cityList":""},{"id":"020095","name":"卧龙","cityList":""},{"id":"020096","name":"随州","cityList":""},{"id":"020097","name":"天门","cityList":""}]},{"id":"010088","name":"武汉","cityList":[]},{"id":"010089","name":"十堰","cityList":[]},{"id":"010090","name":"宜昌","cityList":[]},{"id":"010091","name":"黄石","cityList":[]},{"id":"010092","name":"黄冈","cityList":[]},{"id":"010093","name":"荆门","cityList":[]},{"id":"010094","name":"孝感","cityList":[]},{"id":"010095","name":"仙桃","cityList":[]},{"id":"010096","name":"老河口","cityList":[]},{"id":"010097","name":"随州","cityList":[]}]},{"id":"100088","name":"湖南","cityList":[]},{"id":"100089","name":"河北","cityList":[]},{"id":"100090","name":"河南","cityList":[]},{"id":"100091","name":"江苏","cityList":[]},{"id":"100092","name":"浙江","cityList":[]},{"id":"100093","name":"福建","cityList":[]},{"id":"100094","name":"安徽","cityList":[]},{"id":"100095","name":"黑龙江","cityList":[]},{"id":"100096","name":"吉林","cityList":[]},{"id":"100097","name":"四川","cityList":[]},{"id":"100098","name":"辽宁","cityList":[]}]
     * firstPayType : [{"lable":"押一付一","value":"1"},{"lable":"押二付一","value":"2"}]
     * user : {"id":100000,"companyId":"1","officeId":"2","loginName":"13888888888","password":"","no":"0001","name":"张三","email":"thinkgem@163.com","phone":"8675","mobile":"8675","userType":"","photo":"","loginIp":"1.119.129.178","loginDate":"2017-09-01 13:33:18","loginFlag":"1","createBy":"1","createDate":"2013-05-27 08:00:00","updateBy":"1","updateDate":"2017-12-29 10:29:57","remarks":"最高管理员","delFlag":"0"}
     */

    private UserBean user;
    private List<FlowLayoutTypeBean> payType;
    private List<FlowLayoutTypeBean> rentType;
    private List<FlowLayoutTypeBean> feeReceive;
    private List<FlowLayoutTypeBean> firstPayType;
    @SerializedName(value = "areas")
    private List<Province> provinceList;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<FlowLayoutTypeBean> getPayType() {
        return payType;
    }

    public void setPayType(List<FlowLayoutTypeBean> payType) {
        this.payType = payType;
    }

    public List<FlowLayoutTypeBean> getRentType() {
        return rentType;
    }

    public void setRentType(List<FlowLayoutTypeBean> rentType) {
        this.rentType = rentType;
    }

    public List<FlowLayoutTypeBean> getFeeReceive() {
        return feeReceive;
    }

    public void setFeeReceive(List<FlowLayoutTypeBean> feeReceive) {
        this.feeReceive = feeReceive;
    }

    public List<Province> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public List<FlowLayoutTypeBean> getFirstPayType() {
        return firstPayType;
    }

    public void setFirstPayType(List<FlowLayoutTypeBean> firstPayType) {
        this.firstPayType = firstPayType;
    }

    public static class UserBean implements Serializable {
        private static final long serialVersionUID = -4408983506436646361L;
        /**
         * id : 100000
         * companyId : 1
         * officeId : 2
         * loginName : 13888888888
         * password :
         * no : 0001
         * name : 张三
         * email : thinkgem@163.com
         * phone : 8675
         * mobile : 8675
         * userType :
         * photo :
         * loginIp : 1.119.129.178
         * loginDate : 2017-09-01 13:33:18
         * loginFlag : 1
         * createBy : 1
         * createDate : 2013-05-27 08:00:00
         * updateBy : 1
         * updateDate : 2017-12-29 10:29:57
         * remarks : 最高管理员
         * delFlag : 0
         */

        private int id;
        private String companyId;
        private String officeId;
        private String loginName;
        private String password;
        private String no;
        private String name;
        private String email;
        private String phone;
        private String mobile;
        private String userType;
        private String photo;
        private String loginIp;
        private String loginDate;
        private String loginFlag;
        private String createBy;
        private String createDate;
        private String updateBy;
        private String updateDate;
        private String remarks;
        private String delFlag;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getOfficeId() {
            return officeId;
        }

        public void setOfficeId(String officeId) {
            this.officeId = officeId;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }
    }

    public static class Province implements Serializable {
        private static final long serialVersionUID = 1803883636749913288L;
        /**
         * id : 000086
         * name : 北京
         * cityList : [{"id":"000087","name":"北京","cityList":[{"id":"000088","name":"朝阳","cityList":""},{"id":"000089","name":"西城","cityList":""},{"id":"000090","name":"海淀","cityList":""}]}]
         */
        @SerializedName(value = "id")
        private String areaId;
        @SerializedName(value = "name")
        private String areaName;
        @SerializedName(value = "subAreas")
        private List<City> cities;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public List<City> getCities() {
            return cities;
        }

        public void setCities(List<City> cities) {
            this.cities = cities;
        }

        public static class City implements Serializable {
            private static final long serialVersionUID = -3321676881594743880L;
            /**
             * id : 000087
             * name : 北京
             * districtList : [{"id":"000088","name":"朝阳","cityList":""},{"id":"000089","name":"西城","cityList":""},{"id":"000090","name":"海淀","cityList":""}]
             */

            @SerializedName(value = "id")
            private String areaId;
            @SerializedName(value = "name")
            private String areaName;
            @SerializedName(value = "subAreas")
            private List<District> counties;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public List<District> getCounties() {
                return counties;
            }

            public void setCounties(List<District> counties) {
                this.counties = counties;
            }

            public static class District implements Serializable {
                private static final long serialVersionUID = 7062014422807206375L;
                /**
                 * id : 000088
                 * name : 朝阳
                 * cityList :
                 */

                @SerializedName(value = "id")
                private String areaId;
                @SerializedName(value = "name")
                private String areaName;

                public String getAreaId() {
                    return areaId;
                }

                public void setAreaId(String areaId) {
                    this.areaId = areaId;
                }

                public String getAreaName() {
                    return areaName;
                }

                public void setAreaName(String areaName) {
                    this.areaName = areaName;
                }
            }
        }
    }
}
