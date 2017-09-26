package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MySpendingLimitBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MySpendingLimitListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class BizMySpendingLimit implements IMySpendingLimitBiz {
    private static BizMySpendingLimit testMoudle;

    public synchronized static BizMySpendingLimit getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMySpendingLimit();
        return testMoudle;
    }
    @Override
    public void getdata(final MySpendingLimitListener mySpendingLimitListener, final String token, final int p, final int tab_status) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MySpendingLimitBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MySpendingLimitBean> mySpendingLimitBeanMainBean) {
                MySpendingLimitBean result = mySpendingLimitBeanMainBean.getResult();
                mySpendingLimitListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MySpendingLimitBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMySpendingLimitData(token,p,tab_status);
            }
        });
    }
}
