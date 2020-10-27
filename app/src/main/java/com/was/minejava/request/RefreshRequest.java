package com.was.minejava.request;


import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.SchoolUniformBean;
import com.was.minejava.common.HttpHelper;

import java.util.List;

import rx.Observable;

public class RefreshRequest extends BaseRefershReqeust {

    private MutableLiveData<NetState<List<SchoolUniformBean>>> data;

    public MutableLiveData<NetState<List<SchoolUniformBean>>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    @Override
    public void requestData(boolean isRefresh) {

        Observable<HttpResult<List<SchoolUniformBean>>> observable = HttpHelper.getApi().lookSchoolUniform("13", getPageIndex(isRefresh), getPageSize());

        HttpHelper.toSubscribe(observable, new HttpSubscriber<List<SchoolUniformBean>>() {
            @Override
            public void onSuccess(NetState<List<SchoolUniformBean>> netState) {
                netState.setRefresh(isRefresh);
                getData().postValue(netState);
            }

            @Override
            public void onFail(Throwable e, NetState netState) {
                super.onFail(e, netState);
                netState.setRefresh(isRefresh);
                getData().postValue(netState);
            }
        });
    }
}
