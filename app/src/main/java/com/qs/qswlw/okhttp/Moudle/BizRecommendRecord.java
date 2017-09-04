package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.RecommendRecordListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class BizRecommendRecord implements IRecommendRecordBiz{
    private static BizRecommendRecord testMoudle;

    public BizRecommendRecord() {
    }
    public synchronized static BizRecommendRecord getInstans() {
        if (testMoudle == null)
            testMoudle = new BizRecommendRecord();
        return testMoudle;
    }

    @Override
    public void getdata(final RecommendRecordListener recommendRecordBaseListener, final String token, final int p, final String search_name, final String tab_name) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<RecommendedRecordsBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<RecommendedRecordsBean> recommendedRecordsBeanMainBean) {
                RecommendedRecordsBean result = recommendedRecordsBeanMainBean.getResult();
                recommendRecordBaseListener.onSuccess(result.getResult());
            }

            @Override
            public Observable<MainBean<RecommendedRecordsBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getRecommendRecordData(token,p,search_name,tab_name);
            }
        });
    }
}
