package com.qs.qswlw.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class RankingActivity extends BaseInfoActivity {

    private RelativeLayout day_ranking,week_ranking,month_ranking;
    private TextView tv_ranking_left,tv_ranking_right;
    private String content;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_ranking, null);

        day_ranking = (RelativeLayout) inflate.findViewById(R.id.day_ranking);
        week_ranking = (RelativeLayout) inflate.findViewById(R.id.week_ranking);
        month_ranking = (RelativeLayout) inflate.findViewById(R.id.month_ranking);
        tv_ranking_left = (TextView) inflate.findViewById(R.id.tv_ranking_left);
        tv_ranking_right = (TextView) inflate.findViewById(R.id.tv_ranking_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        /**
         * title设置
         */
        tv_titlebar_center.setText("排名榜");
        tv_titlebar_center.setTextColor(this.getResources().getColor(R.color.white));
        title.setBackgroundColor(this.getResources().getColor(R.color.red));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        day_ranking.setOnClickListener(this);
        week_ranking.setOnClickListener(this);
        month_ranking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.day_ranking:
                content = "日排名";
                showDialog(content);
                break;
            case R.id.week_ranking:
                content = "周排名";
                showDialog(content);
                break;
            case R.id.month_ranking:
                content = "月排名";
                showDialog(content);
                break;
        }
    }

    private void showDialog(final String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] sex = {"省代", "市代", "区代"};
        /**
         *  设置一个单项选择下拉框
         */
        builder.setSingleChoiceItems(sex, 1, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                tv_ranking_left.setText(content);
                tv_ranking_right.setText(sex[which]);
             //   Toast.makeText(RankingActivity.this, "选择了：" + sex[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void initData() {
        super.initData();
    }
}
