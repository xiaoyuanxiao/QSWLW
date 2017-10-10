package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/10/10.
 */

public class RecommendConsumptionActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recommendconsumption, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("消费录单");
    }
}
