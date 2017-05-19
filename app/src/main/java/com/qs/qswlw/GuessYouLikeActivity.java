package com.qs.qswlw;

import android.view.View;

import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/5/19.
 */

public class GuessYouLikeActivity extends BaseInfoActivity {
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_guessyoulike, null);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("猜你喜欢");
    }
}
