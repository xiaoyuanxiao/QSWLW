package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MerchantAuditClickBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MerchantAuditClickListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class BizMerchantAuditClick implements IMerchantAuditClickBiz {
    private static BizMerchantAuditClick testMoudle;

    public synchronized static BizMerchantAuditClick getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMerchantAuditClick();
        return testMoudle;
    }

    @Override
    public void getdata(final MerchantAuditClickListener merchantAuditClickListener, final String token, final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MerchantAuditClickBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MerchantAuditClickBean> merchantAuditBeanMainBean) {
                MerchantAuditClickBean result = merchantAuditBeanMainBean.getResult();
                merchantAuditClickListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MerchantAuditClickBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMerchantAuditClickData(token,id);
            }
        });
    }
}
