package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.ConsumptionLimitBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ConsumptionLimitListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class BizConsumptionLimit implements IConsumptionLimitBiz {
    private static BizConsumptionLimit testMoudle;

    public synchronized static BizConsumptionLimit getInstans() {
        if (testMoudle == null)
            testMoudle = new BizConsumptionLimit();
        return testMoudle;
    }

    @Override
    public void getdata(final ConsumptionLimitListener consumptionLimitListener, final String token,final int p) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ConsumptionLimitBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("e",e+"");
            }

            @Override
            public void onNext(MainBean<ConsumptionLimitBean> consumptionLimitBeanMainBean) {
                ConsumptionLimitBean result = consumptionLimitBeanMainBean.getResult();
                consumptionLimitListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ConsumptionLimitBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getConsumptionLimitData(token,p);
            }
        });
    }
}
