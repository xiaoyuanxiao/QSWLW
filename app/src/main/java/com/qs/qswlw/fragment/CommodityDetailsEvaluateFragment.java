package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsEvaluateFragment extends BaseFragment {
    public static CommodityDetailsEvaluateFragment newInstance() {
        CommodityDetailsEvaluateFragment fragment = new CommodityDetailsEvaluateFragment();
        return fragment;
    }
    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fg_commoditydetailsevaluate, null);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
