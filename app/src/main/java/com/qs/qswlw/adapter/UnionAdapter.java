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
        TextView key = (TextView) view.findViewById(R.id.tv_item_home_content_left);
        TextView value = (TextView) view.findViewById(R.id.tv_item_home_content_value);
        UnionBean unionBean = data.get(i);
        key.setText(unionBean.getStore_name());
        value.setText(unionBean.getSum_money());
        return view;
    }
}
