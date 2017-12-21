package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.MyBonusListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class BizMyBonus implements IMyBonusBiz {
    private static BizMyBonus testMoudle;

    public synchronized static BizMyBonus getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMyBonus();
        return testMoudle;
    }
    @Override
    public void getdata(final MyBonusListener myBonusListener, final String token, final int user_id, final String bonus_type) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<MyBonusBean>>() {
            @Override
            public Observable getObservable(MyRetroService retrofit) {
                return retrofit.getMyBonusData(token,user_id,bonus_type);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<MyBonusBean> myBonusBeanMainBean) {
                int status = myBonusBeanMainBean.getStatus();
                if(status==-3||status==-4){
                    myBonusListener.onTokenFail();
                }else if(status==1){
                    myBonusListener.OnSuccess(myBonusBeanMainBean.getResult());
                }

            }

        });
    }
}
