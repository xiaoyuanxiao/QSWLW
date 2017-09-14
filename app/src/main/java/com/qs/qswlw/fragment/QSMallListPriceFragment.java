package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.GridView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.QSMalListNewAdapter;

/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMallListPriceFragment extends BaseFragment {
    private GridView gv_qsmalllist;

    public static QSMallListPriceFragment newInstance() {
        return  new QSMallListPriceFragment();
    }
    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_qsmalllist, null);
        gv_qsmalllist = (GridView) inflate.findViewById(R.id.gv_qsmalllist);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        gv_qsmalllist.setAdapter(new QSMalListNewAdapter(getActivity()));
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
