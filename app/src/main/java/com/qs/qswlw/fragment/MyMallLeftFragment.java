package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/10/13.
 */

public class MyMallLeftFragment extends BaseFragment {
    public static MyMallLeftFragment newInstance(){
        return new MyMallLeftFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_malldetailleft, null);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
