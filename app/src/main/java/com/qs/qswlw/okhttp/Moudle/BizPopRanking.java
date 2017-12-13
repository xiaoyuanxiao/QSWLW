package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.PopRankingBean;
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
    public void getdata(final PopRankingListener popRankingListener, final String role, final String time_slot) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<PopRankingBean>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("BizPopRanking",e+"");
            }

            @Override
            public void onNext(MainBean<PopRankingBean> popRankingBeanMainBean) {
                PopRankingBean result = popRankingBeanMainBean.getResult();
                popRankingListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<PopRankingBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getPopRankingData(role,time_slot);
            }
        });
    }
}
