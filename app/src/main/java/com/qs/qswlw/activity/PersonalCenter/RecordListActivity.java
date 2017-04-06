package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.Mode.PersonalCenter.TenPercentSystemMode;
import com.qs.qswlw.Mode.PersonalCenter.TwentyPercentSystemMode;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class RecordListActivity extends BaseActivity {
    private List<BaseMode> viewpagedata;
    private RadioGroup fg_RecordList;
    private View view_RecordList;
    private ViewPager viewpager;

    @Override
    public Object initView() {
        return R.layout.activity_recordlist;
    }

    @Override
    public void initfindviewByid() {
        viewpager = (ViewPager) findViewById(R.id.viewpager_RecordList);
        fg_RecordList = (RadioGroup) findViewById(R.id.fg_RecordList);
        view_RecordList = (View) findViewById(R.id.view_RecordList);
        viewpagedata = new ArrayList<BaseMode>();

        viewpagedata.add(new TenPercentSystemMode(this));
        viewpagedata.add(new TwentyPercentSystemMode(this));
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewpager.setAdapter(adapter);
        viewpagedata.get(0).initData();

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //  WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                /**
                 * 得到红线的宽度
                 */
                int width = getApplicationContext().getResources().getDisplayMetrics().widthPixels / 2;
                //int width = view_EntrepreneurialSeed.getWidth();
                /**
                 * position是划动时左边的页码数，从0开始的，positionOffsetPixels是后一页的页码，  positionOffset是当前页与后一页的划动距离的百分比。（0--0.999999）
                 * setX是view的方法，设置当前view在父布局中距离左边的像素点
                 * */
                view_RecordList.setX(width * (position + positionOffset));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setOnclick() {
        //点击radioButton切换到指定页面
        fg_RecordList.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int position = 0;
            switch (checkedId) {
                case R.id.rb_tenPercentSystem:
                    position = 0;
                    break;
                case R.id.rb_twentyPercentSystem:
                    position = 1;
                    break;
            }
            viewpager.setCurrentItem(position);
            viewpagedata.get(position).initData();
        }
    }

    @Override
    public void onClick(View view) {

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

}
