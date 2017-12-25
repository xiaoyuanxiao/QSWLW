package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.UserIDSearchBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.UserIDSearchListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class BizUserIDSearch implements IUserIDSearchBiz {
    private static BizUserIDSearch testMoudle;
    public synchronized static BizUserIDSearch getInstans(){
        if (testMoudle == null)
            testMoudle = new BizUserIDSearch();
        return testMoudle;
    }
    @Override
    public void getdata(final UserIDSearchListener userIDSearchListener, final String token, final int uid, final int user_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<UserIDSearchBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<UserIDSearchBean> userIDSearchBeanMainBean) {
                userIDSearchListener.onSuccess(userIDSearchBeanMainBean.getResult());
            }

            @Override
            public Observable<MainBean<UserIDSearchBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getUserIDSearchData(token,uid,user_id);
            }
        });
    }
}
