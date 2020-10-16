package com.was.minejava.ui.refresh;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.was.core.common.http.BaseRequest;
import com.was.minejava.bean.SchoolUniformBean;
import com.was.minejava.request.BaseRefershReqeust;

import java.util.List;

public abstract class BaseRefreshViewModel<T> extends ViewModel {

    public ObservableBoolean refreshing = new ObservableBoolean(); //

    public ObservableBoolean isEnabledRefresh = new ObservableBoolean();//

    public ObservableBoolean isEnableLoadMore = new ObservableBoolean();


    public final MutableLiveData<List<T>> list = new MutableLiveData<>();


    public void addData(List<T> addDatas) {

        List<T> data = list.getValue();
        data.addAll(addDatas);
        list.postValue(data);

    }

//    public BaseRefershReqeust refreshRequest;
//
//    abstract BaseRefershReqeust initRequest();

    {
        refreshing.set(true);
        isEnableLoadMore.set(false);
        isEnabledRefresh.set(true);
//        refreshRequest = initRequest();
    }
}
