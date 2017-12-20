package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.ReceivingAddressBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.ReceivingAddressListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/20.
 */

public class BizReceivingAddress implements IReceivingAddressBiz {
    private static BizReceivingAddress testMoudle;

    public synchronized static BizReceivingAddress getInstans() {
        if (testMoudle == null)
            testMoudle = new BizReceivingAddress();
        return testMoudle;
    }

    @Override
    public void getdata(final ReceivingAddressListener receivingAddressListener, final String token, final int cyzx_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<ReceivingAddressBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<ReceivingAddressBean> receivingAddressBeanMainBean) {
                ReceivingAddressBean result = receivingAddressBeanMainBean.getResult();
                int status = receivingAddressBeanMainBean.getStatus();
                if(status==-3||status==-4){
                    receivingAddressListener.onTokenFail();
                }
                receivingAddressListener.OnSuccess(result);
            }

            @Override
            public Observable<MainBean<ReceivingAddressBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getReceivingAddressData(token,cyzx_id);
            }
        });
    }
}
