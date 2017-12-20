package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qs.qswlw.Mode.PersonalCenter.RecommendRecordsMode;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.okhttp.Iview.IRecommendRecordView;
import com.qs.qswlw.okhttp.Presenter.RecommendedRecordsPersenter;
import com.qs.qswlw.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class RecommendedRecordsActivity extends BaseInfoActivity implements IRecommendRecordView, RecommendRecordsMode.RemoudeOnLoad {

    int tab_namepage1 = 1, tab_namepage2 = 1;
    int isPage = 1;
    private ViewPager viewpager;
    private List<RecommendRecordsMode> viewpagedata;
    private RadioGroup rg_recommendrecords;
    private TextView tv_consumer, tv_business;
    private RecommendedRecordsPersenter recommendedRecordsPersenter = new RecommendedRecordsPersenter(this);
    private String tab_name1 = "jl_d4";
    private String tab_name2 = "jl_d3";
    private String istab_name = tab_name1;

    @Override
    public void setRecommendRecordList(List<RecommendedRecordsBean> list, String recode) {
        RecommendRecordsMode recommendedRecordsBean;
        if (recode.equals(tab_name1)) {
            recommendedRecordsBean = viewpagedata.get(0);
            tab_namepage1++;
        } else {
            recommendedRecordsBean = viewpagedata.get(1);
            tab_namepage2++;
        }
        if (istab_name.equals(tab_name1))
            isPage = tab_namepage1;
        else isPage = tab_namepage2;
        recommendedRecordsBean.adddata(list);
    }

    @Override
    public void getdataFaile(String msg) {
        ToastUtils.showToast("刷新失败");
        RecommendRecordsMode recommendedRecordsBean;
        if (istab_name.equals(tab_name1)) {
            recommendedRecordsBean = viewpagedata.get(0);
        } else {
            recommendedRecordsBean = viewpagedata.get(1);
        }
    //    recommendedRecordsBean.setLoading(false);
    }

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recommendedrecords, null);
        viewpager = (ViewPager) inflate.findViewById(R.id.viewpager);
        rg_recommendrecords = (RadioGroup) inflate.findViewById(R.id.rg_recommendrecords);
        tv_consumer = (TextView) inflate.findViewById(R.id.tv_consumer);
        tv_business = (TextView) inflate.findViewById(R.id.tv_business);
        viewpagedata = new ArrayList<>();
        //这里不要写什么嘛不要动
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("推荐记录");
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int position = 0;
        switch (v.getId()) {
            case R.id.tv_consumer:
                position = 0;
                tv_consumer.setTextColor(getResources().getColor(R.color.white));
                tv_consumer.setBackgroundColor(getResources().getColor(R.color.tv_green));
                tv_business.setTextColor(getResources().getColor(R.color.red));
                tv_business.setBackgroundColor(getResources().getColor(R.color.white));
                isPage = tab_namepage1;
                istab_name = tab_name1;
//                recommendedRecordsPersenter.getData(MyApplication.TOKEN, tab_namepage1, "", tab_name1);
                break;
            case R.id.tv_business:
                position = 1;
                tv_consumer.setTextColor(getResources().getColor(R.color.red));
                tv_consumer.setBackgroundColor(getResources().getColor(R.color.white));
                tv_business.setTextColor(getResources().getColor(R.color.white));
                tv_business.setBackgroundColor(getResources().getColor(R.color.tv_green));
                isPage = tab_namepage2;
                istab_name = tab_name2;
                //recommendedRecordsPersenter.getData(MyApplication.TOKEN, tab_namepage2, "", tab_name2);
                break;
        }
        viewpager.setCurrentItem(position);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_consumer.setOnClickListener(this);
        tv_business.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        RecommendRecordsMode recommendRecordsMode = new RecommendRecordsMode(this);
        recommendRecordsMode.setRemoudeOnLoad(this);

        viewpagedata.add(recommendRecordsMode);
        RecommendRecordsMode recommendRecordsMode1 = new RecommendRecordsMode(this);
        recommendRecordsMode1.setRemoudeOnLoad(this);
        viewpagedata.add(recommendRecordsMode1);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewpager.setAdapter(adapter);
        isPage = tab_namepage1;
        istab_name = tab_name1;
        getdata();//刷新时改变这个的值
    }

    private void getdata() {
        recommendedRecordsPersenter.getData(MyApplication.TOKEN, isPage, "", istab_name);
    }

    @Override
    public void onLoad() {
        getdata();
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
            return viewpagedata.get(position).view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(viewpagedata.get(position).view);
        }
    }

//    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
//        @Override
//        public void onCheckedChanged(RadioGroup radioGroup, int i) {
//            int position = 0;
//            switch (i) {
//                case R.id.tv_consumer:
//                    position = 0;
//                    break;
//                case R.id.rb_recommendGoldenBean:
//                    position = 1;
//                    break;
//            }
//            viewpager.setCurrentItem(position);
//            viewpagedata.get(position).initData();
//        }
//    }
}
