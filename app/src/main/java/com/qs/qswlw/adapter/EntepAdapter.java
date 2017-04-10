package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class EntepAdapter extends BaseListAdapter<String> {
    String[] keys = {"消费天使20%", "商家傻逼20%", "全所发生的", "全联盟创业总额", "fff", "fsdfsd", "fsaf"};

    public EntepAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_home_content, null);
        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
        key.setText(keys[position]);
        value.setText(data.get(position));
        return convertView;


    }
}
