package com.realtor.jx.dto;

import java.util.List;

/**
 * author: sundong
 * created at 2018/1/18 20:15
 */
public class OrderListDto {

    /**
     * data : {"orders":[{"checkDate":1516192749000,"delayDate":1516192712000,"id":"20180114163504100000","platTotalAmt":0,"repayDate":1516192720000,"siteUsertotalAmt":0,"status":0,"tenancyMobile":"13886286698","tenancyName":"张三"},{"checkDate":1516192751000,"delayDate":1516192716000,"id":"20180116224905100000","platTotalAmt":0,"repayDate":1516192718000,"siteUsertotalAmt":0,"status":0,"tenancyMobile":"13886286698","tenancyName":"张三"}]}
     * result_code : 200
     * result_info : 成功
     */

    private DataBean data;
    private String result_code;
    private String result_info;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_info() {
        return result_info;
    }

    public void setResult_info(String result_info) {
        this.result_info = result_info;
    }

    public static class DataBean {
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
}
