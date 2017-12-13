package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.PopRankingListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class BizPopRanking implements IPopRankingBiz {
    private static BizPopRanking testMoudle;


    public synchronized static BizPopRanking getInstans() {
        if (testMoudle == null)
            testMoudle = new BizPopRanking();
        return testMoudle;
    }
    @Override
    public void getdata(PopRankingListener popRankingListener, final String role, final String time_slot) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe() {
            @Override
            public Observable getObservable(MyRetroService retrofit) {
                return retrofit.getPopRankingData(role,time_slot);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
    }
}
