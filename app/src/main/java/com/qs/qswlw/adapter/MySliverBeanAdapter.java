package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.mynet.ReHttpUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySliverBeanAdapter extends BaseListAdapter<MySliverBean.SingleLogBean> {

    public MySliverBeanAdapter(Context context, List<MySliverBean.SingleLogBean> data) {
        super(context, data);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MySliverBean.SingleLogBean singleLogBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_mysliverbean, null);
            holder.iv_item_mysliverbean = (ImageView) view.findViewById(R.id.iv_item_mysliverbean);
            holder.tv_item_mysliverbean_sliver = (TextView) view.findViewById(R.id.tv_item_mysliverbean_sliver);
            holder.tv_item_mysliverbean_total = (TextView) view.findViewById(R.id.tv_item_mysliverbean_total);
            holder.tv_item_mysliverbean_spname = (TextView) view.findViewById(R.id.tv_item_mysliverbean_spname);
            holder.tv_item_mysliverbean_addtime = (TextView) view.findViewById(R.id.tv_item_mysliverbean_addtime);
            holder.tv_item_mysliverbean_paytime = (TextView) view.findViewById(R.id.tv_item_mysliverbean_paytime);
            holder.tv_item_mysliverbean_singleid = (TextView) view.findViewById(R.id.tv_item_mysliverbean_singleid);
            holder.tv_item_mysliverbean_type = (TextView) view.findViewById(R.id.tv_item_mysliverbean_type);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
      //  if (i <= 50)
            Glide.with(context).load(ReHttpUtils.getBaseUrl() + singleLogBean.getGoods_img()).into(holder.iv_item_mysliverbean);
        if (singleLogBean.getSilver() != null) {
            holder.tv_item_mysliverbean_sliver.setText("获得银豆: ¥ " + singleLogBean.getSilver());
        }
        if (singleLogBean.getTotal() != null) {
            holder.tv_item_mysliverbean_total.setText("消费总额:  " + singleLogBean.getTotal());
        }
        if (singleLogBean.getSp_name() != null) {
            holder.tv_item_mysliverbean_spname.setText("联盟商家： " + singleLogBean.getSp_name());
        }
        if (singleLogBean.getAdd_time() != null) {
            holder.tv_item_mysliverbean_addtime.setText("下单时间： " + singleLogBean.getAdd_time());
        }
        if (singleLogBean.getCtime() != null) {
            holder.tv_item_mysliverbean_paytime.setText("付款时间： " + singleLogBean.getCtime());
        }
        if (singleLogBean.getSingleid() != null) {
            holder.tv_item_mysliverbean_singleid.setText("订单编号： " + singleLogBean.getSingleid());
        }

        String give_id = singleLogBean.getGive_id();
        if (give_id == null) {
            holder.tv_item_mysliverbean_type.setText("订单类型： ");
        } else {
            if (Integer.parseInt(give_id) > 0) {
                holder.tv_item_mysliverbean_type.setText("订单类型： " + "赠送");
            } else {
                holder.tv_item_mysliverbean_type.setText("订单类型： " + "消费让利");
            }
        }

        return view;
    }

    class ViewHolder {
        TextView tv_item_mysliverbean_sliver;
        TextView tv_item_mysliverbean_total;
        TextView tv_item_mysliverbean_spname;
        TextView tv_item_mysliverbean_addtime;
        TextView tv_item_mysliverbean_paytime;
        TextView tv_item_mysliverbean_singleid;
        TextView tv_item_mysliverbean_type;
        ImageView iv_item_mysliverbean;
    }
}
