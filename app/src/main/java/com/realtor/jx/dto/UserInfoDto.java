package com.realtor.jx.dto;

import java.io.Serializable;
import java.util.List;

/**
 * author: sundong
 * created at 2018/1/16 15:45
 */
public class UserInfoDto implements Serializable{

    /**
     * payType : [{"lable":"季付","value":"1"},{"lable":"半年付","value":"2"},{"lable":"年付","value":"3"}]
     * feeReceive : [{"lable":"用户","value":"1"},{"lable":"公寓","value":"2"}]
     * areas : [{"id":"000086","name":"北京","subAreas":[{"id":"000087","name":"北京","subAreas":[{"id":"000088","name":"朝阳","subAreas":""},{"id":"000089","name":"西城","subAreas":""},{"id":"000090","name":"海淀","subAreas":""}]}]},{"id":"100087","name":"湖北","subAreas":[{"id":"010087","name":"襄阳","subAreas":[{"id":"020087","name":"樊城","subAreas":""},{"id":"020088","name":"襄州","subAreas":""},{"id":"020089","name":"襄城","subAreas":""},{"id":"020090","name":"老河口","subAreas":""},{"id":"020091","name":"枣阳","subAreas":""},{"id":"020092","name":"黄龙","subAreas":""},{"id":"020093","name":"玉山","subAreas":""},{"id":"020094","name":"耿集","subAreas":""},{"id":"020095","name":"卧龙","subAreas":""},{"id":"020096","name":"随州","subAreas":""},{"id":"020097","name":"天门","subAreas":""}]},{"id":"010088","name":"武汉","subAreas":[]},{"id":"010089","name":"十堰","subAreas":[]},{"id":"010090","name":"宜昌","subAreas":[]},{"id":"010091","name":"黄石","subAreas":[]},{"id":"010092","name":"黄冈","subAreas":[]},{"id":"010093","name":"荆门","subAreas":[]},{"id":"010094","name":"孝感","subAreas":[]},{"id":"010095","name":"仙桃","subAreas":[]},{"id":"010096","name":"老河口","subAreas":[]},{"id":"010097","name":"随州","subAreas":[]}]},{"id":"100088","name":"湖南","subAreas":[]},{"id":"100089","name":"河北","subAreas":[]},{"id":"100090","name":"河南","subAreas":[]},{"id":"100091","name":"江苏","subAreas":[]},{"id":"100092","name":"浙江","subAreas":[]},{"id":"100093","name":"福建","subAreas":[]},{"id":"100094","name":"安徽","subAreas":[]},{"id":"100095","name":"黑龙江","subAreas":[]},{"id":"100096","name":"吉林","subAreas":[]},{"id":"100097","name":"四川","subAreas":[]},{"id":"100098","name":"辽宁","subAreas":[]}]
     * firstPayType : [{"lable":"押一付一","value":"1"},{"lable":"押二付一","value":"2"}]
     * user : {"id":100000,"companyId":"1","officeId":"2","loginName":"13888888888","password":"","no":"0001","name":"张三","email":"thinkgem@163.com","phone":"8675","mobile":"8675","userType":"","photo":"","loginIp":"1.119.129.178","loginDate":"2017-09-01 13:33:18","loginFlag":"1","createBy":"1","createDate":"2013-05-27 08:00:00","updateBy":"1","updateDate":"2017-12-29 10:29:57","remarks":"最高管理员","delFlag":"0"}
     */

    private UserBean user;
    private List<PayTypeBean> payType;
    private List<FeeReceiveBean> feeReceive;
    private List<AreasBean> areas;
    private List<FirstPayTypeBean> firstPayType;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<PayTypeBean> getPayType() {
        return payType;
    }

    public void setPayType(List<PayTypeBean> payType) {
        this.payType = payType;
    }

    public List<FeeReceiveBean> getFeeReceive() {
        return feeReceive;
    }

    public void setFeeReceive(List<FeeReceiveBean> feeReceive) {
        this.feeReceive = feeReceive;
    }

    public List<AreasBean> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasBean> areas) {
        this.areas = areas;
    }

    public List<FirstPayTypeBean> getFirstPayType() {
        return firstPayType;
    }

    public void setFirstPayType(List<FirstPayTypeBean> firstPayType) {
        this.firstPayType = firstPayType;
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

    public static class PayTypeBean {
        /**
         * lable : 季付
         * value : 1
         */

        private String lable;
        private String value;

        public String getLable() {
            return lable;
        }

        public void setLable(String lable) {
            this.lable = lable;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class FeeReceiveBean {
        /**
         * lable : 用户
         * value : 1
         */

        private String lable;
        private String value;

        public String getLable() {
            return lable;
        }

        public void setLable(String lable) {
            this.lable = lable;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
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

    public static class FirstPayTypeBean {
        /**
         * lable : 押一付一
         * value : 1
         */

        private String lable;
        private String value;

        public String getLable() {
            return lable;
        }

        public void setLable(String lable) {
            this.lable = lable;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
