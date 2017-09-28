package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.fragment.ScanCodeRecordFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ScanCodeRecordActivity extends BaseInfoActivity {

    private TextView tv_scancoderecord_left,tv_scancoderecord_right;

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_scancoderecord, null);
        tv_scancoderecord_left = (TextView) inflate.findViewById(R.id.tv_scancoderecord_left);
        tv_scancoderecord_right = (TextView) inflate.findViewById(R.id.tv_scancoderecord_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("扫码录单详情");
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
        fragments.add(ScanCodeRecordFragment.newInstance(ScanCodeRecordFragment.ISOK));
        fragments.add(ScanCodeRecordFragment.newInstance(ScanCodeRecordFragment.NOOK));
        showFragment(fragments.get(1));

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
        tv_scancoderecord_left.setOnClickListener(this);
        tv_scancoderecord_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_scancoderecord_left:
                setTopColor(tv_scancoderecord_left,tv_scancoderecord_right);
                showFragment(fragments.get(0));
                break;
            case R.id.tv_scancoderecord_right:
                setTopColor(tv_scancoderecord_right,tv_scancoderecord_left);
                showFragment(fragments.get(1));
                break;
        }
    }
    private void setTopColor(TextView tv,TextView tv1){
        tv.setTextColor(this.getResources().getColor(R.color.white));
        tv.setBackgroundColor(this.getResources().getColor(R.color.red));
        tv1.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setBackgroundColor(this.getResources().getColor(R.color.white));
    }
//    @Override
//    public void setData(ScanCodeRecordBean scanCodeRecordBean) {
//        List<ScanCodeRecordBean.ListBean> list = scanCodeRecordBean.getList();
//        swipeRefreshView.setLoading(false);
//        listBeen.clear();
//        if (list == null || list.size() == 0) {
//            return;
//        }
//        listBeen.addAll(list);
//        scanCodeRecordAdapter.notifyDataSetChanged();
//
//
//    }

//    @Override
//    public void setDataRefresh(ScanCodeRecordBean scanCodeRecordBean) {
//        List<ScanCodeRecordBean.ListBean> list = scanCodeRecordBean.getList();
//        swipeRefreshView.setLoading(false);
//        if(page==1){
//            listBeen.clear();
//        }
//        if (list == null || list.size() == 0) {
//            ToastUtils.showToast("没有更多数据了");
//            return;
//        }
//        listBeen.addAll(list);
//        scanCodeRecordAdapter.notifyDataSetChanged();
//
//        page++;
//    }
}
