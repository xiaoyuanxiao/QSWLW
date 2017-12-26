package com.qs.qswlw.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.qs.qswlw.BR;
import com.qs.qswlw.ItemMyGoldenFGData;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BaseRecyleAdapter;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Iview.IMyGoldenView;
import com.qs.qswlw.okhttp.Presenter.MyGoldenPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/26.
 */

public class Sub1MyGoldenTJFragment extends BaseDataBindingFragment implements IMyGoldenView {

    int page = 1;
    private ItemMyGoldenFGData bind;
    private LinearLayoutManager linearLayoutManager;
    private BaseRecyleAdapter adapter;
    private MyGoldenPersenter myGoldenPersenter = new MyGoldenPersenter(this);
    private List<VenturegoldBean.ListBean> listBean;

    @Override
    protected int initview() {
        return R.layout.item_fg_mygold;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();
        setVisible(View.GONE);
        //      bind.refreshLayout.setEnableLoadmoreWhenContentNotFull(false);
        bind.refreshLayout.setEnableRefresh(false);

//        View unionHeadview = LayoutInflater.from(getActivity()).inflate(R.layout.item_bottom_total, null);
//        bind.rvFgMygold.addView(unionHeadview);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        bind.rvFgMygold.setLayoutManager(linearLayoutManager);
        myGoldenPersenter.getData(MyApplication.TOKEN,page,"model1","tjjd","");
        listBean = new ArrayList<>();
        bind.refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                myGoldenPersenter.getData(MyApplication.TOKEN,page,"model1","tjjd","");
            }
        });
    }

    @Override
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData) {
        List<VenturegoldBean.ListBean> list = venturegoldBeanData.getList();
        bind.pbItemforestry.setVisibility(View.GONE);
        bind.rvFgMygold.setVisibility(View.VISIBLE);
        bind.refreshLayout.finishLoadmore();
        if (list == null || list.size() == 0) {
            bind.refreshLayout.finishLoadmoreWithNoMoreData();
            return;
        }
        listBean.addAll(list);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_mygolden_give, BR.mygoldengivelistbean);
        adapter = new BaseRecyleAdapter(listBean, map);
        bind.rvFgMygold.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.tokenfailfg(getActivity());
    }
}
