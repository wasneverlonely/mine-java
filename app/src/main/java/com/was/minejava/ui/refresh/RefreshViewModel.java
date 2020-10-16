package com.was.minejava.ui.refresh;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.BaseRequest;
import com.was.minejava.bean.SchoolUniformBean;
import com.was.minejava.request.BaseRefershReqeust;
import com.was.minejava.request.RefreshRequest;

import java.util.List;

public class RefreshViewModel extends BaseRefreshViewModel {

    public final RefreshRequest refreshRequest = new RefreshRequest();


    {
        Log.e("RefreshViewModel", "init ---------> ");
    }
//
//    @Override
//    BaseRefershReqeust initRequest() {
//        return new RefreshRequest();
//    }
}

