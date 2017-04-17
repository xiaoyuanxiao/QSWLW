package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class MallOrdersAdapter extends BaseAdapter {
    private String[] a = {"121","3232","3241","4334"};
    private Context context;

    public MallOrdersAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public Object getItem(int i) {
        return a[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =   View.inflate(context, R.layout.item_mallorders,null);
        return view;
    }
}
