package com.realtor.jx.netcore.api;

import com.realtor.jx.netcore.entity.ResponseResult;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("{route}")
    Call<ResponseResult> postFormData(@Path(value = "route", encoded = true) String route, @FieldMap Map<String, Object> paramMap);

    @Headers({"Content-Type: application/json"})
    @POST("{route}")
    Call<ResponseResult> postJson(@Path(value = "route", encoded = true) String route, @QueryMap Map<String, Object> paramMap,  @Body Object body);

    @Multipart
    @POST("{route}")
    Call<ResponseResult> uploadFile(@Path(value = "route", encoded = true) String route, @PartMap() Map<String, RequestBody> partMap, @Part() MultipartBody.Part... info);

    @GET("{route}")
    Call<ResponseResult> get(@Path(value = "route", encoded = true) String route, @QueryMap Map<String, Object> paramMap);
}