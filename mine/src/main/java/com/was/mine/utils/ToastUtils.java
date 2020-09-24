/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.was.mine.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast 工具类
 */
public class ToastUtils {

    public static Context sContext;


    private ToastUtils() {
    }

    // 注册toast
    public static void register(Context context) {
        sContext = context.getApplicationContext();
    }

    // 是否注册
    private static void check() {

        if (sContext == null) {
            throw new NullPointerException(
                    "Must initial call ToastUtils.register(Context context) in your " +
                            "<? " + "extends Application class>");
        }
    }

    public static void showShort(int resId) {
        check();
        Toast.makeText(sContext, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(CharSequence msg) {
        check();
        Toast.makeText(sContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        check();
        Toast.makeText(sContext, msg, Toast.LENGTH_LONG).show();
    }

    public static void showLong(int resId) {
        check();
        Toast.makeText(sContext, resId, Toast.LENGTH_LONG).show();
    }


    public static void showLongX2(String message) {
        showLong(message);
        showLong(message);
    }


    public static void showLongX2(int resId) {
        showLong(resId);
        showLong(resId);
    }

}