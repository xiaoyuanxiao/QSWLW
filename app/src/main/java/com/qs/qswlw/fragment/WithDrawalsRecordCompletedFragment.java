package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsRecordAdapter;
import com.qs.qswlw.adapter.WithdrawalsRecordCompletedAdapter;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.okhttp.Iview.IWithDrawalsRecordView;
import com.qs.qswlw.okhttp.Presenter.WithDrawalsRecordPersenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class WithDrawalsRecordCompletedFragment extends BaseFragment implements IWithDrawalsRecordView {
    public static String COMPLETED = "";
    public static String PROCESSING = "pre";
    public static String FAILED = "fail";
    int page = 1;
    private ListView lv_withdrawalsrecord;
 //   private SwipeRefreshView swipeRefreshView;
 private RefreshLayout mRefreshLayout;
    private ProgressBar pb_itemforestry;
    private List<WithDrawalsRecordBean.ListBean> listBeen;
    private WithdrawalsRecordCompletedAdapter withdrawalsRecordCompletedAdapter;
    private WithDrawalsRecordPersenter withDrawalsRecordPersenter = new WithDrawalsRecordPersenter(this);
    private WithdrawalsRecordAdapter withdrawalsRecordAdapter;
    private String Gold_type = "";
    private TextView tv_item_withdrawals_headview;


    public static WithDrawalsRecordCompletedFragment newInstance() {
        return new WithDrawalsRecordCompletedFragment();
    }

    public static WithDrawalsRecordCompletedFragment newInstance(String type) {
        WithDrawalsRecordCompletedFragment withDrawalsRecordCompletedFragment = new WithDrawalsRecordCompletedFragment();
        withDrawalsRecordCompletedFragment.setType(type);
        return withDrawalsRecordCompletedFragment;
    }

    private void setType(String Gold_type) {
        this.Gold_type = Gold_type;
    }

    public void adapterNoty() {
        System.out.println("==========adapterNoty=========" + Gold_type);
        page = 1;
        withDrawalsRecordPersenter.getdata(MyApplication.TOKEN, page, Gold_type);
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_withdrawalsrecord, null);
        lv_withdrawalsrecord = (ListView) inflate.findViewById(R.id.lv_fgwithdrawalsrecord);
        View headview = View.inflate(getActivity(), R.layout.item_withdrawals_head, null);
        tv_item_withdrawals_headview = (TextView) headview.findViewById(R.id.tv_item_withdrawals_headview);
        lv_withdrawalsrecord.addHeaderView(headview);
        mRefreshLayout = (RefreshLayout) inflate.findViewById(R.id.refreshLayout);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(false);
        mRefreshLayout.setEnableRefresh(false);
        if (Gold_type.equals(COMPLETED)) {
            tv_item_withdrawals_headview.setText("提现总金额：1000.00");
            withdrawalsRecordCompletedAdapter = new WithdrawalsRecordCompletedAdapter(getActivity(), listBeen);
            lv_withdrawalsrecord.setAdapter(withdrawalsRecordCompletedAdapter);
        } else if (Gold_type.equals(PROCESSING)) {
            tv_item_withdrawals_headview.setText("提现总金额：尚未有提现完成记录");
            withdrawalsRecordCompletedAdapter = new WithdrawalsRecordCompletedAdapter(getActivity(), listBeen);
            lv_withdrawalsrecord.setAdapter(withdrawalsRecordCompletedAdapter);
        } else if (Gold_type.equals(FAILED)) {
            tv_item_withdrawals_headview.setText("提现失败总金额：2000.00");
            withdrawalsRecordAdapter = new WithdrawalsRecordAdapter(getActivity(), listBeen);
            lv_withdrawalsrecord.setAdapter(withdrawalsRecordAdapter);

        }

        withDrawalsRecordPersenter.getdata(MyApplication.TOKEN, page, Gold_type);
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN, page, Gold_type);
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
    public void setdata(WithDrawalsRecordBean withDrawalsRecordBean) {

        List<WithDrawalsRecordBean.ListBean> list = withDrawalsRecordBean.getList();
        mRefreshLayout.finishLoadmore();
        pb_itemforestry.setVisibility(View.GONE);
        lv_withdrawalsrecord.setVisibility(View.VISIBLE);
        if (page ==1&&(list == null || list.size() == 0)) {
            return;
        }else if(page >1&&(list == null || list.size() == 0)){
            mRefreshLayout.finishLoadmoreWithNoMoreData();
            return;
        }
        System.out.println("==========setdata=========" + Gold_type + "====page==="
                + page + "====withDrawalsRecordBean=" + list.size());
        for (WithDrawalsRecordBean.ListBean bean : list) {
            System.out.println("==========getUser_up_fail_info=========" + bean.getUser_up_fail_info());
        }
        if (page == 1)
            listBeen.clear();
        listBeen.addAll(list);
        if (Gold_type.equals(COMPLETED)) {
            withdrawalsRecordCompletedAdapter.notifyDataSetChanged();
        } else if (Gold_type.equals(PROCESSING)) {
            withdrawalsRecordCompletedAdapter.notifyDataSetChanged();
        } else if (Gold_type.equals(FAILED)) {
            withdrawalsRecordAdapter.notifyDataSetChanged();
        }
        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        mRefreshLayout.finishLoadmore();
    }
}
