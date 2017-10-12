package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BusinessTurnoverAdapter;
import com.qs.qswlw.bean.BusinessTurnoverBean;
import com.qs.qswlw.okhttp.Iview.IBusinessTurnoverView;
import com.qs.qswlw.okhttp.Presenter.BusinessTurnoverPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class BusinessTurnoverFragment extends BaseFragment implements IBusinessTurnoverView{
    public static int ISHISTORY=0;//今日营业额
    public static int HISTORY=1;//历史营业额
    int page = 1;
    private int type = 0;
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_turnover;
    private BusinessTurnoverAdapter businessTurnoverAdapter;
    private List<BusinessTurnoverBean.ListBean> listBeen;
    private BusinessTurnoverPersenter businessTurnoverPersenter = new BusinessTurnoverPersenter(this);
    private TextView tv_businesstonover_one,tv_businesstonover_two;
    private LinearLayout ll_businesstornover;

    public static BusinessTurnoverFragment newInstance(int type) {
        BusinessTurnoverFragment businessTurnoverFragment = new BusinessTurnoverFragment();
        businessTurnoverFragment.setType(type);
        return businessTurnoverFragment;
    }
    private void setType(int type) {
        this.type = type;
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_businessturnover, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_turnover_sw);
        lv_turnover = (ListView) inflate.findViewById(R.id.lv_turnover);
        View inflate1 = View.inflate(getActivity(), R.layout.item_foot_businesstonover, null);
        tv_businesstonover_one = (TextView) inflate1.findViewById(R.id.tv_businesstonover_one);
        tv_businesstonover_two = (TextView) inflate1.findViewById(R.id.tv_businesstonover_two);
        ll_businesstornover = (LinearLayout) inflate1.findViewById(R.id.ll_businesstornover);
        lv_turnover.addFooterView(inflate1);

        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        businessTurnoverAdapter = new BusinessTurnoverAdapter(getActivity(), listBeen);
        lv_turnover.setAdapter(businessTurnoverAdapter);
        businessTurnoverPersenter.getdata(MyApplication.TOKEN,page,type);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                businessTurnoverPersenter.getdata(MyApplication.TOKEN,page,type);
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
    public void getdata(BusinessTurnoverBean businessTurnoverBean) {

        tv_businesstonover_one.setText(businessTurnoverBean.getCount_money());
        tv_businesstonover_two.setText(businessTurnoverBean.getCount_none());
        List<BusinessTurnoverBean.ListBean> list = businessTurnoverBean.getList();
        swipeRefreshView.setLoading(false);
        if(page==1&&(list == null || list.size() == 0)){
            ll_businesstornover.setVisibility(View.GONE);
            return;
        }

        if (page>1&&(list == null || list.size() == 0)) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        listBeen.addAll(list);
        businessTurnoverAdapter.notifyDataSetChanged();
        page++;

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(getActivity());
    }
}
