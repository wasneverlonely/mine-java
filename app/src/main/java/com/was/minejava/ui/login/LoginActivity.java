package com.was.minejava.ui.login;


import android.util.Log;

import androidx.lifecycle.Observer;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.core.common.http.NetState;
import com.was.core.ui.BaseActivity;
import com.was.core.utils.ToastUtils;
import com.was.core.utils.ValidateUtils;
import com.was.minejava.BR;
import com.was.minejava.R;
import com.was.minejava.bean.UserBean;


public class LoginActivity extends BaseActivity {

    LoginViewModel mLoginModel;

    @Override
    protected void initViewModel() {
        mLoginModel = new LoginViewModel();
        mLoginModel.userName.set("18514232635");
        mLoginModel.password.set("123456");

        mLoginModel.loginRequest.getUser().observe(this, new Observer<NetState<UserBean>>() {
            @Override
            public void onChanged(NetState<UserBean> state) {
                if (state.isSuccess()) {
                    ToastUtils.showShort("" + state.getData().getId());
                } else {
                    ToastUtils.showShort(state.getMessage());
                }
            }
        });
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
                    !ValidateUtils.checkPassword(password, 6)) {
                return;
            }

            mLoginModel.loginRequest.login(userName, password);
        }
    }
}