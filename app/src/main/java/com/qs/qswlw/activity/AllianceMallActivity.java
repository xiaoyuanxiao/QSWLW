package com.qs.qswlw.activity;

import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.AllianceMallLVAdapter;

/**
 * Created by xiaoyu on 2017/4/24.
 */

public class AllianceMallActivity extends BaseActivity {

    private GridView gv_alliancemall;
    private AllianceMallGVAdapter allianceMallGVAdapter;
    private ListView lv_alliancemall;
    private AllianceMallLVAdapter allianceMallLVAdapter;

    @Override
    public Object initView() {
        return R.layout.activity_alliancemall;
    }

    @Override
    public void initfindviewByid() {
        gv_alliancemall = (GridView) findViewById(R.id.gv_alliancemall);
        lv_alliancemall = (ListView) findViewById(R.id.lv_alliancemall);


    }

    @Override
    public void initData() {
        super.initData();
        allianceMallGVAdapter = new AllianceMallGVAdapter(this);
        allianceMallLVAdapter = new AllianceMallLVAdapter(this);
        gv_alliancemall.setAdapter(allianceMallGVAdapter);
        lv_alliancemall.setAdapter(allianceMallLVAdapter);
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
