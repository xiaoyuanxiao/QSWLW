package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.WithdrawalsCityBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsCityView;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsCityBiz;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsCityListener;

/**
 * Created by xiaoyu on 2017/9/21.
 */

public class WithdrawalsCityPersenter {
    IWithdrawalsCityBiz iWithdrawalsCityBiz;
    IWithdrawalsCityView iWithdrawalsCityView;

    public WithdrawalsCityPersenter(IWithdrawalsCityView iWithdrawalsCityView) {
        iWithdrawalsCityBiz = IBizFactory.getWithdrawalsCityList();
        this.iWithdrawalsCityView = iWithdrawalsCityView;
    }
    public void getdata(String token,int pid){
        iWithdrawalsCityBiz.getdata(new WithdrawalsCityListener() {
            @Override
            public void onSuccess(WithdrawalsCityBean withdrawalsCityBean) {
                iWithdrawalsCityView.setCitydata(withdrawalsCityBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,pid);
    }
}
