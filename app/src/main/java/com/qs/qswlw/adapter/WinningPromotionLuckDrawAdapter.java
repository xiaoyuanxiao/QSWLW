package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class WinningPromotionLuckDrawAdapter extends BaseAdapter {
    private Context context;
    private String[] time = {"2017-3-20 10:00","2017-3-20 10:00","2017-3-20 10:00","2017-3-20 10:00","2017-3-20 10:00","2017-3-20 10:00","2017-3-20 10:00"};

    public WinningPromotionLuckDrawAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return time.length;
    }

    @Override
    public Object getItem(int i) {
        return time[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =  View.inflate(context, R.layout.item_winning_promotionluckdraw,null);
        return view;
    }
}
