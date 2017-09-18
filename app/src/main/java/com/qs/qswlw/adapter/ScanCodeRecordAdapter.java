package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.ScanCodeRecordBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class ScanCodeRecordAdapter extends BaseListAdapter<ScanCodeRecordBean.ListBean> {
    public ScanCodeRecordAdapter(Context context, List<ScanCodeRecordBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ScanCodeRecordBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if (view == null) {//咦
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

        holder.tv_item_merchantaudit_is_ok.setVisibility(View.GONE);
        holder.tv_item_merchantaudit_time.setText(listBean.getAdd_time());
        holder.tv_item_merchantaudit_uid.setText(listBean.getMoney());
        holder.tv_item_merchantaudit_money.setText(listBean.getNone());
        holder.tv_item_merchantaudit_none.setText(listBean.getNone());
        final String id = listBean.getId();//订单id

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
