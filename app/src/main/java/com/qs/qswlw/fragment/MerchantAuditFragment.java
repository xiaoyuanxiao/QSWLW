package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MerchantAuditAdapter;
import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditView;
import com.qs.qswlw.okhttp.Presenter.MerchantAuditPersenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class MerchantAuditFragment extends BaseFragment implements IMerchantAuditView {
    public static int IS_OK = 1;
    public static int NO_OK = 0;
    int page = 1;
    private int type = 0;
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_merchantaudit;
    private MerchantAuditAdapter merchantAuditAdapter;
    private List<MerchantAuditBean.ListBean> listBeen;
    private MerchantAuditPersenter merchantAuditPersenter = new MerchantAuditPersenter(this);


    public static MerchantAuditFragment newInstance(int type) {
        MerchantAuditFragment merchantAuditFragment = new MerchantAuditFragment();
        merchantAuditFragment.setType(type);
        return merchantAuditFragment;
    }

    private void setType(int type) {
        this.type = type;
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_merchantaudit, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_merchantaudit_sw);
        lv_merchantaudit = (ListView) inflate.findViewById(R.id.lv_merchantaudit);
        View inflate1 = View.inflate(getActivity(), R.layout.item_foot_merchantaudit, null);
        lv_merchantaudit.addFooterView(inflate1);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        merchantAuditAdapter = new MerchantAuditAdapter(getActivity(), listBeen);
        lv_merchantaudit.setAdapter(merchantAuditAdapter);
        merchantAuditPersenter.getdata(MyApplication.TOKEN, page, type);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                merchantAuditPersenter.getdata(MyApplication.TOKEN, page, type);
            }
        });

    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setData(MerchantAuditBean merchantAuditBean) {
        List<MerchantAuditBean.ListBean> list = merchantAuditBean.getList();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            return;
        }
        if (page == 1)
            listBeen.clear();
        listBeen.addAll(list);
        merchantAuditAdapter.notifyDataSetChanged();
        page++;
    }
}
