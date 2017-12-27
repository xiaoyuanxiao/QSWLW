package com.qs.qswlw.activity.mall;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.fragment.MallDetailLeftFragment;
import com.qs.qswlw.fragment.MallDetailRightFragment;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class AllianceMallDetailActivity extends BaseInfoActivity {
    private FragmentManager manager;
    private TextView tv_alliancemalldetail_left,tv_alliancemalldetail_right;
    private MallDetailLeftFragment faleft;
    private MallDetailRightFragment faright;
    private FragmentTransaction transactiona;
    private FragmentTransaction transactionb;
    private FragmentTransaction transaction;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_alliancemalldetail, null);
        tv_alliancemalldetail_left = (TextView) inflate.findViewById(R.id.tv_alliancemalldetail_left);
        tv_alliancemalldetail_right = (TextView) inflate.findViewById(R.id.tv_alliancemalldetail_right);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("店铺详情");
    }

    @Override
    public void initData() {
        super.initData();
        manager=getSupportFragmentManager();//获取fragment管理者
        transaction=manager.beginTransaction();//通过管理者开启事务
        //首先加载第一个界面
        faleft = new MallDetailLeftFragment();
        faright = new MallDetailRightFragment();
        transaction.add(R.id.ll_malldetail, faleft);
        transaction.commit();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_alliancemalldetail_left.setOnClickListener(this);
        tv_alliancemalldetail_right.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_alliancemalldetail_left:
                findViewById(R.id.view_left).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.view_right).setBackgroundColor(getResources().getColor(R.color.view));
                transactiona=manager.beginTransaction();
                transactiona.replace(R.id.ll_malldetail, faleft);
                transactiona.commit();
                break;
            case R.id.tv_alliancemalldetail_right:
                findViewById(R.id.view_right).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.view_left).setBackgroundColor(getResources().getColor(R.color.view));
                transactionb=manager.beginTransaction();
                transactionb.replace(R.id.ll_malldetail, faright);
                transactionb.commit();
                break;

        }
    }
}
