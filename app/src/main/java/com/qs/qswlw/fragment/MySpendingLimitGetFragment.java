package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MySpendingLimitGetAdapter;
import com.qs.qswlw.bean.MySpendingLimitBean;
import com.qs.qswlw.okhttp.Iview.IMySpendingLimitView;
import com.qs.qswlw.okhttp.Presenter.MySpendingLimitPresenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class MySpendingLimitGetFragment extends BaseFragment implements IMySpendingLimitView {

    int page = 1;
    private ListView lv_myspendinglimit;
    private SwipeRefreshView swipeRefreshView;
    private List<MySpendingLimitBean.AddQuotaListBean> listBean;
    private MySpendingLimitGetAdapter mySpendingLimitGetAdapter;
    private MySpendingLimitPresenter mySpendingLimitPresenter = new MySpendingLimitPresenter(this);

    public static MySpendingLimitGetFragment newInstance() {
        MySpendingLimitGetFragment mySpendingLimitFragment = new MySpendingLimitGetFragment();
        return mySpendingLimitFragment;
    }


    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.item_myspendinglimit, null);
        lv_myspendinglimit = (ListView) inflate.findViewById(R.id.lv_myspendinglimit);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_myspendinglimit_sw);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBean = new ArrayList<>();
        mySpendingLimitGetAdapter = new MySpendingLimitGetAdapter(getActivity(),listBean);
        lv_myspendinglimit.setAdapter(mySpendingLimitGetAdapter);
        mySpendingLimitPresenter.getdata(MyApplication.TOKEN,page,0);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                mySpendingLimitPresenter.getdata(MyApplication.TOKEN,page,0);
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
    public void setdata(MySpendingLimitBean mySpendingLimitBean) {
        swipeRefreshView.setLoading(false);
        List<MySpendingLimitBean.AddQuotaListBean> list = mySpendingLimitBean.getAdd_quota_list();
        if (list == null || list.size() == 0) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        listBean.addAll(list);
        mySpendingLimitGetAdapter.notifyDataSetChanged();
        page++;

    }
}
