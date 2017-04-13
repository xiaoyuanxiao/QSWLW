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

public class InteractionAdapter extends BaseAdapter {
    private Context context;

    public InteractionAdapter(Context context) {
        this.context = context;
    }

    private String[] a = {"admin","wjoda","heie","ejij","wuoiq","eoop"};
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
        view = View.inflate(context, R.layout.item_interaction,null);
        TextView username_item_interaction = (TextView) view.findViewById(R.id.username_item_interaction);
        username_item_interaction.setText(a[i]);
        return view;
    }
}
