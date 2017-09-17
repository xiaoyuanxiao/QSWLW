package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.MerchantAuditBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditAdapter extends BaseListAdapter<MerchantAuditBean.ListBean> {
    public MerchantAuditAdapter(Context context, List<MerchantAuditBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MerchantAuditBean.ListBean listBean = data.get(i);
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
        String is_go = listBean.getIs_ok();
        if ("0".equals(is_go)) {
            holder.tv_item_merchantaudit_is_ok.setText("审核");
        } else if ("1".equals(is_go)) {
            holder.tv_item_merchantaudit_is_ok.setText("");
        }
        holder.tv_item_merchantaudit_uid.setText(listBean.getUser_id());
        //    holder.union_ranking.setText(singleLogBean.get());
        holder.tv_item_merchantaudit_time.setText(listBean.getAdd_time());
        holder.tv_item_merchantaudit_none.setText(listBean.getNone());
        holder.tv_item_merchantaudit_money.setText(listBean.getMoney());
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
