package com.qs.qswlw.activity.PersonalCenter;

import android.app.Dialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.view.GenderPopupWindow;
import com.qs.qswlw.view.WheelView;

import java.util.Arrays;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class ConsumptionRecordActivity extends BaseActivity {

    private TextView edt_twentypercent;
    private Button btn_selectorfile;
    private static final String[] PLANETS = new String[]{"20%", "10%"};
    private GenderPopupWindow menuWindow;
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
                menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
                menuWindow.showAtLocation(this.findViewById(R.id.tv_isselect_consumptionrecord), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                menuWindow.setTitleName("选择文件");
                menuWindow.setFemaleName("拍照或录像");
                menuWindow.setMaleName("照片图库");
                break;
        }
    } //上传音频文件
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_female:
                  //  pickPhoto();
                    break;
                case R.id.tv_male:
                    //takePhoto();
                    break;
            }
            menuWindow.dismiss();
        }

    }

}
