package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.WithdrawalsBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsView;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsBiz;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsListener;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class WithdrawalsPersenter {
    IWithdrawalsBiz iWithdrawalsBiz;
    IWithdrawalsView iWithdrawalsView;

    public WithdrawalsPersenter(IWithdrawalsView iWithdrawalsView) {
        iWithdrawalsBiz = IBizFactory.getWithdrawalsList();
        this.iWithdrawalsView = iWithdrawalsView;
    }

    public void getdata(String token){
        iWithdrawalsBiz.getdata(new WithdrawalsListener() {
            @Override
            public void onSuccess(WithdrawalsBean withdrawalsBean) {
                iWithdrawalsView.setdata(withdrawalsBean);
            }

            @Override
            public void onTokenFail() {
                iWithdrawalsView.setTokenFail();
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }

}
