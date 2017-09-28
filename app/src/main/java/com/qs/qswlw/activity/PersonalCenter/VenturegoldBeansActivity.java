package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.MyGoldBeanFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class VenturegoldBeansActivity extends BaseInfoActivity {

    MyGoldBeanFragment ishowfragment;
    private FragmentManager fragmentManager;
    private TextView tv_venturegold_left, tv_venturegold_center, tv_venturegold_right;
    private View view_left, view_center, view_right;
    private LinearLayout ll_venturegold_container;
    private ArrayList<MyGoldBeanFragment> fragments;
    private boolean isselected = false;
    private PopupWindow popupWindow;
    private String type;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_venturegoldbean, null);
        tv_venturegold_left = (TextView) inflate.findViewById(R.id.tv_venturegold_left);
        tv_venturegold_center = (TextView) inflate.findViewById(R.id.tv_venturegold_center);
        tv_venturegold_right = (TextView) inflate.findViewById(R.id.tv_venturegold_right);
        view_left = (View) inflate.findViewById(R.id.view_left);
        view_center = (View) inflate.findViewById(R.id.view_center);
        view_right = (View) inflate.findViewById(R.id.view_right);
        ll_venturegold_container = (LinearLayout) inflate.findViewById(R.id.ll_venturegold_container);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的金豆");
        tv_titlebar_right.setText("筛选");
        iv_titlebar_right.setVisibility(View.VISIBLE);
        iv_titlebar_right.setImageResource(R.mipmap.down);
    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();
    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(MyGoldBeanFragment.newInstance(""));
        fragments.add(MyGoldBeanFragment.newInstance(MyGoldBeanFragment.TJJD));
        fragments.add(MyGoldBeanFragment.newInstance(MyGoldBeanFragment.GIVE));
        showFragment(fragments.get(0));
    }

    /**
     * 显示fragment
     *
     * @param fragment 要显示的fragment
     */
    private void showFragment(MyGoldBeanFragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.ll_venturegold_container, fragment, fragment.getClass().getName());
        }
        transaction.commit();
        ishowfragment = fragment;
    }

    /**
     * 隐藏其他fragment
     *
     * @param transaction 控制器
     */
    private void hideFragment(FragmentTransaction transaction) {
        for (int i = 0; fragments.size() > i; i++) {
            if (fragments.get(i).isVisible()) {
                transaction.hide(fragments.get(i));
            }
        }
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_venturegold_left.setOnClickListener(this);
        tv_venturegold_center.setOnClickListener(this);
        tv_venturegold_right.setOnClickListener(this);
        ll_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_venturegold_left:
                setView(tv_venturegold_left, tv_venturegold_center, tv_venturegold_right, view_left, view_center, view_right);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_venturegold_center:
                setView(tv_venturegold_center, tv_venturegold_left, tv_venturegold_right, view_center, view_left, view_right);
                showFragment(fragments.get(1));
                break;
            case R.id.tv_venturegold_right:
                setView(tv_venturegold_right, tv_venturegold_center, tv_venturegold_left, view_right, view_center, view_left);
                showFragment(fragments.get(2));
                break;
            case R.id.ll_titlebar_right:
                int i = isselected ? R.mipmap.down : R.mipmap.top;
                iv_titlebar_right.setImageResource(i);
                showPW();
                break;
            case R.id.tv_pw_day:
                setType("today");
                break;
            case R.id.tv_pw_week:
                setType("week");
                break;
            case R.id.tv_pw_month:
                setType("month");
                break;
        }
    }

    /**
     * 筛选弹框
     */
    private void showPW() {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pw_withdrawals, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(ll_titlebar_right, Gravity.TOP | Gravity.RIGHT, 10, 120);
        TextView tv_pw_day = (TextView) layout.findViewById(R.id.tv_pw_day);
        TextView tv_pw_week = (TextView) layout.findViewById(R.id.tv_pw_week);
        TextView tv_pw_month = (TextView) layout.findViewById(R.id.tv_pw_month);
        tv_pw_day.setOnClickListener(this);
        tv_pw_week.setOnClickListener(this);
        tv_pw_month.setOnClickListener(this);


    }

    private void setView(TextView tv1, TextView tv2, TextView tv3, View view1, View view2, View view3) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.black));
        tv3.setTextColor(getResources().getColor(R.color.black));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        ishowfragment.refreshlist();
    }
}
