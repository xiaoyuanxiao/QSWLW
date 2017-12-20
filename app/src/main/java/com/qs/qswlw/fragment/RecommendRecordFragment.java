package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecommendedRecordsAdapter;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.okhttp.Iview.IRecommendRecordView;
import com.qs.qswlw.okhttp.Presenter.RecommendedRecordsPersenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import static com.qs.qswlw.R.id.refreshLayout;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class RecommendRecordFragment extends BaseFragment implements IRecommendRecordView {
    public static String JID4 = "jl_d4";
    public static String J1D3 = "jl_d3";
    int page = 1;
    private ListView lv_RecommendRecords;
  //  private SwipeRefreshView swipeRefreshView;
    private List<RecommendedRecordsBean> listBean;
    private RecommendedRecordsAdapter recommendedRecordsAdapter;
    private String Gold_type = "";
    private RecommendedRecordsPersenter recommendedRecordsPersenter = new RecommendedRecordsPersenter(this);
    private EditText edt_recommendrecord_search;
    private Button btn_recommendrecord_search;
    private int a  = 0;
    private RefreshLayout mRefreshLayout;
    private ProgressBar pb_itemforestry;


    public static RecommendRecordFragment newInstance(String type) {//等下
        RecommendRecordFragment withDrawalsRecordCompletedFragment = new RecommendRecordFragment();
        withDrawalsRecordCompletedFragment.setType(type);
        return withDrawalsRecordCompletedFragment;
    }

    private void setType(String Gold_type) {
        this.Gold_type = Gold_type;
    }


    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.sub_recommendrecords, null);
        View inflate1 = View.inflate(getActivity(), R.layout.item_head_recommendrecord, null);
        lv_RecommendRecords = (ListView) inflate.findViewById(R.id.lv_RecommendRecords);
        lv_RecommendRecords.addHeaderView(inflate1);
      //  swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.swipeRefreshView_recommend);
        mRefreshLayout = (RefreshLayout) inflate.findViewById(refreshLayout);
        edt_recommendrecord_search = (EditText) inflate1.findViewById(R.id.edt_recommendrecord_search);
        btn_recommendrecord_search = (Button) inflate1.findViewById(R.id.btn_recommendrecord_search);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBean = new ArrayList<>();
        recommendedRecordsAdapter = new RecommendedRecordsAdapter(getActivity(),listBean);
        lv_RecommendRecords.setAdapter(recommendedRecordsAdapter);
        recommendedRecordsPersenter.getData(MyApplication.TOKEN, page,edt_recommendrecord_search.getText().toString(),Gold_type);
//        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
//            @Override
//            public void onLoad() {
//                recommendedRecordsPersenter.getData(MyApplication.TOKEN, page,edt_recommendrecord_search.getText().toString(),Gold_type);
//            }
//        });
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(false);
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                recommendedRecordsPersenter.getData(MyApplication.TOKEN, page,edt_recommendrecord_search.getText().toString(),Gold_type);
            }
        });
    }


    @Override
    protected void setOnclick() {
        btn_recommendrecord_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_recommendrecord_search:
                page =1;
                a = 1;
                recommendedRecordsPersenter.getData(MyApplication.TOKEN, page,edt_recommendrecord_search.getText().toString(),Gold_type);
                break;
        }
    }

    @Override
    public void setRecommendRecordList(List<RecommendedRecordsBean> list, String recode) {
        mRefreshLayout.finishLoadmore();
        lv_RecommendRecords.setVisibility(View.VISIBLE);
        pb_itemforestry.setVisibility(View.GONE);
        if (page>1&&(list == null || list.size() == 0)) {
            mRefreshLayout.finishLoadmoreWithNoMoreData();
            return;
        }
        if(page==1&&a==1){
            listBean.clear();
        }
        if(list!=null){
            listBean.addAll(list);
        }
        recommendedRecordsAdapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void getdataFaile(String msg) {
        mRefreshLayout.finishLoadmore();
    }
}
