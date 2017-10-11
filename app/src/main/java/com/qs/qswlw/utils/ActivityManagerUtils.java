package com.qs.qswlw.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import com.qs.qswlw.activity.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/30.
 */

public class ActivityManagerUtils {
    private static ActivityManagerUtils mActivityManagerUtils;


    static {
        mActivityManagerUtils = new ActivityManagerUtils();
    }

    /**
     * 打开的activity
     **/

    private List<Activity> activities = new ArrayList<Activity>();


    private ActivityManagerUtils() {
        /**
         * 这里面写一些需要执行初始化的工作
         */
    }

    public static void tokenfailfg(final Activity activity) {
        ToastUtils.showToast("token失效请重新登录");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.startActivity(new Intent(activity, LoginActivity.class));
                activity.finish();
            }
        }, 2000);
    }

    public static ActivityManagerUtils getInstance() {
        return mActivityManagerUtils;

    }

    /**
     * 新建了一个activity
     *
     * @param activity
     */

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */

    public void finishActivity(Activity activity) {

        if (activity != null) {
            this.activities.remove(activity);
            activity.finish();
        }
    }

    /**
     * 应用退出，结束所有的activity
     */

    public void exit() {

        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);

    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivityclass(Class<?> cls) {
        if (activities != null) {
            for (Activity activity : activities) {
                if (activity.getClass().equals(cls)) {
                    this.activities.remove(activity);
                    finishActivity(activity);
                    break;
                }
            }
        }

    }
}
