package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MerchantAuditAdapter;
import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditView;
import com.qs.qswlw.okhttp.Presenter.MerchantAuditPersenter;
import com.qs.qswlw.view.xlistview.IXListViewLoadMore;
import com.qs.qswlw.view.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditActivity extends BaseInfoActivity implements IMerchantAuditView {

    private TextView tv_merchantaudit_left,tv_merchantaudit_right;
    private XListView lv_merchantaudit;
    int page = 1;
    private MerchantAuditPersenter merchantAuditPersenter = new MerchantAuditPersenter(this);
    int is_ok = 0;
    private List<MerchantAuditBean.ListBean> listBeen;
    private MerchantAuditAdapter merchantAuditAdapter;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_merchantaudit, null);
        tv_merchantaudit_left = (TextView) inflate.findViewById(R.id.tv_merchantaudit_left);
        tv_merchantaudit_right = (TextView) inflate.findViewById(R.id.tv_merchantaudit_right);
        lv_merchantaudit = (XListView) inflate.findViewById(R.id.lv_merchantaudit);
        //上拉监听
        lv_merchantaudit.setPullLoadEnable(mLoadMoreListener);
        return inflate;
    }
    /**
     *  上拉监听
     */
    private IXListViewLoadMore mLoadMoreListener = new IXListViewLoadMore() {
        @Override
        public void onLoadMore() {
            Toast.makeText(MerchantAuditActivity.this, "上拉", Toast.LENGTH_SHORT).show();
            page++;
            merchantAuditPersenter.getdataRefresh(MyApplication.TOKEN,page,is_ok);
        }
    };
    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("商家审核");
    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        merchantAuditAdapter = new MerchantAuditAdapter(this,listBeen);
        lv_merchantaudit.setAdapter(merchantAuditAdapter);
        merchantAuditPersenter.getdata(MyApplication.TOKEN,page,is_ok);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_merchantaudit_left.setOnClickListener(this);
        tv_merchantaudit_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_merchantaudit_left:
                setTopColor(tv_merchantaudit_left,tv_merchantaudit_right);
                is_ok= 1;
                merchantAuditPersenter.getdata(MyApplication.TOKEN,page,is_ok);
                break;
            case R.id.tv_merchantaudit_right:
                setTopColor(tv_merchantaudit_right,tv_merchantaudit_left);
                is_ok = 0;
                merchantAuditPersenter.getdata(MyApplication.TOKEN,page,is_ok);
                break;
        }

    }
    private void setTopColor(TextView tv,TextView tv1){
        tv.setTextColor(this.getResources().getColor(R.color.white));
        tv.setBackgroundColor(this.getResources().getColor(R.color.red));
        tv1.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setBackgroundColor(this.getResources().getColor(R.color.white));
    }

    @Override
    public void setData(MerchantAuditBean merchantAuditBean) {
        listBeen.clear();
        List<MerchantAuditBean.ListBean> list = merchantAuditBean.getList();
        if(list!=null) {
            listBeen.addAll(list);
        }

        merchantAuditAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDataRefresh(MerchantAuditBean merchantAuditBean) {
        List<MerchantAuditBean.ListBean> list = merchantAuditBean.getList();
        if (list == null || list.size() == 0) {
            lv_merchantaudit.noMoreForShow();
            return;
        }
        listBeen.addAll(list);
        merchantAuditAdapter.notifyDataSetChanged();
        lv_merchantaudit.stopLoadMore();
    }
}
