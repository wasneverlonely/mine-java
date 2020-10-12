package com.was.minejava;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.minejava.base.BaseActivity;
import com.was.minejava.ui.list.ListActivity;
import com.was.minejava.ui.login.LoginActivity;
import com.was.minejava.ui.refresh.RefreshActivity;
import com.was.minejava.ui.tab.TabLayoutActivity;

public class MainActivity extends BaseActivity {

    MainViewModel mMainModel;

    @Override
    protected void initViewModel() {
        mMainModel = new MainViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, mMainModel)
                .addBindingParam(BR.click, new MainActivity.ClickProxy());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setBack();
//        setTitleText("我是主页面");
//        setTitleRightText("次级按钮", (view) -> {
//            showShortToast("次级按钮点击");
//        });
    }


    public class ClickProxy {
        public void clickLogin() {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        public void clickList() {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        }

        public void clickRefresh() {
            Intent intent = new Intent(MainActivity.this, RefreshActivity.class);
            startActivity(intent);
        }

        public void clickTabLayout() {
            Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
            startActivity(intent);
        }
    }
}