package com.qs.qswlw.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.SettingActivity;
import com.qs.qswlw.adapter.AngelAdapter;
import com.qs.qswlw.adapter.BenefitAdapter;
import com.qs.qswlw.adapter.ChinaAdapter;
import com.qs.qswlw.adapter.EntepAdapter;
import com.qs.qswlw.adapter.LuckAdapter;
import com.qs.qswlw.adapter.MytestAdapter;
import com.qs.qswlw.adapter.UnionAdapter;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AngelBean;
import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.Moudle.UnionBean;
import com.qs.qswlw.okhttp.Presenter.MainPresenter;
import com.qs.qswlw.view.imageswitchview.Image3DSwitchView;
import com.qs.qswlw.view.imageswitchview.Image3DView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小羽 on 2017/3/22.
 */
public class MainActivity extends BaseActivity implements IMainView {
    private Image3DSwitchView imageSwitchView;
    private String[] listViewData = new String[]{
            "test1", "test2", "test3",
            "test4"};
    List<ChinaBean> chlist;
    List<UnionBean> unlist;
    List<BenefitBean> belist;
    List<AngelBean> anlist;
    List<LuckBean> lulist;

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setUnionList(List<UnionBean> list) {
        unlist.clear();
        unlist.addAll(list);
        unionAdapter.notifyDataSetChanged();
    }

    @Override
    public void setEntrepList(EntrepBaen entrepBaen) {
        enlist.clear();
        enlist.add(entrepBaen.getModel1() + "");
        enlist.add(entrepBaen.getModel2() + "");
        enlist.add(entrepBaen.getCount() + "");
        enlist.add(entrepBaen.getShop() + "");
        enlist.add(entrepBaen.getMoney() + "");
        enlist.add(entrepBaen.getModel1() + "");
        entrepAdapter.notifyDataSetChanged();

    }

    @Override
    public void setAngelList(List list) {
        anlist.clear();
        anlist.addAll(list);
        angelAdapter.notifyDataSetChanged();
    }

    @Override
    public void setChinaList(List<ChinaBean> list) {
        chlist.clear();
        chlist.addAll(list);
        chinaAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLuckList(List<LuckBean> list) {
        lulist.clear();
        lulist.addAll(list);
        luckAdapter.notifyDataSetChanged();
    }

    @Override
    public void setBenefitList(List list) {
        belist.clear();
        belist.addAll(list);
        benefitAdapter.notifyDataSetChanged();
    }

    ImageView iv_main_avater;
    // 小雨是傻逼
    MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    public Integer initView() {
        return R.layout.activity_main;
    }

    ArrayList<ChinaBean> listtest;
    ArrayList<String> enlist;
    MytestAdapter myDataAdapter;
    EntepAdapter entrepAdapter;
    ChinaAdapter chinaAdapter;
    UnionAdapter unionAdapter;
    BenefitAdapter benefitAdapter;
    AngelAdapter angelAdapter;
    LuckAdapter luckAdapter;

    @Override
    public void initfindviewByid() {
        imageSwitchView = (Image3DSwitchView) findViewById(R.id.image_switch_view);
        Image3DView benefitList = (Image3DView) findViewById(R.id.benefitList);
        Image3DView unionList = (Image3DView) findViewById(R.id.unionList);
        Image3DView entrepList = (Image3DView) findViewById(R.id.entrepList);
        Image3DView angelList = (Image3DView) findViewById(R.id.angelList);
        Image3DView chinaList = (Image3DView) findViewById(R.id.chinaList);
        Image3DView luckList = (Image3DView) findViewById(R.id.luckList);
        iv_main_avater = (ImageView) findViewById(R.id.iv_main_avater);
        imageSwitchView.setCurrentImage(1);

        benefitList.setBColor(Color.parseColor("#b92340"));
        unionList.setBColor(Color.parseColor("#de2128"));
        entrepList.setBColor(Color.parseColor("#f3c68b"));
        angelList.setBColor(Color.parseColor("#b92340"));
        chinaList.setBColor(Color.parseColor("#f2989a"));
        luckList.setBColor(Color.parseColor("#cd2244"));


        /**
         * 全联盟让利金额排行榜内容填充、头部、尾部
         */
//        belist = new ArrayList<>();
//        benefitAdapter = new BenefitAdapter(this,belist);
//        benefitList.setAdapter(benefitAdapter);
        View benefitHeadview = LayoutInflater.from(this).inflate(R.layout.benefit_homepage_head, null);
        TextView benefit_homepage_title = (TextView) benefitHeadview.findViewById(R.id.benefit_homepage_title);
        belist = new ArrayList<>();
        benefitAdapter = new BenefitAdapter(this, belist);
        benefit_homepage_title.setText("全联盟让利金额排行榜");
        benefitList.setAdapter(benefitAdapter);
        benefitList.addHeaderView(benefitHeadview);

        /**
         * 联盟商家排行榜
         */
//        unlist = new ArrayList<>();
//        unionAdapter = new UnionAdapter(this,unlist);
//        unionList.setAdapter(unionAdapter);
        View unionHeadview = LayoutInflater.from(this).inflate(R.layout.union_homepage_head, null);
        View unionFootview =  LayoutInflater.from(this).inflate(R.layout.union_homepage_foot, null);
        unlist = new ArrayList<>();
        unionAdapter = new UnionAdapter(this, unlist);
        unionList.setAdapter(unionAdapter);
        unionList.addHeaderView(unionHeadview);
        unionList.addFooterView(unionFootview);
        /**
         * 全联盟创业日值内容填充
         */
//        enlist = new ArrayList<>();
//        entrepAdapter = new EntepAdapter(this, enlist);
//        entrepList.setAdapter(entrepAdapter);
//        enlist = new ArrayList<>();
//        entepAdapter = new EntepAdapter(this, enlist);
//        tv_homepage_title.setText("全联盟创业日值");
//        entrepList.setAdapter(chinaAdapter);
//        entrepList.addHeaderView(headview);
//        entrepList.addFooterView(footview);

        View entrepHeadview = LayoutInflater.from(this).inflate(R.layout.entrep_homepage_head, null);
        enlist = new ArrayList<>();
        entrepAdapter = new EntepAdapter(this, enlist);
        entrepList.setAdapter(entrepAdapter);
        entrepList.addHeaderView(entrepHeadview);

        /**
         * 创业天使创业排名榜内容填充
         */
//      anlist   = new ArrayList<>();
//        angelAdapter = new AngelAdapter(this, anlist);
//        angelList.setAdapter(angelAdapter);

        View angelHeadview = LayoutInflater.from(this).inflate(R.layout.angel_homepage_head, null);
        anlist = new ArrayList<>();
        angelAdapter = new AngelAdapter(this, anlist);
        angelList.setAdapter(angelAdapter);
        angelList.addHeaderView(angelHeadview);
        angelList.addFooterView(unionFootview);


        /**
         * 中国好产品排行榜内容填充
         */
//        chlist = new ArrayList<>();
//        chinaAdapter = new ChinaAdapter(this, chlist);
//        chinaList.setAdapter(chinaAdapter);
        View chinaHeadview = LayoutInflater.from(this).inflate(R.layout.china_homepage_head, null);
        chlist = new ArrayList<>();
        chinaAdapter = new ChinaAdapter(this, chlist);
        chinaList.setAdapter(chinaAdapter);
        chinaList.addHeaderView(chinaHeadview);
        chinaList.addFooterView(unionFootview);

        /**
         * 拼手气促销抽奖名单内容填充
         */
//        lulist = new ArrayList<>();
//        luckAdapter = new LuckAdapter(this, lulist);
//        luckList.setAdapter(luckAdapter);



        View luckHeadview = LayoutInflater.from(this).inflate(R.layout.luck_homepage_head, null);
        lulist = new ArrayList<>();
        luckAdapter = new LuckAdapter(this, lulist);
        luckList.setAdapter(luckAdapter);
        luckList.addHeaderView(luckHeadview);
        luckList.addFooterView(unionFootview);

        mainPresenter.getdata();


    }


    @Override
    public void setOnclick() {
        iv_main_avater.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_main_avater:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageSwitchView.clear();
    }

    private class MyDataAdapter extends BaseAdapter {
        private String[] keys = {"前海公司", "飞腾公司", "前海公司", "飞腾公司", "飞腾公司"};
        private String[] values = {"11111万", "22222万", "33333万", "44444万", "55555万"};

        @Override
        public int getCount() {
            return keys.length;
        }

        @Override
        public Object getItem(int i) {
            return keys[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            convertView = View.inflate(MainActivity.this, R.layout.item_home_content, null);
            TextView key = (TextView) convertView.findViewById(R.id.tv_item_home_content_left);
            TextView value = (TextView) convertView.findViewById(R.id.tv_item_home_content_value);
            key.setText(keys[i]);
            value.setText(values[i]);
            return convertView;
        }
    }
}
