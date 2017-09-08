package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class GetGoldBeanFragment extends BaseFragment {
    public static GetGoldBeanFragment newInstance() {
        return  new GetGoldBeanFragment();
    }
    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.sub_mygoldenbean, null);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
