package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.ScanCodeRecordBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ScanCodeRecordListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class BizScanCodeRecord implements IScanCodeRecordBiz {
    private static BizScanCodeRecord testMoudle;
    public synchronized static BizScanCodeRecord getInstans(){
        if (testMoudle == null)
            testMoudle = new BizScanCodeRecord();
        return testMoudle;
    }


    @Override
    public void getData(final ScanCodeRecordListener scanCodeRecordListener, final String token, final int p, final int is_ok) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ScanCodeRecordBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ScanCodeRecordBean> scanCodeRecordBeanMainBean) {
                ScanCodeRecordBean result = scanCodeRecordBeanMainBean.getResult();
                scanCodeRecordListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<ScanCodeRecordBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getScanCodeRecordData(token,p,is_ok);
            }
        });
    }
}
