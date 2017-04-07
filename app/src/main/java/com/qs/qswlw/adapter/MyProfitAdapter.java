package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitAdapter extends BaseAdapter {
    private Context context;
    public String[] time1 = {"2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26",};

    public MyProfitAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return time1.length;
    }

    @Override
    public Object getItem(int i) {
        return time1[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_myprofit,null);
        return view;
    }
}
