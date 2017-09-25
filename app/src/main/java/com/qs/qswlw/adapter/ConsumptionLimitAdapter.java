package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionLimitBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitAdapter extends BaseListAdapter<ConsumptionLimitBean.ListBean> {

    public ConsumptionLimitAdapter(Context context, List<ConsumptionLimitBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ConsumptionLimitBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_consumptionlimit, null);
            holder.tv_item_consumptionlimit_one = (TextView) view.findViewById(R.id.tv_item_consumptionlimit_one);
            holder.tv_item_consumptionlimit_two = (TextView) view.findViewById(R.id.tv_item_consumptionlimit_two);
            holder.tv_item_consumptionlimit_three = (TextView) view.findViewById(R.id.tv_item_consumptionlimit_three);
            holder.tv_item_consumptionlimit_four = (TextView) view.findViewById(R.id.tv_item_consumptionlimit_four);
            holder.tv_item_consumptionlimit_five = (TextView) view.findViewById(R.id.tv_item_consumptionlimit_five);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_consumptionlimit_one.setText(listBean.getAdd_time());
        String none = listBean.getNone();
        if(none==null){
            holder.tv_item_consumptionlimit_two.setText(none);
        }

        holder.tv_item_consumptionlimit_three.setText("0");
        holder.tv_item_consumptionlimit_four.setText(listBean.getMoney());
        holder.tv_item_consumptionlimit_five.setText(listBean.getOld_money_count());

        return view;
    }

    class ViewHolder {
        TextView tv_item_consumptionlimit_one;
        TextView tv_item_consumptionlimit_two;
        TextView tv_item_consumptionlimit_three;
        TextView tv_item_consumptionlimit_four;
        TextView tv_item_consumptionlimit_five;

    }
}