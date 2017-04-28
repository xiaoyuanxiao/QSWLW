package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsWareFragment extends BaseFragment {
    public static CommodityDetailsWareFragment newInstance() {
        CommodityDetailsWareFragment fragment = new CommodityDetailsWareFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fragment_qsmalllist, null);
        return inflate;
    }
}
