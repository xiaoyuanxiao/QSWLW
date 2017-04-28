package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsDetailFragment extends BaseFragment {
    public static CommodityDetailsDetailFragment newInstance() {
        CommodityDetailsDetailFragment fragment = new CommodityDetailsDetailFragment();
        return fragment;
    }
    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fragment_qsmalllist, null);
        return inflate;
    }
}
