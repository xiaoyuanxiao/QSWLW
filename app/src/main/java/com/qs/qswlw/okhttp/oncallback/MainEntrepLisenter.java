package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.Maindatabean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public abstract class  MainEntrepLisenter implements MainBaseListener<Maindatabean.Current_sales> {
    @Override
    public void onFailure(String code) {

    }

    @Override
    public void onSuccess(List<Maindatabean.Current_sales> list) {

    }
}
