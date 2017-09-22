package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsBankAdapter;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IMyBankListView;
import com.qs.qswlw.okhttp.Presenter.MyBankListPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

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
    private List<MyBankListBean.CardListBean> card_list;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsbank, null);
        lv_mybanklist = (ListView) inflate.findViewById(R.id.lv_mybanklist);
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
        adapter = new WithdrawalsBankAdapter(this, listBeen);
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

    /**
     * 修改默认银行卡
     *
     * @param token
     * @param id
     */
    private void postData(final String token, final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
                if(mainBean.getSucc()==1){
                    Intent intent=new Intent();
                    setResult(4,intent);
                    finish();
                }
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithdrawalsDefault(token, id);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
        btn_mybanklist_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this, WithdrawalsAddActivity.class));
                break;
            case R.id.btn_mybanklist_confirm:
                postData(MyApplication.TOKEN, Integer.parseInt(card_list.get(MyApplication.POSITION).getId()));
                break;
        }
    }

    @Override
    public void setdata(MyBankListBean myBankListBean) {
        swipeRefreshView.setLoading(false);
        card_list = myBankListBean.getCard_list();
        listBeen.addAll(card_list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void isgetDataFaile(String meg) {

    }
}
