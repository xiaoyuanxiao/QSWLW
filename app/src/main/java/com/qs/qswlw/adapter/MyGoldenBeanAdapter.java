package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyGoldenBeanAdapter extends BaseAdapter {
    private Context context;
    public String[] quality = {"变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00","变动数量：¥3168.00"};
    public String[] time = {"下单时间：2017-03-26", "下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26","下单时间：2017-03-26",};
    public String[] time1 = {"2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26","2017-03-26",};
    public String[] num = {"订单编号：28", "订单编号：28","订单编号：28","订单编号：28","订单编号：28","订单编号：28","订单编号：28",};
    private LinearLayout ll_outgoingSeed;
    public boolean isNeed;

    public MyGoldenBeanAdapter(Context context, boolean isNeed) {
        this.context = context;
        this.isNeed = isNeed;
    }

    @Override
    public int getCount() {
        return time1.length;
    }

    @Override
    public Object getItem(int i) {
        return time1[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_mygoldenbean,null);
        if(!isNeed){
            ll_outgoingSeed = (LinearLayout) view.findViewById(R.id.ll_OutgoingSeed);
            ll_outgoingSeed.setVisibility(View.GONE);
        }
        return view;
    }
}
