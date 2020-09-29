package com.was.minejava.dapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kunminx.binding_recyclerview.adapter.SimpleDataBindingAdapter;
import com.was.core.utils.ToastUtils;
import com.was.minejava.R;
import com.was.minejava.bean.ProvinceBean;
import com.was.minejava.databinding.ItemListBinding;

public class ListActivityAdapter extends SimpleDataBindingAdapter<ProvinceBean, ItemListBinding> {

    public ListActivityAdapter(Context context) {

        super(context, R.layout.item_list, new DiffUtil.ItemCallback<ProvinceBean>() {
            @Override
            public boolean areItemsTheSame(@NonNull ProvinceBean oldItem, @NonNull ProvinceBean newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull ProvinceBean oldItem, @NonNull ProvinceBean newItem) {
                return oldItem.getCode().equals(newItem.getCode());
            }
        });
        setOnItemClickListener(((item, position) -> {
            ToastUtils.showShort("item  点击 ------> " + item.getName());
        }));
    }

    @Override
    protected void onBindItem(ItemListBinding binding, ProvinceBean item, RecyclerView.ViewHolder holder) {
        binding.setData(item);

    }
}
