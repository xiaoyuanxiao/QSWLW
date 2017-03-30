package com.qs.qswlw.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author xiaoyu:
 * @version 创建时间：2016-12-14 下午2:38:10
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    List<T> data;
    Context context;

    public BaseListAdapter(Context context, List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}