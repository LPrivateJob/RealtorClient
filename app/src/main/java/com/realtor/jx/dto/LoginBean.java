package com.realtor.jx.dto;

import java.util.List;

/**
 * author: sundong
 * created at 2018/1/16 15:45
 */
public class LoginBean {

    /**
     * payType : 1,2,3
     * feeReceive : 1,2
     * areas : [{"id":"000086","name":"北京","subAreas":[{"id":"000087","name":"北京","subAreas":[{"id":"000088","name":"朝阳","subAreas":""},{"id":"000089","name":"西城","subAreas":""},{"id":"000090","name":"海淀","subAreas":""}]}]}]
     * firstPayType : 1
     * user : {"id":100000,"companyId":"1","officeId":"2","loginName":"13888888888","password":"","no":"0001","name":"张三","email":"thinkgem@163.com","phone":"8675","mobile":"8675","userType":"","photo":"","loginIp":"1.119.129.178","loginDate":"2017-09-01 13:33:18","loginFlag":"1","createBy":"1","createDate":"2013-05-27 08:00:00","updateBy":"1","updateDate":"2017-12-29 10:29:57","remarks":"最高管理员","delFlag":"0"}
     */

    private String payType;
    private String feeReceive;
    private String firstPayType;
    private UserBean user;
    private List<AreasBean> areas;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getFeeReceive() {
        return feeReceive;
    }

    public void setFeeReceive(String feeReceive) {
        this.feeReceive = feeReceive;
    }

    public String getFirstPayType() {
        return firstPayType;
    }

    public void setFirstPayType(String firstPayType) {
        this.firstPayType = firstPayType;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<AreasBean> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBean> areas) {
        this.areas = areas;
    }

    public static class UserBean {
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

    public static class AreasBean {
        /**
         * id : 000086
         * name : 北京
         * subAreas : [{"id":"000087","name":"北京","subAreas":[{"id":"000088","name":"朝阳","subAreas":""},{"id":"000089","name":"西城","subAreas":""},{"id":"000090","name":"海淀","subAreas":""}]}]
         */

        private String id;
        private String name;
        private List<SubAreasBeanX> subAreas;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubAreasBeanX> getSubAreas() {
            return subAreas;
        }

        public void setSubAreas(List<SubAreasBeanX> subAreas) {
            this.subAreas = subAreas;
        }

        public static class SubAreasBeanX {
            /**
             * id : 000087
             * name : 北京
             * subAreas : [{"id":"000088","name":"朝阳","subAreas":""},{"id":"000089","name":"西城","subAreas":""},{"id":"000090","name":"海淀","subAreas":""}]
             */

            private String id;
            private String name;
            private List<SubAreasBean> subAreas;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubAreasBean> getSubAreas() {
                return subAreas;
            }

            public void setSubAreas(List<SubAreasBean> subAreas) {
                this.subAreas = subAreas;
            }

            public static class SubAreasBean {
                /**
                 * id : 000088
                 * name : 朝阳
                 * subAreas :
                 */

                private String id;
                private String name;
                private String subAreas;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSubAreas() {
                    return subAreas;
                }

                public void setSubAreas(String subAreas) {
                    this.subAreas = subAreas;
                }
            }
        }
    }
}
