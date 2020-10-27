package com.was.minejava.ui.login;


import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.was.core.common.http.HttpSubscriber;
import com.was.core.common.http.NetState;
import com.was.core.utils.ToastUtils;
import com.was.minejava.bean.UserBean;
import com.was.minejava.data.network.LoginRequest;


public class LoginViewModel extends ViewModel {

    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    public MutableLiveData<NetState<UserBean>> user = new MutableLiveData<>();

    public final LoginRequest loginRequest = new LoginRequest();

    public void login(String userName, String password) {
        loginRequest.login(userName, password, new HttpSubscriber() {
            @Override
            public void onSuccess(NetState netState) {
                user.postValue(netState);
            }

            @Override
            public void onFail(Throwable e, NetState netState) {
                super.onFail(e, netState);
                ToastUtils.showShort(netState.getMessage());
//                user.postValue(netState);
            }
        });
    }

    {
        userName.set("18514232635");
        password.set("123456");

        Log.e("LoginViewModel", "init ---------> ");
    }

}
