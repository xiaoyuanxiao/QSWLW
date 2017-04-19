package com.qs.qswlw.Mode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.qs.qswlw.R;

/**
 * Created by 小猴子 on 2017/4/19.
 */

public class BaseMainViewMoudle implements BaseMainInterface {
    @Override
    public void addFootView(View view) {
        listView.addFooterView(view);
    }

    @Override
    public void addHeardView(View view) {
        listView.addHeaderView(view);
    }

    public LinearLayout view;
    ListView listView;

    @Override
    public void setBackgroundColor(int color) {
        view.setBackgroundColor(color);
    }

    BaseAdapter adapter;

    public BaseMainViewMoudle(Context context, BaseAdapter adapter) {
        view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.layout, null);
        listView = (ListView) view.findViewById(R.id.list_test);
        this.adapter = adapter;
        listView.setAdapter(this.adapter);

    }

    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }
}
