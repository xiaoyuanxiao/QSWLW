package com.qs.qswlw.Mode;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.MainRankingActivity;
import com.qs.qswlw.adapter.RankingAdapter;
import com.qs.qswlw.bean.RankingBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MainRankingMode extends BaseMode {
    private ListView lv_sub_unionmonthranking;
    private int code = 100;
    List<RankingBean.SingleLogBean> data;

    public MainRankingMode(Context context, int code) {
        super(context);
        this.code = code;

    }

    RankingAdapter rankingAdapter;

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_unionmonthranking, null);
        lv_sub_unionmonthranking = (ListView) inflate.findViewById(R.id.lv_sub_unionmonthranking);
        data = new ArrayList<RankingBean.SingleLogBean>();

        rankingAdapter = new RankingAdapter(context, data);
        lv_sub_unionmonthranking.setAdapter(rankingAdapter);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        if (data != null && data.size() != 0) {
            return;
        }
        ((MainRankingActivity) context).rankingPresenter.getdata(code);
    }

    public void setdata(List<RankingBean.SingleLogBean> data) {
        this.data.clear();
        this.data.addAll(data);
        rankingAdapter.notifyDataSetChanged();
    }
}
