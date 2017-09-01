package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.JoinPromotionLuckDrawAdapter;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class RecommendRecordMode extends BaseMode {
    private ListView lv_sub_join_promotionluckdraw;

    public RecommendRecordMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.item_recommendedrecords, null);
        return inflate;
    }
}
