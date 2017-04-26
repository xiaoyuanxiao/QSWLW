package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMallListPriceFragment extends BaseFragment {
    public static QSMallListPriceFragment newInstance() {
        return  new QSMallListPriceFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fragment_qsmalllist, null);
        return inflate;
    }
}
