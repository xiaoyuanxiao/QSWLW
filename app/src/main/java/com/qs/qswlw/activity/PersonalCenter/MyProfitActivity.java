package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyProfitAdapter;
import com.qs.qswlw.bean.MyProfitBean;
import com.qs.qswlw.okhttp.Iview.IMyProfitView;
import com.qs.qswlw.okhttp.Presenter.MyProfitPersenter;
import com.qs.qswlw.view.xlistview.IXListViewLoadMore;
import com.qs.qswlw.view.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitActivity extends BaseInfoActivity implements IMyProfitView {

    private XListView lv_myprofit;
    private List<MyProfitBean.ListBean> myProfitBeanlist;
    private MyProfitPersenter myProfitPersenter = new MyProfitPersenter(this);
    int page = 1;
    private TextView tv_myprofit_one,tv_myprofit_two;
    private MyProfitAdapter myProfitAdapter;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myprofit, null);
        lv_myprofit = (XListView) inflate.findViewById(R.id.lv_myprofit);
        tv_myprofit_one = (TextView) inflate.findViewById(R.id.tv_myprofit_one);
        tv_myprofit_two = (TextView) inflate.findViewById(R.id.tv_myprofit_two);
        //上拉监听
        lv_myprofit.setPullLoadEnable(mLoadMoreListener);
        return inflate;
    }
    /**
     *  上拉监听
     */
    private IXListViewLoadMore mLoadMoreListener = new IXListViewLoadMore() {
        @Override
        public void onLoadMore() {
            Toast.makeText(MyProfitActivity.this, "上拉", Toast.LENGTH_SHORT).show();
            page++;
            myProfitPersenter.getData(MyApplication.TOKEN,page);
        }
    };

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的让利");
    }

    @Override
    public void initData() {
        super.initData();
        myProfitBeanlist = new ArrayList<>();
        myProfitAdapter = new MyProfitAdapter(this,myProfitBeanlist);
        lv_myprofit.setAdapter(myProfitAdapter);
        myProfitPersenter.getData(MyApplication.TOKEN,page);
    }

    @Override
    public void setMyProfitData(MyProfitBean myProfitData) {
        tv_myprofit_one.setText("应让利合计:"+myProfitData.getSum());
        tv_myprofit_two.setText("已让利合计:"+myProfitData.getCount());
        List<MyProfitBean.ListBean> list = myProfitData.getList();
        if (list == null || list.size() == 0) {
            lv_myprofit.noMoreForShow();
            return;
        }
        myProfitBeanlist.addAll(list);
        myProfitAdapter.notifyDataSetChanged();
        lv_myprofit.stopLoadMore();
    }
}
