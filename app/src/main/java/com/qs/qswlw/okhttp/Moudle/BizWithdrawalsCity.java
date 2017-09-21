package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsCityBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsCityListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/21.
 */

public class BizWithdrawalsCity implements IWithdrawalsCityBiz{
    private static BizWithdrawalsCity testMoudle;


    public synchronized static BizWithdrawalsCity getInstans() {
        if (testMoudle == null)
            testMoudle = new BizWithdrawalsCity();
        return testMoudle;
    }
    @Override
    public void getdata(final WithdrawalsCityListener withdrawalsCityListener, final String token, final int pid) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<WithdrawalsCityBean>>() {

            @Override
            public void onError(Throwable e) {

            }


            @Override
            public void onNext(MainBean<WithdrawalsCityBean> withdrawalsCityBeanMainBean) {
                WithdrawalsCityBean result = withdrawalsCityBeanMainBean.getResult();
                withdrawalsCityListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<WithdrawalsCityBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getWithdrawalsCityData(token,pid);
            }
        });
    }
}
