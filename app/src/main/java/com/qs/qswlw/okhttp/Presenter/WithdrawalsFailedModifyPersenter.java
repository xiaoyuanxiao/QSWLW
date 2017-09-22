package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.WithdrawalsFailedModifyBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsFailedModifyView;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsFailedModifyBiz;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsFailedModifyListener;

/**
 * Created by xiaoyu on 2017/9/22.
 */

public class WithdrawalsFailedModifyPersenter {
    IWithdrawalsFailedModifyBiz iWithdrawalsFailedModifyBiz;
    IWithdrawalsFailedModifyView iWithdrawalsFailedModifyView;

    public WithdrawalsFailedModifyPersenter(IWithdrawalsFailedModifyView iWithdrawalsFailedModifyView) {
        iWithdrawalsFailedModifyBiz = IBizFactory.getWithdrawalsFailedModifyList();
        this.iWithdrawalsFailedModifyView = iWithdrawalsFailedModifyView;
    }
    public void getdata(String token,int id){
        iWithdrawalsFailedModifyBiz.getdata(new WithdrawalsFailedModifyListener() {
            @Override
            public void onSuccess(WithdrawalsFailedModifyBean withdrawalsFailedModifyBean) {
                iWithdrawalsFailedModifyView.setFailedModifydata(withdrawalsFailedModifyBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,id);
    }
}
