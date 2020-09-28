package com.was.minejava.request;

import com.was.core.common.http.ProgressSubscriber;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.UserBean;
import com.was.minejava.common.HttpUtils;

import rx.Observable;

public class LoginRequest {

    public void login(String userName, String password) {

        Observable<HttpResult<UserBean>> observable = HttpUtils.getApi().login(userName, password);



//        HttpUtils.toSubscribe(observable, new ProgressSubscriber<UserBean>(this) {
//            @Override
//            public void onNext(UserBean data) {
//
//            }
//
//            @Override
//            public void onFail(Throwable e) {
//                super.onFail(e);
//            }
//        });
    }

}
