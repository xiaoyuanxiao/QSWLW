package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.LuckBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class LuckAdapter extends BaseListAdapter<LuckBean> {

    public LuckAdapter(Context context, List<LuckBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = View.inflate(context, R.layout.item_home_content, null);
//        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
//        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
//        RelativeLayout rl_width = (RelativeLayout) convertView.findViewById(R.id.rl_width);
//        rl_width.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
//        LuckBean luckBean = data.get(position);
//        key.setText(luckBean.getNickname());
//        value.setText(luckBean.getCc());
        convertView = View.inflate(context, R.layout.item_luck_main, null);
        return convertView;


    }
}
