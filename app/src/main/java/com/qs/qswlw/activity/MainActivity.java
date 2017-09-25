package com.qs.qswlw.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.mall.AllianceMallActivity;
import com.qs.qswlw.activity.mall.QSMallActivity;
import com.qs.qswlw.adapter.AngelAdapter;
import com.qs.qswlw.adapter.BenefitAdapter;
import com.qs.qswlw.adapter.ChinaAdapter;
import com.qs.qswlw.adapter.EntrepAdapter;
import com.qs.qswlw.adapter.LuckAdapter;
import com.qs.qswlw.adapter.MytestAdapter;
import com.qs.qswlw.adapter.UnionAdapter;
import com.qs.qswlw.bean.LoginBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.bean.RegisterBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.Presenter.MainPresenter;
import com.qs.qswlw.view.imageswitchview.Image3DSwitchView;
import com.qs.qswlw.view.imageswitchview.Image3DView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by 小羽 on 2017/3/22.
 */
public class MainActivity extends BaseActivity implements IMainView {
    public static Observable observable = new Observable();
    List<Maindatabean.Goods> chlist;
    List<Maindatabean.Shop> unlist;
    List<Maindatabean.Area> belist;
    List<Maindatabean.Salema> anlist;
    List<LuckBean> lulist;
    AlertBean allist;
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
    MainPresenter mainPresenter = new MainPresenter(this);
    private Image3DSwitchView imageSwitchView;
    private Image3DView benefitList, unionList, entrepList, angelList, chinaList, luckList;
    private TextView tv_dialog_index_title, tv_dialog_index_content, tv_dialog_index_name, tv_dialog_index_time;
    private View alertview;
    private Button btn_dialog;
    private ImageView iv_setting_main;
    private ImageView iv_ranking_main, iv_main_avater;
    private LinearLayout ll_footview_union;
    private RadioButton rb_main_goodprojects, rb_main_media, rb_main_mall, rb_main_union, rb_main_WitnessChinaBusiness, rb_main_Win, rb_main_luckgame, rb_main_funtime;
    private WebView webview;
    private Intent intent;
    private PopupWindow popupWindow;
    private LinearLayout ll_ranking_popup, main_ll_avater;

    @Override
    public void setAlertList(AlertBean title) {
        tv_dialog_index_title.setText(title.getIndex_title());
        //   tv_dialog_index_content.setText(allist.getIndex_content());
        tv_dialog_index_content.setText(title.getIndex_content());
        tv_dialog_index_name.setText(title.getIndex_name());
        tv_dialog_index_time.setText(title.getIndex_time());
    }

    @Override
    public void setUnionList(List<Maindatabean.Shop> list) {
        unlist.clear();
        unlist.addAll(list);
        unionAdapter.notifyDataSetChanged();
        // unionList.invalidate();
        imageSwitchView.scrollToNext();
        Log.d("TAG", "-------setUnionList---");
        observable.notifyObservers("这不重要");
//        observable.notifyAll();
    }

    @Override
    public void setEntrepList(Maindatabean.Current_sales entrepBaen) {
        enlist.clear();
        enlist.add(entrepBaen.getLoveval_model2_xfz() + "");
        enlist.add(entrepBaen.getLoveval_model2_shop());
        enlist.add(entrepBaen.getSales_amount() + "");
        enlist.add(entrepBaen.getMoney() + "");
        enlist.add(entrepBaen.getCount() + "");
        enlist.add(entrepBaen.getShop() + "");
        entrepAdapter.notifyDataSetChanged();
        Log.d("TAG", "-------setEntrepList---");
    }

    @Override
    public void setAngelList(List<Maindatabean.Salema> list) {
        anlist.clear();
        anlist.addAll(list);
        Log.d("TAG", "-------setAngelList---");
        angelAdapter.notifyDataSetChanged();
    }

    @Override
    public void setChinaList(List<Maindatabean.Goods> list) {
        chlist.clear();
        chlist.addAll(list);
        Log.d("TAG", "-------setChinaList---");
        chinaAdapter.notifyDataSetChanged();

    }

    @Override
    public void setLuckList(List<LuckBean> list) {
        lulist.clear();
        lulist.addAll(list);
        Log.d("TAG", "-------setLuckList---");
        luckAdapter.notifyDataSetChanged();
    }

    @Override
    public void setBenefitList(List<Maindatabean.Area> list) {
        belist.clear();
        belist.addAll(list);
        benefitAdapter.notifyDataSetChanged();
        Log.d("TAG", "-------setBenefitList---");
    }

    @Override
    public Integer initView() {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        return R.layout.activity_main;
    }


    @Override
    public void initfindviewByid() {
        LoginBean.UserinfoBean userInfo = UserManage.getInstance().getUserInfo(this);
        RegisterBean registerUserInfo = UserManage.getInstance().getRegisterUserInfo(this);
        iv_setting_main = (ImageView) findViewById(R.id.iv_setting_main);
        imageSwitchView = (Image3DSwitchView) findViewById(R.id.image_switch_view);
        benefitList = (Image3DView) findViewById(R.id.benefitList);
        unionList = (Image3DView) findViewById(R.id.unionList);
        entrepList = (Image3DView) findViewById(R.id.entrepList);
        angelList = (Image3DView) findViewById(R.id.angelList);
        chinaList = (Image3DView) findViewById(R.id.chinaList);
        luckList = (Image3DView) findViewById(R.id.luckList);
        iv_ranking_main = (ImageView) findViewById(R.id.iv_ranking_main);
        rb_main_goodprojects = (RadioButton) findViewById(R.id.rb_main_goodprojects);
        rb_main_media = (RadioButton) findViewById(R.id.rb_main_media);
        rb_main_mall = (RadioButton) findViewById(R.id.rb_main_mall);
        rb_main_union = (RadioButton) findViewById(R.id.rb_main_union);
        rb_main_WitnessChinaBusiness = (RadioButton) findViewById(R.id.rb_main_WitnessChinaBusiness);
        rb_main_Win = (RadioButton) findViewById(R.id.rb_main_Win);
        rb_main_luckgame = (RadioButton) findViewById(R.id.rb_main_luckgame);
        rb_main_funtime = (RadioButton) findViewById(R.id.rb_main_funtime);
        main_ll_avater = (LinearLayout) findViewById(R.id.main_ll_avater);
        iv_main_avater = (ImageView) findViewById(R.id.iv_main_avater);
        imageSwitchView.setCurrentImage(0);
        showDilog();

//        if(userInfo!=null||registerUserInfo!=null){
//            main_ll_avater.setVisibility(View.VISIBLE);
//            iv_setting_main.setVisibility(View.GONE);
//            //   iv_main_avater.setImageResource();
//        }
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
        DisplayMetrics a = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(a);
        MyApplication.WIDTH = (int) (a.widthPixels * 0.7);
        benefitList.setBColor(Color.parseColor("#b92340"));
        unionList.setBColor(Color.parseColor("#de2128"));
        entrepList.setBColor(Color.parseColor("#f3c68b"));
        angelList.setBColor(Color.parseColor("#b92340"));
        chinaList.setBColor(Color.parseColor("#f2989a"));
        luckList.setBColor(Color.parseColor("#cd2244"));
        WindowManager wm = this.getWindowManager();
        MyApplication.WIDTH = (int) (wm.getDefaultDisplay().getWidth() * 0.7);
        /**
         * 全联盟让利金额排行榜内容填充、头部、尾部
         */
        View benefitHeadview = LayoutInflater.from(this).inflate(R.layout.benefit_homepage_head, null);
        TextView tv_benefit_head = (TextView) benefitHeadview.findViewById(R.id.tv_benefit_head);
        tv_benefit_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));

        belist = new ArrayList<>();
        benefitAdapter = new BenefitAdapter(this, belist);
        benefitList.setAdapter(benefitAdapter);
        benefitList.addHeaderView(benefitHeadview);
        /**
         * 联盟商家排行榜
         */
        /*MyApplication.WIDTH=*/

        View unionHeadview = LayoutInflater.from(this).inflate(R.layout.union_homepage_head, null);
        View unionFootview = LayoutInflater.from(this).inflate(R.layout.union_homepage_foot, null);
        TextView tv_union_head = (TextView) unionHeadview.findViewById(R.id.tv_union_head);
        LinearLayout ll_footview = (LinearLayout) unionFootview.findViewById(R.id.ll_footview);
        ll_footview.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        tv_union_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));
        unlist = new ArrayList<>();
        unionAdapter = new UnionAdapter(this, unlist);
        unionList.setAdapter(unionAdapter);
        unionList.addHeaderView(unionHeadview);
        unionList.addFooterView(unionFootview);
        unionFootview.findViewById(R.id.ll_footview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
//                intent.putExtra("footview", "unionranking");
                Intent intent = new Intent(MainActivity.this, UnionRankingActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 全联盟创业日值内容填充
         */

        View entrepHeadview = LayoutInflater.from(this).inflate(R.layout.entrep_homepage_head, null);
        final LinearLayout ll_entrep_width = (LinearLayout) entrepHeadview.findViewById(R.id.ll_entrep_width);
        ll_entrep_width.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
        ll_entrep_width.measure(0, 0);
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
        tv_angel_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));
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
                Intent intent = new Intent(MainActivity.this, AngelRankingActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 中国好产品排行榜内容填充
         */
        View chinaFootview = LayoutInflater.from(this).inflate(R.layout.china_homepage_foot, null);
        View chinaHeadview = LayoutInflater.from(this).inflate(R.layout.china_homepage_head, null);
        TextView tv_china_head = (TextView) chinaHeadview.findViewById(R.id.tv_china_head);
        tv_china_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));
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
                startActivity(new Intent(MainActivity.this, ChinaGoodProductActivity.class));
            }
        });
        /**
         * 拼手气促销抽奖名单内容填充
         */
        View luckHeadview = LayoutInflater.from(this).inflate(R.layout.luck_homepage_head, null);
        View luckFootview = LayoutInflater.from(this).inflate(R.layout.luck_homepage_foot, null);
        TextView tv_luck_head = (TextView) luckHeadview.findViewById(R.id.tv_luck_head);
        tv_luck_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));
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
        iv_ranking_main.setOnClickListener(this);
        rb_main_goodprojects.setOnClickListener(this);
        rb_main_media.setOnClickListener(this);
        rb_main_mall.setOnClickListener(this);
        rb_main_union.setOnClickListener(this);
        rb_main_WitnessChinaBusiness.setOnClickListener(this);
        rb_main_Win.setOnClickListener(this);
        rb_main_luckgame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting_main:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.iv_ranking_main:
                // startActivity(new Intent(this, RankingActivity.class));
                showPw(iv_ranking_main);
                break;
            case R.id.rb_main_goodprojects:
                startActivity(new Intent(this, ProjectRecommendationActivity.class));
                break;
            case R.id.rb_main_media:
                startActivity(new Intent(this, InteractionActivity.class));
                break;
            case R.id.rb_main_union:
                intent = new Intent(this, AllianceMallActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_main_mall:
                intent = new Intent(this, QSMallActivity.class);
                startActivity(intent);
                break;
            case R.id.rb_main_WitnessChinaBusiness:
                this.intent = new Intent(this, WebviewActivity.class);
                this.intent.putExtra("WitnessChinaBusiness", "http://case.dian7dian.com/qiansheng/jzhs.html");
                startActivity(this.intent);
                break;
            case R.id.rb_main_Win:
                this.intent = new Intent(this, WebviewActivity.class);
                this.intent.putExtra("Win", "http://case.dian7dian.com/qiansheng/yzqs.html");
                startActivity(this.intent);
                break;
            case R.id.rb_main_luckgame:
                startActivity(new Intent(this, LuckGameActivity.class));
                break;
            case R.id.rb_main_funtime:
                this.intent = new Intent(this, WebviewActivity.class);
                this.intent.putExtra("Win", "http://case.dian7dian.com/qiansheng/kxyk.html");
                startActivity(this.intent);
                break;
            case R.id.ll_ranking_popup:
                //   startActivity(new Intent(MainActivity.this,MainRankingActivity.class));
                break;
        }
    }

    private void showPw(ImageView v) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.popup_main, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ll_ranking_popup = (LinearLayout) layout.findViewById(R.id.ll_ranking_popup);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.TOP | Gravity.RIGHT, 10, 120);
        ll_ranking_popup.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   imageSwitchView.clear();
    }

    //┏┓　　　┏┓
    //┏┛┻━━━┛┻┓
    //┃　　　　　　　┃ 　
    //┃　　　━　　　┃
    //┃　┳┛　┗┳　┃
    //┃　　　　　　　┃
    //┃　　　┻　　　┃
    //┃　　　　　　　┃
    //┗━┓　　　┏━┛
    //┃　　　┃  神兽保佑　　　　　　　　
    //┃　　　┃  代码无BUG！
    //┃　　　┗━━━┓
    //┃　　　　　　　┣┓
    //┃　　　　　　　┏┛
    //┗┓┓┏━┳┓┏┛
    // ┃┫┫　┃┫┫
    // ┗┻┛　┗┻┛
}