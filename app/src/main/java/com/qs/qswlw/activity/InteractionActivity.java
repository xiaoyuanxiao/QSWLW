package com.qs.qswlw.activity;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.adapter.InteractionAdapter;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class InteractionActivity extends BaseInfoActivity {
    private ListView lv_interaction;
    private InteractionAdapter interactionAdapter;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_interaction, null);
        lv_interaction = (ListView) inflate.findViewById(R.id.lv_interaction);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("互动吧");
    }

    @Override
    public void initData() {
        super.initData();
        interactionAdapter = new InteractionAdapter(this);
        lv_interaction.setAdapter(interactionAdapter);
    }
}
