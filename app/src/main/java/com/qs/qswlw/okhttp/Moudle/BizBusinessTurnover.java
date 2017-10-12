package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.BusinessTurnoverBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.BusinessTurnoverListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class BizBusinessTurnover implements IBusinessTurnoverBiz{
    private static BizBusinessTurnover testMoudle;

    public synchronized static BizBusinessTurnover getInstans() {
        if (testMoudle == null)
            testMoudle = new BizBusinessTurnover();
        return testMoudle;
    }
    @Override
    public void getdata(final BusinessTurnoverListener businessTurnoverListener, final String token, final int p, final int is_history) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<BusinessTurnoverBean>>() {
            @Override
            public Observable<MainBean<BusinessTurnoverBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getBusinessTurnoverData(token,p,is_history);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MainBean<BusinessTurnoverBean> data) {
                BusinessTurnoverBean result = data.getResult();
                int status = data.getStatus();
                if (status == -4||status == -3) {
                    businessTurnoverListener.onTokenFail();
                }
                businessTurnoverListener.onSuccess(result);
            }
        });
    }
}
