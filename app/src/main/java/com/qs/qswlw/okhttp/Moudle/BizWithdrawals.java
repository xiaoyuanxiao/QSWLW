package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class BizWithdrawals implements IWithdrawalsBiz{
    private static BizWithdrawals testMoudle;


    public synchronized static BizWithdrawals getInstans() {
        if (testMoudle == null)
            testMoudle = new BizWithdrawals();
        return testMoudle;
    }
    @Override
    public void getdata(final WithdrawalsListener withdrawalsListener, final String token) {
         ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<WithdrawalsBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("BizWithdrawals",e+"");
            }

            @Override
            public void onNext(MainBean<WithdrawalsBean> withdrawalsBeanMainBean) {
                int status = withdrawalsBeanMainBean.getStatus();
                if (status == -4||status == -3) {
                    withdrawalsListener.onTokenFail();
                }
                withdrawalsListener.onSuccess(withdrawalsBeanMainBean.getResult());
            }

            @Override
            public Observable<MainBean<WithdrawalsBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getWithDrawalsData(token);
            }
        });
    }
}
