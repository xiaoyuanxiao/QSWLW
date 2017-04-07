package com.qs.qswlw.Mode.PersonalCenter;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyGoldenBeanAdapter;


/**
 * Created by xiaoyu on 2017/4/5.
 */

public class RecommendGoldenBeanMode extends BaseMode {
    private ListView lv_sub_myGoldenBean;
    private TextView tv_outgoingSeed;
    public RecommendGoldenBeanMode(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_mygoldenbean, null);
        lv_sub_myGoldenBean = (ListView)inflate.findViewById(R.id.lv_sub_myGoldenBean);
        tv_outgoingSeed = (TextView) inflate.findViewById(R.id.tv_outgoingSeed);
        tv_outgoingSeed.setVisibility(View.GONE);
        lv_sub_myGoldenBean.setAdapter(new MyGoldenBeanAdapter(context,false));
        return inflate;
    }
}
