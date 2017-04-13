package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class RankingAdapter extends BaseAdapter {
    private Context context;

    public RankingAdapter(Context context) {
        this.context = context;
    }

    private int[]  a = {1,2,3,4,5,6,7,8,9,10};



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
        view =  View.inflate(context, R.layout.item_ranking,null);
        TextView tv_test = (TextView) view.findViewById(R.id.tv_test);
        tv_test.setText(a[i]+"");
        return view;
    }
}
