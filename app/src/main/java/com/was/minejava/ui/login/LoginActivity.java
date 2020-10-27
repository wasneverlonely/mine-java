package com.was.minejava.ui.login;


import android.util.Log;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.minejava.common.base.BaseActivity;
import com.was.core.utils.ToastUtils;
import com.was.core.utils.ValidateUtils;
import com.was.minejava.BR;
import com.was.minejava.R;

//登录
public class LoginActivity extends BaseActivity {

    LoginViewModel mLoginModel;

    @Override
    protected void initView() {
        setBack();
        setTitleText("登录");
    }

    @Override
    protected void initViewModel() {
        mLoginModel = new LoginViewModel();

        mLoginModel.user.observe(this, (state) -> {
            if (state.isSuccess()) {
                ToastUtils.showShort("" + state.getData().getId());
            } else {
                ToastUtils.showShort(state.getMessage());
            }
            dismissProgressDialog();
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
            showProgressDialog();
            mLoginModel.login(userName, password);
        }
    }
}