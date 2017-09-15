package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.MyProfitBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitAdapter extends BaseListAdapter<MyProfitBean.ListBean> {


    public MyProfitAdapter(Context context, List<MyProfitBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_myprofit,null);
            holder.tv_item_myprofit_uid = (TextView) view.findViewById(R.id.tv_item_myprofit_uid);
            holder.tv_item_myprofit_nickname = (TextView) view.findViewById(R.id.tv_item_myprofit_nickname);
            holder.tv_item_myprofit_model = (TextView) view.findViewById(R.id.tv_item_myprofit_model);
            holder.tv_item_myprofit_time = (TextView) view.findViewById(R.id.tv_item_myprofit_time);
            holder.tv_item_myprofit_money = (TextView) view.findViewById(R.id.tv_item_myprofit_money);
            holder.tv_item_myprofit_none = (TextView) view.findViewById(R.id.tv_item_myprofit_none);
            holder.tv_item_myprofit_isnone = (TextView) view.findViewById(R.id.tv_item_myprofit_isnone);
            holder.tv_item_myprofit_isgo = (TextView) view.findViewById(R.id.tv_item_myprofit_isgo);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }
    class ViewHolder{
        TextView tv_item_myprofit_uid;
        TextView tv_item_myprofit_nickname;
        TextView tv_item_myprofit_model;
        TextView tv_item_myprofit_time;
        TextView tv_item_myprofit_money;
        TextView tv_item_myprofit_none;
        TextView tv_item_myprofit_isnone;
        TextView tv_item_myprofit_isgo;
    }
}
