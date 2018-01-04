package com.realtor.jx.netcore.core;


import com.realtor.jx.netcore.NetConfig;
import com.realtor.jx.netcore.api.ApiService;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;

/**
 * author: sundong
 * created at 2018/1/4 15:10
 */
public class NetEngine {

    private static NetEngine instance = null;

    private NetEngine(NetConfig config) {
        this.config = config;
    }

    private NetConfig config;           // 配置实例
    private OkHttpClient okHttpClient;  // httpClient实例
    private Retrofit retrofit;          // retrofit实例
    private ApiService apiService;      // serverApi 实例


    public static void init(NetConfig config) {

        if (instance == null) {
            instance = new NetEngine(config);
        }

        instance.setupOkHttpClient();
        instance.setupRetrofit();
        instance.setupApiService();
    }

    public static ApiService getServerApi() {
        if (instance == null) {
            throw new RuntimeException("Net Engine Not Initialized");
        }

        return instance.getApiService();
    }

    private void setupOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(config.cookieJar);
        builder.connectTimeout(config.timeout, config.timeoutUnit);

        if (config.headers != null && !config.headers.isEmpty()) {
            builder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {

                    Request.Builder builder = chain.request().newBuilder();
                    headerSetup(builder, config.headers);

                    return chain.proceed(builder.build());
                }
            });
        }

        if (config.logger != null) {
            builder.addInterceptor(config.logger);
        }
        okHttpClient = builder.build();
    }

    private void headerSetup(Request.Builder builder, Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private void setupRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(config.BASE_URL)
                .addConverterFactory(config.factory)
                .build();
    }

    private void setupApiService() {
        apiService = retrofit.create(ApiService.class);
    }

    protected ApiService getApiService() {
        return apiService;
    }

}
