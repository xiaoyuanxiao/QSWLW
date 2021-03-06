package com.qs.qswlw.activity.PersonalCenter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.qs.qswlw.Mode.BaseMode;
import com.qs.qswlw.Mode.PersonalCenter.JoinRecordMode;
import com.qs.qswlw.Mode.PersonalCenter.WinningRecordMode;
import com.qs.qswlw.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class PromotionLuckDrawActivity extends BaseInfoActivity {
    private List<BaseMode> viewpagedata;
    private RadioGroup fg_promotionLuckDraw;
    private View view_promotionLuckDraw;
    private ViewPager viewpager;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_promotionluckdraw, null);
        viewpager = (ViewPager) inflate.findViewById(R.id.viewpager_promotionLuckDraw);
        fg_promotionLuckDraw = (RadioGroup) inflate.findViewById(R.id.fg_promotionLuckDraw);
        view_promotionLuckDraw = (View) inflate.findViewById(R.id.view_promotionLuckDraw);
        viewpagedata = new ArrayList<BaseMode>();

        viewpagedata.add(new JoinRecordMode(this));
        viewpagedata.add(new WinningRecordMode(this));
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
                view_promotionLuckDraw.setX(width * (position + positionOffset));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("促销抽奖");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        //点击radioButton切换到指定页面
        fg_promotionLuckDraw.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int position = 0;
            switch (checkedId) {
                case R.id.rb_joinRecord:
                    position = 0;
                    break;
                case R.id.rb_winningRecord:
                    position = 1;
                    break;
            }
            viewpager.setCurrentItem(position);
            viewpagedata.get(position).initData();
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
            return viewpagedata.get(position).view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(viewpagedata.get(position).view);
        }
    }

}
