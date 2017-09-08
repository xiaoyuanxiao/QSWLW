package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class MyGoldBeanFragment extends BaseFragment  {
    public static MyGoldBeanFragment newInstance() {
        return  new MyGoldBeanFragment();
    }
    @Override
    View initView() {
        return View.inflate(activity,R.layout.sub_mygoldenbean,null);
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
