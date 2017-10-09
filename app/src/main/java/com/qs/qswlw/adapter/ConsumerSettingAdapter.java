package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/17.
 */

/**
 * 设置中心的adapter
 */
public class ConsumerSettingAdapter extends BaseAdapter {

    public int[] imgs = {R.mipmap.wytj, R.mipmap.tubiao0029, R.mipmap.jilu,
            R.mipmap.tubiao0030, R.mipmap.saoma, R.mipmap.daizi, R.mipmap.consume_quota,
            R.mipmap.pingjia,R.mipmap.jinbi,R.mipmap.jinbi2,R.mipmap.user_address,
            R.mipmap.citie,R.mipmap.user08,R.mipmap.shouh,R.mipmap.xfyd,R.mipmap.cyzz,R.mipmap.xfjd,
            R.mipmap.tx,R.mipmap.wdjb,R.mipmap.tz,R.mipmap.cyzj,R.mipmap.cj,R.mipmap.tubiao0028,R.mipmap.wslhy,R.mipmap.user_ren};
//    public String[] contents = {"我的金豆", "消费银豆", "创业种子", "我的金币",
//            "我的投资", "创业直捐", "我要推荐", "我要提现","我要转赠",
//            "促销抽奖记录","收货地址","升级申请","获赠记录","商品评价",
//            "我的购物","我的商城设置","商城消费金豆专区","线下门店扫码","我的阿消费额度"};
    public String[] contents = {"我要推荐", "直推联盟商", "升级申请", "我的机构",
            "门店扫码记录", "我的购物", "我的消费额度", "商品评价","(无)消费金豆专区",
            "商城消费金豆专区","收货地址","我的商城设置","我要转增","获赠记录",
            "消费银豆","创业种子","我的金豆","我要提现","我的金币","我的投资","创业直捐",
        "促销抽奖记录","我要创业","我是老会员","我的角色"};

//    public int[] imgs = {R.mipmap.beans, R.mipmap.xfyd, R.mipmap.cyzz,
//            R.mipmap.wdjb, R.mipmap.tz, R.mipmap.cyzj, R.mipmap.wytj,
//            R.mipmap.tx,R.mipmap.user08,R.mipmap.cj,R.mipmap.user_address,
//            R.mipmap.jilu,R.mipmap.shouh,R.mipmap.tx,R.mipmap.daizi,R.mipmap.citie,R.mipmap.jinbi,
//            R.mipmap.saoma,R.mipmap.consume_quota};
    private Context context;
    public ConsumerSettingAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return imgs[ i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context,R.layout.item_setting,null);
        ImageView iv_item_setting = (ImageView) view.findViewById(R.id.iv_item_setting);
        TextView tv_item_setting = (TextView) view.findViewById(R.id.tv_item_setting);
        iv_item_setting.setImageResource(imgs[i]);
        tv_item_setting.setText(contents[i]);
        return view;
    }
}