package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;

import java.util.List;

import static com.qs.qswlw.R.id.tv_item_home_content_left;
import static com.qs.qswlw.R.id.tv_item_home_content_value;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class ChinaAdapter extends BaseListAdapter<ChinaBean> {

    public ChinaAdapter(Context context, List<ChinaBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_home_chinacontent, null);
        TextView key = (TextView) convertView.findViewById(tv_item_home_content_left);
        TextView value = (TextView) convertView.findViewById(tv_item_home_content_value);
        ChinaBean chinaBean = data.get(position);
        key.setTextColor(context.getResources().getColor(R.color.text_red));
        value.setTextColor(context.getResources().getColor(R.color.text_red));
        key.setText(chinaBean.getGoods_name());
        value.setText("出售" + chinaBean.getNumber() + "件");
        return convertView;


    }
}
