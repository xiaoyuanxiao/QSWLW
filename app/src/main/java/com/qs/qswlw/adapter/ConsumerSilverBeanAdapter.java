package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qs.qswlw.R;


/**
 * Created by xiaoyu on 2017/4/5.
 */

public class ConsumerSilverBeanAdapter extends BaseAdapter {
    private Context context;
    public String[] quality = {"变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00"};
    public String[] time = {"下单时间：2017-03-26", "下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26",};
    public String[] time1 = {"付款时间：2017-03-26", "付款时间：2017-03-26","付款时间：2017-03-26","付款时间：2017-03-26","付款时间：2017-03-26","付款时间：2017-03-26","付款时间：2017-03-26",};
    public String[] num = {"订单编号：28", "订单编号：28","订单编号：28","订单编号：28","订单编号：28","订单编号：28","订单编号：28",};
    public ConsumerSilverBeanAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return quality.length;
    }

    @Override
    public Object getItem(int i) {
        return quality[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_consumersilverbean,null);
        TextView tv_consumerSilverBean_variableQuantity = (TextView) view.findViewById(R.id.tv_consumerSilverBean_variableQuantity);
        TextView tv_consumerSilverBean_orderTime = (TextView) view.findViewById(R.id.tv_consumerSilverBean_orderTime);
        TextView tv_consumerSilverBean_paymentTime = (TextView) view.findViewById(R.id.tv_consumerSilverBean_paymentTime);
        TextView tv_consumerSilverBean_orderNumber = (TextView) view.findViewById(R.id.tv_consumerSilverBean_orderNumber);
        tv_consumerSilverBean_variableQuantity.setText(quality[i]);
        tv_consumerSilverBean_orderTime.setText(time[i]);
        tv_consumerSilverBean_paymentTime.setText(time1[i]);
        tv_consumerSilverBean_orderNumber.setText(num[i]);
        return view;
    }
}
