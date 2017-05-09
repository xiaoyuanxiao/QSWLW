package com.qs.qswlw.activity;

import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.view.MyGifView;

/**
 * Created by xiaoyu on 2017/5/9.
 */

public class LuckGameActivity extends BaseInfoActivity {

    private MyGifView gif_luckgame;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_luckgame, null);
        gif_luckgame = (MyGifView) inflate.findViewById(R.id.gif_luckgame);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("促销抽奖");
        tv_titlebar_right.setText("抽奖记录");
    }

    @Override
    public void initData() {
        super.initData();
        gif_luckgame.setMovieResource(R.raw.chouqian);
    }
}
