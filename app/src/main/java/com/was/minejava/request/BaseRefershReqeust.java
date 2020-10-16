package com.was.minejava.request;

import androidx.lifecycle.MutableLiveData;

import com.was.core.common.http.NetState;

import java.util.List;

//<T>
public abstract class BaseRefershReqeust {

    private int pageSize = 5;// 每页加载的条数
    private int pageIndex = 1;// 加载下标


    //得到每页条数
    public int getPageIndex(boolean isRefresh) {
        return isRefresh ? pageIndex = 1 : ++pageIndex;
    }

    //一页的个数
    public int getPageSize() {
        return pageSize;
    }


    abstract void requestData(boolean isRefresh); //请求数据

    public void start() {
        requestData(true);
    }

}
