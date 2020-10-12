package com.was.minejava.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.BaseRequest;
import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.UserBean;
import com.was.minejava.common.HttpHelper;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class LoginRequest extends BaseRequest {

    private MutableLiveData<NetState<UserBean>> user;

    public LiveData<NetState<UserBean>> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public void login(String userName, String password) {

        Observable<HttpResult<UserBean>> observable = HttpHelper.getApi().login(userName, password);


        HttpHelper.toSubscribe(observable, new HttpSubscriber<UserBean>() {

            @Override
            public void sub(NetState<UserBean> netState) {
                user.postValue(netState);
            }

            @Override
            public void onFail(Throwable e, NetState netState) {
                super.onFail(e, netState);
                user.postValue(netState);
            }
        });
    }
}
