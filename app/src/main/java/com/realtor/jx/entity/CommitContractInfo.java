package com.realtor.jx.entity;

/**
 * description: 提交合同类
 * autour: Tait
 * created at: 2018/1/20 15:23
 */
public class CommitContractInfo {
    //租住信息
    public String tenancyName;//姓名
    public String tenancyMobile;//手机号码
    public String tenancyIdcard;//身份证号
    public int tenancyType;//租住方式
    public String cityNo;//所在城市
    public String houseName;//小区名称
    public String houseCode;//门牌号
    public String roomNum;//房间号
    //分期信息
    public int cash;//月租金
    public String startTime;//起租日
    public String endTime;//到租日
    public int feeType;//服务费承担方
    public int firstPaytype;//租客首付方式
    public int platformPayType;//平台付款方式
    public int payTerm;//还款期数
    public String changeNo;//台账号
    public String info;//备注信息

    public CommitContractInfo() {
    }


}
