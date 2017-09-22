package com.qs.qswlw.activity;

import android.view.View;
import android.widget.ImageView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2016/4/1.
 */
public class SplashActivity extends BaseActivity {
    private ImageView iv_splash;

    @Override
    public Object initView() {
      //  MainActivity.observable.addObserver(this);
        View inflate = View.inflate(this, R.layout.activity_splash, null);
        iv_splash = (ImageView) inflate.findViewById(R.id.iv_splash);
        return inflate;
    }

    @Override
    protected void onDestroy() {
      //  MainActivity.observable.deleteObserver(this);
        super.onDestroy();
    }

    @Override
    public void initfindviewByid() {

    }

    @Override
    public void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

//    @Override
//    public void update(Observable observable, Object o) {
//        finish();
//    }
}
