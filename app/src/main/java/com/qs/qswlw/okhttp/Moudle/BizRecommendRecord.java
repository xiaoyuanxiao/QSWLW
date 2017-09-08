package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.RecommendRecordListener;

import java.util.List;

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
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<List<RecommendedRecordsBean>>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("RecommendRecordListener",e+"");
            }

            @Override
            public void onNext(MainBean<List<RecommendedRecordsBean>> recommendedRecordsBeanMainBean) {
                recommendRecordBaseListener.onSuccess(recommendedRecordsBeanMainBean);
            }

            @Override
            public Observable<MainBean<List<RecommendedRecordsBean>>> getObservable(MyRetroService retrofit) {
                return retrofit.getRecommendRecordData(token,p,search_name,tab_name);
            }
        });
    }
}
