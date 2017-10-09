package com.qs.qswlw.activity.PersonalCenter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MySliverBeanAdapter;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.okhttp.Iview.IMySliverBeanView;
import com.qs.qswlw.okhttp.Presenter.MySliverBeanPresenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySilverBeanActivity extends BaseInfoActivity implements IMySliverBeanView {

    SwipeRefreshView swipeRefreshView;
    int page = 1;
    private ImageView iv_mysliverbean_avater;
    private TextView tv_mysliverbean_id, tv_mysliverbean_nickname, tv_mysliverbean_sliver, tv_mysliverbean_total;
    private List<MySliverBean.SingleLogBean> sliverbeanList;
    private ListView lv_mysliverbean;
    private MySliverBeanAdapter mySliverBeanAdapter;
    private MySliverBeanPresenter mySliverBeanPresenter = new MySliverBeanPresenter(this);
    private ProgressBar pb_itemforestry;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mysliverbaen, null);
        View inflate1 = View.inflate(this, R.layout.item_head_mysliverbean, null);
        iv_mysliverbean_avater = (ImageView) inflate1.findViewById(R.id.iv_mysliverbean_avater);
        tv_mysliverbean_id = (TextView) inflate1.findViewById(R.id.tv_mysliverbean_id);
        tv_mysliverbean_nickname = (TextView) inflate1.findViewById(R.id.tv_mysliverbean_nickname);
        tv_mysliverbean_sliver = (TextView) inflate1.findViewById(R.id.tv_mysliverbean_sliver);
        tv_mysliverbean_total = (TextView) inflate1.findViewById(R.id.tv_mysliverbean_total);
        lv_mysliverbean = (ListView) inflate.findViewById(R.id.lv_mysliverbean);
        lv_mysliverbean.addHeaderView(inflate1);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_mysliverbean_sw);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("银豆页面");
        tv_titlebar_right.setText("筛选");

    }

    @Override
    public void initData() {
        super.initData();
        sliverbeanList = new ArrayList<>();
        mySliverBeanAdapter = new MySliverBeanAdapter(this, sliverbeanList);
        lv_mysliverbean.setAdapter(mySliverBeanAdapter);
        mySliverBeanPresenter.getdata(page);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                mySliverBeanPresenter.getdata(page);
            }
        });
    }

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
        pb_itemforestry.setVisibility(View.GONE);
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        sliverbeanList.addAll(list);
        mySliverBeanAdapter.notifyDataSetChanged();

        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }
}
