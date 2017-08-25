package com.qs.qswlw.Mode;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RankingAdapter;
import com.qs.qswlw.bean.RankingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class UnionWeakRankingMode extends BaseMode {
    private ListView lv_sub_unionweakranking;
    List<RankingBean.SingleLogBean> data;
    public UnionWeakRankingMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_unionweakranking, null);
        lv_sub_unionweakranking = (ListView)inflate.findViewById(R.id.lv_sub_unionweakranking);
        data = new ArrayList<RankingBean.SingleLogBean>();
        lv_sub_unionweakranking.setAdapter(new RankingAdapter(context, data));
        return inflate;
    }
}
