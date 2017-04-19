package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class RecommendActivity extends BaseInfoActivity {

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.recommend_activity, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("推荐注册");
        tv_titlebar_right.setText("推荐记录");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,RecommendedRecordsActivity.class));

                break;
        }
    }
}
