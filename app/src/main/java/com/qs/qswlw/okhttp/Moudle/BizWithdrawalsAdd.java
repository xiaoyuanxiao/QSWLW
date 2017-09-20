package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsAddListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class BizWithdrawalsAdd implements IWithdrawalsAddBiz {
    private static BizWithdrawalsAdd testMoudle;


    public synchronized static BizWithdrawalsAdd getInstans() {
        if (testMoudle == null)
            testMoudle = new BizWithdrawalsAdd();
        return testMoudle;
    }
    @Override
    public void getData(final WithdrawalsAddListener withdrawalsAddListener, final String token, final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<WithdrawalsAddBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("BizWithdrawals",e+"");
            }

            @Override
            public void onNext(MainBean<WithdrawalsAddBean> withdrawalsAddBeanMainBean) {
                withdrawalsAddListener.onSuccess(withdrawalsAddBeanMainBean.getResult());
            }

            @Override
            public Observable<MainBean<WithdrawalsAddBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getWithdrawalsAddData(token,id);
            }
        });
    }
}
