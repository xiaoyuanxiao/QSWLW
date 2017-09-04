package com.qs.qswlw;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by xiaoyu on 2017/4/14.
 */

public class MyApplication extends Application {
    public static int WIDTH = 240;
    public static int Height = 100;
    public static int ENTREPHEIGHT = 100;
    public static String TOKEN = "";

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(this)
                .build();//开始构建

        ImageLoader.getInstance().init(config);
    }
}
