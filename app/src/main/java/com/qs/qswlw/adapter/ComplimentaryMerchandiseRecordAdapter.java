package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.utils.DateUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class ComplimentaryMerchandiseRecordAdapter extends BaseListAdapter<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> {

    public ComplimentaryMerchandiseRecordAdapter(Context context, List<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ComplimentaryMerchandiseRecordBean.GoodsInfoBean goodsInfoBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_complimentarymerchandiserecord, null);
            holder.tv_goodsname = (TextView) view.findViewById(R.id.tv_goodsname_item_complimentarymerchandise);
            holder.tv_money = (TextView) view.findViewById(R.id.tv_money_item_complimentarymerchandise);
            holder.tv_salessum = (TextView) view.findViewById(R.id.tv_salessum_item_complimentarymerchandise);
            holder.tv_time = (TextView) view.findViewById(R.id.tv_time_item_complimentarymerchandise);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_goodsname.setText(goodsInfoBean.getGoods_name());
        holder.tv_money.setText("没有写");
        holder.tv_salessum.setText("中奖次数"+goodsInfoBean.getSales_sum());
        holder.tv_time.setText("选送时间："+DateUtils.date2date(Long.parseLong(goodsInfoBean.getAdd_time())*1000L));
        return view;
    }

    class ViewHolder {
        TextView tv_goodsname;
        TextView tv_money;
        TextView tv_salessum;
        TextView tv_time;

    }
}
