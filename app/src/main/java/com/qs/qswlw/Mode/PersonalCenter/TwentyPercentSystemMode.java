package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecordListAdapter;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class TwentyPercentSystemMode extends BaseMode {
    private ListView lv_sub_recordList;
    public TwentyPercentSystemMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_recordlist, null);
        ListView lv_sub_recordList = (ListView) inflate.findViewById(R.id.lv_sub_recordList);
        lv_sub_recordList.setAdapter(new RecordListAdapter(context));
        return  inflate;
    }
}
