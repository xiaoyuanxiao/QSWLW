package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyPartnerAdapter;

/**
 * Created by xiaoyu on 2017/4/20.
 */

public class MyPartnerActivity extends BaseInfoActivity {

    private ListView lv_myPartner;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mypartner, null);
        lv_myPartner = (ListView) inflate.findViewById(R.id.lv_myPartner);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的伙伴");
    }

    @Override
    public void initData() {
        super.initData();
        lv_myPartner.setAdapter(new MyPartnerAdapter(this));
    }
}
