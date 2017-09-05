package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.OldMemberBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.OldMemberListener;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class BizOldMember  implements  IOldMemberBiz{
    private static BizOldMember testMoudle;

    private BizOldMember() {
    }

    public synchronized static BizOldMember getInstans() {
        if (testMoudle == null)
            testMoudle = new BizOldMember();
        return testMoudle;
    }
    public void getdata(final OldMemberListener oldMemberListener, final String token, final String member_number, final String member_type){
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<OldMemberBean>>(){

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<OldMemberBean> oldMemberBeanMainBean) {
                OldMemberBean result = oldMemberBeanMainBean.getResult();
                ToastUtils.showToast(oldMemberBeanMainBean.getMsg());
                oldMemberListener.success(result);
            }

            @Override
            public Observable<MainBean<OldMemberBean>> getObservable(MyRetroService retrofit) {
                return retrofit.postOldMemberData(token,member_number,member_type);
            }
        });
    }

}
