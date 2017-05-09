package com.qs.qswlw.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.adapter.InteractionDetailAdapter;

/**
 * Created by xiaoyu on 2017/5/9.
 */

public class InteractionDetailActivity extends BaseInfoActivity {

    private ListView lv_interactiondetail;
    private TextView tv_enroll;
    private PopupWindow popupWindow;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_interactiondetail, null);
        lv_interactiondetail = (ListView) inflate.findViewById(R.id.lv_interactiondetail);
        tv_enroll = (TextView) inflate.findViewById(R.id.tv_enroll);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("互动详情");
    }

    @Override
    public void initData() {
        super.initData();
        lv_interactiondetail.setAdapter(new InteractionDetailAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_enroll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch(v.getId()){
            case R.id.tv_enroll:
                showPw(tv_enroll);
                break;
        }
    }

    private void showPw(TextView v) {
        //加载布局
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(this).inflate(
                R.layout.popup_interactiondetail, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, RelativeLayout.LayoutParams.MATCH_PARENT, 500);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
    }
}
