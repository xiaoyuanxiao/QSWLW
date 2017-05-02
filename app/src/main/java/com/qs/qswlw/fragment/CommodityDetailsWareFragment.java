package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsWareFragment extends BaseFragment {

    private TextView tv_fg_ware;

    public static CommodityDetailsWareFragment newInstance() {
        CommodityDetailsWareFragment fragment = new CommodityDetailsWareFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fg_commoditydetailsware, null);
        tv_fg_ware = (TextView) inflate.findViewById(R.id.tv_fg_ware);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
