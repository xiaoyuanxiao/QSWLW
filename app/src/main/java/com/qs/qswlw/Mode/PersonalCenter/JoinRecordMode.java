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

public class JoinRecordMode extends BaseMode {
    private ListView lv_sub_join_promotionluckdraw;

    public JoinRecordMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_join_promotionluckdraw, null);
        lv_sub_join_promotionluckdraw = (ListView) inflate.findViewById(R.id.lv_sub_join_promotionluckdraw);
        lv_sub_join_promotionluckdraw.setAdapter(new JoinPromotionLuckDrawAdapter(context));
        return inflate;
    }
}
