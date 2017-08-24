package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.Maindatabean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/11.
 */

public class UnionAdapter extends BaseListAdapter<Maindatabean.Shop> {


    public UnionAdapter(Context context, List<Maindatabean.Shop> data) {
        super(context, data);
    }

    @Override
    public int getCount() {
        return data.size() > 0 ? super.getCount() : 20;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_home_content, null);
        TextView tv_item_home_content_left = (TextView) view.findViewById(R.id.tv_item_home_content_left);
        TextView tv_item_home_content_value = (TextView) view.findViewById(R.id.tv_item_home_content_value);
        RelativeLayout rl_width = (RelativeLayout) view.findViewById(R.id.rl_width);
        rl_width.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, (MyApplication.Height - 108) / 6));
        tv_item_home_content_left.setTextColor(context.getResources().getColor(R.color.text_yellow));
        tv_item_home_content_value.setTextColor(context.getResources().getColor(R.color.text_yellow));
        try {
            Maindatabean.Shop unionBean = data.get(i);
            String store_name = unionBean.getStore_name();
            if (("").equals(store_name)) {
                tv_item_home_content_left.setText("...");
            }else{
                tv_item_home_content_left.setText(store_name);
            }

            tv_item_home_content_value.setText(unionBean.getSum_money() + "元");
        } catch (Exception e) {

        }

        return view;
    }
}
