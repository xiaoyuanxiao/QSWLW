package com.qs.qswlw.activity.mall;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.adapter.QSMallLVAdapter;
import com.qs.qswlw.adapter.QSMallTopAdapter;
import com.qs.qswlw.adapter.QSMallTwoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 import com.bumptech.glide.Glide;
 import com.qs.qswlw.R;
 import com.qs.qswlw.activity.BaseActivity;
 import com.qs.qswlw.adapter.QSMallLVAdapter;
 import com.qs.qswlw.adapter.QSMallTopAdapter;
 import com.qs.qswlw.adapter.QSMallTwoAdapter;

 import java.util.ArrayList;
 import java.util.List;

 * Created by xiaoyu on 2017/4/25.
 */

public class QSMallActivity1 extends BaseActivity {
    private ViewPager viewpager;
    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            viewpager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        }

    };
    private ImageView dot_focus;
    private ImageView dot_blur;
    private ImageView dot3;
    private ImageView dot4;
    private String[] imgUrlArr;
    private List<ImageView> imgList;
    private int num = 300;//起始位置300
    private GridView gv_qsmall,gv_new_qsmall;
    private ListView lv_alliancemall;
    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        public void run() {
            // 每隔多长时间执行一次
            /**
             * mHandler.postDelayed(mRunnable, 1000*PhoneConstans.TIMEVALUE);
             */
            mHandler.postDelayed(mRunnable, 1000 * 3);
            num++;
            viewHandler.sendEmptyMessage(num);
        }

    };

    @Override
    public Object initView() {
        return R.layout.activity_qsmall1;
    }

    @Override
    public void initfindviewByid() {
        viewpager=(ViewPager) findViewById(R.id.mViewPager);
        dot_focus=(ImageView) findViewById(R.id.dot1);
        dot_blur=(ImageView) findViewById(R.id.dot2);
        dot3=(ImageView) findViewById(R.id.dot3);
        dot4=(ImageView) findViewById(R.id.dot4);
        gv_qsmall = (GridView) findViewById(R.id.gv_qsmall);
        gv_new_qsmall = (GridView) findViewById(R.id.gv_new_qsmall);
        lv_alliancemall = (ListView) findViewById(R.id.lv_alliancemall);
        imgUrlArr=new String[]{"http://fengshouguo.com/data/upload/mobile/special/s0/s0_05233785427198540.jpg",
                "http://fengshouguo.com/data/upload/mobile/special/s0/s0_05233870008759730.jpg",
                "http://fengshouguo.com/data/upload/mobile/special/s0/s0_05233785635319825.jpg",
                "http://fengshouguo.com/data/upload/mobile/special/s0/s0_05233786821255365.jpg"};
        loadImg();
    }

    @Override
    public void initData() {
        super.initData();
        gv_qsmall.setAdapter(new QSMallTopAdapter(this));
        gv_new_qsmall.setAdapter(new QSMallTwoAdapter(this));
        lv_alliancemall.setAdapter(new QSMallLVAdapter(this));
    }

    @Override
    public void setOnclick() {


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }

    }

    public void loadImg(){
        imgList=new ArrayList<ImageView>();
        for(int i=0;i<imgUrlArr.length;i++){
            ImageView imageView=new ImageView(this);
            //Glide加载网络图片
            Glide.with(this)
                    .load(imgUrlArr[i])
                    .into(imageView);
            //设置imageview占满整个ViewPager
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgList.add(imageView);
        }
        viewpager.setAdapter(new MyAdapter());
        viewpager.setOnPageChangeListener(new MyPagerChangeListener());
        viewpager.setCurrentItem(300);
        mHandler.postDelayed(mRunnable, 2000);
    }

    private void  setdotDrawable(ImageView iv1,ImageView iv2,ImageView iv3,ImageView iv4){
        iv1.setBackgroundResource(R.mipmap.dot_focus);
        iv2.setBackgroundResource(R.mipmap.dot_blur);
        iv3.setBackgroundResource(R.mipmap.dot_blur);
        iv4.setBackgroundResource(R.mipmap.dot_blur);

    }

    class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            num = arg0;
            arg0 = arg0 % imgList.size();
            switch (arg0) {
                case 0:
                    setdotDrawable(dot_focus,dot_blur,dot3,dot4);
                    break;
                case 1:
                    setdotDrawable(dot_blur,dot_focus,dot3,dot4);
                    break;
                case 2:
                    setdotDrawable(dot3,dot_focus,dot_blur,dot4);
                    break;
                case 3:
                    setdotDrawable(dot4,dot_focus,dot_blur,dot3);
                    break;
                default:
                    break;
            }

        }
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return  arg0 == arg1;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            try {
                ((ViewPager) container).addView((View) imgList.get(position % imgList.size()),
                        0);
            } catch (Exception e) {
            }

            return imgList.get(position % imgList.size());
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //container.removeView(list.get(position));
        }
        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }


    }


}
