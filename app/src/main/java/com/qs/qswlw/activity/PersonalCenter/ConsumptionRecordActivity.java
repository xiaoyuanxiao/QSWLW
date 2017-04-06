package com.qs.qswlw.activity.PersonalCenter;

import android.app.Dialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.view.WheelView;

import java.util.Arrays;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class ConsumptionRecordActivity extends BaseActivity {

    private TextView edt_twentypercent;
    private static final String[] PLANETS = new String[]{"20%", "10%"};
    @Override
    public Object initView() {
        return R.layout.activity_consumptionrecord;
    }

    @Override
    public void initfindviewByid() {
        edt_twentypercent = (TextView) findViewById(R.id.edt_twentypercent_consumptionrecord);

    }

    @Override
    public void setOnclick() {
        edt_twentypercent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edt_twentypercent_consumptionrecord:
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
                window .setGravity(Gravity.LEFT | Gravity.BOTTOM);
                dialog.show();

                break;
        }
    }

    private int[] ids ={R.mipmap.left,R.mipmap.down};
}
