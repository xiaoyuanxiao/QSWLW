package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsFailedModifyBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsFailedModifyListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/22.
 */

public class BizWithdrawalsFailedModify implements IWithdrawalsFailedModifyBiz{
    private static BizWithdrawalsFailedModify testMoudle;


    public synchronized static BizWithdrawalsFailedModify getInstans() {
        if (testMoudle == null)
            testMoudle = new BizWithdrawalsFailedModify();
        return testMoudle;
    }

    @Override
    public void getdata(final WithdrawalsFailedModifyListener withdrawalsFailedModifyListener, final String token,final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<WithdrawalsFailedModifyBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<WithdrawalsFailedModifyBean> withdrawalsFailedModifyBeanMainBean) {
                WithdrawalsFailedModifyBean result = withdrawalsFailedModifyBeanMainBean.getResult();
                withdrawalsFailedModifyListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<WithdrawalsFailedModifyBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getWithdrawalsFailedModify(token,id);
            }
        });
    }
}
