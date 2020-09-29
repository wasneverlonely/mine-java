package com.was.minejava.ui.refresh;


import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.was.minejava.bean.ProvinceBean;

import java.util.List;

public class RefreshViewModel extends ViewModel {

    public final MutableLiveData<List<ProvinceBean>> list = new MutableLiveData<>();


    {
        Log.e("RefreshViewModel", "init ---------> ");
    }

}

