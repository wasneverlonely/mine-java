package com.was.minejava.request;

import com.was.core.common.http.ApiException;
import com.was.core.common.http.ProgressSubscriber;
import com.was.core.utils.ToastUtils;
import com.was.minejava.App;
import com.was.minejava.bean.HttpResult;
import com.was.minejava.bean.UserBean;
import com.was.minejava.common.HttpUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.was.minejava.common.HttpUtils.isRequestSuccess;

public class LoginRequest {

    public void login(String userName, String password) {

        Observable<HttpResult<UserBean>> observable = HttpUtils.getApi().login(userName, password);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(new HttpResultFunc<>()).subscribe(new Subscriber<UserBean>() {
            @Override
            public void onCompleted() {
                ToastUtils.showShort("加载完成");
            }

            @Override
            public void onError(Throwable e) {
                ToastUtils.showShort("链接失败" + e.toString());
            }

            @Override
            public void onNext(UserBean data) {
                ToastUtils.showShort(data.getId() + "");
            }
        });

    }

    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            // 如果返回code不是1  请求不成功  报ApiException
            if (!isRequestSuccess(httpResult))
                throw new ApiException(httpResult.getCode(), httpResult.getMsg());
            return httpResult.getData();
        }
    }
}
