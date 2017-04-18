package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class ConsumerEntrepreneurialSeedAdapter extends BaseAdapter {
    private Context context;

    public ConsumerEntrepreneurialSeedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =  View.inflate(context, R.layout.item_consumerentrepreneurialseed,null);
        return view;
    }
}
