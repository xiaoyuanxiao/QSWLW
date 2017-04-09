package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public int[] ids = {R.mipmap.bianji, R.mipmap.cyzz, R.mipmap.beans,
            R.mipmap.wytj, R.mipmap.xfyd, R.mipmap.tx, R.mipmap.user_11,
            R.mipmap.yye,R.mipmap.user_09,R.mipmap.jilu,R.mipmap.cyzz,
            R.mipmap.cpgl,R.mipmap.cj,R.mipmap.user_address};
    public String[] contents = {"商家完善资料", "创业种子", "我的金豆", "我要推荐",
            "消费银豆", "我要提现", "我的让利", "商家营业额","消费录单",
            "录单记录","创业直捐","商品管理","促销抽奖记录","收获地址"};

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
        view = View.inflate(context,R.layout.item_entrepreneurialseed,null);
        TextView tv_ConsumptionDate = (TextView) view.findViewById(R.id.tv_ConsumptionDate);
        TextView tv_ConfirmationDate = (TextView) view.findViewById(R.id.tv_ConfirmationDate);
        TextView tv_ConsumerSilverBean = (TextView) view.findViewById(R.id.tv_ConsumerSilverBean);
        TextView tv_BusinessTurnover = (TextView) view.findViewById(R.id.tv_BusinessTurnover);
        tv_ConsumptionDate.setText(contents[i]);
        tv_ConfirmationDate.setText(contents[i]);
        tv_ConsumerSilverBean.setText(contents[i]);
        tv_BusinessTurnover.setText(contents[i]);
        return view;
    }
}
