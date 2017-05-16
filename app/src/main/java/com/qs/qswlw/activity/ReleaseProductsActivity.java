package com.qs.qswlw.activity;

import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class ReleaseProductsActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_releaseproducts, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
    }
}
