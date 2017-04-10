package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class ChinaAdapter extends BaseListAdapter<ChinaBean> {

    public ChinaAdapter(Context context, List<ChinaBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_home_content, null);
        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
        ChinaBean chinaBean = data.get(position);
        key.setText(chinaBean.getGoods_name());
        value.setText(chinaBean.getNumber());
        return convertView;


    }
}
