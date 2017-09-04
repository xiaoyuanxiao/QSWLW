package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecommendedRecordsAdapter;
import com.qs.qswlw.bean.RecommendedRecordsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class RecommendRecordsMode extends BaseMode {
    private List<RecommendedRecordsBean.ResultBean> data;

    private ListView lv_recommendRecords;
    private RecommendedRecordsAdapter recommendedRecordsAdapter;

    public RecommendRecordsMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_recommendrecords, null);
        lv_recommendRecords = (ListView) inflate.findViewById(R.id.lv_RecommendRecords);
        data = new ArrayList<>();
        recommendedRecordsAdapter  =new RecommendedRecordsAdapter(context,data);
        lv_recommendRecords.setAdapter(new RecommendedRecordsAdapter(context,data));

        return inflate;
    }
    public void setdata(List<RecommendedRecordsBean.ResultBean> data) {
        this.data.clear();
        this.data.addAll(data);
        recommendedRecordsAdapter.notifyDataSetChanged();
    }
}
