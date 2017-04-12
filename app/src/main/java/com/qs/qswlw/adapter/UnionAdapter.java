package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.okhttp.Moudle.UnionBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/11.
 */

public class UnionAdapter extends BaseListAdapter<UnionBean> {


    public UnionAdapter(Context context, List<UnionBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_home_content, null);
        TextView tv_item_home_content_left = (TextView) view.findViewById(R.id.tv_item_home_content_left);
        TextView tv_item_home_content_value = (TextView) view.findViewById(R.id.tv_item_home_content_value);
        tv_item_home_content_left.setTextColor(context.getResources().getColor(R.color.text_yellow));
        tv_item_home_content_value.setTextColor(context.getResources().getColor(R.color.text_yellow));
        UnionBean unionBean = data.get(i);
        tv_item_home_content_left.setText(unionBean.getStore_name());
        tv_item_home_content_value.setText(unionBean.getSum_money()+"元");
        return view;
    }
}
