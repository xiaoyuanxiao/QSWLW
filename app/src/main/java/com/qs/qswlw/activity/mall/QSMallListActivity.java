package com.qs.qswlw.activity.mall;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.fragment.QSMalListNewFragment;
import com.qs.qswlw.fragment.QSMallListCommentFragment;
import com.qs.qswlw.fragment.QSMallListPriceFragment;
import com.qs.qswlw.fragment.QSMallListSalesVolumeFragment;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMallListActivity extends BaseActivity {
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;
    private MyPagerAdapter myPagerAdapter;
    private ViewPager viewPager;
    private TextView tv;
    private ImageView iv_qsmalllist;
    private boolean ischeck = true;
    private TextView tv_screen;
    private EditText edt_qsmalllist;
    private LinearLayout ll_content;
    private LinearLayout ll_souso;
    private ImageView iv_back;

    @Override
    public Object initView() {
        return R.layout.activity_qsmalllist;
    }

    @Override
    public void initfindviewByid() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        iv_qsmalllist = (ImageView) findViewById(R.id.iv_qsmalllist);
        tv_screen = (TextView) findViewById(R.id.tv_screen);
        edt_qsmalllist = (EditText) findViewById(R.id.edt_qsmalllist);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        ll_souso = (LinearLayout) findViewById(R.id.ll_souso);
        iv_back = (ImageView) findViewById(R.id.iv_back);


    }

    @Override
    public void initData() {
        super.initData();
        fragmentManager = getSupportFragmentManager();
        initFragment();

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.viewpager_qsmalllist);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(myPagerAdapter.getTabView(i, false));
        }

    }

    /**
     * 初始化所有基fragment
     */
    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(QSMalListNewFragment.newInstance());
        fragments.add(QSMallListCommentFragment.newInstance());
        fragments.add(QSMallListSalesVolumeFragment.newInstance());
        fragments.add(QSMallListPriceFragment.newInstance());
        showFragment(fragments.get(0));

    }

    /**
     * 显示fragment
     *
     * @param fragment 要显示的fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.viewpager_qsmalllist, fragment, fragment.getClass().getName());
        }
        transaction.commit();
    }

    /**
     * 隐藏其他fragment
     *
     * @param transaction 控制器
     */
    private void hideFragment(FragmentTransaction transaction) {
        for (int i = 0; fragments.size() > i; i++) {
            if (fragments.get(i).isVisible()) {
                transaction.hide(fragments.get(i));
            }
        }
    }


    @Override
    public void setOnclick() {
        iv_qsmalllist.setOnClickListener(this);
        tv_screen.setOnClickListener(this);
        edt_qsmalllist.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_qsmalllist:
                if(ischeck){
                    ischeck = false;
                    iv_qsmalllist.setImageResource(R.mipmap.gride);
                }else{
                    ischeck = true;
                    iv_qsmalllist.setImageResource(R.mipmap.list);
                }
                break;
            case R.id.tv_screen:
                Intent intent = new Intent(this, ScreenActivity.class);
                startActivity(intent);
                break;
            case R.id.edt_qsmalllist:
                edt_qsmalllist.setHint("请输入关键字");
                tv_screen.setText("搜素");
                ll_content.setVisibility(View.GONE);
                ll_souso.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_back:
                if("搜素".equals(tv_screen.getText().toString())){
                    ll_content.setVisibility(View.VISIBLE);
                    ll_souso.setVisibility(View.GONE);
                    tv_screen.setText("筛选");
                    hintKb();
                }else{
                    finish();
                }

                break;
        }

    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 4;
        private String tabTitles[] = new String[]{"最新", "销量", "评论","价格"};
        private Context context;

        public MyPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new QSMalListNewFragment();
                case 1:
                    return new QSMallListCommentFragment();
                case 2:
                    return new QSMallListPriceFragment();
                case 3:
                    return new QSMallListSalesVolumeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //第一次的代码
            //return tabTitles[position];
            //第二次的代码
            /**
             Drawable image = context.getResources().getDrawable(imageResId[position]);
             image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
             SpannableString sb = new SpannableString(" " + tabTitles[position]);
             ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
             sb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
             return sb;*/


            return null;
        }
        public View getTabView(int position,boolean select){
            View view = LayoutInflater.from(context).inflate(R.layout.tablayout, null);
            view.setSelected(select);
             tv =  (TextView) view.findViewById(R.id.tv_tab);
            tv.setText(tabTitles[position]);
            ImageView img = (ImageView) view.findViewById(R.id.iv_tab);
            if(position==3){
                img.setVisibility(View.VISIBLE);
                img.setImageResource(R.mipmap.beans);
            }
            return view;
        }

    }
    //此方法只是关闭软键盘
    private void hintKb() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
}
