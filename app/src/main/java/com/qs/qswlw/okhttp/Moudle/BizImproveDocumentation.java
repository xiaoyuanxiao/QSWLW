package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.ImproveDocumentationBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ImproveDocumentationListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class BizImproveDocumentation implements IImproveDocumentationBiz{
    private static BizImproveDocumentation testMoudle;

    public synchronized static BizImproveDocumentation getInstans() {
        if (testMoudle == null)
            testMoudle = new BizImproveDocumentation();
        return testMoudle;
    }
    @Override
    public void getdata(final ImproveDocumentationListener improveDocumentationListener, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ImproveDocumentationBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("ImproveDocumentationListener",e+"");
            }

            @Override
            public void onNext(MainBean<ImproveDocumentationBean> improveDocumentationBeanMainBean) {
                ImproveDocumentationBean result = improveDocumentationBeanMainBean.getResult();
                improveDocumentationListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ImproveDocumentationBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getImproveDocumentationData(token);
            }
        });
    }
}
