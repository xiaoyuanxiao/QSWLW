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

import static com.qs.qswlw.R.id.tv_rankMoney;
import static com.qs.qswlw.R.id.tv_rankStar;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ChinaOrderAmountAdapter extends BaseListAdapter<GoodProductBean.GoodsAmonut> {


    public ChinaOrderAmountAdapter(Context context, List<GoodProductBean.GoodsAmonut> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GoodProductBean.GoodsAmonut goodsAmonut = data.get(i);
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_chinagoodproduct,null);
            holder.iv_goodsRank = (ImageView) view.findViewById(R.id.iv_goodsRank);
            holder.tv_rankStar = (TextView) view.findViewById(tv_rankStar);
            holder.tv_rankContent = (TextView) view.findViewById(R.id.tv_rankContent);
            holder.tv_rankMoney = (TextView) view.findViewById(tv_rankMoney);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(ReHttpUtils.getBaseUrl() + goodsAmonut.getOriginal_img()).into(holder.iv_goodsRank);
        holder.tv_rankStar.setText("订单金额:"+"\n"+goodsAmonut.getSum_goods_price()+"");
        holder.tv_rankContent.setText(goodsAmonut.getGoods_name());
        holder.tv_rankMoney.setText(goodsAmonut.getShop_price());

        return view;
    }

    class ViewHolder {
        public ImageView iv_goodsRank;
        public TextView tv_rankStar;
        public TextView tv_rankContent;
        public TextView tv_rankMoney;
    }

}
