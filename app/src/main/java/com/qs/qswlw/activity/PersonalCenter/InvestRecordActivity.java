package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.InvestRecordAdapter;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class InvestRecordActivity extends BaseInfoActivity {

    private ListView lv_investrecord;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_investrecord, null);
        lv_investrecord = (ListView) inflate.findViewById(R.id.lv_investrecord);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("投资记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_investrecord.setAdapter(new InvestRecordAdapter(this));
    }
}
