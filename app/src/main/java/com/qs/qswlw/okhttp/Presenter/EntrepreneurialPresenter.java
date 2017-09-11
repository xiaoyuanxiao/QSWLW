package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IEntrepreneurialView;
import com.qs.qswlw.okhttp.Moudle.IEntrepreneurialBiz;
import com.qs.qswlw.okhttp.oncallback.EntrepreneurialListener;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public class EntrepreneurialPresenter {
    IEntrepreneurialBiz iEntrepreneurialBiz;
    IEntrepreneurialView iEntrepreneurialView;

    public EntrepreneurialPresenter(IEntrepreneurialView iEntrepreneurialView) {
        iEntrepreneurialBiz = IBizFactory.getEntrepreneurial();
        this.iEntrepreneurialView = iEntrepreneurialView;
    }

    public void getdata(String token,int p,String model){
        iEntrepreneurialBiz.getEntrepreneurialData(new EntrepreneurialListener() {
            @Override
            public void onSuccess(EntrepreneurialIncentiveBean entrepreneurialIncentiveBean) {
                iEntrepreneurialView.setEntrepreneurialData(entrepreneurialIncentiveBean);
            }

            @Override
            public void onFailure(String code) {
                Log.e("tag",code+"");
            }
        },token,p,model);
    }
}
