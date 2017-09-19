package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.WithDrawalsRecordListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class BizWithDrawalsRecord  implements IWithDrawalsRecordBiz{
    private static BizWithDrawalsRecord testMoudle;
    public synchronized static BizWithDrawalsRecord getInstans(){
        if(testMoudle==null){
            testMoudle = new BizWithDrawalsRecord();
        }
        return testMoudle;
    }
    @Override
    public void getdata(final WithDrawalsRecordListener withDrawalsRecordListener, final String token, final int p, final String status) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<WithDrawalsRecordBean>>() {

            @Override
            public void onError(Throwable e) {

            }


            @Override
            public void onNext(MainBean<WithDrawalsRecordBean> withDrawalsRecordBeanMainBean) {
                WithDrawalsRecordBean result = withDrawalsRecordBeanMainBean.getResult();
                withDrawalsRecordListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<WithDrawalsRecordBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getWithDrawalsRecordData(token,p,status);
            }
        });

    }
}
