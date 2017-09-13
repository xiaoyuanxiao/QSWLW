package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecommendedRecordsAdapter;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class RecommendRecordsMode extends BaseMode {
    private List<RecommendedRecordsBean> data;
    private ListView lv_recommendRecords;
    private RecommendedRecordsAdapter recommendedRecordsAdapter;
    private SwipeRefreshView mSwipeLayout;
    private ProgressBar pb_itemforestry;

    public RecommendRecordsMode(Context context) {
        super(context);
        recommendedRecordsAdapter = new RecommendedRecordsAdapter(context, data);
        lv_recommendRecords.setAdapter(recommendedRecordsAdapter);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeLayout.setRefreshing(false);
            }
        });
        mSwipeLayout.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                if (remoudeOnLoad != null) {
                    remoudeOnLoad.onLoad();
                }
            }
        });
    }

    public void setRemoudeOnLoad(RemoudeOnLoad remoudeOnLoad) {
        this.remoudeOnLoad = remoudeOnLoad;
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_recommendrecords, null);
        lv_recommendRecords = (ListView) inflate.findViewById(R.id.lv_RecommendRecords);
        data = new ArrayList<>();
        mSwipeLayout = (SwipeRefreshView) inflate.findViewById(R.id.swipeRefreshView_recommend);
        pb_itemforestry = (ProgressBar) inflate.findViewById(R.id.pb_itemforestry);
        return inflate;
    }

    RemoudeOnLoad remoudeOnLoad;

    public interface RemoudeOnLoad {
        void onLoad();
    }

    public void setLoading(boolean b) {
        mSwipeLayout.setLoading(b);
    }

    public SwipeRefreshView getmSwipeLayout() {
        return mSwipeLayout;
    }

    public void adddata(List<RecommendedRecordsBean> data) {
        if(data==null)
            return;
        if (data.size() < 20) {
            mSwipeLayout.setisOnload(false);
            ToastUtils.showToast("没有更多数据了");//你这样只会出一次
        }
        this.data.addAll(data);
        recommendedRecordsAdapter.notifyDataSetChanged();
        setLoading(false);
    }

    public void setdata(List<RecommendedRecordsBean> data) {
        this.data.clear();
        this.data.addAll(data);
        recommendedRecordsAdapter.notifyDataSetChanged();
        setLoading(false);
    }


}
