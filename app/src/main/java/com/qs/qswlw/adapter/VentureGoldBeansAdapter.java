package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.fragment.MyGoldBeanFragment;

import java.util.List;

import static com.qs.qswlw.R.id.tv_item_mygoldenbean_four;
import static com.qs.qswlw.R.id.tv_item_mygoldenbean_one;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class VentureGoldBeansAdapter extends BaseListAdapter<VenturegoldBean.ListBean> {

    public VentureGoldBeansAdapter(Context context, List<VenturegoldBean.ListBean> data) {
        super(context, data);
    }

    String type = "";

    public VentureGoldBeansAdapter(Context context, List<VenturegoldBean.ListBean> data, String type) {
        super(context, data);
        this.type = type;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VenturegoldBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            if (type.equals("")) {
                view = View.inflate(context, R.layout.item_mygoldenbean, null);
                holder.tv_item_mygoldenbean_one = (TextView) view.findViewById(tv_item_mygoldenbean_one);
                holder.tv_item_mygoldenbean_two = (TextView) view.findViewById(R.id.tv_item_mygoldenbean_two);
                holder.tv_item_mygoldenbean_three = (TextView) view.findViewById(R.id.tv_item_mygoldenbean_three);
                holder.tv_item_mygoldenbean_four = (TextView) view.findViewById(tv_item_mygoldenbean_four);
            } else if (type.equals(MyGoldBeanFragment.TJJD)||type.equals(MyGoldBeanFragment.GIVE)) {
                view = View.inflate(context, R.layout.item_giveslivenbean, null);
                holder.tv_item_gilversliverbean_one = (TextView) view.findViewById(R.id.tv_item_gilversliverbean_one);
                holder.tv_item_gilversliverbean_two = (TextView) view.findViewById(R.id.tv_item_gilversliverbean_two);
                holder.tv_item_gilversliverbean_three = (TextView) view.findViewById(R.id.tv_item_gilversliverbean_three);
            }
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if(type.equals("")){
            holder.tv_item_mygoldenbean_one.setText(listBean.getAdd_time());
            holder.tv_item_mygoldenbean_two.setText(listBean.getDellove());
            holder.tv_item_mygoldenbean_three.setText("+"+listBean.getTemp2());
            holder.tv_item_mygoldenbean_four.setText("+"+listBean.getTemp1());
        } else if (type.equals(MyGoldBeanFragment.TJJD)||type.equals(MyGoldBeanFragment.GIVE)) {
            holder.tv_item_gilversliverbean_one.setText(listBean.getAdd_time());
            holder.tv_item_gilversliverbean_two.setText("+"+listBean.getDellove());
            holder.tv_item_gilversliverbean_three.setText("+"+listBean.getTemp2());
        }
        return view;
    }

    class ViewHolder{
       TextView tv_item_mygoldenbean_one;
       TextView tv_item_mygoldenbean_two;
       TextView tv_item_mygoldenbean_three;
       TextView tv_item_mygoldenbean_four;
       TextView tv_item_gilversliverbean_one;
       TextView tv_item_gilversliverbean_two;
       TextView tv_item_gilversliverbean_three;
    }
}
