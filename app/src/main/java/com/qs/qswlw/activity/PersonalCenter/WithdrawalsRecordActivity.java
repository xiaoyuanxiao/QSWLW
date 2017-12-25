package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.WithDrawalsRecordApplyingFragment;
import com.qs.qswlw.fragment.WithDrawalsRecordCompletedFragment;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordActivity extends BaseInfoActivity {

    private TextView tv_one, tv_two, tv_three, tv_four;
    private View view_one, view_two, view_three, view_four;
    private PopupWindow popupWindow;


    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsrecord, null);
        tv_one = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_one);
        tv_two = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_two);
        tv_three = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_three);
        tv_four = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_four);
        view_one = (View) inflate.findViewById(R.id.view_withdrawalsrecord_one);
        view_two = (View) inflate.findViewById(R.id.view_withdrawalsrecord_two);
        view_three = (View) inflate.findViewById(R.id.view_withdrawalsrecord_three);
        view_four = (View) inflate.findViewById(R.id.view_withdrawalsrecord_four);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("提现记录");
        tv_titlebar_right.setText("筛选");
        iv_titlebar_right.setVisibility(View.VISIBLE);
        iv_titlebar_right.setImageResource(R.mipmap.top);

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
        fragments = new ArrayList<Fragment>();
        fragments.add(WithDrawalsRecordApplyingFragment.newInstance());
        fragments.add(WithDrawalsRecordCompletedFragment.newInstance(WithDrawalsRecordCompletedFragment.PROCESSING));
        fragments.add(WithDrawalsRecordCompletedFragment.newInstance(WithDrawalsRecordCompletedFragment.COMPLETED));
        fragments.add(WithDrawalsRecordCompletedFragment.newInstance(WithDrawalsRecordCompletedFragment.FAILED));
        showFragment(fragments.get(2));

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("===========onActivityResult=======" + data);
        if (data == null || !data.getBooleanExtra("isok", false))
            return;
        int id = data.getIntExtra("id", 0);
        Iterator<Fragment> iterator = fragments.iterator();
        while (iterator.hasNext()) {
            Fragment next = iterator.next();
            if (next.isVisible()) {
                ((WithDrawalsRecordCompletedFragment) next).adapterNoty();

            }
        }
    }

    /**
     * 显示fragment
     *
     * @param fragment 要显示的fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.ll_container, fragment, fragment.getClass().getName());
        }
        transaction.commit();
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
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        tv_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_withdrawalsrecord_one:
                setTopColor(tv_one, tv_two, tv_three, tv_four, view_one, view_two, view_three, view_four);
                showFragment(fragments.get(0));

                break;
            case R.id.tv_withdrawalsrecord_two:
                setTopColor(tv_two, tv_one, tv_three, tv_four, view_two, view_one, view_three, view_four);
                showFragment(fragments.get(1));
                break;
            case R.id.tv_withdrawalsrecord_three:
                setTopColor(tv_three, tv_two, tv_one, tv_four, view_three, view_two, view_one, view_four);
                showFragment(fragments.get(2));

                break;
            case R.id.tv_withdrawalsrecord_four:
                setTopColor(tv_four, tv_two, tv_three, tv_one, view_four, view_two, view_three, view_one);
                showFragment(fragments.get(3));

                break;
            case R.id.ll_titlebar_right:
                showpw(ll_titlebar_right);
                break;
        }
    }


    private void setTopColor(TextView tv1, TextView tv2, TextView tv3, TextView tv4, View view1, View view2, View view3, View view4) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.text_blue));
        tv3.setTextColor(getResources().getColor(R.color.text_blue));
        tv4.setTextColor(getResources().getColor(R.color.text_blue));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
        view4.setBackgroundColor(getResources().getColor(R.color.view));
//        page = 1;
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
        popupWindow.showAtLocation(v, Gravity.RIGHT | Gravity.TOP, 0, 100);

    }

    public void setFragmentdata(int i) {
        showFragment(fragments.get(i));
    }
}
