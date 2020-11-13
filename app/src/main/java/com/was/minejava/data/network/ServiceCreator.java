package com.was.minejava.data.network;

import com.was.core.common.http.PrintReqeustInterceptor;
import com.was.core.common.http.print.PrintGsonConverterFactory;
import com.was.core.utils.L;
import com.was.minejava.common.Api;
import com.was.minejava.common.Config;
import com.was.minejava.common.HttpHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceCreator {

    // 默认超时  10秒
    private static final int DEFAULT_TIMEOUT = 25;

    static Retrofit retrofit;

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final ServiceCreator INSTANCE = new ServiceCreator();
    }

    //获取单例
    public static ServiceCreator getInstance() {
        return ServiceCreator.SingletonHolder.INSTANCE;
    }

    //构造方法私有
    private ServiceCreator() {
        initRetrofit();
    }

    public static void initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)//设置超时时间
                .addInterceptor(new PrintReqeustInterceptor());//设置加密拦截

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(PrintGsonConverterFactory.create())//输出 网络请求log
                .addConverterFactory(GsonConverterFactory.create())// 转化gson
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Config.getNetworkPath())
                .build();
    }




}
