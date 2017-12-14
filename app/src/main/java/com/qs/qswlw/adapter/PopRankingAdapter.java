package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.PopRankingBean;
import com.qs.qswlw.mynet.ReHttpUtils;

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
        PopRankingBean.ListBean popRankingBean = data.get(i);
        ViewHolder holder;
        if (view == null) {//咦
            holder = new PopRankingAdapter.ViewHolder();
            view = View.inflate(context, R.layout.item_popranking, null);
            holder.iv_popranking = (ImageView) view.findViewById(R.id.iv_popranking);
            holder.popranking_name = (TextView) view.findViewById(R.id.popranking_name);
            holder.popranking_id = (TextView) view.findViewById(R.id.popranking_id);
            holder.popranking_city = (TextView) view.findViewById(R.id.popranking_city);
            holder.popranking = (TextView) view.findViewById(R.id.popranking);
            holder.popranking_volume = (TextView) view.findViewById(R.id.popranking_volume);
            holder.tv_ranking_bottom = (TextView) view.findViewById(R.id.tv_ranking_bottom);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_ranking_bottom.setText("业绩:");
        Glide.with(context).load(ReHttpUtils.getBaseUrl() + popRankingBean.getHead_pic()).into(holder.iv_popranking);
        holder.popranking_name.setText("昵称:"+popRankingBean.getNickname());
        holder.popranking_id.setText("ID:"+ popRankingBean.getUser_id());
            holder.popranking_city.setText("代理点:"+popRankingBean.getSheng_name());
            holder.popranking.setText(i+1+"");
        holder.popranking_volume.setText(popRankingBean.getTotal());

        return view;
    }

    class ViewHolder {
        ImageView iv_popranking;
        TextView popranking_name;
        TextView popranking_id;
        TextView popranking_city;
        TextView popranking;
        TextView popranking_volume;
        TextView tv_ranking_bottom;

    }
}
