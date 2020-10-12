package com.was.minejava.ui.login;


import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.was.minejava.request.LoginRequest;


public class LoginViewModel extends ViewModel {

    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    public final LoginRequest loginRequest = new LoginRequest();

    {
        userName.set("18514232635");
        password.set("123456");

        Log.e("LoginViewModel", "init ---------> ");
    }

}
