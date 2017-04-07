package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.adapter.MyProfitAdapter;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyProfitActivity extends BaseActivity {

    private ListView lv_myprofit;

    @Override
    public Object initView() {
        return R.layout.activity_myprofit;
    }

    @Override
    public void initfindviewByid() {
        lv_myprofit = (ListView) findViewById(R.id.lv_myprofit);
        lv_myprofit.setAdapter(new MyProfitAdapter(this));
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
