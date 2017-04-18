package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ConsumerEntrepreneurialSeedAdapter;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class ConsumerEntrepreneurialSeedActivity extends BaseInfoActivity {

    private ListView lv_consumerentreseed;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumerentrepreneurialseed, null);
        lv_consumerentreseed = (ListView) inflate.findViewById(R.id.lv_consumerentreseed);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业种子");
    }

    @Override
    public void initData() {
        super.initData();
        lv_consumerentreseed.setAdapter(new ConsumerEntrepreneurialSeedAdapter(this));
    }
}
