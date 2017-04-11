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
    public EntepAdapter(Context context, List<String> data) {
        super(context, data);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_globalentrepreneurshipvalue, null);
        TextView tv_twentypercent_congtv = (TextView) view.findViewById(R.id.tv_twentypercent_congtv);
        TextView tv_twentypercent_busgtv = (TextView) view.findViewById(R.id.tv_twentypercent_busgtv);
        TextView tv_yesterdayConsumption_gtv = (TextView) view.findViewById(R.id.tv_yesterdayConsumption_gtv);
        TextView tv_totalEntrepreneurship_gtv = (TextView) view.findViewById(R.id.tv_totalEntrepreneurship_gtv);
        TextView tv_totalnumber_gtv = (TextView) view.findViewById(R.id.tv_totalnumber_gtv);
        TextView tv_llianceMerchant_gtv = (TextView) view.findViewById(R.id.tv_llianceMerchant_gtv);
        tv_twentypercent_congtv.setText(data.get(i));
        tv_twentypercent_busgtv.setText(data.get(i));
        tv_yesterdayConsumption_gtv.setText(data.get(i));
        tv_totalEntrepreneurship_gtv.setText(data.get(i));
        tv_totalnumber_gtv.setText(data.get(i));
        tv_llianceMerchant_gtv.setText(data.get(i));
        return view;
    }
//    String[] keys = {"消费天使20%", "商家傻逼20%", "全所发生的", "全联盟创业总额", "fff", "fsdfsd", "fsaf"};
//
//    public EntepAdapter(Context context, List<String> data) {
//        super(context, data);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = View.inflate(context, R.layout.item_home_content, null);
//        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
//        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
//        key.setText(keys[position]);
//        value.setText(data.get(position));
//        return convertView;
//
//
//    }
}
