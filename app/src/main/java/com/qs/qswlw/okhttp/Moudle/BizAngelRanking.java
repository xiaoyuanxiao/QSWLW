package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.AngelRankingBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.AngelRankingBaseListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class BizAngelRanking implements IAngelRankingBiz {
    private static BizAngelRanking testMoudle;

    private BizAngelRanking() {
    }

    public synchronized static BizAngelRanking getInstans() {
        if (testMoudle == null)
            testMoudle = new BizAngelRanking();
        return testMoudle;
    }

    /**
     *
     * @param angelRankingBaseListener
     * @param code
     */

    @Override
    public void getdata(final AngelRankingBaseListener angelRankingBaseListener, final int code) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<AngelRankingBean>>() {
            @Override
            public Observable<MainBean<AngelRankingBean>> getObservable(MyRetroService retrofit) {
                String vaule = "";

                if (code == 300)
                    vaule = "yue";
                else if (code == 200)
                    vaule = "zhou";
                else if (code == 100)
                    vaule = "ri";
                return retrofit.getAngelRankingData(vaule);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MainBean<AngelRankingBean> data) {
                AngelRankingBean result = data.getResult();
                angelRankingBaseListener.onSuccess(result.getSaleman());
            }
        });
    }
}
