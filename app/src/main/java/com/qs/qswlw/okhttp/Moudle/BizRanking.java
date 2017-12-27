package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.RankingBaseListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class BizRanking implements IRankingBiz {
    private static BizRanking testMoudle;

    private BizRanking() {
    }

    public synchronized static BizRanking getInstans() {
        if (testMoudle == null)
            testMoudle = new BizRanking();
        return testMoudle;
    }

    /**
     *
     * @param baseOnlistener
     * @param code
     */
    public void getdata(final RankingBaseListener baseOnlistener, final int code) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RankingBean>>() {
            @Override
            public Observable<MainBean<RankingBean>> getObservable(MyRetroService retrofit) {
                String vaule = "";
                if (code == 300)
                    vaule = "yue";
                else if (code == 200)
                    vaule = "zhou";
                else if (code == 100)
                    vaule = "ri";
                return retrofit.getRankingData(vaule);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MainBean<RankingBean> data) {
                RankingBean result = data.getResult();
                baseOnlistener.onSuccess(result.getSingle_log());
            }
        });
    }

}
