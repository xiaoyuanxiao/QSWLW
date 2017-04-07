package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.adapter.ConsumerSilverBeanAdapter;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class ConsumerSilverBeanActivity extends BaseActivity {
    private ListView lv_consumersliverbean;

    @Override
    public Object initView() {
        return R.layout.activity_consumersilverbean;
    }

    @Override
    public void initfindviewByid() {
        lv_consumersliverbean = (ListView) findViewById(R.id.lv_consumersliverbean);
        lv_consumersliverbean.setAdapter(new ConsumerSilverBeanAdapter(this));
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
