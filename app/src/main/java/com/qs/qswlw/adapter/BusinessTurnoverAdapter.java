package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.BusinessTurnoverBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class BusinessTurnoverAdapter extends BaseListAdapter<BusinessTurnoverBean.ListBean> {

    public BusinessTurnoverAdapter(Context context, List<BusinessTurnoverBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final BusinessTurnoverBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_merchantsudit, null);
            holder.tv_item_merchantaudit_time = (TextView) view.findViewById(R.id.tv_item_merchantaudit_time);
            holder.tv_item_merchantaudit_uid = (TextView) view.findViewById(R.id.tv_item_merchantaudit_uid);
            holder.tv_item_merchantaudit_money = (TextView) view.findViewById(R.id.tv_item_merchantaudit_money);
            holder.tv_item_merchantaudit_none = (TextView) view.findViewById(R.id.tv_item_merchantaudit_none);
            holder.tv_item_merchantaudit_is_ok = (TextView) view.findViewById(R.id.tv_item_merchantaudit_is_ok);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_merchantaudit_time.setText(listBean.getAdd_time());
        holder.tv_item_merchantaudit_uid.setText(listBean.getUser_id());
        holder.tv_item_merchantaudit_none.setText(listBean.getUser_name().getNickname());
        holder.tv_item_merchantaudit_money.setText(listBean.getMoney());
        holder.tv_item_merchantaudit_is_ok.setText(listBean.getNone());

        return view;
    }

    class ViewHolder {
        TextView tv_item_merchantaudit_time;
        TextView tv_item_merchantaudit_uid;
        TextView tv_item_merchantaudit_money;
        TextView tv_item_merchantaudit_none;
        TextView tv_item_merchantaudit_is_ok;

    }
}
