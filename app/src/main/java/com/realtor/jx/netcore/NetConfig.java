package com.realtor.jx.netcore;

import android.content.Context;

import com.realtor.jx.BuildConfig;
import com.realtor.jx.netcore.core.cookie.CookiesManager;
import com.realtor.jx.netcore.utils.NetLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: sundong
 * created at 2018/1/4 15:11
 */
public class NetConfig {

    // httpheaders
    public Map<String, String> headers = new HashMap<>();

    private void setupHeaders() {

        headers.put("Accept-Charset", "UTF-8,*");
        headers.put("Plantform", "Android");
        headers.put("Content-Type", "application/json");
        headers.put("Client-Version", BuildConfig.VERSION_NAME);
    }

    // 超时时间
    public final long timeout = 20L * 1000L;

    // 时间单位
    public final TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;

    // 服务器地址
    public final String BASE_URL = BuildConfig.SERVER_ADD;

    // cookie 工具
    public CookieJar cookieJar = null;

    private void setupCookieJar(Context context) {

        if (context != null)
            cookieJar = new CookiesManager(context);
    }

    // 解析器
    public Converter.Factory factory = GsonConverterFactory.create();

    // 日志
    public HttpLoggingInterceptor logger;

    private void setupLogger() {
        logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                NetLogger.connLog(message);
            }
        });
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    public static NetConfig create(Context context) {

        NetConfig config = new NetConfig();

        config.setupHeaders();
        config.setupCookieJar(context);
        config.setupLogger();

        return config;
    }
}
