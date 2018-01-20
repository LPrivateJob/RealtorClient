package com.realtor.jx.dto;

import java.util.List;

/**
 * author: sundong
 * created at 2018/1/18 20:15
 */
public class OrderListDto {


    private List<OrdersBean> orders;

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        /**
         * checkDate : 1516192749000
         * delayDate : 1516192712000
         * id : 20180114163504100000
         * platTotalAmt : 0
         * repayDate : 1516192720000
         * siteUsertotalAmt : 0
         * status : 0
         * tenancyMobile : 13886286698
         * tenancyName : 张三
         */

        private long checkDate;
        private long delayDate;
        private String id;
        private int platTotalAmt;
        private long repayDate;
        private int siteUsertotalAmt;
        private int status;
        private String tenancyMobile;
        private String tenancyName;

        public long getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(long checkDate) {
            this.checkDate = checkDate;
        }

        public long getDelayDate() {
            return delayDate;
        }

        public void setDelayDate(long delayDate) {
            this.delayDate = delayDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getPlatTotalAmt() {
            return platTotalAmt;
        }

        public void setPlatTotalAmt(int platTotalAmt) {
            this.platTotalAmt = platTotalAmt;
        }

        public long getRepayDate() {
            return repayDate;
        }

        public void setRepayDate(long repayDate) {
            this.repayDate = repayDate;
        }

        public int getSiteUsertotalAmt() {
            return siteUsertotalAmt;
        }

        public void setSiteUsertotalAmt(int siteUsertotalAmt) {
            this.siteUsertotalAmt = siteUsertotalAmt;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
    }
}
