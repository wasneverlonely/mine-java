package com.was.minejava.common;


import com.was.core.common.http.ApiException;
import com.was.core.common.http.PrintReqeustInterceptor;
import com.was.core.common.http.print.PrintGsonConverterFactory;
import com.was.core.utils.L;
import com.was.minejava.bean.HttpResult;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by liukun on 16/3/9.
 * <p>
 * <p>
 * 网络请求工具类  所有的网络请求调用这个里面的工具类
 */
public class HttpUtils {

    public static final MediaType MULTIPART_FORM_DATA = MediaType.parse("multipart/form-data;charset=utf-8");
    public static final MediaType APPLICATION_URLENCODED = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType TEXT_XML = MediaType.parse("text/xml;charset=utf-8");


    // 成功请求 code  1
    public static final int CODE_REQUEST_SUCCESS = 1;

    // 默认超时  10秒
    private static final int DEFAULT_TIMEOUT = 25;

    private static Api api;

    public static Api getApi() {
        return getInstance().api;
    }

    static Retrofit retrofit;


    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpUtils INSTANCE = new HttpUtils();
    }

    //获取单例
    public static HttpUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //构造方法私有
    private HttpUtils() {
        initRetrofit();
    }


    /**
     * 初始化 initRetorfit
     */
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
        L.e("  " + Config.getNetworkPath());
        api = retrofit.create(Api.class);
    }


    /**
     * 原始   toSunscribe
     *
     * @param o
     * @param s
     * @param <T>
     */
    public static <T> void originalToSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


    /**
     * 判断 code返回数据
     *
     * @param o
     * @param s
     */
    public static <T> void toSubscribe(Observable<HttpResult<T>> o, Subscriber<T> s) {
        if (o == null) {
            return;
        }

        Observable<T> map = o.map(new HttpResultFunc<T>());
        originalToSubscribe(map, s);
    }


    /**
     * 判断网络请求是否成功
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> boolean isRequestSuccess(HttpResult<T> result) {
        return result.getCode() == CODE_REQUEST_SUCCESS;
    }


    /**
     * 判断网络请求的数据是否成功
     *
     * @param <T>
     */
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            // 如果返回code不是1  请求不成功  报ApiException
            if (!isRequestSuccess(httpResult))
                throw new ApiException(httpResult.getCode(), httpResult.getMsg());
            return httpResult.getData();
        }
    }
}

