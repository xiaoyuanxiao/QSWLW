package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMallListSalesVolumeFragment extends BaseFragment {
    public static QSMallListSalesVolumeFragment newInstance() {
        return  new QSMallListSalesVolumeFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fragment_qsmalllist, null);
        return inflate;
    }
}
