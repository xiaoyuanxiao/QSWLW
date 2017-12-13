package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.PopRankingAdapter;
import com.qs.qswlw.bean.PopRankingBean;
import com.qs.qswlw.okhttp.Iview.IPopRankingView;
import com.qs.qswlw.okhttp.Presenter.PopRankingPersenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class PopRankingCenterFragment extends BaseFragment implements IPopRankingView{
    private ListView lv_listview;
    private List<PopRankingBean.ListBean> popRankingBean;
    private PopRankingAdapter PopRankingAdapter;
    private PopRankingPersenter popRankingPersenter = new PopRankingPersenter(this);
    private String role;
    private String time_slot;

    public PopRankingCenterFragment(String role, String time_slot) {
        this.role = role;
        this.time_slot = time_slot;
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_listview, null);
        lv_listview = (ListView) inflate.findViewById(R.id.lv_listview);

        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        popRankingBean = new ArrayList<>();
        PopRankingAdapter = new PopRankingAdapter(getActivity(),popRankingBean);
        lv_listview.setAdapter(PopRankingAdapter);
        popRankingPersenter.getdata(role,time_slot);

    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setData(PopRankingBean popRankingBean) {
        List<PopRankingBean.ListBean> list = popRankingBean.getList();
        this.popRankingBean.clear();
        this.popRankingBean.addAll(list);
        PopRankingAdapter.notifyDataSetChanged();


    }
}
