package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyGoldenView;
import com.qs.qswlw.okhttp.Moudle.IVentureGoldBiz;
import com.qs.qswlw.okhttp.oncallback.VenturegoldBeanListener;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class MyGoldenPersenter {
    IVentureGoldBiz iVentureGoldBiz;
    IMyGoldenView iMyGoldenView;

    public MyGoldenPersenter(IMyGoldenView iMyGoldenView) {
        iVentureGoldBiz = IBizFactory.getVentureGold();
        this.iMyGoldenView = iMyGoldenView;
    }

    public void getData(String token, int p, final String model, String gold_type, String type) {
        iVentureGoldBiz.getdata(new VenturegoldBeanListener() {
            @Override
            public void onSuccess(VenturegoldBean venturegoldBean) {
                iMyGoldenView.setVenturegoldBeanData(venturegoldBean);
            }

            @Override
            public void onTokenFail() {
                iMyGoldenView.setTokenFail();
            }
        }, token, p, model, gold_type, type);

    }
}
