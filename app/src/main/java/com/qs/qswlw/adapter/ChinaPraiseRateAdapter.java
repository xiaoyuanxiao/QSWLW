package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.mynet.ReHttpUtils;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ChinaPraiseRateAdapter extends BaseListAdapter<GoodProductBean.GoodsRank> {


    public ChinaPraiseRateAdapter(Context context, List<GoodProductBean.GoodsRank> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GoodProductBean.GoodsRank goodsRank = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_chinagoodproduct, null);
            holder.iv_goodsRank = (ImageView) view.findViewById(R.id.iv_goodsRank);
            holder.iv_china = (ImageView) view.findViewById(R.id.iv_china);
            holder.tv_rankStar = (TextView) view.findViewById(R.id.tv_rankStar);
            holder.tv_rankContent = (TextView) view.findViewById(R.id.tv_rankContent);
            holder.tv_rankMoney = (TextView) view.findViewById(R.id.tv_rankMoney);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if(goodsRank.getGoods_rank()==null){
            holder.tv_rankStar.setText("好评率：0星"  );
        }else{
            holder.tv_rankStar.setText("好评率："+goodsRank.getGoods_rank() );
        }
        Glide.with(context).load(ReHttpUtils.getBaseUrl() + goodsRank.getOriginal_img()).into(holder.iv_goodsRank);
        holder.tv_rankMoney.setText(goodsRank.getShop_price());
        holder.tv_rankContent.setText(goodsRank.getGoods_name());
        holder.iv_china.setImageResource(R.mipmap.hp);
        return view;
    }

    class ViewHolder {
        public ImageView iv_china;
        public ImageView iv_goodsRank;
        public TextView tv_rankStar;
        public TextView tv_rankContent;
        public TextView tv_rankMoney;
    }
}
