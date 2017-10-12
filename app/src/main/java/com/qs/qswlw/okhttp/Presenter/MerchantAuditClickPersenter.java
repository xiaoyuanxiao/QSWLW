package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MerchantAuditClickBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditClickView;
import com.qs.qswlw.okhttp.Moudle.IMerchantAuditClickBiz;
import com.qs.qswlw.okhttp.oncallback.MerchantAuditClickListener;

/**
 * Created by xiaoyu on 2017/9/17.
 */

public class MerchantAuditClickPersenter {
    IMerchantAuditClickBiz iMerchantAuditBiz;
    IMerchantAuditClickView iMerchantAuditView;

    public MerchantAuditClickPersenter(IMerchantAuditClickView iMerchantAuditView) {
        iMerchantAuditBiz = IBizFactory.getMerchantAuditClickList();
        this.iMerchantAuditView = iMerchantAuditView;
    }

    public void getdata(String token,int id){
        iMerchantAuditBiz.getdata(new MerchantAuditClickListener() {
            @Override
            public void onSuccess(MerchantAuditClickBean merchantAuditBean) {
                iMerchantAuditView.setData(merchantAuditBean);
            }

            @Override
            public void onTokenFail() {
                iMerchantAuditView.setTokenFail();
            }

            @Override
            public void onFailure(String code) {

            }
        },token,id);
    }

}
