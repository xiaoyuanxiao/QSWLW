package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsBankAdapter;
import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.okhttp.Iview.IMyBankListView;
import com.qs.qswlw.okhttp.Presenter.MyBankListPersenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/5/12.
 */

public class WithdrawalsBankActivity extends BaseInfoActivity implements IMyBankListView {
    private ListView lv_mybanklist;
    private MyBankListPersenter myBankListPersenter = new MyBankListPersenter(this);
    private List<MyBankListBean.CardListBean> listBeen;
    private WithdrawalsBankAdapter adapter;
    SwipeRefreshView swipeRefreshView;
    private Button btn_mybanklist_confirm;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsbank, null);
        lv_mybanklist =  (ListView) inflate.findViewById(R.id.lv_mybanklist);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_mybanklist_sw);
        btn_mybanklist_confirm = (Button) inflate.findViewById(R.id.btn_mybanklist_confirm);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("我的银行卡");
        tv_titlebar_right.setText("添加+");



    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        adapter = new WithdrawalsBankAdapter(this,listBeen);
        lv_mybanklist.setAdapter(adapter);
        myBankListPersenter.getdata(MyApplication.TOKEN);
        lv_mybanklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 MyApplication.POSITION = i;
                adapter.notifyDataSetChanged(); //通知ada
            }
        });
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                myBankListPersenter.getdata(MyApplication.TOKEN);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,WithdrawalsAddActivity.class));
                break;
        }
    }

    @Override
    public void setdata(MyBankListBean myBankListBean) {
        swipeRefreshView.setLoading(false);
        List<MyBankListBean.CardListBean> card_list = myBankListBean.getCard_list();
        listBeen.addAll(card_list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void isgetDataFaile(String meg) {

    }
}
