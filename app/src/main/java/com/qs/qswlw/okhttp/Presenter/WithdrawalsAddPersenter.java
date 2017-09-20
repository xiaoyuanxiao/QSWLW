package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsAddView;
import com.qs.qswlw.okhttp.Moudle.IWithdrawalsAddBiz;
import com.qs.qswlw.okhttp.oncallback.WithdrawalsAddListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class WithdrawalsAddPersenter {
    IWithdrawalsAddBiz iWithdrawalsAddBiz;
    IWithdrawalsAddView iWithdrawalsAddView;

    public WithdrawalsAddPersenter(IWithdrawalsAddView iWithdrawalsAddView) {
        iWithdrawalsAddBiz = IBizFactory.getWithdrawalsAddList();
        this.iWithdrawalsAddView = iWithdrawalsAddView;
    }
    public void getdata(String token,int id){
        iWithdrawalsAddBiz.getData(new WithdrawalsAddListener() {
            @Override
            public void onSuccess(WithdrawalsAddBean withdrawalsAddBean) {
                iWithdrawalsAddView.setdata(withdrawalsAddBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,id);
    }
}
