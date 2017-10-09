package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecommendedRecordsAdapter;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.okhttp.Iview.IRecommendRecordView;
import com.qs.qswlw.okhttp.Presenter.RecommendedRecordsPersenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class RecommendRecordFragment extends BaseFragment implements IRecommendRecordView {
    public static String JID4 = "jl_d4";
    public static String J1D3 = "jl_d3";
    int page = 1;
    private ListView lv_RecommendRecords;
    private SwipeRefreshView swipeRefreshView;
    private List<RecommendedRecordsBean> listBean;
    private RecommendedRecordsAdapter recommendedRecordsAdapter;
    private String Gold_type = "";
    private RecommendedRecordsPersenter recommendedRecordsPersenter = new RecommendedRecordsPersenter(this);
    private EditText edt_recommendrecord_search;
    private Button btn_recommendrecord_search;
    private int a  = 0;


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
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.swipeRefreshView_recommend);
        edt_recommendrecord_search = (EditText) inflate1.findViewById(R.id.edt_recommendrecord_search);
        btn_recommendrecord_search = (Button) inflate1.findViewById(R.id.btn_recommendrecord_search);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBean = new ArrayList<>();
        recommendedRecordsAdapter = new RecommendedRecordsAdapter(getActivity(),listBean);
        lv_RecommendRecords.setAdapter(recommendedRecordsAdapter);
        recommendedRecordsPersenter.getData(MyApplication.TOKEN, page,edt_recommendrecord_search.getText().toString(),Gold_type);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
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
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        if(page==1&&a==1){
            listBean.clear();
        }
        listBean.addAll(list);
        recommendedRecordsAdapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void getdataFaile(String msg) {
        swipeRefreshView.setLoading(false);
    }
}
