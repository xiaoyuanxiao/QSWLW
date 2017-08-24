package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.Maindatabean;

/**
 * Created by 小猴子 on 2017/4/10.
 */

public abstract class MainChinaLisenter implements MainBaseListener<Maindatabean.Goods> {
    @Override
    public void onFailure(String code) {

    }

    @Override
    public void onSuccess(Maindatabean.Goods list) {

    }
}
