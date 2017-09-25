package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ConsumptionLimitRechargeListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class BizConsumptionLimitRecharge implements  IConsumptionLimitRechargeBiz {
    private static BizConsumptionLimitRecharge testMoudle;

    private BizConsumptionLimitRecharge() {
    }

    public synchronized static BizConsumptionLimitRecharge getInstans() {
        if (testMoudle == null)
            testMoudle = new BizConsumptionLimitRecharge();
        return testMoudle;
    }
    @Override
    public void getdata(final ConsumptionLimitRechargeListener consumptionLimitRechargeListener, final String token, final String recharge_type) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ConsumptionLimitRechargeBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ConsumptionLimitRechargeBean> consumptionLimitRechargeBeanMainBean) {
                ConsumptionLimitRechargeBean result = consumptionLimitRechargeBeanMainBean.getResult();
                consumptionLimitRechargeListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ConsumptionLimitRechargeBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getConsumptionLimitRechargeData(token,recharge_type);
            }
        });
    }
}
