package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.GoodProductBean;

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
        view = View.inflate(context, R.layout.item_chinagoodproduct,null);
        ImageView iv_goodsRank = (ImageView) view.findViewById(R.id.iv_goodsRank);
        TextView tv_rankStar = (TextView) view.findViewById(R.id.tv_rankStar);
        TextView tv_rankContent = (TextView) view.findViewById(R.id.tv_rankContent);
        TextView tv_rankMoney = (TextView) view.findViewById(R.id.tv_rankMoney);
        GoodProductBean.GoodsRank goodsRank = data.get(i);
        tv_rankStar.setText(goodsRank.getGoods_rank());
        tv_rankMoney.setText(goodsRank.getShop_price());
        Glide.with(context).load(goodsRank.getOriginal_img()).into(iv_goodsRank);
        return null;
    }
}
