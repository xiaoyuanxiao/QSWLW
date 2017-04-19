package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecommendedRecordsAdapter;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class RecommendedRecordsActivity extends BaseInfoActivity {
    private ListView lv_recommendrecords;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recommendedrecords, null);
        lv_recommendrecords = (ListView) inflate.findViewById(R.id.lv_recommendrecords);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("推荐记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_recommendrecords.setAdapter(new RecommendedRecordsAdapter(this));
    }
}
