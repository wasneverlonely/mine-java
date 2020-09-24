package com.was.mine.widget.recycler;


import android.support.annotation.NonNull;

import com.was.mine.widget.recycler.quick.BaseQuickAdapter;
import com.was.mine.widget.recycler.quick.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 加载  adapter
 *
 * @param <T>
 * @param <K>
 */
public abstract class RefreshAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    private int mLoadCount = 10; //默认加载数量

    public void setLoadCount(int loadCount) {
        this.mLoadCount = loadCount;
    }

    public RefreshAdapter(int layoutResId, List<T> data) {
        super(layoutResId, data);
    }

    // 注意不用去判断 size = 0
    @Override
    public void addData(@NonNull Collection<? extends T> addData) {
        if (addData == null) {
            addData = new ArrayList<>();
        }
        super.addData(addData);
        loadMoreComplete();
        isLoadAll(addData);
    }

    /**
     * 重新  刷新
     *
     * @param data
     */
    @Override
    public void setNewData(List<T> data) {
        super.setNewData(data);
        setEnableLoadMore(true);//刷新的时候把下拉关闭  所以现在要打开
        isLoadAll(getData());// 直接把 adapter的数据去判断  不用去判断null了
    }

    /**
     * 是否加载全部
     *
     * @param data
     */
    public void isLoadAll(Collection<? extends T> data) {
        if (data.size() < mLoadCount) {
            loadMoreEnd(false);
        }
    }


}
