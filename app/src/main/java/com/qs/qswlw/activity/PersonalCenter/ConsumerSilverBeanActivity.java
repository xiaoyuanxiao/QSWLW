package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ConsumerSilverBeanAdapter;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class ConsumerSilverBeanActivity extends BaseInfoActivity {
    private ListView lv_consumersliverbean;

    @Override
    View setConetnView() {
        return View.inflate(this, R.layout.activity_consumersilverbean, null);
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        lv_consumersliverbean = (ListView) findViewById(R.id.lv_consumersliverbean);
        lv_consumersliverbean.setAdapter(new ConsumerSilverBeanAdapter(this));
    }


    @Override
    public void initData() {
        super.initData();
        tv_titlebar_center.setText("消费银豆");

    }

    @Override
    public void setOnclick() {
        super.setOnclick();


    }


    @Override
    public void onClick(View view) {
        super.onClick(view);

    }
}
