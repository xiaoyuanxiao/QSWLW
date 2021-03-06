package com.qs.qswlw.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.mall.CommodityDetailsActivity;
import com.qs.qswlw.adapter.QSMalListNewAdapter;


/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMalListNewFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private GridView gv_qsmalllist;

    public static QSMalListNewFragment newInstance() {
        return  new QSMalListNewFragment();
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
        gv_qsmalllist.setOnItemClickListener(this);
        gv_qsmalllist.setAdapter(new QSMalListNewAdapter(getActivity()));
    }

    @Override
    protected void setOnclick() {

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), CommodityDetailsActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {

    }
}
