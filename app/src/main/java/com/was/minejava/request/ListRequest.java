package com.was.minejava.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.bean.UserBean;
import com.was.minejava.common.HttpHelper;

import java.util.List;

import rx.Observable;

public class ListRequest {

    private MutableLiveData<NetState<List<ProvinceBean>>> data;

    public LiveData<NetState<List<ProvinceBean>>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void lookProvince() {

        Observable<HttpResult<List<ProvinceBean>>> observable = HttpHelper.getApi().lookProvince();

        HttpHelper.toSubscribe(observable, new HttpSubscriber<List<ProvinceBean>>() {

            @Override
            public void sub(NetState<List<ProvinceBean>> netState) {
                data.postValue(netState);
            }

            @Override
            public void onFail(Throwable e, NetState netState) {
                super.onFail(e, netState);
                data.postValue(netState);
            }
        });
    }

}
