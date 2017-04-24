package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/24.
 */

public class AllianceMallGVAdapter extends BaseAdapter {
    private String[] contents = {"生活服务","美妆养护","珠宝钟表","服装箱包",
            "美食酒店","电子家居","酒类","鲜蔬花果"};
    private int[] imgs = new int[]{R.mipmap.lifeservice, R.mipmap.mezhuang, R.mipmap.zhongbiao, R.mipmap.fuzhaung, R.mipmap.meishi, R.mipmap.dianzi, R.mipmap.jiu, R.mipmap.huaguo};
    private Context context;

    public AllianceMallGVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return imgs[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view  =  View.inflate(context, R.layout.item_gv_alliancemall,null);
        ImageView iv_gv_alliancemall = (ImageView) view.findViewById(R.id.iv_gv_alliancemall);
        TextView tv_gv_alliancemall = (TextView) view.findViewById(R.id.tv_gv_alliancemall);
        iv_gv_alliancemall.setImageResource(imgs[i]);
        tv_gv_alliancemall.setText(contents[i]);
        return view;
    }
}
