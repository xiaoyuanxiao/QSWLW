package com.qs.qswlw.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.BusinessSettingActivity;
import com.qs.qswlw.activity.PersonalCenter.ConsumerSettingActivity;
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
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.Presenter.MainPresenter;
import com.qs.qswlw.utils.ScreenUtils;
import com.qs.qswlw.view.imageswitchview.Image3DSwitchView;
import com.qs.qswlw.view.imageswitchview.Image3DView;
import com.qs.qswlw.view.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by 小羽 on 2017/3/22.
 */
public class MainActivity extends BaseActivity implements IMainView {
    public static MyObservable observable = new MyObservable();
    List<Maindatabean.Goods> chlist;
    List<Maindatabean.Shop> unlist;
    List<Maindatabean.Area> belist;
    List<Maindatabean.Salema> anlist;
    List<LuckBean> lulist;
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
    private TextView tv_dialog_index_title, tv_dialog_index_content, tv_dialog_index_name,tv_dialog_index_department, tv_dialog_index_time;
    private View alertview;
    private Button btn_dialog_list,btn_dialog_delay;
    private ImageView iv_setting_main;
    private ImageView iv_ranking_main, iv_main_avater;
    private LinearLayout ll_footview_union;
    private RadioButton rb_main_goodprojects, rb_main_media, rb_main_mall, rb_main_union, rb_main_WitnessChinaBusiness, rb_main_Win, rb_main_luckgame, rb_main_funtime;
    private WebView webview;
    private Intent intent;
    private PopupWindow popupWindow;
    private LinearLayout ll_ranking_popup, main_ll_avater,ll_notice_popup,ll_yzqs_popup;
    private Maindatabean.Current_sales entrepBaen;
    private LinearLayout ll_dialogmain_bg;
    private Maindatabean.Notices notices;


    //    private volatile static MainActivity singleton;
//    private MainActivity (){}
//    public static MainActivity getSingleton() {
//        if (singleton == null) {
//            synchronized (MainActivity.class) {
//                if (singleton == null) {
//                    singleton = new MainActivity();
//                }
//            }
//        }
//        return singleton;
//    }
//
    @Override
    public void setAlertList(Maindatabean.Notices title) {
        notices = title;
        tv_dialog_index_title.setText(title.getIndex_title());
        tv_dialog_index_content.setText(title.getIndex_content());
        tv_dialog_index_name.setText(title.getIndex_name());
        tv_dialog_index_department.setText(title.getIndex_faburen());
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
        observable.setChanged();
        observable.notifyObservers("这不重要");
    }

    @Override
    public void setEntrepList(Maindatabean.Current_sales entrepBaen) {
        this.entrepBaen = entrepBaen;
        enlist.clear();
        enlist.add(entrepBaen.getProducts() + "");
        enlist.add(entrepBaen.getElla());
//        enlist.add(entrepBaen.getSales_amount() + "");
//        enlist.add(entrepBaen.getMoney() + "");
//        enlist.add(entrepBaen.getCount() + "");
//        enlist.add(entrepBaen.getShop() + "");
        entrepAdapter.notifyDataSetChanged();
        Log.d("TAG", "-------setEntrepList---");
    }

    @Override
    public void setAngelList(List<Maindatabean.Salema> list) {
//        anlist.clear();
//        anlist.addAll(list);
//        Log.d("TAG", "-------setAngelList---");
//        angelAdapter.notifyDataSetChanged();
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
        Intent intent1 = getIntent();
        String setting = intent1.getStringExtra("setting");
        if(!"setting".equals(setting)){
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
        }
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
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View alertview = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_main, null);
        tv_dialog_index_title = (TextView) alertview.findViewById(R.id.tv_dialog_index_title);
        tv_dialog_index_content = (TextView) alertview.findViewById(R.id.tv_dialog_index_content);
        tv_dialog_index_department = (TextView) alertview.findViewById(R.id.tv_dialog_index_department);
        tv_dialog_index_name = (TextView) alertview.findViewById(R.id.tv_dialog_index_name);
        tv_dialog_index_time = (TextView) alertview.findViewById(R.id.tv_dialog_index_time);
        ll_dialogmain_bg = (LinearLayout) alertview.findViewById(R.id.ll_dialogmain_bg);
        btn_dialog_list = (Button) alertview.findViewById(R.id.btn_dialog_list);
        btn_dialog_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NoticeActivity.class));
            }
        });
        int width = ScreenUtils.getScreenWidth(this)-60;
        ll_dialogmain_bg.setLayoutParams(new LinearLayout.LayoutParams(width, width-20));
        btn_dialog_delay = (Button) alertview.findViewById(R.id.btn_dialog_delay);
        btn_dialog_delay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setView(alertview);
        dialog.show();

        Window dialogWindow = dialog.getWindow();
        WindowManager m = this.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() -20); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height =  p.width ; // 高度设置为屏幕的0.6，根据实际情况调整
        dialogWindow.setAttributes(p);

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
//        View unionFootview2 = LayoutInflater.from(this).inflate(R.layout.union_homepage_foot, null);
//        View angelHeadview = LayoutInflater.from(this).inflate(R.layout.angel_homepage_head, null);
//        TextView tv_angel_head = (TextView) angelHeadview.findViewById(R.id.tv_angel_head);
//        tv_angel_head.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, 60));
//        LinearLayout ll_footview1 = (LinearLayout) unionFootview2.findViewById(R.id.ll_footview);
//        ll_footview1.setLayoutParams(new LinearLayout.LayoutParams(MyApplication.WIDTH, LinearLayout.LayoutParams.WRAP_CONTENT));
//        anlist = new ArrayList<>();
//        angelAdapter = new AngelAdapter(this, anlist);
//        angelList.setAdapter(angelAdapter);
//        angelList.addHeaderView(angelHeadview);
//        angelList.addFooterView(unionFootview2);
//        unionFootview2.findViewById(R.id.ll_footview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, AngelRankingActivity.class);
//                startActivity(intent);
//            }
//        });

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
        rb_main_funtime.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting_main:
                LoginBean.UserinfoBean userInfo = UserManage.getInstance().getUserInfo(MainActivity.this);
                if(userInfo==null){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }else{
                    String role = userInfo.getRole();
                    if(role==null){
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    }else{
                        if (role.equals("0")) {
                            startActivity(new Intent(MainActivity.this,ConsumerSettingActivity.class));
                        } else if (role.equals("10")) {
                            startActivity(new Intent(MainActivity.this,BusinessSettingActivity.class));
                        } else {
                            //其他页面
                            startActivity(new Intent(MainActivity.this,BusinessSettingActivity.class));
                        }
                    }
                }
               // finish();
                break;
            case R.id.iv_ranking_main:
                showPw(iv_ranking_main);
                break;
            //项目推荐
            case R.id.rb_main_goodprojects:
                startActivity(new Intent(this, ProjectRecommendationActivity.class));
                break;
            //互动吧
            case R.id.rb_main_media:
                this.intent = new Intent(this, WebViewActivity.class);
                this.intent.putExtra("Interaction", entrepBaen.getInteraction());
                startActivity(this.intent);
                break;
            //钱盛联盟
            case R.id.rb_main_union:
//                intent = new Intent(this, AllianceMallActivity.class);
//                startActivity(intent);
                intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("qs_union", entrepBaen.getQs_union());
                startActivity(this.intent);
                break;
            //钱盛商城
            case R.id.rb_main_mall:
//                intent = new Intent(this, QSMallActivity1.class);
//                startActivity(intent);
                intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("qs_shop", entrepBaen.getQs_shop());
                startActivity(this.intent);
                break;
            //见证华商
            case R.id.rb_main_WitnessChinaBusiness:
                this.intent = new Intent(this, WebViewActivity.class);
                this.intent.putExtra("WitnessChinaBusiness", entrepBaen.getWitness_url());
                startActivity(this.intent);
                break;
            //人气王
            case R.id.rb_main_Win:
                showDilog();
                tv_dialog_index_title.setText(notices.getIndex_title());
                tv_dialog_index_content.setText(notices.getIndex_content());
                tv_dialog_index_name.setText(notices.getIndex_name());
                tv_dialog_index_department.setText(notices.getIndex_faburen());
                tv_dialog_index_time.setText(notices.getIndex_time());
                break;
            //促销抽奖
            case R.id.rb_main_luckgame:
             //   startActivity(new Intent(this, LuckGameActivity.class));
                this.intent = new Intent(this, WebViewActivity.class);
                this.intent.putExtra("qs_lack_draw", entrepBaen.getQs_lack_draw());
                startActivity(this.intent);
                break;
            //开心一刻
            case R.id.rb_main_funtime:
                this.intent = new Intent(this, WebViewActivity.class);
                this.intent.putExtra("qs_fun", entrepBaen.getQs_fun());
                startActivity(this.intent);
                break;
            case R.id.ll_ranking_popup:
                   startActivity(new Intent(MainActivity.this,PopRankingActivity.class));
                break;
            case R.id.ll_notice_popup:
                startActivity(new Intent(MainActivity.this,NoticeActivity.class));
                break;
            case R.id.ll_yzqs_popup:
                this.intent = new Intent(this, WebViewActivity.class);
                this.intent.putExtra("winqs",entrepBaen.getWinqs());
                startActivity(this.intent);
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
        ll_notice_popup = (LinearLayout) layout.findViewById(R.id.ll_notice_popup);
        ll_yzqs_popup = (LinearLayout) layout.findViewById(R.id.ll_yzqs_popup);

        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.TOP | Gravity.RIGHT, 10, 120);
        ll_ranking_popup.setOnClickListener(this);
        ll_notice_popup.setOnClickListener(this);
        ll_yzqs_popup.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   imageSwitchView.clear();
    }


    static class MyObservable extends Observable {
        public void setChanged() {
            super.setChanged();
        }
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