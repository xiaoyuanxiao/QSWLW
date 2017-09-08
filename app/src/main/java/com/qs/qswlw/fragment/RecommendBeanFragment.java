package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class RecommendBeanFragment extends BaseFragment {
    public static RecommendBeanFragment newInstance() {
        return  new RecommendBeanFragment();
    }
    @Override
    View initView() {
       return View.inflate(activity, R.layout.sub_mygoldenbean,null);
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
