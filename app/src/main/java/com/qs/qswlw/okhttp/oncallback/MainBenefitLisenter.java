package com.qs.qswlw.okhttp.oncallback;


import com.qs.qswlw.bean.Maindatabean;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public abstract class MainBenefitLisenter implements MainBaseListener<Maindatabean.Area> {
    @Override
    public void onFailure(String code) {

    }

    @Override
    public void onSuccess(Maindatabean.Area list) {

    }
}
