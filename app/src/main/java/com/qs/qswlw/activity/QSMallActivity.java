package com.qs.qswlw.activity;

import android.view.View;
import android.widget.GridView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.QSGuessGVAdapter;
import com.qs.qswlw.adapter.QSHotGVAdapter;
import com.qs.qswlw.adapter.QSNewGVAdapter;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class QSMallActivity extends BaseActivity {

    private GridView gv_qsmall,gv_new_qsmall,gv_hot_qsmall,gv_guess_qsmall;

    @Override
    public Object initView() {
        return R.layout.activity_qsmall;
    }

    @Override
    public void initfindviewByid() {
        gv_qsmall = (GridView) findViewById(R.id.gv_qsmall);
        gv_new_qsmall = (GridView) findViewById(R.id.gv_new_qsmall);
        gv_hot_qsmall = (GridView) findViewById(R.id.gv_hot_qsmall);
        gv_guess_qsmall = (GridView) findViewById(R.id.gv_guess_qsmall);

    }

    @Override
    public void initData() {
        super.initData();
        gv_qsmall.setAdapter(new AllianceMallGVAdapter(this));
        gv_new_qsmall.setAdapter(new QSNewGVAdapter(this));
        gv_hot_qsmall.setAdapter(new QSHotGVAdapter(this));
        gv_guess_qsmall.setAdapter(new QSGuessGVAdapter(this));
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
