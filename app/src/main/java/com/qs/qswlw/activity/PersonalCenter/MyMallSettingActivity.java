package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.RelativeLayout;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/10/16.
 */

public class MyMallSettingActivity extends BaseInfoActivity {

    private RelativeLayout title;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mymallsetting, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        title = (RelativeLayout) findViewById(R.id.title);
        title.setVisibility(View.GONE);
    }
}
