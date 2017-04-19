package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.EntrepreneurialDonationRecordAdapter;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class EntrepreneurialDonationRecordActivity extends BaseInfoActivity {

    private ListView lv_entrepreneurialDonationRecord;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_entrepreneurialdonationrecord, null);
        lv_entrepreneurialDonationRecord = (ListView) inflate.findViewById(R.id.lv_EntrepreneurialDonationRecord);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("直捐记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_entrepreneurialDonationRecord.setAdapter(new EntrepreneurialDonationRecordAdapter(this));
    }
}
