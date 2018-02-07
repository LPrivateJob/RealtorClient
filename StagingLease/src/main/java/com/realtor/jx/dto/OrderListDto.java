package com.realtor.jx.dto;

import java.util.List;

/**
 * description:
 * autour: Tait
 * created at 2018/1/18 20:15
 */
public class OrderListDto {

    /**
     * totalNum : 10
     * orders : [{"id":"20180114163504100000","orderNo":"","delayDate":"2018-01-17","repayDate":"2018-01-17","lateStatus":"","userId":"","platformPayType":"","payTerm":"","changeNo":"","returnType":"","applyDate":"","status":0,"refuseInfo":"","refuseRemark":"","rate":"","discountRate":"","delayRate":"","cash":"","siteUsertotalAmt":0,"platTotalAmt":0,"tenancyName":"张三","tenancyMobile":"13886286698","tenancyIdcard":"","tenancyType":"","startTime":"","endTime":"","feeType":"","firstPaytype":"","houseName":"","houseCode":"","roomNum":"","settleDate":"","info":"","qrcodeUrl":"","orderUrl":"","ownerUrl":"","houseUrl":"","agentUrl":"","gmtCreate":"","gmtModify":"","checkDate":"2018-01-17","lateDays":"","cityNo":""},{"id":"20180116224905100000","orderNo":"","delayDate":"2018-01-17","repayDate":"2018-01-17","lateStatus":"","userId":"","platformPayType":"","payTerm":"","changeNo":"","returnType":"","applyDate":"","status":8,"refuseInfo":"","refuseRemark":"","rate":"","discountRate":"","delayRate":"","cash":"","siteUsertotalAmt":0,"platTotalAmt":0,"tenancyName":"张三","tenancyMobile":"13886286698","tenancyIdcard":"","tenancyType":"","startTime":"","endTime":"","feeType":"","firstPaytype":"","houseName":"","houseCode":"","roomNum":"","settleDate":"","info":"","qrcodeUrl":"","orderUrl":"","ownerUrl":"","houseUrl":"","agentUrl":"","gmtCreate":"","gmtModify":"","checkDate":"2018-01-17","lateDays":"","cityNo":""},{"id":"20180120153413100000","orderNo":"","delayDate":"","repayDate":"","lateStatus":"","userId":"","platformPayType":"","payTerm":"","changeNo":"","returnType":"","applyDate":"","status":1,"refuseInfo":"","refuseRemark":"","rate":"","discountRate":"","delayRate":"","cash":"","siteUsertotalAmt":0,"platTotalAmt":0,"tenancyName":"张三","tenancyMobile":"13886286698","tenancyIdcard":"","tenancyType":"","startTime":"","endTime":"","feeType":"","firstPaytype":"","houseName":"","houseCode":"","roomNum":"","settleDate":"","info":"","qrcodeUrl":"","orderUrl":"","ownerUrl":"","houseUrl":"","agentUrl":"","gmtCreate":"","gmtModify":"","checkDate":"","lateDays":"","cityNo":""},{"id":"20180120153430100000","orderNo":"","delayDate":"","repayDate":"","lateStatus":"","userId":"","platformPayType":"","payTerm":"","changeNo":"","returnType":"","applyDate":"","status":2,"refuseInfo":"","refuseRemark":"","rate":"","discountRate":"","delayRate":"","cash":"","siteUsertotalAmt":0,"platTotalAmt":0,"tenancyName":"张三","tenancyMobile":"13886286698","tenancyIdcard":"","tenancyType":"","startTime":"","endTime":"","feeType":"","firstPaytype":"","houseName":"","houseCode":"","roomNum":"","settleDate":"","info":"","qrcodeUrl":"","orderUrl":"","ownerUrl":"","houseUrl":"","agentUrl":"","gmtCreate":"","gmtModify":"","checkDate":"","lateDays":"","cityNo":""}]
     */

    private int totalNum;
    private List<OrdersBean> orders;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        /**
         * id : 20180114163504100000
         * orderNo :
         * delayDate : 2018-01-17
         * repayDate : 2018-01-17
         * lateStatus :
         * userId :
         * platformPayType :
         * payTerm :
         * changeNo :
         * returnType :
         * applyDate :
         * status : 0
         * refuseInfo :
         * refuseRemark :
         * rate :
         * discountRate :
         * delayRate :
         * cash :
         * siteUsertotalAmt : 0
         * platTotalAmt : 0
         * tenancyName : 张三
         * tenancyMobile : 13886286698
         * tenancyIdcard :
         * tenancyType :
         * startTime :
         * endTime :
         * feeType :
         * firstPaytype :
         * houseName :
         * houseCode :
         * roomNum :
         * settleDate :
         * info :
         * qrcodeUrl :
         * orderUrl :
         * ownerUrl :
         * houseUrl :
         * agentUrl :
         * gmtCreate :
         * gmtModify :
         * checkDate : 2018-01-17
         * lateDays :
         * cityNo :
         */

        private String id;
        private String orderNo;
        private String delayDate;
        private String repayDate;
        private String lateStatus;
        private String userId;
        private String platformPayType;
        private String payTerm;
        private String changeNo;
        private String returnType;
        private String applyDate;
        private int status;
        private String refuseInfo;
        private String refuseRemark;
        private String rate;
        private String discountRate;
        private String delayRate;
        private String cash;
        private int siteUsertotalAmt;
        private int platTotalAmt;
        private String tenancyName;
        private String tenancyMobile;
        private String tenancyIdcard;
        private String tenancyType;
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

        public String getPayTerm() {
            return payTerm;
        }

        public void setPayTerm(String payTerm) {
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

        public String getCash() {
            return cash;
        }

        public void setCash(String cash) {
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

        public String getTenancyType() {
            return tenancyType;
        }

        public void setTenancyType(String tenancyType) {
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
}
