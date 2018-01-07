package com.realtor.jx.entity;

/**
 * autour: lewish
 * created at: 2018/1/7 19:32
*/

public class ContractListItemData {
    public int type;
    public String renterName;
    public String renterPhone;
    public String time;

    public ContractListItemData(int type, String renterName, String renterPhone, String time) {
        this.type = type;
        this.renterName = renterName;
        this.renterPhone = renterPhone;
        this.time = time;
    }
}
