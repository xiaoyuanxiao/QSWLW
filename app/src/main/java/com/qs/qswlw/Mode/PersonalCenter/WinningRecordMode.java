package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WinningPromotionLuckDrawAdapter;


/**
 * Created by xiaoyu on 2017/4/6.
 */

public class WinningRecordMode extends BaseMode {

    private ListView lv_sub_winning_promotionluckdraw;

    public WinningRecordMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_winning_promotionluckdraw, null);
        lv_sub_winning_promotionluckdraw = (ListView) inflate.findViewById(R.id.lv_sub_winning_promotionluckdraw);
        lv_sub_winning_promotionluckdraw.setAdapter(new WinningPromotionLuckDrawAdapter(context));
        return inflate;
    }
}
