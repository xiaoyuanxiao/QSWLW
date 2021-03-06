package com.qs.qswlw.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.Mode.UnionMonthRankingMode;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BaseInfoActivity;
import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.okhttp.Iview.IRankingView;
import com.qs.qswlw.okhttp.Presenter.RankingPresenter;
import com.qs.qswlw.utils.TextcolorUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class UnionRankingActivity extends BaseInfoActivity implements IRankingView {
    public RankingPresenter rankingPresenter = new RankingPresenter(this);
    private ViewPager viewpager_unionranking;
    private RadioGroup fg_unionranking;
    private List<UnionMonthRankingMode> viewpagedata;
    private RelativeLayout day_ranking, week_ranking, month_ranking;
    private TextView tv_dayranking, tv_weekranking,tv_monthranking;
    private ImageView iv_dayranking, iv_weekranking,iv_monthranking;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_unionranking, null);
        viewpager_unionranking = (ViewPager) inflate.findViewById(R.id.viewpager_unionranking);
        fg_unionranking = (RadioGroup) inflate.findViewById(R.id.fg_unionranking);
        day_ranking = (RelativeLayout) inflate.findViewById(R.id.day_ranking);
        week_ranking = (RelativeLayout) inflate.findViewById(R.id.week_ranking);
        month_ranking = (RelativeLayout) inflate.findViewById(R.id.month_ranking);
        tv_dayranking = (TextView) inflate.findViewById(R.id.tv_dayranking);
        tv_weekranking = (TextView) inflate.findViewById(R.id.tv_weekranking);
        tv_monthranking = (TextView) inflate.findViewById(R.id.tv_monthranking);
        iv_dayranking = (ImageView) inflate.findViewById(R.id.iv_dayranking);
        iv_weekranking = (ImageView) inflate.findViewById(R.id.iv_weekranking);
        iv_monthranking = (ImageView) inflate.findViewById(R.id.iv_monthranking);
        viewpagedata = new ArrayList<>();
        viewpagedata.add(new UnionMonthRankingMode(this, 100));
        viewpagedata.add(new UnionMonthRankingMode(this, 200));
        viewpagedata.add(new UnionMonthRankingMode(this, 300));
        viewpager_unionranking.setOffscreenPageLimit(0);
        rankingPresenter.getdata(0);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("排名榜");
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewpager_unionranking.setAdapter(adapter);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        fg_unionranking.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
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
                setTextBg(day_ranking,week_ranking,month_ranking);
                TextcolorUtil.setTextColor(this,0,tv_dayranking,tv_weekranking,tv_monthranking);
                setImageView(iv_dayranking,iv_weekranking,iv_monthranking);
                position = 0;
                viewpagedata.get(0).initData();
                break;
            case R.id.week_ranking:
                setTextBg(week_ranking,day_ranking,month_ranking);
                TextcolorUtil.setTextColor(this,1,tv_dayranking,tv_weekranking,tv_monthranking);
                setImageView(iv_weekranking,iv_dayranking,iv_monthranking);
                position = 1;
                break;
            case R.id.month_ranking:
                setTextBg(month_ranking,day_ranking,week_ranking);
                TextcolorUtil.setTextColor(this,2,tv_dayranking,tv_weekranking,tv_monthranking);
                setImageView(iv_monthranking,iv_dayranking,iv_weekranking);
                position = 2;
                break;
        }
        viewpager_unionranking.setCurrentItem(position);

    }
    private void setTextBg(RelativeLayout rl1,RelativeLayout rl2,RelativeLayout rl3){
        rl1.setBackgroundColor(getResources().getColor(R.color.red));
        rl2.setBackgroundColor(getResources().getColor(R.color.white));
        rl3.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setImageView(ImageView iv1,ImageView iv2,ImageView iv3){
        iv1.setImageResource(R.mipmap.oo2_03);
        iv2.setImageResource(R.mipmap.oo_03);
        iv3.setImageResource(R.mipmap.oo_03);
    }

    @Override
    public void setRankMondayWek(List<RankingBean.SingleLogBean> list, int recode) {

        //返回请求结果  用0请求的   就到这里来了--是这里的回传*/
        if (recode == 0) {
            viewpagedata.get(0).setdata(list, recode);
            return;
        }

        for (int i = 0; i < viewpagedata.size(); i++) {
            if (viewpagedata.get(i).getCode() == recode) {
                viewpagedata.get(i).setdata(list, recode);
                continue;
            }
        }

    }

    /**
     * 页面切换监听
     */
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int position = 0;
            switch (checkedId) {
                case R.id.day_ranking:
                    position = 0;
                    viewpagedata.get(0).initData();
                    break;
                case R.id.week_ranking:
                    position = 1;
                    break;
                case R.id.month_ranking:
                    position = 2;
                    break;
            }
            viewpager_unionranking.setCurrentItem(position);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewpagedata.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewpagedata.get(position).view);
            viewpagedata.get(position).initData();
            return viewpagedata.get(position).view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(viewpagedata.get(position).view);
        }
    }

}
