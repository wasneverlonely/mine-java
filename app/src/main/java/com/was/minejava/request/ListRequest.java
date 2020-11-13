package com.was.minejava.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.data.PlaceRepository;
import com.was.minejava.data.model.Province;
import com.was.minejava.common.HttpHelper;

import java.util.List;

import rx.Observable;

public class ListRequest {

    private MutableLiveData<NetState<List<Province>>> data;

    public LiveData<NetState<List<Province>>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void lookProvince() {



//        Observable<HttpResult<List<Province>>> observable = HttpHelper.getApi().lookProvince();

//        HttpHelper.toSubscribe(observable, new HttpSubscriber<List<Province>>() {
//
//            @Override
//            public List<Province> onSuccess(NetState<List<Province>> netState) {
//                data.postValue(netState);
//                return null;
//            }
//
//            @Override
//            public void onFail(Throwable e, NetState netState) {
//                super.onFail(e, netState);
//                data.postValue(netState);
//            }
//        });
    }

}
