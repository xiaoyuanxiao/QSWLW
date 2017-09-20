package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyBankListListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class BizMyBankList implements IMyBankListBiz {
    private static BizMyBankList testMoudle;

    public synchronized static BizMyBankList getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyBankList();
        return testMoudle;
    }

    @Override
    public void getdata(final MyBankListListener myBankListListener, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyBankListBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyBankListBean> myBankListBeanMainBean) {
                MyBankListBean result = myBankListBeanMainBean.getResult();
                myBankListListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<MyBankListBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMyBankListData(token);
            }
        });
    }
}
