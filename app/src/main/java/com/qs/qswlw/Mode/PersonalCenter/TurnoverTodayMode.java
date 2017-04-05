package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BusinessTurnoverAdapter;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class TurnoverTodayMode extends BaseMode {
    private ListView lv_sub_businessturnover;

    public TurnoverTodayMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_businessturnover, null);
        lv_sub_businessturnover = (ListView) inflate.findViewById(R.id.lv_sub_businessturnover);
        lv_sub_businessturnover.setAdapter(new BusinessTurnoverAdapter(context));
        return inflate;
    }
}
