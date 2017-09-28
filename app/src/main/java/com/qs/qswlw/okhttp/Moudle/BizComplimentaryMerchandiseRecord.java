package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ComplimentaryMerchandiseRecordListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class BizComplimentaryMerchandiseRecord implements  IComplimentaryMerchandiseRecordBiz {

    private static BizComplimentaryMerchandiseRecord testMoudle;

    public synchronized static BizComplimentaryMerchandiseRecord getInstans() {
        if (testMoudle == null)
            testMoudle = new BizComplimentaryMerchandiseRecord();
        return testMoudle;
    }

    @Override
    public void getdata(final ComplimentaryMerchandiseRecordListener complimentaryMerchandiseRecordListener, final String token, final int p, final int is_review) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ComplimentaryMerchandiseRecordBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ComplimentaryMerchandiseRecordBean> complimentaryMerchandiseRecordBeanMainBean) {
                ComplimentaryMerchandiseRecordBean result = complimentaryMerchandiseRecordBeanMainBean.getResult();
                complimentaryMerchandiseRecordListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ComplimentaryMerchandiseRecordBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getComplimentaryMerchandiseData(token,p,is_review);
            }
        });
    }
}
