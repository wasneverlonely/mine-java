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

package com.was.core.common.http;

/**
 * Create by KunMinX at 19/10/11
 */
public class NetState<T> {

    public static final int state_normal = 0x001; //正常

    public static final int state_no_network_link = 0x002; //没有网络连接
    public static final int state_timeout = 0x003; //连接超时
    public static final int state_api_exception = 0x004; //连接异常
    public static final int state_unknown_exception = 0x005; //未知异常

    private boolean success = true;
    private int state = state_normal;
    private String responseCode = "0";
    private String message = "";
    private T data;

    private boolean isRefresh;

    public NetState(T t) {
        state = state_normal;
        success = true;
        data = t;
    }

    //请求成功
    public NetState(int state, String message) {
        this.state = state;
        this.message = message;
        this.success = false;
    }

    public NetState(String code, String message) {
        this(state_api_exception, message);
        this.responseCode = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
}
