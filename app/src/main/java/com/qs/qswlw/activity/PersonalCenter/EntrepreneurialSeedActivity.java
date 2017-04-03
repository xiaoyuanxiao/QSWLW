package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class EntrepreneurialSeedActivity extends BaseActivity {
    private List<BaseMode> viewpagedata;
    private RadioGroup fg_EntrepreneurialSeed;
    private ViewPager viewpager;



    @Override
    public Object initView() {
        return R.layout.activity_entrepreneurialseed;
    }

    @Override
    public void initfindviewByid() {
        viewpager = (ViewPager) findViewById(R.id.viewpager_entrepreneurialSeed);
        fg_EntrepreneurialSeed = (RadioGroup) findViewById(R.id.fg_EntrepreneurialSeed);
        viewpagedata = new ArrayList<BaseMode>();

        viewpagedata.add(new TenPercentMode(this));
        viewpagedata.add(new TwentyPercentMode(this));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewpager.setAdapter(adapter);
        viewpagedata.get(0).initData();

    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int position = 0;
            switch (checkedId) {
                case R.id.rb_tenPercent:
                    position = 0;
                    break;
                case R.id.rb_twentyPercent:
                    position = 1;
                    break;
            }
            viewpager.setCurrentItem(position);
            viewpagedata.get(position).initData();
        }
    }

    @Override
    public void setOnclick() {
        //点击radioButton切换到指定页面
        fg_EntrepreneurialSeed.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    @Override
    public void onClick(View view) {

    }


    public class MyViewPagerAdapter extends PagerAdapter
    {
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
}
