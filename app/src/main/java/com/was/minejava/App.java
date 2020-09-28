package com.was.minejava;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import com.was.core.utils.ToastUtils;

public class App extends MultiDexApplication {

    static Application app;

    public static Application getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        ToastUtils.register(getApplicationContext());
    }
}
