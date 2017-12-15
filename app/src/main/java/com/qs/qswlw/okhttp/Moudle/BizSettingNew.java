package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.SettingNewListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class BizSettingNew implements ISettingNewBiz {
    private static BizSettingNew testMoudle;
    public synchronized static BizSettingNew getInstans(){
        if (testMoudle == null)
            testMoudle = new BizSettingNew();
        return testMoudle;
    }
    @Override
    public void getdata(final SettingNewListener settingNewListener, final String token, final int user_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<SettingNewsBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<SettingNewsBean> settingNewsBeanMainBean) {
                SettingNewsBean result = settingNewsBeanMainBean.getResult();
                settingNewListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<SettingNewsBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getSettingNewData(token,user_id);
            }
        });
    }
}
