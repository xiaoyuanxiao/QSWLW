package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MerchantAuditListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class BizMerchantAudit implements IMerchantAuditBiz {
    private static BizMerchantAudit testMoudle;

    public synchronized static BizMerchantAudit getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMerchantAudit();
        return testMoudle;
    }

    @Override
    public void getdata(final MerchantAuditListener merchantAuditListener, final String token, final int p, final int is_ok) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MerchantAuditBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MerchantAuditBean> merchantAuditBeanMainBean) {
                MerchantAuditBean result = merchantAuditBeanMainBean.getResult();
                merchantAuditListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MerchantAuditBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMerchantAuditData(token,p,is_ok);
            }
        });
    }
}
