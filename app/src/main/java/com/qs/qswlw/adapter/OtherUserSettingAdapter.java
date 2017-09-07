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
public class OtherUserSettingAdapter extends BaseAdapter {

    private Context context;

    public OtherUserSettingAdapter(Context context) {
        this.context = context;
    }

    public String[] contents = {"我的金豆", "消费银豆", "创业种子", "我的金币",
            "我的投资", "创业直捐", "我要推荐", "我要提现","我要转赠",
            "促销抽奖记录","收货地址","升级提醒","直推联盟商","我的机构","我是老会员","获赠记录",
            "我要创业","商品评价","我的购物","我的商城设置","商城消费金豆专区","线下门店扫码","我的消费额度"};

    public int[] ids = {R.mipmap.xfjd, R.mipmap.xfyd, R.mipmap.cyzz,
            R.mipmap.wdjb, R.mipmap.tz, R.mipmap.cyzj, R.mipmap.wytj,
            R.mipmap.tx,R.mipmap.user08,R.mipmap.cj,R.mipmap.user_address,
            R.mipmap.jilu,R.mipmap.ztlms,R.mipmap.jigou,R.mipmap.wslhy,R.mipmap.shouh,
            R.mipmap.chuangye,R.mipmap.pingjia,R.mipmap.daizi,R.mipmap.citie,R.mipmap.jinbi,
            R.mipmap.saoma,R.mipmap.consume_quota};
    @Override
    public int getCount() {
        return contents.length;
    }

    @Override
    public Object getItem(int i) {
        return ids[ i];
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
        iv_item_setting.setImageResource(ids[i]);
        tv_item_setting.setText(contents[i]);
        return view;
    }
}