package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyOrganizationBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyOrganizationListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class BizMyOrganization implements IMyOrganizationBiz {

    private static BizMyOrganization testMoudle;


    public synchronized static BizMyOrganization getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyOrganization();
        return testMoudle;
    }
    @Override
    public void getdata(final MyOrganizationListener myOrganizationListener, final String token, final int user_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyOrganizationBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyOrganizationBean> myOrganizationBean) {
                myOrganizationListener.onSuccess(myOrganizationBean.getResult());
            }

            @Override
            public Observable<MainBean<MyOrganizationBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMyOrganizationData(token,user_id);
            }
        });
    }
}
