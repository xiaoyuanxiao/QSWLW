package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyRoleDatailBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyRoleDetailListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class BizMyRoleDetail implements IMyRoleDetailBiz{

    private static BizMyRoleDetail testMoudle;

    public synchronized static BizMyRoleDetail getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyRoleDetail();
        return testMoudle;
    }

    @Override
    public void getdata(final MyRoleDetailListener myRoleDetailListener, final String a, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyRoleDatailBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyRoleDatailBean> myRoleDatailBeanMainBean) {
                int status = myRoleDatailBeanMainBean.getStatus();
                if(status==-3||status==-4){
                    myRoleDetailListener.onTokenFail();
                }if(status==1){
                    myRoleDetailListener.onSuccess(myRoleDatailBeanMainBean.getResult());
                }

            }

            @Override
            public Observable<MainBean<MyRoleDatailBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMyRoleDatailData(a,token);
            }
        });
    }
}
