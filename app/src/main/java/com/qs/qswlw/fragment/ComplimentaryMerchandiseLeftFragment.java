package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ComplimentaryMerchandiseRecordAdapter;
import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.okhttp.Iview.IComplimentaryMerchandiseRecordView;
import com.qs.qswlw.okhttp.Presenter.ComplimentaryMerchandiseRecordPresenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class ComplimentaryMerchandiseLeftFragment extends BaseFragment implements IComplimentaryMerchandiseRecordView{

    ComplimentaryMerchandiseRecordPresenter complimentaryMerchandiseRecordPresenter = new ComplimentaryMerchandiseRecordPresenter(this);
    int page = 1;
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_complimentarymerchandiseleft;
    private List<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> listBean;
    private ComplimentaryMerchandiseRecordAdapter adapter;

    public static ComplimentaryMerchandiseLeftFragment newInstance() {
        ComplimentaryMerchandiseLeftFragment fragment = new ComplimentaryMerchandiseLeftFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_complimentarymerchandiseleft, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_complimentarymerchandiseleft_sw);
        lv_complimentarymerchandiseleft = (ListView) inflate.findViewById(R.id.lv_complimentarymerchandiseleft);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBean = new ArrayList<>();
        adapter = new ComplimentaryMerchandiseRecordAdapter(getActivity(),listBean);
        lv_complimentarymerchandiseleft.setAdapter(adapter);
        complimentaryMerchandiseRecordPresenter.getdata(MyApplication.TOKEN,page,1);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                complimentaryMerchandiseRecordPresenter.getdata(MyApplication.TOKEN,page,1);
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
    public void setdata(ComplimentaryMerchandiseRecordBean complimentaryMerchandiseRecordBean) {
        List<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> list = complimentaryMerchandiseRecordBean.getGoodsInfo();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        listBean.addAll(list);
        adapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }
}
