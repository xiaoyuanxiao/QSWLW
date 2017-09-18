package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BusinessTurnoverAdapter;
import com.qs.qswlw.bean.BusinessTurnoverBean;
import com.qs.qswlw.okhttp.Iview.IBusinessTurnoverView;
import com.qs.qswlw.okhttp.Presenter.BusinessTurnoverPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class BusinessTurnoverActivity extends BaseInfoActivity implements IBusinessTurnoverView {

    private RadioGroup fg_BusinessTurnover;
    private TextView tv_businessturnover_left, tv_businessturnover_right;
    private View view_turnover_left, view_turnover_right;
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_turnover;
    private BusinessTurnoverAdapter businessTurnoverAdapter;
    private List<BusinessTurnoverBean.ListBean> listBeen;

    private BusinessTurnoverPersenter businessTurnoverPersenter = new BusinessTurnoverPersenter(this);

    int page = 1;
    int is_history = 0;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_businessturnover, null);
        fg_BusinessTurnover = (RadioGroup) inflate.findViewById(R.id.fg_BusinessTurnover);
        tv_businessturnover_left = (TextView) inflate.findViewById(R.id.tv_businessturnover_left);
        tv_businessturnover_right = (TextView) inflate.findViewById(R.id.tv_businessturnover_right);
        view_turnover_left = inflate.findViewById(R.id.view_turnover_left);
        view_turnover_right = inflate.findViewById(R.id.view_turnover_right);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_turnover_sw);
        lv_turnover = (ListView) inflate.findViewById(R.id.lv_turnover);


        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商家营业额");
    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        businessTurnoverAdapter = new BusinessTurnoverAdapter(this, listBeen);
        lv_turnover.setAdapter(businessTurnoverAdapter);
        businessTurnoverPersenter.getdata(MyApplication.TOKEN,page,is_history);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                businessTurnoverPersenter.getdataRefresh(MyApplication.TOKEN,page,is_history);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_businessturnover_left.setOnClickListener(this);
        tv_businessturnover_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_businessturnover_left:
                setTopColor(tv_businessturnover_left, tv_businessturnover_right, view_turnover_left, view_turnover_right);
                break;
            case R.id.tv_businessturnover_right:
                setTopColor(tv_businessturnover_right, tv_businessturnover_left, view_turnover_right, view_turnover_left);
                break;
        }
    }

    private void setTopColor(TextView tv, TextView tv1, View view, View view1) {
        tv.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setBackgroundColor(this.getResources().getColor(R.color.white));
        view.setBackgroundColor(this.getResources().getColor(R.color.red));
        view1.setBackgroundColor(this.getResources().getColor(R.color.white));
    }

    @Override
    public void getdata(BusinessTurnoverBean businessTurnoverBean) {
        List<BusinessTurnoverBean.ListBean> list = businessTurnoverBean.getList();
        listBeen.clear();
        if (list!=null) {
            listBeen.addAll(list);
        }
        businessTurnoverAdapter.notifyDataSetChanged();
    }

    @Override
    public void getdataRefresh(BusinessTurnoverBean businessTurnoverBean) {
        List<BusinessTurnoverBean.ListBean> list = businessTurnoverBean.getList();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        listBeen.addAll(list);
        businessTurnoverAdapter.notifyDataSetChanged();
        page++;
    }
}
