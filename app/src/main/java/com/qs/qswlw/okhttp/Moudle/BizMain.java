package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBaseListener;


import java.lang.reflect.Type;
import java.util.HashMap;

import rx.Observable;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class BizMain implements IMainBiz {
    private static BizMain testMoudle;

    private BizMain() {
    }

    public synchronized static BizMain getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMain();
        return testMoudle;
    }


    private final String index_data = "index_data";
    private final String alert = "alert";
    private final String union = "union";
    private final String entrep = "entrep";
    private final String angel = "angel";
    private final String china = "china";
    private final String luck = "luck";
    private final String benefit = "benefit";
    private Maindatabean result;

    public void getALLdata(final MainBaseListener baseOnlistener) {

        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<Maindatabean>>() {
            @Override
            public Observable<MainBean<Maindatabean>> getObservable(MyRetroService retrofit) {
                   System.out.println("=========onError=============="+retrofit.toString());
                return retrofit.getALLdata();
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("=========onError==============" + e);
            }

            @Override
            public void onNext(MainBean<Maindatabean> testBean) {
                baseOnlistener.onSuccess(testBean);
                System.out.println("============onNext=================" + testBean.toString());
            }
        });

    }

    //这是弹框,doushuole，这是dialog
    @Override
    public void getAlert(final MainAlertLisenter mainAlertLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, alert);//
        Type type = new TypeToken<BaseBean<ResultAlertBean<AlertBean>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultAlertBean<AlertBean>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultAlertBean<AlertBean>> data) {
                        AlertBean result = null;
                        try {
                            result = data.getResult().getAlert();

                        } catch (Exception e) {

                        }
                        if (result == null)
                            mainAlertLisenter.onFailure("错误信息");
                        else
                            mainAlertLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainAlertLisenter.onFailure("错误信息" + code);
                    }
                });

    }


}
