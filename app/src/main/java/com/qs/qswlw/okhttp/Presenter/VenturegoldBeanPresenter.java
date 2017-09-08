package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IVenturegoldBeansView;
import com.qs.qswlw.okhttp.Moudle.IVentureGoldBiz;
import com.qs.qswlw.okhttp.oncallback.VenturegoldBeanListener;

/**
 * Created by xiaoyu on 2017/9/8.
 */

public class VenturegoldBeanPresenter {
    IVentureGoldBiz iVentureGoldBiz;
    IVenturegoldBeansView iVenturegoldBeansView;

    public VenturegoldBeanPresenter(IVenturegoldBeansView iVenturegoldBeansView) {
        iVentureGoldBiz = IBizFactory.getVentureGold();
        this.iVenturegoldBeansView = iVenturegoldBeansView;
    }

    public void getData(String token, int p, final String model, String gold_type, String type) {
        iVentureGoldBiz.getdata(new VenturegoldBeanListener() {
            @Override
            public void onSuccess(VenturegoldBean venturegoldBean) {
                iVenturegoldBeansView.setVenturegoldBeanData(venturegoldBean, model);
            }
        }, token, p, model, gold_type, type);

    }
}
