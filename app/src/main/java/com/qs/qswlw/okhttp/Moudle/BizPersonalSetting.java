package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.PersonalSettingBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.PersonalSettingBaseListener;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/8/30.
 */

public class BizPersonalSetting implements IPersonalSettingBiz {
    private static BizPersonalSetting testMoudle;

    public synchronized static BizPersonalSetting getInstans() {
        if (testMoudle == null)
            testMoudle = new BizPersonalSetting();
        return testMoudle;
    }

    public BizPersonalSetting() {
    }


    /**
     * 得到数据
     *
     * @param personalSettingBaseListener
     */
    @Override
    public void getAllData(final PersonalSettingBaseListener personalSettingBaseListener, final String token) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<PersonalSettingBean>>() {
            @Override
            public void onError(Throwable e) {
                System.out.println("=========onError==============" + e);
                personalSettingBaseListener.onFailure("网络异常" + e);
            }

            @Override
            public void onNext(MainBean<PersonalSettingBean> personalSettingBeanMainBean) {
                if (personalSettingBeanMainBean.getResult() == null||personalSettingBeanMainBean.getSucc()!=1) {
                    personalSettingBaseListener.onFailure("错误代码" + personalSettingBeanMainBean.getStatus() + "错误提示" + personalSettingBeanMainBean.getMsg());
                    return;
                }

                personalSettingBaseListener.OnSucess(personalSettingBeanMainBean);

            }

            @Override
            public Observable<MainBean<PersonalSettingBean>> getObservable(MyRetroService retrofit) {
                return retrofit.getPersonalData(token);
            }
        });
    }
}
