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
public class BusinessSettingAdapter extends BaseAdapter {
    public String[] contents={"商家录单","我要推荐","客户消费记录","我的机构","商城订单","自营商品","现金专区","消费金豆专区","收货地址","消费银豆","创业种子",
    "我的金豆","我的奖金","我要提现","促销抽奖记录","我的角色","商家完善资料","商品管理","我的商城","商家营业额"};

//    public String[] contents = {"商家二维码", "门店扫码记录", "商家扫码审核", "商家销售审核",
//            "我要推荐", "线下消费录单", "录单记录", "我的管理费","商家完善资料",
//            "商品管理","消费金豆额度","我的商城","商家营业额","选送商品记录","消费银豆","创业种子",
//            "我的金豆","我要提现","我的购物","收货地址","(无)消费金豆专区","消费金豆专区","我的消费额度",
//            "我的商城设置","我要转赠","获赠记录","我的金币","创业直捐","我是老会员","我的角色","我的投资","我要创业","促销抽奖记录","我的收购"};
//    public int[] ids = {R.mipmap.wytj, R.mipmap.saoma, R.mipmap.smsh,
//            R.mipmap.dingdan, R.mipmap.wytj, R.mipmap.user_09, R.mipmap.jilu,
//            R.mipmap.user_11,R.mipmap.bianji,R.mipmap.spgl,R.mipmap.edu,
//            R.mipmap.lingdang,R.mipmap.yye,R.mipmap.happygame01,R.mipmap.xfyd,R.mipmap.cyzz,
//            R.mipmap.beans,R.mipmap.tx,R.mipmap.daizi,R.mipmap.user_address,R.mipmap.jinbi,
//            R.mipmap.jinbi2,R.mipmap.consume_quota,R.mipmap.citie,R.mipmap.user08,R.mipmap.shouh,
//            R.mipmap.wdjb,R.mipmap.cyzj,R.mipmap.wslhy,R.mipmap.user_ren, R.mipmap.cyzj,R.mipmap.tubiao0028,R.mipmap.cj,R.mipmap.huishou};
    public int[] ids = {R.mipmap.user_09,R.mipmap.wytj,R.mipmap.jilu,R.mipmap.tubiao0030,R.mipmap.daizi,R.mipmap.is_me,R.mipmap.jinbi,R.mipmap.jinbi2,
            R.mipmap.user_address,R.mipmap.xfyd,R.mipmap.cyzz,R.mipmap.xfjd,R.mipmap.xfjd,R.mipmap.tx,R.mipmap.cj,R.mipmap.user_ren,
            R.mipmap.bianji,R.mipmap.spgl,R.mipmap.lingdang,R.mipmap.yye};

    private Context context;
    public BusinessSettingAdapter(Context context) {
        this.context = context;
    }

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