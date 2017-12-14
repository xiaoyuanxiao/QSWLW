package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.SetModifyBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.SetModifyListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/14.
 */

public class BizSetModify implements ISetModifyBiz {
    private static BizSetModify testMoudle;

    public synchronized static BizSetModify getInstans() {
        if (testMoudle == null)
            testMoudle = new BizSetModify();
        return testMoudle;
    }
    @Override
    public void getData(final SetModifyListener setModifyListener, final String token, final int user_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<SetModifyBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<SetModifyBean> setModifyBeanMainBean) {
                SetModifyBean result = setModifyBeanMainBean.getResult();
                setModifyListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<SetModifyBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getSetModifyData(token,user_id);
            }
        });
    }
}
