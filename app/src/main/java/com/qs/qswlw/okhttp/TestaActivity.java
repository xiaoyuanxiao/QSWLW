package com.qs.qswlw.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.okhttp.Iview.ITestaView;
import com.qs.qswlw.okhttp.Presenter.TestaPresenter;

import java.util.ArrayList;

/**
 * Created by 小猴子 on 2017/4/7.
 *
 */

public class TestaActivity extends Activity implements ITestaView {
    TextView tv = new TextView(this);

    TestaPresenter testaPresenter = new TestaPresenter(this);

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testaPresenter.login();
            }
        });

    }

    @Override
    public void setText1(String name1) {

        tv.setText(name1);
    }

    @Override
    public void setListData(ArrayList<String> name1) {
        //相应操作
    }

    @Override
    public void setImagSrc(String url) {
        //设置 图片
        tv.setText(url);
    }

    @Override
    public String getMobile() {
        return tv.getText().toString();
    }

    @Override
    public String getPassword() {
        return tv.getText().toString();
    }
}
