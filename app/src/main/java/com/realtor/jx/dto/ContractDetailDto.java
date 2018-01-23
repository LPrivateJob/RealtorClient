package com.realtor.jx.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lewish on 2018/1/20.
 */

public class ContractDetailDto implements Serializable{

    private static final long serialVersionUID = -8014124264590178871L;
    /**
     * instalmentOrders : [{"id":"201801162225311000001","overdueDays":0,"orderId":"20180114163504100000","siteUserMobile":"13886286698","apartmentId":"113417667","repayDate":"2018-01-09","termNo":1,"totalAmt":3300,"principalAmt":3000,"interestAmt":300,"overdueAmt":0,"repayType":"","status":"待审核","createTime":"","modTime":""},{"id":"201801162225311000002","overdueDays":0,"orderId":"20180114163504100000","siteUserMobile":"13886286698","apartmentId":"113417667","repayDate":"2018-02-09","termNo":2,"totalAmt":3300,"principalAmt":3000,"interestAmt":300,"overdueAmt":0,"repayType":"","status":"待审核","createTime":"","modTime":""},{"id":"201801162225311000003","overdueDays":0,"orderId":"20180114163504100000","siteUserMobile":"13886286698","apartmentId":"113417667","repayDate":"2018-03-09","termNo":3,"totalAmt":4359,"principalAmt":3963,"interestAmt":396,"overdueAmt":0,"repayType":"","status":"待审核","createTime":"","modTime":""}]
     * payType : {"lable":"季付","value":"1"}
     * feeReceive : {"lable":"用户","value":"1"}
     * areas : {"province":"北京","city":"北京","region":"海淀"}
     * firstPayType : {"lable":"押一付一","value":"1"}
     * order : {"id":"20180114163504100000","timeOffset":"3月1天","orderNo":"","delayDate":"2018-01-17","repayDate":"2018-01-17","lateStatus":"","userId":"","platformPayType":"1","payTerm":3,"changeNo":"string","returnType":"","applyDate":"","status":3,"refuseInfo":"","refuseRemark":"不行，这伙计太穷了，不租！","rate":"","discountRate":"","delayRate":"","cash":3000,"siteUsertotalAmt":10959,"platTotalAmt":0,"tenancyName":"张三","tenancyMobile":"13717537745","tenancyIdcard":"420621199001061215","tenancyType":1,"startTime":"2018-01-09","endTime":"2018-04-18","feeType":"1","firstPaytype":"1","houseName":"远洋天地","houseCode":"64号楼","roomNum":"1007","settleDate":"","info":"输入备注信息","qrcodeUrl":"https://www.baidu.com/","orderUrl":"https://www.baidu.com/","ownerUrl":"https://www.baidu.com/","houseUrl":"https://www.baidu.com/","agentUrl":"https://www.baidu.com/","gmtCreate":"","gmtModify":"","checkDate":"2018-01-17","lateDays":"","cityNo":"000090"}
     */

    private FlowLayoutTypeBean payType;
    private FlowLayoutTypeBean feeReceive;
    private AreasBean areas;
    private FlowLayoutTypeBean firstPayType;
    private OrderBean order;
    private List<InstalmentOrdersBean> instalmentOrders;

    public FlowLayoutTypeBean getPayType() {
        return payType;
    }

    public void setPayType(FlowLayoutTypeBean payType) {
        this.payType = payType;
    }

    public FlowLayoutTypeBean getFeeReceive() {
        return feeReceive;
    }

    public void setFeeReceive(FlowLayoutTypeBean feeReceive) {
        this.feeReceive = feeReceive;
    }

    public AreasBean getAreas() {
        return areas;
    }

    public void setAreas(AreasBean areas) {
        this.areas = areas;
    }

    public FlowLayoutTypeBean getFirstPayType() {
        return firstPayType;
    }

    public void setFirstPayType(FlowLayoutTypeBean firstPayType) {
        this.firstPayType = firstPayType;
    }

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public List<InstalmentOrdersBean> getInstalmentOrders() {
        return instalmentOrders;
    }

    public void setInstalmentOrders(List<InstalmentOrdersBean> instalmentOrders) {
        this.instalmentOrders = instalmentOrders;
    }

    public static class AreasBean implements Serializable{

        /**
         * province : 北京
         * city : 北京
         * region : 海淀
         */

        private String province;
        private String city;
        private String region;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public static class OrderBean implements Serializable{

        private static final long serialVersionUID = -963953118993563275L;
        /**
         * id : 20180114163504100000
         * timeOffset : 3月1天
         * orderNo :
         * delayDate : 2018-01-17
         * repayDate : 2018-01-17
         * lateStatus :
         * userId :
         * platformPayType : 1
         * payTerm : 3
         * changeNo : string
         * returnType :
         * applyDate :
         * status : 3
         * refuseInfo :
         * refuseRemark : 不行，这伙计太穷了，不租！
         * rate :
         * discountRate :
         * delayRate :
         * cash : 3000
         * siteUsertotalAmt : 10959
         * platTotalAmt : 0
         * tenancyName : 张三
         * tenancyMobile : 13717537745
         * tenancyIdcard : 420621199001061215
         * tenancyType : 1
         * startTime : 2018-01-09
         * endTime : 2018-04-18
         * feeType : 1
         * firstPaytype : 1
         * houseName : 远洋天地
         * houseCode : 64号楼
         * roomNum : 1007
         * settleDate :
         * info : 输入备注信息
         * qrcodeUrl : https://www.baidu.com/
         * orderUrl : https://www.baidu.com/
         * ownerUrl : https://www.baidu.com/
         * houseUrl : https://www.baidu.com/
         * agentUrl : https://www.baidu.com/
         * gmtCreate :
         * gmtModify :
         * checkDate : 2018-01-17
         * lateDays :
         * cityNo : 000090
         */

        private String id;
        private String timeOffset;
        private String orderNo;
        private String delayDate;
        private String repayDate;
        private String lateStatus;
        private String userId;
        private String platformPayType;
        private int payTerm;
        private String changeNo;
        private String returnType;
        private String applyDate;
        private int status;
        private String refuseInfo;
        private String refuseRemark;
        private String rate;
        private String discountRate;
        private String delayRate;
        private int cash;
        private int siteUsertotalAmt;
        private int platTotalAmt;
        private String tenancyName;
        private String tenancyMobile;
        private String tenancyIdcard;
        private int tenancyType;
        private String startTime;
        private String endTime;
        private String feeType;
        private String firstPaytype;
        private String houseName;
        private String houseCode;
        private String roomNum;
        private String settleDate;
        private String info;
        private String qrcodeUrl;
        private String orderUrl;
        private String ownerUrl;
        private String houseUrl;
        private String agentUrl;
        private String gmtCreate;
        private String gmtModify;
        private String checkDate;
        private String lateDays;
        private String cityNo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTimeOffset() {
            return timeOffset;
        }

        public void setTimeOffset(String timeOffset) {
            this.timeOffset = timeOffset;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getDelayDate() {
            return delayDate;
        }

        public void setDelayDate(String delayDate) {
            this.delayDate = delayDate;
        }

        public String getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(String repayDate) {
            this.repayDate = repayDate;
        }

        public String getLateStatus() {
            return lateStatus;
        }

        public void setLateStatus(String lateStatus) {
            this.lateStatus = lateStatus;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPlatformPayType() {
            return platformPayType;
        }

        public void setPlatformPayType(String platformPayType) {
            this.platformPayType = platformPayType;
        }

        public int getPayTerm() {
            return payTerm;
        }

        public void setPayTerm(int payTerm) {
            this.payTerm = payTerm;
        }

        public String getChangeNo() {
            return changeNo;
        }

        public void setChangeNo(String changeNo) {
            this.changeNo = changeNo;
        }

        public String getReturnType() {
            return returnType;
        }

        public void setReturnType(String returnType) {
            this.returnType = returnType;
        }

        public String getApplyDate() {
            return applyDate;
        }

        public void setApplyDate(String applyDate) {
            this.applyDate = applyDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRefuseInfo() {
            return refuseInfo;
        }

        public void setRefuseInfo(String refuseInfo) {
            this.refuseInfo = refuseInfo;
        }

        public String getRefuseRemark() {
            return refuseRemark;
        }

        public void setRefuseRemark(String refuseRemark) {
            this.refuseRemark = refuseRemark;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDiscountRate() {
            return discountRate;
        }

        public void setDiscountRate(String discountRate) {
            this.discountRate = discountRate;
        }

        public String getDelayRate() {
            return delayRate;
        }

        public void setDelayRate(String delayRate) {
            this.delayRate = delayRate;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public int getSiteUsertotalAmt() {
            return siteUsertotalAmt;
        }

        public void setSiteUsertotalAmt(int siteUsertotalAmt) {
            this.siteUsertotalAmt = siteUsertotalAmt;
        }

        public int getPlatTotalAmt() {
            return platTotalAmt;
        }

        public void setPlatTotalAmt(int platTotalAmt) {
            this.platTotalAmt = platTotalAmt;
        }

        public String getTenancyName() {
            return tenancyName;
        }

        public void setTenancyName(String tenancyName) {
            this.tenancyName = tenancyName;
        }

        public String getTenancyMobile() {
            return tenancyMobile;
        }

        public void setTenancyMobile(String tenancyMobile) {
            this.tenancyMobile = tenancyMobile;
        }

        public String getTenancyIdcard() {
            return tenancyIdcard;
        }

        public void setTenancyIdcard(String tenancyIdcard) {
            this.tenancyIdcard = tenancyIdcard;
        }

        public int getTenancyType() {
            return tenancyType;
        }

        public void setTenancyType(int tenancyType) {
            this.tenancyType = tenancyType;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public String getFirstPaytype() {
            return firstPaytype;
        }

        public void setFirstPaytype(String firstPaytype) {
            this.firstPaytype = firstPaytype;
        }

        public String getHouseName() {
            return houseName;
        }

        public void setHouseName(String houseName) {
            this.houseName = houseName;
        }

        public String getHouseCode() {
            return houseCode;
        }

        public void setHouseCode(String houseCode) {
            this.houseCode = houseCode;
        }

        public String getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(String roomNum) {
            this.roomNum = roomNum;
        }

        public String getSettleDate() {
            return settleDate;
        }

        public void setSettleDate(String settleDate) {
            this.settleDate = settleDate;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getQrcodeUrl() {
            return qrcodeUrl;
        }

        public void setQrcodeUrl(String qrcodeUrl) {
            this.qrcodeUrl = qrcodeUrl;
        }

        public String getOrderUrl() {
            return orderUrl;
        }

        public void setOrderUrl(String orderUrl) {
            this.orderUrl = orderUrl;
        }

        public String getOwnerUrl() {
            return ownerUrl;
        }

        public void setOwnerUrl(String ownerUrl) {
            this.ownerUrl = ownerUrl;
        }

        public String getHouseUrl() {
            return houseUrl;
        }

        public void setHouseUrl(String houseUrl) {
            this.houseUrl = houseUrl;
        }

        public String getAgentUrl() {
            return agentUrl;
        }

        public void setAgentUrl(String agentUrl) {
            this.agentUrl = agentUrl;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtModify() {
            return gmtModify;
        }

        public void setGmtModify(String gmtModify) {
            this.gmtModify = gmtModify;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(String checkDate) {
            this.checkDate = checkDate;
        }

        public String getLateDays() {
            return lateDays;
        }

        public void setLateDays(String lateDays) {
            this.lateDays = lateDays;
        }

        public String getCityNo() {
            return cityNo;
        }

        public void setCityNo(String cityNo) {
            this.cityNo = cityNo;
        }
    }

    public static class InstalmentOrdersBean implements Serializable{

        private static final long serialVersionUID = 2193459239777887200L;
        /**
         * id : 201801162225311000001
         * overdueDays : 0
         * orderId : 20180114163504100000
         * siteUserMobile : 13886286698
         * apartmentId : 113417667
         * repayDate : 2018-01-09
         * termNo : 1
         * totalAmt : 3300
         * principalAmt : 3000
         * interestAmt : 300
         * overdueAmt : 0
         * repayType :
         * status : 待审核
         * createTime :
         * modTime :
         */

        private String id;
        private int overdueDays;
        private String orderId;
        private String siteUserMobile;
        private String apartmentId;
        private String repayDate;
        private int termNo;
        private int totalAmt;
        private int principalAmt;
        private int interestAmt;
        private int overdueAmt;
        private String repayType;
        private String status;
        private String createTime;
        private String modTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getOverdueDays() {
            return overdueDays;
        }

        public void setOverdueDays(int overdueDays) {
            this.overdueDays = overdueDays;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getSiteUserMobile() {
            return siteUserMobile;
        }

        public void setSiteUserMobile(String siteUserMobile) {
            this.siteUserMobile = siteUserMobile;
        }

        public String getApartmentId() {
            return apartmentId;
        }

        public void setApartmentId(String apartmentId) {
            this.apartmentId = apartmentId;
        }

        public String getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(String repayDate) {
            this.repayDate = repayDate;
        }

        public int getTermNo() {
            return termNo;
        }

        public void setTermNo(int termNo) {
            this.termNo = termNo;
        }

        public int getTotalAmt() {
            return totalAmt;
        }

        public void setTotalAmt(int totalAmt) {
            this.totalAmt = totalAmt;
        }

        public int getPrincipalAmt() {
            return principalAmt;
        }

        public void setPrincipalAmt(int principalAmt) {
            this.principalAmt = principalAmt;
        }

        public int getInterestAmt() {
            return interestAmt;
        }

        public void setInterestAmt(int interestAmt) {
            this.interestAmt = interestAmt;
        }

        public int getOverdueAmt() {
            return overdueAmt;
        }

        public void setOverdueAmt(int overdueAmt) {
            this.overdueAmt = overdueAmt;
        }

        public String getRepayType() {
            return repayType;
        }

        public void setRepayType(String repayType) {
            this.repayType = repayType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModTime() {
            return modTime;
        }

        public void setModTime(String modTime) {
            this.modTime = modTime;
        }
    }
}
