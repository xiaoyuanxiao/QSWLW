package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyRoleListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class BizMyRole implements IMyRoleBiz{
    private static BizMyRole testMoudle;
    private BizMyRole() {
    }
    public synchronized static BizMyRole getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyRole();
        return testMoudle;
    }

    @Override
    public void getdata(final MyRoleListener myRoleListener, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyRoleBean>>(){

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyRoleBean> myRoleBeanMainBean) {
                MyRoleBean result = myRoleBeanMainBean.getResult();
                myRoleListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MyRoleBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMyRoleData(token);
            }
        });
    }
}
