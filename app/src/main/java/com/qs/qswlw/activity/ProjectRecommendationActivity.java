package com.qs.qswlw.activity;

import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class ProjectRecommendationActivity extends BaseInfoActivity {
    private TextView tv_goodProject,tv_goodProduct;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_projectrecommendation, null);
        tv_goodProject = (TextView) inflate.findViewById(R.id.tv_goodProject);
        tv_goodProduct = (TextView) inflate.findViewById(R.id.tv_goodProduct);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("中国好项目");
    }
    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_goodProject.setOnClickListener(this);
        tv_goodProduct.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_goodProject:
                tv_goodProject.setTextColor(this.getResources().getColor(R.color.red));
                tv_goodProduct.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.tv_goodProduct:
                tv_goodProduct.setTextColor(this.getResources().getColor(R.color.red));
                tv_goodProject.setTextColor(this.getResources().getColor(R.color.black));
                break;
        }
    }


}
