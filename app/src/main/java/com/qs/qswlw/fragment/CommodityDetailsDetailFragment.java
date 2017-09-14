package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsDetailFragment extends BaseFragment implements View.OnClickListener {


    public static CommodityDetailsDetailFragment newInstance() {
        CommodityDetailsDetailFragment fragment = new CommodityDetailsDetailFragment();
        return fragment;
    }
    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_commoditydetailsdetail, null);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
