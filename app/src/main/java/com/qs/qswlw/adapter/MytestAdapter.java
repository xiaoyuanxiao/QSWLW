package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.ChinaBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MytestAdapter extends BaseListAdapter<ChinaBean> {
    public MytestAdapter(Context context, List<ChinaBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_home_content, null);
        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
        key.setText(data.get(position).getGoods_name());
        value.setText(data.get(position).getNumber());

        return convertView;


    }
}
