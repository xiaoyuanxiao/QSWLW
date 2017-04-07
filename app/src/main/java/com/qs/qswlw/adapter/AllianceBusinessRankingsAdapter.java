package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.AllianceBusinessRankingsContentBean;

import java.util.List;

import static com.qs.qswlw.R.id.tv_item_home_content_left;
import static com.qs.qswlw.R.id.tv_item_home_content_value;

/**
 * Created by xiaoyu on 2017/4/7.
 */

public class AllianceBusinessRankingsAdapter extends BaseListAdapter<AllianceBusinessRankingsContentBean> {


    public AllianceBusinessRankingsAdapter(Context context, List<AllianceBusinessRankingsContentBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AllianceBusinessRankingsContentBean forestItemDataEntity = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_home_content, null);
            holder.tv_item_home_content_left = (TextView) view.findViewById(tv_item_home_content_left);
            holder.tv_item_home_content_value = (TextView) view.findViewById(tv_item_home_content_value);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_home_content_left.setText(data.get(i).store_name);
        holder.tv_item_home_content_value.setText(data.get(i).sum_money);
        return view;
    }

    class ViewHolder {
        public TextView tv_item_home_content_left, tv_item_home_content_value;

    }
}
