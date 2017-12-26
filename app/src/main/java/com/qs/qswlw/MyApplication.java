package com.qs.qswlw;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by xiaoyu on 2017/4/14.
 */

public class MyApplication extends Application {
    public static  String QSTEGONG = "";
    public static  String QSXIANFU = "";
    public static  String QSCHONGZHI = "";
    public static  String QSCOMMENT =  "";
    public static  String QSLACK = "";
    public static  String QSFUN = "" ;
    public static  String QSSPGL = "" ;
    public static String QSZY = "";
    public static int WIDTH = 240;
    public static int Height = 100;
    public static int ENTREPHEIGHT = 100;
    public static String TOKEN = "";
    public static String USERROLE = "";
    public static String NICKNAME = "";
    public static String ROLE = "";
    public static String ID = "";
    public static String QSSHOP = "";
    public static String QSCAT = "";
    public static String QSCART = "";
    public static String QSMINE = "";
    public static String MOBILE = "";
    public static String CYZXID = "";
    public static int POSITION = 0 ;
    private static Application app ;

    public static Application getApplication()

    {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(this)
                .build();//开始构建

        ImageLoader.getInstance().init(config);
    }
}
