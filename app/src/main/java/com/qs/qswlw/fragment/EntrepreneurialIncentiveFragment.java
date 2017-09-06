package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.EntrepreneurialAdapter;
import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;
import com.qs.qswlw.okhttp.Iview.IEntrepreneurialView;
import com.qs.qswlw.okhttp.Presenter.EntrepreneurialPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public class EntrepreneurialIncentiveFragment extends BaseFragment implements IEntrepreneurialView {
    private ListView lv_sub_entrepreneurialseed;
    private EntrepreneurialPresenter entrepreneurialPresenter = new EntrepreneurialPresenter(this);
    private TextView tv_entrepreneurial_one,tv_entrepreneurial_two,tv_entrepreneurial_three,tv_entrepreneurial_four,tv_entrepreneurial_model;
    private List<EntrepreneurialIncentiveBean.ListModel1Bean> entrepreneurialList;
    private EntrepreneurialAdapter entrepreneurialAdapter;

    public static EntrepreneurialIncentiveFragment newInstener() {
        return new EntrepreneurialIncentiveFragment();
    }
    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.sub_entrepreneurialseed, null);
        lv_sub_entrepreneurialseed = (ListView)inflate.findViewById(R.id.lv_sub_entrepreneurialseed);
        tv_entrepreneurial_one = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_one);
        tv_entrepreneurial_two = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_two);
        tv_entrepreneurial_three = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_three);
        tv_entrepreneurial_four = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_four);
        tv_entrepreneurial_model = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_model);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        entrepreneurialList = new ArrayList<>();
        entrepreneurialAdapter = new EntrepreneurialAdapter(activity,entrepreneurialList);
        lv_sub_entrepreneurialseed.setAdapter(entrepreneurialAdapter);
        entrepreneurialPresenter.getdata(MyApplication.TOKEN,1,"model1");
    }

    @Override
    public void setEntrepreneurialData(EntrepreneurialIncentiveBean entrepreneurialData) {
        String allow_silver = entrepreneurialData.getAllow_silver();
        tv_entrepreneurial_one.setText("消费银豆："+entrepreneurialData.getSilver()+"");
        tv_entrepreneurial_two.setText("可转为创业种子消费银豆："+allow_silver);
        int i = Integer.parseInt(allow_silver) / (Integer.parseInt(entrepreneurialData.getExchange_love()));
        tv_entrepreneurial_three.setText("正在激励创业种子："+entrepreneurialData.getLove()+"");
        tv_entrepreneurial_four.setText("可转为创业种子数："+i+"");
        tv_entrepreneurial_model.setText(entrepreneurialData.getModel1()+"");
        entrepreneurialList.clear();
        entrepreneurialList.addAll(entrepreneurialData.getList_model1());
        entrepreneurialAdapter.notifyDataSetChanged();
    }


}
