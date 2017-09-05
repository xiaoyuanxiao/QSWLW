package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MySliverBeanAdapter;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.okhttp.Iview.IMySliverBeanView;
import com.qs.qswlw.okhttp.Presenter.MySliverBeanPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySilverBeanActivity extends BaseInfoActivity implements IMySliverBeanView {

    private ImageView iv_mysliverbean_avater;
    private TextView tv_mysliverbean_id,tv_mysliverbean_nickname,tv_mysliverbean_sliver,tv_mysliverbean_total;
    private List<MySliverBean.SingleLogBean> sliverbeanList;
    private ListView lv_mysliverbean;

    private MySliverBeanAdapter mySliverBeanAdapter;
    private MySliverBeanPresenter mySliverBeanPresenter = new MySliverBeanPresenter(this);

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mysliverbaen, null);
        iv_mysliverbean_avater = (ImageView) inflate.findViewById(R.id.iv_mysliverbean_avater);
        tv_mysliverbean_id = (TextView) inflate.findViewById(R.id.tv_mysliverbean_id);
        tv_mysliverbean_nickname = (TextView) inflate.findViewById(R.id.tv_mysliverbean_nickname);
        tv_mysliverbean_sliver = (TextView) inflate.findViewById(R.id.tv_mysliverbean_sliver);
        tv_mysliverbean_total = (TextView) inflate.findViewById(R.id.tv_mysliverbean_total);
        lv_mysliverbean = (ListView) inflate.findViewById(R.id.lv_mysliverbean);

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
        mySliverBeanAdapter = new MySliverBeanAdapter(this,sliverbeanList);
        lv_mysliverbean.setAdapter(mySliverBeanAdapter);
        mySliverBeanPresenter.getdata(MyApplication.TOKEN,1);
    }

    @Override
    public void setMySliverBeancountData(MySliverBean.SilverCountBean slivercountbean) {
        tv_mysliverbean_id.setText("会员ID:"+MyApplication.ID);
        tv_mysliverbean_nickname.setText("昵称："+MyApplication.NICKNAME);
        tv_mysliverbean_sliver.setText("获得银豆总额:"+slivercountbean.getSilver());
        tv_mysliverbean_total.setText("获得消费总额:"+slivercountbean.getTotal());

    }

    @Override
    public void setMySliverBeanListData(List<MySliverBean.SingleLogBean> list) {
        sliverbeanList.clear();
        sliverbeanList.addAll(list);
        mySliverBeanAdapter.notifyDataSetChanged();

    }
}
