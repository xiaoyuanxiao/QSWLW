package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.ImproveCityBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ImproveCityListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class BizImproveCity implements IImproveCityBiz {
    private static BizImproveCity testMoudle;

    public synchronized static BizImproveCity getInstans() {
        if (testMoudle == null)
            testMoudle = new BizImproveCity();
        return testMoudle;
    }
    @Override
    public void getdata(final ImproveCityListener improveCityListener, final String token, final int pid) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ImproveCityBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
                public void onNext(MainBean<ImproveCityBean> improveCityBeanMainBean) {
                ImproveCityBean result = improveCityBeanMainBean.getResult();
                improveCityListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ImproveCityBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getImproveCityData(token,pid);
            }
        });
    }
}
