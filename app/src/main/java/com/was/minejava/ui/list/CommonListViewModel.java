package com.was.minejava.ui.list;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.was.minejava.data.PlaceRepository;
import com.was.minejava.data.model.Province;
import com.was.minejava.data.model.Province;
import com.was.minejava.request.ListRequest;

import java.util.List;

public class CommonListViewModel extends ViewModel {

    public final MutableLiveData<List<Province>> list = new MutableLiveData<>();

    private PlaceRepository repository;

    public CommonListViewModel(PlaceRepository repository) {
        this.repository = repository;
    }

    public void getProvinceList() {
        List<Province> provinceList = repository.getProvinceList();
        list.postValue(provinceList);
    }


    public final ListRequest listRequest = new ListRequest();

    {
        Log.e("ListViewModel", "init ---------> ");
    }

}
