package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.ValidateOldMemberBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ValidateOldMemberListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class BizValidateOldMember implements  IValidateOldMemberBiz{
    private static BizValidateOldMember testMoudle;

    private BizValidateOldMember() {
    }

    public synchronized static BizValidateOldMember getInstans() {
        if (testMoudle == null)
            testMoudle = new BizValidateOldMember();
        return testMoudle;
    }
    public void getdata(final ValidateOldMemberListener validateOldMemberListener, final String token){
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ValidateOldMemberBean>>(){

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ValidateOldMemberBean> validateOldMemberBeanMainBean) {
                ValidateOldMemberBean result = validateOldMemberBeanMainBean.getResult();
                validateOldMemberListener.success(result);
            }

            @Override
            public Observable<MainBean<ValidateOldMemberBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getOldMemberData(token);
            }
        });
    }

}
