package com.qs.qswlw.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.adapter.InteractionAdapter;

/**
 * Created by xiaoyu on 2017/4/13.
 */

public class InteractionActivity extends BaseInfoActivity implements AdapterView.OnItemClickListener {
    private ListView lv_interaction;
    private InteractionAdapter interactionAdapter;
    private ImageView iv_interaction;
    private TextView tv_release;


    //定义一个访问图片的数组
    final int[] images = new int[]{
            R.mipmap.bbg_02,
            R.mipmap.bg_head_02,
    };
    int i=0;
    private Handler handler;
    private boolean first = true;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_interaction, null);
        lv_interaction = (ListView) inflate.findViewById(R.id.lv_interaction);
        iv_interaction = (ImageView) inflate.findViewById(R.id.iv_interaction);
        tv_release = (TextView) inflate.findViewById(R.id.tv_release);
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
        iv_interaction.setImageDrawable(getResources().getDrawable(images[0]));
        handler = new Handler();
        showSwitchImg();


    }

    /**
     * 定时切换图片
     */
    private void showSwitchImg() {
        final Runnable myRun = new Runnable() {
            @Override
            public void run() {
                if (true) {  //change to refresh if it is auto mod
                    handler.removeCallbacks(this);
                    handler.postDelayed(this, 4000);

                     //这里功能模块代码
                    if(first){
                        iv_interaction.setImageDrawable(getResources().getDrawable(images[i+1]));
                        i++;
                        first = false;
                    }else{
                        iv_interaction.setImageDrawable(getResources().getDrawable(images[i]));
                    }
                    i++;
                    if (i >= images.length) {
                        i = 0;
                    }
                }
            }
        };
        //使用handler对象来定时启动线程运行
        handler.postDelayed(myRun, 4000);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        iv_interaction.setOnClickListener(this);
        lv_interaction.setOnItemClickListener(this);
        tv_release.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_release:
                startActivity(new Intent(this,PublishInteractiveActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,InteractionDetailActivity.class);
        startActivity(intent);
    }
}
