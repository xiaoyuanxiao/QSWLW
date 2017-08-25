package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.mynet.ReHttpUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class RankingAdapter extends BaseListAdapter<RankingBean.SingleLogBean> {


    public RankingAdapter(Context context, List<RankingBean.SingleLogBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RankingBean.SingleLogBean singleLogBean = data.get(i);
        ViewHolder holder;
        if (view == null) {//咦
            holder = new RankingAdapter.ViewHolder();
            view = View.inflate(context, R.layout.item_ranking, null);
            holder.iv_union_ranking = (ImageView) view.findViewById(R.id.iv_union_ranking);
            holder.union_ranking_name = (TextView) view.findViewById(R.id.union_ranking_name);
            holder.union_ranking_id = (TextView) view.findViewById(R.id.union_ranking_id);
            holder.union_ranking = (TextView) view.findViewById(R.id.union_ranking);
            holder.union_ranking_volume = (TextView) view.findViewById(R.id.union_ranking_volume);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(ReHttpUtils.getBaseUrl() + singleLogBean.getPhoto()).into(holder.iv_union_ranking);
        holder.union_ranking_name.setText(singleLogBean.getStore_name());
        holder.union_ranking_id.setText(singleLogBean.getUser_id());
        //    holder.union_ranking.setText(singleLogBean.get());
        holder.union_ranking_volume.setText(singleLogBean.getSum_money());

        return view;
    }

    class ViewHolder {
        ImageView iv_union_ranking;
        TextView union_ranking_name;
        TextView union_ranking_id;
        TextView union_ranking;
        TextView union_ranking_volume;

    }
}
