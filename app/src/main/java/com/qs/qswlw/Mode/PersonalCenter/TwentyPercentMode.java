package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.Adapter;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class TwentyPercentMode extends BaseMode {
    private ListView lv_sub_entrepreneurialseed;
    public TwentyPercentMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_entrepreneurialseed, null);
        lv_sub_entrepreneurialseed = (ListView)inflate.findViewById(R.id.lv_sub_entrepreneurialseed);
        lv_sub_entrepreneurialseed.setAdapter(new Adapter(context));
        return inflate;
    }
}
