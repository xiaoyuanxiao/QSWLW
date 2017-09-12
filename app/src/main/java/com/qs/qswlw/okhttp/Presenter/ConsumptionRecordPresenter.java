package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IConsumptionRecordView;
import com.qs.qswlw.okhttp.Moudle.IConsumptionRecordBiz;
import com.qs.qswlw.okhttp.oncallback.ConsumptionRecordListener;

/**
 * Created by xiaoyu on 2017/9/11.
 */

public class ConsumptionRecordPresenter {
    IConsumptionRecordBiz iConsumptionRecordBiz;
    IConsumptionRecordView iConsumptionRecordView;

    public ConsumptionRecordPresenter(IConsumptionRecordView iConsumptionRecordView) {
        iConsumptionRecordBiz = IBizFactory.getConsumptionRecord();
        this.iConsumptionRecordView = iConsumptionRecordView;
    }

    public void getdata(String token){
        iConsumptionRecordBiz.getConsumptionRecordData(new ConsumptionRecordListener() {
            @Override
            public void onSuccess(ConsumptionRecordBean consumptionRecordBean) {
                iConsumptionRecordView.setConsumptionRecordData(consumptionRecordBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }
}
