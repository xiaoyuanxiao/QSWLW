package com.qs.qswlw.activity.PersonalCenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
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
    private Button btn_selectorfile;
    private static final String[] PLANETS = new String[]{"20%", "10%"};

    @Override
    public Object initView() {
        return R.layout.activity_consumptionrecord;
    }

    @Override
    public void initfindviewByid() {
        edt_twentypercent = (TextView) findViewById(R.id.edt_twentypercent_consumptionrecord);
        btn_selectorfile = (Button) findViewById(R.id.btn_selectorfile);

    }

    @Override
    public void setOnclick() {
        edt_twentypercent.setOnClickListener(this);
        btn_selectorfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
                window.setGravity(Gravity.LEFT | Gravity.BOTTOM);
                dialog.show();
                break;
            case R.id.btn_selectorfile:
                showPopwindow();
                break;
        }
    }

        /**
         * 显示popupWindow
         */

    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.popupwindow, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        PopupWindow window = new PopupWindow(view1, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);
        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(this.findViewById(R.id.btn_selectorfile),
                Gravity.BOTTOM, 0, 0);

        //popWindow消失监听方法
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });

    }

}
