package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ConsumptionRecordListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public class BizConsumptionRecord implements IConsumptionRecordBiz {
    private static BizConsumptionRecord testMoudle;

    private BizConsumptionRecord() {
    }

    public synchronized static BizConsumptionRecord getInstans() {
        if (testMoudle == null)
            testMoudle = new BizConsumptionRecord();
        return testMoudle;
    }

    @Override
    public void getConsumptionRecordData(final ConsumptionRecordListener consumptionRecordListener, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ConsumptionRecordBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ConsumptionRecordBean> consumptionRecordBeanMainBean) {
                ConsumptionRecordBean result = consumptionRecordBeanMainBean.getResult();
                int status = consumptionRecordBeanMainBean.getStatus();
                if (status == -4||status == -3) {
                    consumptionRecordListener.onTokenFail();
                }
                consumptionRecordListener.onSuccess(consumptionRecordBeanMainBean);
            }

            @Override
            public Observable<MainBean<ConsumptionRecordBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getConsumptionRecordData(token);
            }
        });
    }
}
