package com.qs.qswlw.okhttp.Moudle;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.NoticesListener;

import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public class BizNotices implements INoticesBiz {
    private static BizNotices testMoudle;

    public synchronized static BizNotices getInstans() {
        if (testMoudle == null)
            testMoudle = new BizNotices();
        return testMoudle;
    }
    @Override
    public void getdata(final NoticesListener noticesListener) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<List<NoticesBean>>>() {

            @Override
            public void onError(Throwable e) {
                Log.e("BizNotices",e+"");
            }

            @Override
            public void onNext(MainBean<List<NoticesBean>> noticesBeen) {
                noticesListener.onSuccess(noticesBeen);
            }

            @Override
            public Observable<MainBean<List<NoticesBean>>> getObservable(MyRetroService retrofit) {
                return retrofit.getNotices();
            }
        });
    }
}
