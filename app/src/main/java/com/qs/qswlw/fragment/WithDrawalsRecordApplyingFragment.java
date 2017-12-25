package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsRecordApplyingAdapter;
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

public class WithDrawalsRecordApplyingFragment extends BaseFragment implements IWithDrawalsRecordView {
    int page = 1;
    private ListView lv_withdrawalsrecord;
    //   private SwipeRefreshView swipeRefreshView;
    private RefreshLayout mRefreshLayout;
    private ProgressBar pb_itemforestry;
    private List<WithDrawalsRecordBean.ListBean> listBeen;
    private WithdrawalsRecordApplyingAdapter withdrawalsRecordAdapter;
    private WithDrawalsRecordPersenter withDrawalsRecordPersenter = new WithDrawalsRecordPersenter(this);

    public static WithDrawalsRecordApplyingFragment newInstance() {
        return new WithDrawalsRecordApplyingFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_withdrawalsrecord, null);
        lv_withdrawalsrecord = (ListView) inflate.findViewById(R.id.lv_fgwithdrawalsrecord);
        View headview = View.inflate(getActivity(), R.layout.item_withdrawals_head, null);
        lv_withdrawalsrecord.addHeaderView(headview);
        mRefreshLayout = (RefreshLayout) inflate.findViewById(R.id.refreshLayout);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        withdrawalsRecordAdapter = new WithdrawalsRecordApplyingAdapter(getActivity(), listBeen);
        lv_withdrawalsrecord.setAdapter(withdrawalsRecordAdapter);
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(false);
        mRefreshLayout.setEnableRefresh(false);
        withDrawalsRecordPersenter.getdata(MyApplication.TOKEN, page, "audit");
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN, page, "audit");
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
        if (list == null || list.size() == 0) {
            mRefreshLayout.finishLoadmoreWithNoMoreData();
            return;
        }
        listBeen.addAll(list);
        withdrawalsRecordAdapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        mRefreshLayout.finishLoadmore();
    }
}
