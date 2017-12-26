package com.qs.qswlw.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qs.qswlw.R;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/26.
 */

public class ItemMyGoldAdapter extends BaseRecyleAdapter {

    public ItemMyGoldAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        ViewDataBinding inflate = DataBindingUtil.inflate(from, R.layout.item_mygolden, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

    }
}
