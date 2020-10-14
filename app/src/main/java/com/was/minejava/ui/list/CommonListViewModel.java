package com.was.minejava.ui.list;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.request.ListRequest;

import java.util.List;

public class CommonListViewModel extends ViewModel {

    public final MutableLiveData<List<ProvinceBean>> list = new MutableLiveData<>();

    public final ListRequest listRequest = new ListRequest();

    {
        Log.e("ListViewModel", "init ---------> ");
    }

}
