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

package com.was.minejava.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;

import com.was.core.domain.NetworkStateManager;
import com.was.core.ui.BaseToolActivity;
import com.was.minejava.R;


/**
 * Create by KunMinX at 19/8/1
 */
public abstract class BaseActivity extends BaseToolActivity {

    public final String TAG = "tag";

    /**
     * 返回
     */
    protected void setBack() {
        this.setBack((v) -> {
            onBackPressed();
        });
    }

    /**
     * 设置返回
     *
     * @param click
     */
    protected void setBack(View.OnClickListener click) {
        super.setBack(R.id.iv_common_back, click);
    }

    /**
     * 设置标题
     *
     * @param textRcesID
     */
    protected void setTitleText(int textRcesID) {
        String title = getResources().getString(textRcesID);
        this.setTitleText(title);
    }

    /**
     * 设置中间字体
     *
     * @param title
     */
    protected void setTitleText(CharSequence title) {
        super.setTitleText(R.id.tv_common_title, title);
    }

    /**
     * 设置右边的字体
     *
     * @param rightText
     * @param click
     */
    protected void setTitleRightText(String rightText, View.OnClickListener click) {
        super.setTitleRightText(R.id.tv_common_right, rightText, click);
    }

    /**
     * 设置右边图片
     *
     * @param iconResID
     * @param click
     */
    protected void setTitleRightIcon(int iconResID, View.OnClickListener click) {
        super.setTitleRightIcon(R.id.iv_common_right, iconResID, click);
    }

    /**
     * 设置次级右边图片
     *
     * @param iconResID
     * @param click
     */
    protected void setTitleSecondRightIcon(int iconResID, View.OnClickListener click) {
        super.setTitleSecondRightIcon(R.id.iv_common_second_right, iconResID, click);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

//        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
//        BarUtils.setStatusBarLightMode(this, true);

        super.onCreate(savedInstanceState);

        // 监听生命activity的生命周期
        getLifecycle().addObserver(NetworkStateManager.getInstance());
    }


//    @Override
//    public Resources getResources() {
//        if (ScreenUtils.isPortrait()) {
//            return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
//        } else {
//            return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
//        }
//    }

    protected void toggleSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
