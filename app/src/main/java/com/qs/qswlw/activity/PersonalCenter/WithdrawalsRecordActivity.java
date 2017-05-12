package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsRecordAdapter;


/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordActivity extends BaseInfoActivity {

    private TextView tv_withdrawalsed,tv_withdrawalsing;
    private View view_left,view_right;
    private ListView lv_withdrawalsrecord;
    private PopupWindow popupWindow;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsrecord, null);
        tv_withdrawalsed = (TextView) inflate.findViewById(R.id.tv_withdrawalsed);
        tv_withdrawalsing = (TextView) inflate.findViewById(R.id.tv_withdrawalsing);
        view_left = (View) inflate.findViewById(R.id.view_left);
        view_right = (View) inflate.findViewById(R.id.view_right);
        lv_withdrawalsrecord = (ListView) inflate.findViewById(R.id.lv_withdrawalsrecord);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("提现记录");
        tv_titlebar_right.setText("筛选");
        iv_titlebar_right.setVisibility(View.VISIBLE);
        iv_titlebar_right.setImageResource(R.mipmap.left);

    }

    @Override
    public void initData() {
        super.initData();
        lv_withdrawalsrecord.setAdapter(new WithdrawalsRecordAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_withdrawalsed.setOnClickListener(this);
        tv_withdrawalsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_withdrawalsed:
                tv_withdrawalsed.setTextColor(getResources().getColor(R.color.red));
                tv_withdrawalsing.setTextColor(getResources().getColor(R.color.black));
                view_left.setVisibility(View.VISIBLE);
                view_left.setBackgroundColor(getResources().getColor(R.color.red));
                view_right.setVisibility(View.INVISIBLE);
                break;
            case R.id.tv_withdrawalsing:
                tv_withdrawalsing.setTextColor(getResources().getColor(R.color.red));
                tv_withdrawalsed.setTextColor(getResources().getColor(R.color.black));
                view_right.setBackgroundColor(getResources().getColor(R.color.red));
                view_right.setVisibility(View.VISIBLE);
                view_left.setVisibility(View.INVISIBLE);
                break;
            case R.id.ll_titlebar_right:
                showpw(ll_titlebar_right);
                break;
        }
    }

    private void showpw(LinearLayout v) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pw_withdrawals, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, 150, LinearLayout.LayoutParams.WRAP_CONTENT);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.RIGHT|Gravity.TOP,0,100);

    }
}
