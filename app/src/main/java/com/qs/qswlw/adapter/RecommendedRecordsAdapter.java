package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.DateUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class RecommendedRecordsAdapter extends BaseListAdapter<RecommendedRecordsBean> {
    public RecommendedRecordsAdapter(Context context, List<RecommendedRecordsBean> data) {
        super(context, data);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RecommendedRecordsBean recommendedRecordsBean=    data.get(i);
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view =  View.inflate(context, R.layout.item_recommendedrecords,null);
            holder.tv_recommendrecord_name = (TextView) view.findViewById(R.id.tv_recommendrecord_name);
            holder.tv_recommendrecord_role = (TextView) view.findViewById(R.id.tv_recommendrecord_role);
            holder.tv_recommendrecord_data = (TextView) view.findViewById(R.id.tv_recommendrecord_data);
            holder.iv_recommendrecord_avater = (ImageView) view.findViewById(R.id.iv_recommendrecord_avater);
            view.setTag(holder);

        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_recommendrecord_name.setText(recommendedRecordsBean.getNickname());
        String role = recommendedRecordsBean.getRole();
        if(role.equals("0")){
            holder.tv_recommendrecord_role.setText("（消费天使）");
        }else if(role.equals("10")){
            holder.tv_recommendrecord_role.setText("（商家）");
        }
        if(recommendedRecordsBean.getHead_pic()!=null){
            Glide.with(context).load(ReHttpUtils.getBaseUrl() + recommendedRecordsBean.getHead_pic()).into(holder.iv_recommendrecord_avater);
        }
        holder.tv_recommendrecord_data.setText(DateUtils.date2date(Long.parseLong(recommendedRecordsBean.getReg_time())*1000L));
        return view;
    }

    class ViewHolder{
        TextView tv_recommendrecord_name;
        TextView tv_recommendrecord_role;
        TextView tv_recommendrecord_data;
        ImageView iv_recommendrecord_avater;

    }
}
