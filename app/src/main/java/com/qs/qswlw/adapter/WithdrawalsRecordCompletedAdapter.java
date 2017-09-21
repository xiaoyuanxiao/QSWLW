package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.utils.DateUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordCompletedAdapter extends BaseListAdapter<WithDrawalsRecordBean.ListBean> {

    public WithdrawalsRecordCompletedAdapter(Context context, List<WithDrawalsRecordBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        WithDrawalsRecordBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_withdrawalsrecord,null);
            holder.tv_item_withdrawalsrecord_money = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_money);
            holder.tv_item_withdrawalsrecord_time = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_time);
            holder.tv_item_withdrawalsrecord_recall = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_recall);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_withdrawalsrecord_money.setText(listBean.getMoney());
        String create_time = listBean.getCreate_time();
        holder.tv_item_withdrawalsrecord_recall.setText(DateUtils.date2date(Long.parseLong(create_time)*1000L));
        holder.tv_item_withdrawalsrecord_time.setVisibility(View.GONE);
        return view;
    }
    class ViewHolder{
        TextView tv_item_withdrawalsrecord_money;
        TextView tv_item_withdrawalsrecord_time;
        TextView tv_item_withdrawalsrecord_recall;
    }
}
