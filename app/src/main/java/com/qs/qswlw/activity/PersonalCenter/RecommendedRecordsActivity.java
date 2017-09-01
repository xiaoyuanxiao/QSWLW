package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.qs.qswlw.Mode.PersonalCenter.RecommendRecordMode;
import com.qs.qswlw.R;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class RecommendedRecordsActivity extends BaseInfoActivity {

    private ViewPager viewpager;
    private List<RecommendRecordMode> viewpagedata;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recommendedrecords, null);
        viewpager = (ViewPager) inflate.findViewById(R.id.viewpager);
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
    }
}
