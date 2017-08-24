package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.Maindatabean;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public abstract class MainUnionLisenter implements MainBaseListener<Maindatabean.Shop> {
    @Override
    public void onFailure(String code) {

    }

    @Override
    public void onSuccess(Maindatabean.Shop list) {

    }
}
