package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.Adapter;

import static com.qs.qswlw.R.id.lv_sub_entrepreneurialseed;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class MyGoldenBeanMode extends BaseMode {
    private ListView lv_sub_myGoldenBean;
    public MyGoldenBeanMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_mygoldenbean, null);
        lv_sub_myGoldenBean = (ListView)inflate.findViewById(R.id.lv_sub_myGoldenBean);
        lv_sub_myGoldenBean.setAdapter(new Adapter(context));
        return inflate;
    }
}
