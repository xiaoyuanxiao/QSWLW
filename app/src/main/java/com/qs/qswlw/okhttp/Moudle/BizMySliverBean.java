package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MySliverBeanListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class BizMySliverBean implements IMySliverBeanBiz {
    private static BizMySliverBean testMoudle;

    public BizMySliverBean() {
    }
    public synchronized static BizMySliverBean getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMySliverBean();
        return testMoudle;
    }

    @Override
    public void getdata(final MySliverBeanListener mySliverBeanListener, final String token, final int p) {

        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MySliverBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("e",e+"");

            }

            @Override
            public void onNext(MainBean<MySliverBean> mySliverBeanMainBean) {
                MySliverBean result = mySliverBeanMainBean.getResult();
                mySliverBeanListener.onSuccess(result);

            }

            @Override
            public Observable<MainBean<MySliverBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getMySliverBeanData(token,p);
            }
        });
    }
}
