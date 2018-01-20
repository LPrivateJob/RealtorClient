package com.realtor.jx.dto;

import java.util.List;

/**
 * Created by Lewish on 2018/1/20.
 */

public class ContractDetailDto {

    /**
     * areas : {"city":"北京","province":"北京","region":"海淀"}
     * instalmentOrders : [{"apartmentId":"113417667","id":"201801201534521000001","interestAmt":505,"orderId":"20180120153452100000","overdueAmt":0,"overdueDays":0,"principalAmt":5054,"repayDate":1519111560000,"siteUserMobile":"13886286698","status":0,"termNo":1,"totalAmt":5559},{"apartmentId":"113417667","id":"201801201534521000002","interestAmt":505,"orderId":"20180120153452100000","overdueAmt":0,"overdueDays":0,"principalAmt":5054,"repayDate":1521530760000,"siteUserMobile":"13886286698","status":0,"termNo":2,"totalAmt":5559},{"apartmentId":"113417667","id":"201801201534521000003","interestAmt":541,"orderId":"20180120153452100000","overdueAmt":0,"overdueDays":0,"principalAmt":5416,"repayDate":1524209160000,"siteUserMobile":"13886286698","status":0,"termNo":3,"totalAmt":5957}]
     * order : {"cash":5054,"changeNo":"string","checkDate":1516192718000,"cityNo":"000090","delayDate":1516192718000,"endTime":1540193160000,"feeType":1,"firstPaytype":1,"houseCode":"64号楼","houseName":"远洋天地","id":"20180120153452100000","info":"输入备注信息","payTerm":3,"platTotalAmt":0,"platformPayType":1,"refuseRemark":"不行，这伙计太穷了，不租！","repayDate":1516192718000,"roomNum":"1007","siteUsertotalAmt":17075,"startTime":1516433160000,"status":4,"tenancyIdcard":"420621199001061215","tenancyMobile":"13886286698","tenancyName":"张三","tenancyType":1}
     */

    private AreasBean areas;
    private OrderBean order;
    private List<InstalmentOrdersBean> instalmentOrders;

    public AreasBean getAreas() {
        return areas;
    }

    public void setAreas(AreasBean areas) {
        this.areas = areas;
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

    public static class AreasBean {
        /**
         * city : 北京
         * province : 北京
         * region : 海淀
         */

        private String city;
        private String province;
        private String region;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }

    public static class OrderBean {
        /**
         * cash : 5054.0
         * changeNo : string
         * checkDate : 1516192718000
         * cityNo : 000090
         * delayDate : 1516192718000
         * endTime : 1540193160000
         * feeType : 1
         * firstPaytype : 1
         * houseCode : 64号楼
         * houseName : 远洋天地
         * id : 20180120153452100000
         * info : 输入备注信息
         * payTerm : 3
         * platTotalAmt : 0
         * platformPayType : 1
         * refuseRemark : 不行，这伙计太穷了，不租！
         * repayDate : 1516192718000
         * roomNum : 1007
         * siteUsertotalAmt : 17075
         * startTime : 1516433160000
         * status : 4
         * tenancyIdcard : 420621199001061215
         * tenancyMobile : 13886286698
         * tenancyName : 张三
         * tenancyType : 1
         */

        private double cash;
        private String changeNo;
        private long checkDate;
        private String cityNo;
        private long delayDate;
        private long endTime;
        private int feeType;
        private int firstPaytype;
        private String houseCode;
        private String houseName;
        private String id;
        private String info;
        private int payTerm;
        private int platTotalAmt;
        private int platformPayType;
        private String refuseRemark;
        private long repayDate;
        private String roomNum;
        private int siteUsertotalAmt;
        private long startTime;
        private int status;
        private String tenancyIdcard;
        private String tenancyMobile;
        private String tenancyName;
        private int tenancyType;

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public String getChangeNo() {
            return changeNo;
        }

        public void setChangeNo(String changeNo) {
            this.changeNo = changeNo;
        }

        public long getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(long checkDate) {
            this.checkDate = checkDate;
        }

        public String getCityNo() {
            return cityNo;
        }

        public void setCityNo(String cityNo) {
            this.cityNo = cityNo;
        }

        public long getDelayDate() {
            return delayDate;
        }

        public void setDelayDate(long delayDate) {
            this.delayDate = delayDate;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public int getFeeType() {
            return feeType;
        }

        public void setFeeType(int feeType) {
            this.feeType = feeType;
        }

        public int getFirstPaytype() {
            return firstPaytype;
        }

        public void setFirstPaytype(int firstPaytype) {
            this.firstPaytype = firstPaytype;
        }

        public String getHouseCode() {
            return houseCode;
        }

        public void setHouseCode(String houseCode) {
            this.houseCode = houseCode;
        }

        public String getHouseName() {
            return houseName;
        }

        public void setHouseName(String houseName) {
            this.houseName = houseName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public int getPayTerm() {
            return payTerm;
        }

        public void setPayTerm(int payTerm) {
            this.payTerm = payTerm;
        }

        public int getPlatTotalAmt() {
            return platTotalAmt;
        }

        public void setPlatTotalAmt(int platTotalAmt) {
            this.platTotalAmt = platTotalAmt;
        }

        public int getPlatformPayType() {
            return platformPayType;
        }

        public void setPlatformPayType(int platformPayType) {
            this.platformPayType = platformPayType;
        }

        public String getRefuseRemark() {
            return refuseRemark;
        }

        public void setRefuseRemark(String refuseRemark) {
            this.refuseRemark = refuseRemark;
        }

        public long getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(long repayDate) {
            this.repayDate = repayDate;
        }

        public String getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(String roomNum) {
            this.roomNum = roomNum;
        }

        public int getSiteUsertotalAmt() {
            return siteUsertotalAmt;
        }

        public void setSiteUsertotalAmt(int siteUsertotalAmt) {
            this.siteUsertotalAmt = siteUsertotalAmt;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTenancyIdcard() {
            return tenancyIdcard;
        }

        public void setTenancyIdcard(String tenancyIdcard) {
            this.tenancyIdcard = tenancyIdcard;
        }

        public String getTenancyMobile() {
            return tenancyMobile;
        }

        public void setTenancyMobile(String tenancyMobile) {
            this.tenancyMobile = tenancyMobile;
        }

        public String getTenancyName() {
            return tenancyName;
        }

        public void setTenancyName(String tenancyName) {
            this.tenancyName = tenancyName;
        }

        public int getTenancyType() {
            return tenancyType;
        }

        public void setTenancyType(int tenancyType) {
            this.tenancyType = tenancyType;
        }
    }

    public static class InstalmentOrdersBean {
        /**
         * apartmentId : 113417667
         * id : 201801201534521000001
         * interestAmt : 505
         * orderId : 20180120153452100000
         * overdueAmt : 0
         * overdueDays : 0
         * principalAmt : 5054
         * repayDate : 1519111560000
         * siteUserMobile : 13886286698
         * status : 0
         * termNo : 1
         * totalAmt : 5559
         */

        private String apartmentId;
        private String id;
        private int interestAmt;
        private String orderId;
        private int overdueAmt;
        private int overdueDays;
        private int principalAmt;
        private long repayDate;
        private String siteUserMobile;
        private int status;
        private int termNo;
        private int totalAmt;

        public String getApartmentId() {
            return apartmentId;
        }

        public void setApartmentId(String apartmentId) {
            this.apartmentId = apartmentId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getInterestAmt() {
            return interestAmt;
        }

        public void setInterestAmt(int interestAmt) {
            this.interestAmt = interestAmt;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOverdueAmt() {
            return overdueAmt;
        }

        public void setOverdueAmt(int overdueAmt) {
            this.overdueAmt = overdueAmt;
        }

        public int getOverdueDays() {
            return overdueDays;
        }

        public void setOverdueDays(int overdueDays) {
            this.overdueDays = overdueDays;
        }

        public int getPrincipalAmt() {
            return principalAmt;
        }

        public void setPrincipalAmt(int principalAmt) {
            this.principalAmt = principalAmt;
        }

        public long getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(long repayDate) {
            this.repayDate = repayDate;
        }

        public String getSiteUserMobile() {
            return siteUserMobile;
        }

        public void setSiteUserMobile(String siteUserMobile) {
            this.siteUserMobile = siteUserMobile;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
    }
}
