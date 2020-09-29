package com.was.minejava;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.kunminx.architecture.BaseApplication;
import com.was.core.utils.AppUtils;
import com.was.core.utils.ToastUtils;
import com.was.core.utils.Utils;

public class App extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
        ToastUtils.register(getApplicationContext());
    }
}
