package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.EntrepreneurialListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public class BizEntrepreneurial implements IEntrepreneurialBiz {
    private static BizEntrepreneurial testMoudle;

    private BizEntrepreneurial() {
    }

    public synchronized static BizEntrepreneurial getInstans() {
        if (testMoudle == null)
            testMoudle = new BizEntrepreneurial();
        return testMoudle;
    }


    @Override
    public void getEntrepreneurialData(final EntrepreneurialListener entrepreneuriaListener, final String token, final int p, final String model) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<EntrepreneurialIncentiveBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("e",e+"");
            }

            @Override
            public void onNext(MainBean<EntrepreneurialIncentiveBean> data) {
                EntrepreneurialIncentiveBean result = data.getResult();
                entrepreneuriaListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<EntrepreneurialIncentiveBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getEntrepreneurialData(token,p,model);
            }
        });
    }
}
