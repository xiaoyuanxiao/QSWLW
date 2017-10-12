package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MySpendingLimitBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMySpendingLimitView;
import com.qs.qswlw.okhttp.Moudle.IMySpendingLimitBiz;
import com.qs.qswlw.okhttp.oncallback.MySpendingLimitListener;

/**
 * Created by xiaoyu on 2017/9/26.
 */

public class MySpendingLimitPresenter {
    IMySpendingLimitBiz iSpendingLimitBiz;
    IMySpendingLimitView iMySpendingLimitView;

    public MySpendingLimitPresenter(IMySpendingLimitView iMySpendingLimitView) {
        iSpendingLimitBiz = IBizFactory.getMySpendingLimitList();
        this.iMySpendingLimitView = iMySpendingLimitView;
    }
    public void getdata(String token,int p,int tab_status){
        iSpendingLimitBiz.getdata(new MySpendingLimitListener() {
            @Override
            public void onSuccess(MySpendingLimitBean mySpendingLimitBean) {
                iMySpendingLimitView.setdata(mySpendingLimitBean);
            }

            @Override
            public void onTokenFail() {
                iMySpendingLimitView.setTokenFail();
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,tab_status);
    }
}
