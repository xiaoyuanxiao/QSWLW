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
    private View view_EntrepreneurialSeed;
    private ViewPager viewpager;



    @Override
    public Object initView() {
        return R.layout.activity_entrepreneurialseed;
    }

    @Override
    public void initfindviewByid() {
        viewpager = (ViewPager) findViewById(R.id.viewpager_entrepreneurialSeed);
        fg_EntrepreneurialSeed = (RadioGroup) findViewById(R.id.fg_EntrepreneurialSeed);
        view_EntrepreneurialSeed = (View) findViewById(R.id.view_EntrepreneurialSeed);
        viewpagedata = new ArrayList<BaseMode>();

        viewpagedata.add(new TenPercentMode(this));
        viewpagedata.add(new TwentyPercentMode(this));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewpager.setAdapter(adapter);
        viewpagedata.get(0).initData();

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /**
                 * 得到红线的宽度
                 */
                int width = view_EntrepreneurialSeed.getWidth();
                /**
                 * position是划动时左边的页码数，从0开始的，positionOffsetPixels是后一页的页码，  positionOffset是当前页与后一页的划动距离的百分比。（0--0.999999）
                 * setX是view的方法，设置当前view在父布局中距离左边的像素点
                 * */
                view_EntrepreneurialSeed.setX(width * (position + positionOffset));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
