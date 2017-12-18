package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MainBaseListener;

import rx.Observable;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class BizMain implements IMainBiz {
    private static BizMain testMoudle;
    private final String index_data = "index_data";
    private final String alert = "alert";
    private final String union = "union";
    private final String entrep = "entrep";
    private final String angel = "angel";
    private final String china = "china";
    private final String luck = "luck";
    private final String benefit = "benefit";
    private Maindatabean result;
    private BizMain() {
    }

    public synchronized static BizMain getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMain();
        return testMoudle;
    }

    public void getALLdata(final MainBaseListener baseOnlistener) {

        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<Maindatabean>>() {
            @Override
            public Observable<MainBean<Maindatabean>> getObservable(MyRetroService retrofit) {
                   System.out.println("=========onError=============="+retrofit.toString());
                return retrofit.getALLdata();
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("=========BizMainonError==============" + e);
            }

            @Override
            public void onNext(MainBean<Maindatabean> testBean) {
                System.out.println("============onNext=================" + testBean.toString());
                baseOnlistener.onSuccess(testBean);

            }
        });

    }

}
