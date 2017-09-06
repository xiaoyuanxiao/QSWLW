package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class InnovationAdapter extends BaseListAdapter<EntrepreneurialIncentiveBean.ListModel2Bean> {

    public InnovationAdapter(Context context, List<EntrepreneurialIncentiveBean.ListModel2Bean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        EntrepreneurialIncentiveBean.ListModel2Bean listMode21Bean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_entrepreneurialseed, null);
            holder.tv_ConsumptionDate = (TextView) view.findViewById(R.id.tv_ConsumptionDate);
            holder.tv_ConfirmationDate = (TextView) view.findViewById(R.id.tv_ConfirmationDate);
            holder.tv_ConsumerSilverBean = (TextView) view.findViewById(R.id.tv_ConsumerSilverBean);
            holder.tv_BusinessTurnover = (TextView) view.findViewById(R.id.tv_BusinessTurnover);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String add_time = listMode21Bean.getAdd_time();
        String c_time = listMode21Bean.getCtime();
        String silver = listMode21Bean.getSilver();
        String total = listMode21Bean.getTotal();

        if(add_time!=null){
            holder.tv_ConsumptionDate.setText("消费日期："+add_time);
        }
        if(c_time!=null){
            holder.tv_ConfirmationDate.setText("确认日期："+c_time);
        }
        if(silver!=null){
            holder.tv_ConsumerSilverBean.setText(silver);
        }
        if(total!=null){
            holder.tv_BusinessTurnover.setText(total);
        }

        return view;
    }

    class ViewHolder {
        TextView tv_ConsumptionDate;
        TextView tv_ConfirmationDate;
        TextView tv_ConsumerSilverBean;
        TextView tv_BusinessTurnover;

    }
}