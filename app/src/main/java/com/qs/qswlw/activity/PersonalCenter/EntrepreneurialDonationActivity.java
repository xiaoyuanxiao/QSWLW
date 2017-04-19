package com.qs.qswlw.activity.PersonalCenter;

import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.view.WheelView;

import java.util.Arrays;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class EntrepreneurialDonationActivity extends BaseInfoActivity {

    private TextView tv_entrepreneurialdonation;
    private static final String[] PLANETS = new String[]{"创业基金", "创新基金"};

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_entrepreneurialdonation, null);
        tv_entrepreneurialdonation = (TextView) inflate.findViewById(R.id.tv_entrepreneurialdonation);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("创业直捐");
        tv_titlebar_right.setText("直捐记录");

    }


    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_entrepreneurialdonation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_entrepreneurialdonation:
                View outerView = LayoutInflater.from(this).inflate(R.layout.wheel_view, null);
                WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
                //  wv.setOffset(1);
                wv.setItems(Arrays.asList(PLANETS));
                wv.setSeletion(0);
                wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                        Log.d("tag", "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                    }
                });
                Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(outerView);
                //dialog.setPositiveButton("完成", null);
                //获得当前窗体
                Window window = dialog.getWindow();
                //重新设置
                WindowManager.LayoutParams lp = window.getAttributes();
                window.setGravity(Gravity.LEFT | Gravity.BOTTOM);
                dialog.show();

              break;
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,EntrepreneurialDonationRecordActivity.class));


                break;
        }
    }



}
