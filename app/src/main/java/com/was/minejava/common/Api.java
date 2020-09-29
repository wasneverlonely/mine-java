package com.was.minejava.common;

import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.bean.UserBean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * api 接口
 * Created by liukun on 16/3/9.
 */
public interface Api {
    /**
     * 登录
     *
     * @param phoneNumber
     * @param password
     * @return "content":{
     * "id":7,             //用户id
     * "type":3           //用户类型  1.家长 2.老师  3.普通用户
     * }
     */
    @FormUrlEncoded
    @POST("user/app_login.action")
    Observable<HttpResult<UserBean>>
    login(@Field("mobile") String phoneNumber, @Field("password") String password);


    @GET("nation/app_qryAllProvince.action")
    Observable<HttpResult<List<ProvinceBean>>> lookProvince();
}






