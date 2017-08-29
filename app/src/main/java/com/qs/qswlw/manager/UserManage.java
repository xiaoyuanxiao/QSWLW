package com.qs.qswlw.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.qs.qswlw.bean.LoginBean;

/**
 * Created by xiaoyu on 2017/8/29.
 */

public class UserManage {
    private static UserManage instance;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }

    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, LoginBean.UserinfoBean userinfoBean) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER", new Gson().toJson(userinfoBean));
        editor.putString("NICKNAME", userinfoBean.getNickname());
        editor.putString("MOBILE", userinfoBean.getMobile());
        editor.putString("ISFORZEN", userinfoBean.getIs_frozen());
        editor.putString("REGTIME", userinfoBean.getReg_time());
        editor.putString("TOKEN", userinfoBean.getToken());
        editor.putString("USERID", userinfoBean.getUser_id());
        editor.putString("HEADPIC", userinfoBean.getHead_pic());
        editor.putString("ROLE", userinfoBean.getRole());
        editor.commit();
    }


    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public LoginBean.UserinfoBean getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user = sp.getString("USER", null);
        if (!TextUtils.isEmpty(user)) {
            LoginBean.UserinfoBean userinfoBean = null;
            try {
                userinfoBean = new Gson().fromJson(user, LoginBean.UserinfoBean.class);
            } catch (Exception e) {
                Log.e("getUserInfo",e+"111111");
            }
            return userinfoBean;
        }
        return null;
    }

}
