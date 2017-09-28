package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyProfitAdapter;
import com.qs.qswlw.bean.MyProfitBean;
import com.qs.qswlw.okhttp.Iview.IMyProfitView;
import com.qs.qswlw.okhttp.Presenter.MyProfitPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitActivity extends BaseInfoActivity implements IMyProfitView {

    int page = 1;
    SwipeRefreshView swipeRefreshView;
    private ListView lv_myprofit;
    private List<MyProfitBean.ListBean> myProfitBeanlist;
    private MyProfitPersenter myProfitPersenter = new MyProfitPersenter(this);
    private TextView tv_myprofit_one,tv_myprofit_two;
    private MyProfitAdapter myProfitAdapter;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myprofit, null);
        View inflate1 = View.inflate(this, R.layout.item_head_myprofit, null);
        lv_myprofit = (ListView) inflate.findViewById(R.id.lv_myprofit);
        lv_myprofit.addHeaderView(inflate1);
        tv_myprofit_one = (TextView) inflate1.findViewById(R.id.tv_myprofit_one);
        tv_myprofit_two = (TextView) inflate1.findViewById(R.id.tv_myprofit_two);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_myprofit_sw);
        return inflate;
    }

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
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                myProfitPersenter.getData(MyApplication.TOKEN,page);
            }
        });
    }

    @Override
    public void setMyProfitData(MyProfitBean myProfitData) {
        swipeRefreshView.setLoading(false);
        tv_myprofit_one.setText("应让利合计:"+myProfitData.getSum());
        tv_myprofit_two.setText("已让利合计:"+myProfitData.getCount());
        List<MyProfitBean.ListBean> list = myProfitData.getList();
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        myProfitBeanlist.addAll(list);
        myProfitAdapter.notifyDataSetChanged();
        page++;
    }

}
