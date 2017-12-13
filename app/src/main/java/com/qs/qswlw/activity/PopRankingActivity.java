package com.qs.qswlw.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.okhttp.Iview.IRankingView;
import com.qs.qswlw.okhttp.Presenter.RankingPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/8/28.
 */

public class PopRankingActivity extends BaseInfoActivity implements IRankingView {
    public RankingPresenter rankingPresenter = new RankingPresenter(this);
    private ViewPager viewpager_unionranking;
    private RadioGroup fg_unionranking;
    private RelativeLayout day_ranking, week_ranking, month_ranking;
    private TextView tv_ranking_left,tv_ranking_right;
    private String content;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_mainranking, null);
        viewpager_unionranking = (ViewPager) inflate.findViewById(R.id.viewpager_unionranking);
        fg_unionranking = (RadioGroup) inflate.findViewById(R.id.fg_unionranking);
        day_ranking = (RelativeLayout) inflate.findViewById(R.id.day_ranking);
        week_ranking = (RelativeLayout) inflate.findViewById(R.id.week_ranking);
        month_ranking = (RelativeLayout) inflate.findViewById(R.id.month_ranking);
        tv_ranking_left = (TextView) inflate.findViewById(R.id.tv_ranking_left);
        tv_ranking_right = (TextView) inflate.findViewById(R.id.tv_ranking_right);

        return  inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("排名榜");
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
        int position = 0;
        switch (v.getId()) {

            case R.id.day_ranking:
                position = 0;
                content = "日排名";
                showDialog(content);
                break;
            case R.id.week_ranking:
                position = 1;
                content = "周排名";
                showDialog(content);
                break;
            case R.id.month_ranking:
                position = 2;
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
        builder.setSingleChoiceItems(sex, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                tv_ranking_left.setText(content);
                tv_ranking_right.setText(sex[which].substring(0, 1) + "管理中心");
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void setRankMondayWek(List<RankingBean.SingleLogBean> list, int recode) {

    }



}
