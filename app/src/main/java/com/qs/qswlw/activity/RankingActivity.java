package com.qs.qswlw.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.adapter.RankingAdapter;

/**
 * Created by xiaoyu on 2017/4/12.
 */

public class RankingActivity extends BaseInfoActivity {

    private RelativeLayout day_ranking, week_ranking, month_ranking;
    private TextView tv_ranking_left, tv_ranking_right;
    private ImageView iv_dayranking, iv_weekranking, iv_monthranking;
    private TextView tv_dayranking, tv_weekranking, tv_monthranking;
    private ListView lv_ranking;
    private String content;
    private boolean flag;
    private View view_ranking;
    private String footview;
    private RankingAdapter rankingAdapter;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_ranking, null);

        day_ranking = (RelativeLayout) inflate.findViewById(R.id.day_ranking);
        week_ranking = (RelativeLayout) inflate.findViewById(R.id.week_ranking);
        month_ranking = (RelativeLayout) inflate.findViewById(R.id.month_ranking);
        tv_ranking_left = (TextView) inflate.findViewById(R.id.tv_ranking_left);
        tv_ranking_right = (TextView) inflate.findViewById(R.id.tv_ranking_right);
        iv_dayranking = (ImageView) inflate.findViewById(R.id.iv_dayranking);
        iv_weekranking = (ImageView) inflate.findViewById(R.id.iv_weekranking);
        iv_monthranking = (ImageView) inflate.findViewById(R.id.iv_monthranking);
        tv_dayranking = (TextView) inflate.findViewById(R.id.tv_dayranking);
        tv_weekranking = (TextView) inflate.findViewById(R.id.tv_weekranking);
        tv_monthranking = (TextView) inflate.findViewById(R.id.tv_monthranking);
        view_ranking = (View) inflate.findViewById(R.id.view_ranking);
        lv_ranking = (ListView) inflate.findViewById(R.id.lv_ranking);
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
    public void initData() {
        super.initData();
        footview = getIntent().getStringExtra("footview");
        if("unionranking".equals(footview)){
            view_ranking.setVisibility(View.GONE);
            tv_ranking_right.setVisibility(View.GONE);
            tv_ranking_left.setText("联盟商家销售额排名榜");
            rankingAdapter = new RankingAdapter(this);
            lv_ranking.setAdapter(rankingAdapter);
        }else if("angelranking".equals(footview)){
            view_ranking.setVisibility(View.GONE);
            tv_ranking_right.setVisibility(View.GONE);
            tv_ranking_left.setText("创业天使创业排名榜");
        }
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
        switch (v.getId()) {
            case R.id.day_ranking:
                flag = true;
                if (flag) {
                    dayRankingChecked();
                }
                if("unionranking".equals(footview)){

                }else if("angelranking".equals(footview)){

                }else{
                    content = "日排名";
                    showDialog(content);
                }

                break;
            case R.id.week_ranking:
                flag = true;
                if (flag) {
                    weekRankingChecked();
                }
                if("unionranking".equals(footview)){

                }else if("angelranking".equals(footview)){

                }else{
                    content = "周排名";
                    showDialog(content);
                }
                break;
            case R.id.month_ranking:
                flag = true;
                if (flag) {
                    monthRankingChecked();
                }
                if("unionranking".equals(footview)){

                }else if("angelranking".equals(footview)){

                }else{
                    content = "月排名";
                    showDialog(content);
                }

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
                tv_ranking_right.setText(sex[which].substring(0,1)+"管理中心");
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


    /**
     * 日排行选中
     */
    private void dayRankingChecked() {
        day_ranking.setBackgroundColor(this.getResources().getColor(R.color.red));
        iv_dayranking.setImageResource(R.mipmap.oo2_03);
        tv_dayranking.setTextColor(this.getResources().getColor(R.color.white));
        week_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_weekranking.setImageResource(R.mipmap.oo_03);
        tv_weekranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
        month_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_monthranking.setImageResource(R.mipmap.oo_03);
        tv_monthranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
    }

    /**
     * 周排行选中
     */
    private void weekRankingChecked() {
        week_ranking.setBackgroundColor(this.getResources().getColor(R.color.red));
        iv_weekranking.setImageResource(R.mipmap.oo2_03);
        tv_weekranking.setTextColor(this.getResources().getColor(R.color.white));
        day_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_dayranking.setImageResource(R.mipmap.oo_03);
        tv_dayranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
        month_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_monthranking.setImageResource(R.mipmap.oo_03);
        tv_monthranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
    }

    /**
     * 月排行选中
     */
    private void monthRankingChecked() {
        month_ranking.setBackgroundColor(this.getResources().getColor(R.color.red));
        iv_monthranking.setImageResource(R.mipmap.oo2_03);
        tv_monthranking.setTextColor(this.getResources().getColor(R.color.white));
        day_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_dayranking.setImageResource(R.mipmap.oo_03);
        tv_dayranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
        week_ranking.setBackgroundColor(this.getResources().getColor(R.color.white));
        iv_weekranking.setImageResource(R.mipmap.oo_03);
        tv_weekranking.setTextColor(this.getResources().getColor(R.color.tv_ranking));
    }
}
