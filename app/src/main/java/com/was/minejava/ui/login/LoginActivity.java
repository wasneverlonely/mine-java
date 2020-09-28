package com.was.minejava.ui.login;


import android.util.Log;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.core.ui.BaseActivity;
import com.was.core.utils.ValidateUtils;
import com.was.minejava.BR;
import com.was.minejava.R;


public class LoginActivity extends BaseActivity {

    LoginViewModel mLoginModel;

    @Override
    protected void initViewModel() {
        mLoginModel = new LoginViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_login, BR.vm, mLoginModel)
                .addBindingParam(BR.click, new ClickProxy());
    }


    public class ClickProxy {
        public void login() {

            String userName = mLoginModel.userName.get();
            String password = mLoginModel.password.get();
            Log.e(TAG, "login: " + userName + password);

            if (!ValidateUtils.checkPhoneNumber(userName) ||
                    !ValidateUtils.checkPhoneNumber(password)) {
                return;
            }

            mLoginModel.loginRequest.login(userName, password);
//            mLoginModel.loginRequest.
        }
    }
}