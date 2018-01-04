package com.realtor.jx.netcore.api;

import com.realtor.jx.netcore.Entity.ResponseResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public interface ApiService {


    // 登陆接口
    @POST(ApiRoute.LOGIN.LOGIN)
    Call<ResponseResult> login(@Body RequestBody body);

    // Token登陆
    @POST(ApiRoute.LOGIN.LOGIN_BY_TOKEN)
    Call<ResponseResult> loginByToken(@Body RequestBody body);

    // 我的客户列表
    @POST(ApiRoute.COUSTOMERS.COSTOMERS_LIST)
    Call<ResponseResult> customersList(@Body RequestBody body);  // 我的客户列表

    //合同详情
    @POST(ApiRoute.COUSTOMERS.CONTACTS_LIST)
    Call<ResponseResult> contactsList(@Body RequestBody body);


    //客户经理绑卡列表
    @POST(ApiRoute.COUSTOMERS_DETAILS.BINDCARD_LIST)
    Call<ResponseResult> bindcardList(@Body RequestBody body);


    //获取支付验证码
    @POST(ApiRoute.COUSTOMERS_DETAILS.SMSCODE)
    Call<ResponseResult> getSMSCode(@Body RequestBody body);

    //确认支付
    @POST(ApiRoute.COUSTOMERS_DETAILS.COMFIRMPAYMENT)
    Call<ResponseResult> confirmPayment(@Body RequestBody body);

    //获取绑卡验证码
    @POST(ApiRoute.COUSTOMERS_DETAILS.BINDCARDSMMCODE)
    Call<ResponseResult> getBindCardCode(@Body RequestBody body);   //获取绑卡验证码

    //确认绑卡
    @POST(ApiRoute.COUSTOMERS_DETAILS.CONFIRMBINDCARD)
    Call<ResponseResult> confirmBindCard(@Body RequestBody body);

    //解除绑卡
    @POST(ApiRoute.COUSTOMERS_DETAILS.REMOVERBINDCARD)
    Call<ResponseResult> removeVindCard(@Body RequestBody body);

    //解除绑卡
    @POST(ApiRoute.COUSTOMERS.SEARCH)
    Call<ResponseResult> search(@Body RequestBody body);

    //解除绑卡
    @POST(ApiRoute.COUSTOMERS_DETAILS.GETBANKLIST)
    Call<ResponseResult> getBankList(); //解除绑卡

    // 获取汇款银行账号
    @POST(ApiRoute.COUSTOMERS_DETAILS.GETACCOUNTINFO)
    Call<ResponseResult> getAccountInfo(@Body RequestBody body);

    // 提交划扣信息 接口
    @POST(ApiRoute.COUSTOMERS_DETAILS.GETHUAKOUPAYMENT)
    Call<ResponseResult> getHuaKouPayMent(@Body RequestBody body);
}