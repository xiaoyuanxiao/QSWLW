package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.PopRankingBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class PopRankingAdapter extends BaseListAdapter<PopRankingBean.ListBean> {


    public PopRankingAdapter(Context context, List<PopRankingBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PopRankingBean.ListBean salemanBean = data.get(i);
        ViewHolder holder;
        if (view == null) {//咦
            holder = new PopRankingAdapter.ViewHolder();
            view = View.inflate(context, R.layout.item_ranking, null);
            holder.iv_union_ranking = (ImageView) view.findViewById(R.id.iv_union_ranking);
            holder.union_ranking_name = (TextView) view.findViewById(R.id.union_ranking_name);
            holder.union_ranking_id = (TextView) view.findViewById(R.id.union_ranking_id);
            holder.union_ranking = (TextView) view.findViewById(R.id.union_ranking);
            holder.union_ranking_volume = (TextView) view.findViewById(R.id.union_ranking_volume);
            holder.tv_ranking_bottom = (TextView) view.findViewById(R.id.tv_ranking_bottom);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_ranking_bottom.setText("业绩:");
     //   Glide.with(context).load(ReHttpUtils.getBaseUrl() + salemanBean.getHead_pic()).into(holder.iv_union_ranking);
        holder.union_ranking_name.setText(salemanBean.getNickname());
        holder.union_ranking_id.setText("ID:"+ salemanBean.getUser_id());
        //    holder.union_ranking.setText(singleLogBean.get());
        holder.union_ranking_volume.setText(salemanBean.getTotal());
        holder.union_ranking.setText((i+1)+"");

        return view;
    }

    class ViewHolder {
        ImageView iv_union_ranking;
        TextView union_ranking_name;
        TextView union_ranking_id;
        TextView union_ranking;
        TextView union_ranking_volume;
        TextView tv_ranking_bottom;

    }
}
