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
     * 日月周 都可以用这一个
     *
     * @param baseOnlistener---可以用是三个不同的 回调，怎么写三个呀 这里可以不用
     * @param code
     */
    public void getdata(final RankingBaseListener baseOnlistener, final int code) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RankingBean>>() {
            @Override
            public Observable<MainBean<RankingBean>> getObservable(MyRetroService retrofit) {
                //这是什么   这个是复制的 还没改完 你先看着哈 我改这个了
                // 你可以这样 反正是一样的--什么都不用改
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
