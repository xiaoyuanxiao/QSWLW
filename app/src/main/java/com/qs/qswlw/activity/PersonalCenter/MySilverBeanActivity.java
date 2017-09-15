package com.qs.qswlw.activity.PersonalCenter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MySliverBeanAdapter;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.okhttp.Iview.IMySliverBeanView;
import com.qs.qswlw.okhttp.Presenter.MySliverBeanPresenter;
import com.qs.qswlw.view.xlistview.IXListViewLoadMore;
import com.qs.qswlw.view.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySilverBeanActivity extends BaseInfoActivity implements IMySliverBeanView {

    private ImageView iv_mysliverbean_avater;
    private TextView tv_mysliverbean_id, tv_mysliverbean_nickname, tv_mysliverbean_sliver, tv_mysliverbean_total;
    private List<MySliverBean.SingleLogBean> sliverbeanList;
    private XListView lv_mysliverbean;

    private MySliverBeanAdapter mySliverBeanAdapter;
    private MySliverBeanPresenter mySliverBeanPresenter = new MySliverBeanPresenter(this);
    private ProgressBar pb_itemforestry;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mysliverbaen, null);
        iv_mysliverbean_avater = (ImageView) inflate.findViewById(R.id.iv_mysliverbean_avater);
        tv_mysliverbean_id = (TextView) inflate.findViewById(R.id.tv_mysliverbean_id);
        tv_mysliverbean_nickname = (TextView) inflate.findViewById(R.id.tv_mysliverbean_nickname);
        tv_mysliverbean_sliver = (TextView) inflate.findViewById(R.id.tv_mysliverbean_sliver);
        tv_mysliverbean_total = (TextView) inflate.findViewById(R.id.tv_mysliverbean_total);
        lv_mysliverbean = (XListView) inflate.findViewById(R.id.lv_mysliverbean);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        //上拉监听
        lv_mysliverbean.setPullLoadEnable(mLoadMoreListener);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("银豆页面");
        tv_titlebar_right.setText("筛选");

    }
    /**
     *  上拉监听
     */
    private IXListViewLoadMore mLoadMoreListener = new IXListViewLoadMore() {
        @Override
        public void onLoadMore() {
            Toast.makeText(MySilverBeanActivity.this, "上拉", Toast.LENGTH_SHORT).show();
            page++;
            mySliverBeanPresenter.getdata(page);
        }
    };

    int page = 1;

    @Override
    public void initData() {
        super.initData();
        sliverbeanList = new ArrayList<>();
        mySliverBeanAdapter = new MySliverBeanAdapter(this, sliverbeanList);
        lv_mysliverbean.setAdapter(mySliverBeanAdapter);
        mySliverBeanPresenter.getdata(page);
//        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
//            @Override
//            public void onLoad() {
//                mySliverBeanPresenter.getdata(page);
//            }
//        });
      /*  lv_mysliverbean.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Log.d("OnScrollListener", "============onScrollStateChanged===========" + absListView.getLastVisiblePosition());
                if (absListView.getLastVisiblePosition() == (absListView.getCount() - 1)) {
                    Log.d("OnScrollListener", "============absListView.getCount()===========" + absListView.getCount());
                    getaddList(absListView.getCount());
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("OnScrollListener", "============onScroll===========" + i + "==================i1=" + i1 + "=======i2=" + i2);
            }
        });*/
    }/*

    private void getaddList(int a) {
        mySliverBeanPresenter.getaddData(a);
    }*/

    @Override
    public void setMySliverBeancountData(MySliverBean.SilverCountBean slivercountbean) {
        tv_mysliverbean_id.setText("会员ID:" + MyApplication.ID);
        tv_mysliverbean_nickname.setText("昵称：" + MyApplication.NICKNAME);
        if (slivercountbean.getSilver() != null) {
            tv_mysliverbean_sliver.setText("获得银豆总额:" + slivercountbean.getSilver());
        }
        if (slivercountbean.getTotal() != null) {
            tv_mysliverbean_total.setText("获得消费总额:" + slivercountbean.getTotal());
        }
    }

    @Override
    public void setMySliverBeanListData(List<MySliverBean.SingleLogBean> list) {
        Log.d("TAG", "===========setMySliverBeanListData===" + list.size());
        pb_itemforestry.setVisibility(View.GONE);//这是什么  就第一次那个旋转圈圈 就加一次的
       // swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            lv_mysliverbean.noMoreForShow();
            return;
        }
        sliverbeanList.addAll(list);
        mySliverBeanAdapter.notifyDataSetChanged();

        lv_mysliverbean.stopLoadMore();
    }

//    @Override
//    public void isgetDataFaile(String meg) {
//        swipeRefreshView.setLoading(false);
//    }
}