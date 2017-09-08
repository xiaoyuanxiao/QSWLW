package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.fragment.MyGoldBeanFragment;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class VentureGoldBeansAdapter extends BaseListAdapter<VenturegoldBean.ListBean> {

    public VentureGoldBeansAdapter(Context context, List<VenturegoldBean.ListBean> data) {
        super(context, data);
    }

    String type = "";

    public VentureGoldBeansAdapter(Context context, List<VenturegoldBean.ListBean> data, String type) {
        super(context, data);
        this.type = type;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VenturegoldBean.ListBean listBean = data.get(i);
        if (type.equals(MyGoldBeanFragment.GIVE)) {
            view = View.inflate(context, R.layout.item_mygoldenbean, null);
            TextView tv_item_mygoldenbean_four = (TextView) view.findViewById(R.id.tv_item_mygoldenbean_four);
            tv_item_mygoldenbean_four.setText(listBean.getAdd_time());
        } else if (type.equals(MyGoldBeanFragment.TJJD)) {
            view = View.inflate(context, R.layout.item_mysliverbean, null);//先随便写一个
        } else if (type.equals("")) {
            view = View.inflate(context, R.layout.item_mygoldenbean, null);
        }
        return view;
    }
}
