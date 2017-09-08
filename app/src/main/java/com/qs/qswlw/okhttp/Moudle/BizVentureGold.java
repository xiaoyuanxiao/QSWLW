package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.VenturegoldBeanListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class BizVentureGold implements IVentureGoldBiz{
    private static BizVentureGold testMoudle;

    private BizVentureGold() {
    }

    public synchronized static BizVentureGold getInstans() {
        if (testMoudle == null)
            testMoudle = new BizVentureGold();
        return testMoudle;
    }

    @Override
    public void getdata(final VenturegoldBeanListener venturegoldBeanListener, final String token, final int p, final String model, final String gold_type, final String type) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<VenturegoldBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("BizVentureGold",e+"");
            }

            @Override
            public void onNext(MainBean<VenturegoldBean> venturegoldBeanMainBean) {
                venturegoldBeanListener.onSuccess(venturegoldBeanMainBean.getResult());
            }

            @Override
            public Observable<MainBean<VenturegoldBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getVentureGoldData(token,p,model,gold_type,type);
            }
        });
    }
}
