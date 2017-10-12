package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyProfitBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyProfitListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public class BizMyProfit implements IMyProfitBiz {

    private static BizMyProfit testMoudle;


    public synchronized static BizMyProfit getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyProfit();
        return testMoudle;
    }
    @Override
    public void getdata(final MyProfitListener myProfitListener ,final String token, final int p) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyProfitBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyProfitBean> myProfitBizMainBean) {
                MyProfitBean result = myProfitBizMainBean.getResult();
                int status = myProfitBizMainBean.getStatus();
                if (status == -4||status == -3) {
                    myProfitListener.onTokenFail();
                }
                myProfitListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MyProfitBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMyProfitData(token,p);
            }
        });

    }
}
