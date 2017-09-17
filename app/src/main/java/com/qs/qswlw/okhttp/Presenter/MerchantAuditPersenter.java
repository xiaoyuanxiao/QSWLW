package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditView;
import com.qs.qswlw.okhttp.Moudle.IMerchantAuditBiz;
import com.qs.qswlw.okhttp.oncallback.MerchantAuditListener;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditPersenter {
    IMerchantAuditBiz iMerchantAuditBiz;
    IMerchantAuditView iMerchantAuditView;

    public MerchantAuditPersenter(IMerchantAuditView iMerchantAuditView) {
        iMerchantAuditBiz = IBizFactory.getMerchantAuditList();
        this.iMerchantAuditView = iMerchantAuditView;
    }

    public void getdata(String token,int p,int is_ok){
        iMerchantAuditBiz.getdata(new MerchantAuditListener() {
            @Override
            public void onSuccess(MerchantAuditBean merchantAuditBean) {
                iMerchantAuditView.setData(merchantAuditBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_ok);
    }

    public void getdataRefresh(String token,int p,int is_ok){
        iMerchantAuditBiz.getdata(new MerchantAuditListener() {
            @Override
            public void onSuccess(MerchantAuditBean merchantAuditBean) {
                iMerchantAuditView.setDataRefresh(merchantAuditBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_ok);
    }
}
