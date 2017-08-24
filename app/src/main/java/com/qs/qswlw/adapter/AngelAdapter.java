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
 * Created by 小猴子 on 2017/4/9.
 */

public class AngelAdapter extends BaseListAdapter<Maindatabean.Salema> {

    public AngelAdapter(Context context, List<Maindatabean.Salema> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_home_content, null);
        TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
        TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
        RelativeLayout rl_width = (RelativeLayout) convertView.findViewById(R.id.rl_width);
        rl_width.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,(MyApplication.Height-108)/6));
        Maindatabean.Salema angelBean = data.get(position);
        key.setText(angelBean.getNickname());
        value.setText(angelBean.getTotal()+"元");
        return convertView;


    }
}
