package com.was.minejava.data.network;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.common.HttpHelper;
import com.was.minejava.data.model.Province;

import java.util.List;

import rx.Observable;

public class PlaceNetwork {

    public void fetchProvinceList(HttpSubscriber<List<Province>> subscriber) {

        Observable<HttpResult<List<Province>>> observable = HttpHelper.getApi().lookProvince();

        HttpHelper.toSubscribe(observable, subscriber);
//        HttpHelper.toSubscribe(observable, new HttpSubscriber<List<Province>>() {
//            @Override
//            public void onSuccess(NetState<List<Province>> netState) {
////                placeDao.saveProvinceList(netState.getData());
//                return netState.getData();
//            }
//        });

//        placeNetWork.fetchProvinceList(new HttpSubscriber<HttpResult<List<Province>>>() {
//            @Override
//            public List<Province> onSuccess(NetState<HttpResult<List<Province>>> netState) {
//                placeDao.saveProvinceList(netState.getData());
//                return netState.getData();
//            }
//        });
//        return null;
    }
}
