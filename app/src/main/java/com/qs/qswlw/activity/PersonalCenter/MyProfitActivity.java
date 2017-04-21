package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyProfitAdapter;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitActivity extends BaseInfoActivity {

    private ListView lv_myprofit;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_myprofit, null);
        lv_myprofit = (ListView) inflate.findViewById(R.id.lv_myprofit);
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
        lv_myprofit.setAdapter(new MyProfitAdapter(this));
    }
}
