package com.qs.qswlw.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.activity.MainActivity;

import java.lang.reflect.Type;

/**
 * Created by burning on 2017/8/15.
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * -------------------------//┏┓　　　┏┓
 * -------------------------//┏┛┻━━━┛┻┓
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　━　　　┃
 * -------------------------//┃　┳┛　┗┳　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┃　　　┻　　　┃
 * -------------------------//┃　　　　　　　┃
 * -------------------------//┗━┓　　　┏━┛
 * -------------------------//┃　　　┃  神兽保佑
 * -------------------------//┃　　　┃  代码无BUG！
 * -------------------------//┃　　　┗━━━┓
 * -------------------------//┃　　　　　　　┣┓
 * -------------------------//┃　　　　　　　┏┛
 * -------------------------//┗┓┓┏━┳┓┏┛
 * -------------------------// ┃┫┫　┃┫┫
 * -------------------------// ┗┻┛　┗┻┛
 */

public class Gsonutils<T> {

    public T fromJson(String json) {
        Type type = new TypeToken<T>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    public void test() {
        String json = null;
        MainActivity tobean = new Gsonutils<MainActivity>().fromJson(json);
    }
}
