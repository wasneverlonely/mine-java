/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.was.core.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kunminx.architecture.ui.page.DataBindingActivity;
import com.was.core.domain.NetworkStateManager;


/**
 * Create by KunMinX at 19/8/1
 */
public abstract class BaseActivity extends DataBindingActivity {

    public final String TAG = "tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

//        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
//        BarUtils.setStatusBarLightMode(this, true);

        super.onCreate(savedInstanceState);

        // 监听生命activity的生命周期
        getLifecycle().addObserver(NetworkStateManager.getInstance());
    }

    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        return super.getActivityViewModel(modelClass);
    }

    protected ViewModelProvider getAppViewModelProvider() {
        return super.getAppViewModelProvider();
    }

//    @Override
//    public Resources getResources() {
//        if (ScreenUtils.isPortrait()) {
//            return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
//        } else {
//            return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
//        }
//    }

    private ProgressDialog pd;

    public void showProgressDialog() {
        showProgressDialog(false);
    }

    public void showProgressDialog(boolean cancelable) {
        if (pd == null) {
            pd = new ProgressDialog(this);
            pd.setCancelable(cancelable);
            pd.setMessage("正在拼命加载中~");

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });
            }
        }

        try {
            if (!pd.isShowing()) {
                pd.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }


    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
