package com.qs.qswlw.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.ConsumerSettingActivity;
import com.qs.qswlw.activity.mall.AllianceMallActivity;
import com.qs.qswlw.adapter.AngelAdapter;
import com.qs.qswlw.adapter.BenefitAdapter;
import com.qs.qswlw.adapter.ChinaAdapter;
import com.qs.qswlw.adapter.EntrepAdapter;
import com.qs.qswlw.adapter.LuckAdapter;
import com.qs.qswlw.adapter.MytestAdapter;
import com.qs.qswlw.adapter.UnionAdapter;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.AngelBean;
import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBean;
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

    List<ChinaBean> chlist;
    List<UnionBean> unlist;
    List<BenefitBean> belist;
    List<AngelBean> anlist;
    List<LuckBean> lulist;
    AlertBean allist;
    private Image3DView benefitList, unionList, entrepList, angelList, chinaList, luckList;
    private TextView tv_dialog_index_title, tv_dialog_index_content, tv_dialog_index_name, tv_dialog_index_time;
    private View alertview;
    private Button btn_dialog;
    private ImageView iv_setting_main;
    private TextView tv_ranking_main;
    private LinearLayout ll_footview_union;
    private RadioButton rb_main_goodprojects,rb_main_media,rb_main_mall,rb_main_union;


    @Override
    public void setAlertList(AlertBean title) {
        tv_dialog_index_title.setText(title.getIndex_title());
        //   tv_dialog_index_content.setText(allist.getIndex_content());
        tv_dialog_index_content.setText(title.getIndex_content());
        tv_dialog_index_name.setText(title.getIndex_name());
        tv_dialog_index_time.setText(title.getIndex_time());
    }

    @Override
    public void setUnionList(List<UnionBean> list) {
        unlist.clear();
        unlist.addAll(list);
        unionAdapter.notifyDataSetChanged();
    }

    @Override
    public void setEntrepList(EntrepBean entrepBaen) {
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

    MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    public Integer initView() {
        return R.layout.activity_main;
    }

    ArrayList<ChinaBean> listtest;
    ArrayList<String> enlist;
    MytestAdapter myDataAdapter;
    EntrepAdapter entrepAdapter;
    ChinaAdapter chinaAdapter;
    UnionAdapter unionAdapter;
    BenefitAdapter benefitAdapter;
    AngelAdapter angelAdapter;
    LuckAdapter luckAdapter;
    ArrayList<View> pagelist = new ArrayList<>();

    @Override
    public void initfindviewByid() {
        iv_setting_main = (ImageView) findViewById(R.id.iv_setting_main);
        imageSwitchView = (Image3DSwitchView) findViewById(R.id.image_switch_view);
        benefitList = (Image3DView) findViewById(R.id.benefitList);
        unionList = (Image3DView) findViewById(R.id.unionList);
        entrepList = (Image3DView) findViewById(R.id.entrepList);
        angelList = (Image3DView) findViewById(R.id.angelList);
        chinaList = (Image3DView) findViewById(R.id.chinaList);
        luckList = (Image3DView) findViewById(R.id.luckList);
        tv_ranking_main = (TextView) findViewById(R.id.tv_ranking_main);
        rb_main_goodprojects = (RadioButton) findViewById(R.id.rb_main_goodprojects);
        rb_main_media = (RadioButton) findViewById(R.id.rb_main_media);
        rb_main_mall = (RadioButton) findViewById(R.id.rb_main_mall);
        rb_main_union = (RadioButton) findViewById(R.id.rb_main_union);
        imageSwitchView.setCurrentImage(1);
        showDilog();
    }


    private void showDilog() {
        allist = new AlertBean();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View alertview = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_main, null);
        tv_dialog_index_title = (TextView) alertview.findViewById(R.id.tv_dialog_index_title);
        tv_dialog_index_content = (TextView) alertview.findViewById(R.id.tv_dialog_index_content);
        tv_dialog_index_name = (TextView) alertview.findViewById(R.id.tv_dialog_index_name);
        tv_dialog_index_time = (TextView) alertview.findViewById(R.id.tv_dialog_index_time);
        btn_dialog = (Button) alertview.findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "表单填写完成",
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setView(alertview);
        dialog.show();
    }

    @Override
    public void initData() {
        super.initData();
        benefitList.setBColor(Color.parseColor("#b92340"));
        unionList.setBColor(Color.parseColor("#de2128"));
        entrepList.setBColor(Color.parseColor("#f3c68b"));
        angelList.setBColor(Color.parseColor("#b92340"));
        chinaList.setBColor(Color.parseColor("#f2989a"));
        luckList.setBColor(Color.parseColor("#cd2244"));
        WindowManager wm =  this.getWindowManager();
        MyApplication.WIDTH = (int) (wm.getDefaultDisplay().getWidth()*0.7);
        /**
         * 全联盟让利金额排行榜内容填充、头部、尾部
         */
        View benefitHeadview = LayoutInflater.from(this).inflate(R.layout.benefit_homepage_head, null);
        TextView tv_benefit_head = (TextView) benefitHeadview.findViewById(R.id.tv_benefit_head);
        tv_benefit_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,60));
        belist = new ArrayList<>();
        benefitAdapter = new BenefitAdapter(this, belist);
        benefitList.setAdapter(benefitAdapter);
        benefitList.addHeaderView(benefitHeadview);
        /**
         * 联盟商家排行榜
         */
        View unionHeadview = LayoutInflater.from(this).inflate(R.layout.union_homepage_head, null);
        View unionFootview = LayoutInflater.from(this).inflate(R.layout.union_homepage_foot, null);
        TextView tv_union_head = (TextView) unionHeadview.findViewById(R.id.tv_union_head);
        LinearLayout ll_footview = (LinearLayout) unionFootview.findViewById(R.id.ll_footview);
        ll_footview.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        tv_union_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,60));
        unlist = new ArrayList<>();
        unionAdapter = new UnionAdapter(this, unlist);
        unionList.setAdapter(unionAdapter);
        unionList.addHeaderView(unionHeadview);
        unionList.addFooterView(unionFootview);
        unionFootview.findViewById(R.id.ll_footview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                intent.putExtra("footview","unionranking");
                startActivity(intent);
            }
        });
        /**
         * 全联盟创业日值内容填充
         */

        View entrepHeadview = LayoutInflater.from(this).inflate(R.layout.entrep_homepage_head, null);
        final LinearLayout ll_entrep_width = (LinearLayout) entrepHeadview.findViewById(R.id.ll_entrep_width);
        ll_entrep_width.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        ll_entrep_width.measure(0,0);
        MyApplication.ENTREPHEIGHT = ll_entrep_width.getMeasuredHeight();
        enlist = new ArrayList<>();
        entrepAdapter = new EntrepAdapter(this, enlist);
        entrepList.setAdapter(entrepAdapter);
        entrepList.addHeaderView(entrepHeadview);

        /**
         * 创业天使创业排名榜内容填充
         */
        View unionFootview2 = LayoutInflater.from(this).inflate(R.layout.union_homepage_foot, null);
        View angelHeadview = LayoutInflater.from(this).inflate(R.layout.angel_homepage_head, null);
        TextView tv_angel_head = (TextView) angelHeadview.findViewById(R.id.tv_angel_head);
        tv_angel_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,60));
        LinearLayout ll_footview1 = (LinearLayout) unionFootview2.findViewById(R.id.ll_footview);
        ll_footview1.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        anlist = new ArrayList<>();
        angelAdapter = new AngelAdapter(this, anlist);
        angelList.setAdapter(angelAdapter);
        angelList.addHeaderView(angelHeadview);
        angelList.addFooterView(unionFootview2);
        unionFootview2.findViewById(R.id.ll_footview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                intent.putExtra("footview","angelranking");
                startActivity(intent);
            }
        });

        /**
         * 中国好产品排行榜内容填充
         */
        View chinaFootview = LayoutInflater.from(this).inflate(R.layout.china_homepage_foot, null);
        View chinaHeadview = LayoutInflater.from(this).inflate(R.layout.china_homepage_head, null);
        TextView tv_china_head = (TextView) chinaHeadview.findViewById(R.id.tv_china_head);
        tv_china_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,60));
        LinearLayout china_footview = (LinearLayout) chinaFootview.findViewById(R.id.china_footview);
        china_footview.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        chlist = new ArrayList<>();
        chinaAdapter = new ChinaAdapter(this, chlist);
        chinaList.setAdapter(chinaAdapter);
        chinaList.addHeaderView(chinaHeadview);
        chinaList.addFooterView(chinaFootview);
        chinaFootview.findViewById(R.id.china_footview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ChinaGoodProductActivity.class));
            }
        });
        /**
         * 拼手气促销抽奖名单内容填充
         */
        View luckHeadview = LayoutInflater.from(this).inflate(R.layout.luck_homepage_head, null);
        View luckFootview = LayoutInflater.from(this).inflate(R.layout.luck_homepage_foot, null);
        TextView tv_luck_head = (TextView) luckHeadview.findViewById(R.id.tv_luck_head);
        tv_luck_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH,60));
        LinearLayout luck_footview = (LinearLayout) luckFootview.findViewById(R.id.luck_footview);
        luck_footview.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        lulist = new ArrayList<>();
        luckAdapter = new LuckAdapter(this, lulist);
        luckList.setAdapter(luckAdapter);
        luckList.addHeaderView(luckHeadview);
        luckList.addFooterView(luckFootview);
        mainPresenter.getdata();
    }

    @Override
    public void setOnclick() {
        iv_setting_main.setOnClickListener(this);
        tv_ranking_main.setOnClickListener(this);
        rb_main_goodprojects.setOnClickListener(this);
        rb_main_media.setOnClickListener(this);
        rb_main_mall.setOnClickListener(this);
        rb_main_union.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting_main:
                startActivity(new Intent(this, ConsumerSettingActivity.class));
                break;
            case R.id.tv_ranking_main:
                startActivity(new Intent(this, RankingActivity.class));
                break;
            case R.id.rb_main_goodprojects:
                startActivity(new Intent(this,ProjectRecommendationActivity.class));
                break;
            case R.id.rb_main_media:
                startActivity(new Intent(this,InteractionActivity.class));
                break;
            case R.id.rb_main_union:
                startActivity(new Intent(this,AllianceMallActivity.class));
                break;
            case R.id.rb_main_mall:
                //实例化WebView对象
                WebView webview = new WebView(this);
                //设置WebView属性，能够执行Javascript脚本
                webview.getSettings().setJavaScriptEnabled(true);
                //加载需要显示的网页
                webview.loadUrl("http://qiansheng.dian7dian.com/index.php?m=Mobile&c=Index&a=index");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   imageSwitchView.clear();
    }
}