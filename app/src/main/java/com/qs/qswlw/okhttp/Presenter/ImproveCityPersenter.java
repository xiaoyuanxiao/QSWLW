package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ImproveCityBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IImproveCityView;
import com.qs.qswlw.okhttp.Moudle.IImproveCityBiz;
import com.qs.qswlw.okhttp.oncallback.ImproveCityListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class ImproveCityPersenter {
    IImproveCityBiz iImproveCityBiz;
    IImproveCityView iImproveCityView;

    public ImproveCityPersenter(IImproveCityView iImproveCityView) {
        iImproveCityBiz = IBizFactory.getImproveCityList();
        this.iImproveCityView = iImproveCityView;
    }

    public void getdata(String token,int pid){
        iImproveCityBiz.getdata(new ImproveCityListener() {
            @Override
            public void onSuccess(ImproveCityBean improveCityBean) {
                iImproveCityView.setSelecteddata(improveCityBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,pid);
    }

}
