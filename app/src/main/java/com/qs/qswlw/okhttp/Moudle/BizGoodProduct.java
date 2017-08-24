package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ProductBaseListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public class BizGoodProduct implements IProductBiz {
    private static BizGoodProduct testMoudle;

    private BizGoodProduct() {
    }

    public synchronized static BizGoodProduct getInstans() {
        if (testMoudle == null)
            testMoudle = new BizGoodProduct();
        return testMoudle;
    }

    public void getdata(final ProductBaseListener baseOnlistener) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<GoodProductBean>>() {
            @Override
            public Observable<MainBean<GoodProductBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getGoodproductdata();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MainBean<GoodProductBean> data) {
                GoodProductBean result = data.getResult();
                baseOnlistener.onSuccess(result);
            }
        });
    }

}
