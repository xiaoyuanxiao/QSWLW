package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IConsumptionLimitRechargeView;
import com.qs.qswlw.okhttp.Moudle.IConsumptionLimitRechargeBiz;
import com.qs.qswlw.okhttp.oncallback.ConsumptionLimitRechargeListener;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitRechargePresenter {
    IConsumptionLimitRechargeBiz iConsumptionLimitRechargeBiz;
    IConsumptionLimitRechargeView iConsumptionLimitRechargeView;

    public ConsumptionLimitRechargePresenter(IConsumptionLimitRechargeView iConsumptionLimitRechargeView) {
        iConsumptionLimitRechargeBiz = IBizFactory.getConsumptionLimitRechargeList();
        this.iConsumptionLimitRechargeView = iConsumptionLimitRechargeView;
    }

    public void getdata(String token,String recharge_type){
        iConsumptionLimitRechargeBiz.getdata(new ConsumptionLimitRechargeListener() {
            @Override
            public void onSuccess(ConsumptionLimitRechargeBean consumptionLimitRechargeBean) {
                iConsumptionLimitRechargeView.setdata(consumptionLimitRechargeBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,recharge_type);

    }
}
