package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.DonationRecordAdapter;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class DonationRecordActivity extends BaseInfoActivity {

    private ListView lv_donationrecords;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_donationrecord, null);
        lv_donationrecords = (ListView) inflate.findViewById(R.id.lv_donationrecords);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("转赠记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_donationrecords.setAdapter(new DonationRecordAdapter(this));
    }
}
