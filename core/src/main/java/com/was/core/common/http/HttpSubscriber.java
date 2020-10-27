package com.was.core.common.http;


import com.was.core.R;
import com.was.core.utils.AppUtils;
import com.was.core.utils.PrintUtils;
import com.was.core.utils.ToastUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import rx.Subscriber;


public abstract class HttpSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onNext(T t) {
        onSuccess(new NetState(t));
    }


    @Override
    public void onError(Throwable e) {
        onFail(e, caException(e));
    }


    public abstract void onSuccess(NetState<T> netState);

    /**
     * 页面处理异常
     *
     * @param e
     */
    public void onFail(Throwable e, NetState netState) {

    }

    /**
     * 捕捉异常
     */
    public NetState caException(Throwable e) {
        NetState state = null;
        if (e instanceof UnknownHostException || e instanceof ConnectException) {
            state = new NetState(NetState.state_no_network_link, "暂无网络连接,请连接网络后重试!");
        } else if (e instanceof SocketTimeoutException) {
            state = new NetState(NetState.state_timeout, "网络连接超时");
        } else if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            state = new NetState(apiException.getResultCode(), apiException.getMessage());
        } else {
            state = new NetState(NetState.state_unknown_exception, "未知异常!" + "\n" + e.getMessage());
        }
        PrintUtils.printNetRequestException(e);
        return state;
    }


    /**
     * 捕捉异常
     */
    public void catchException(Throwable e) {

        if (e instanceof UnknownHostException || e instanceof ConnectException) {
            ToastUtils.showShort(R.string.str_no_network_link);
        } else if (e instanceof SocketTimeoutException) {
            ToastUtils.showShort((R.string.str_network_link_timeout));
        } else if (e instanceof ApiException) {
            ToastUtils.showShort((e.getMessage()));
        } else {
            ToastUtils.showShort((R.string.str_unknown_exception + "\n" + e.getMessage()));
        }
        PrintUtils.printNetRequestException(e);
    }
}
