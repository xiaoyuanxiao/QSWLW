package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.BusinessTurnoverBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IBusinessTurnoverView;
import com.qs.qswlw.okhttp.Moudle.IBusinessTurnoverBiz;
import com.qs.qswlw.okhttp.oncallback.BusinessTurnoverListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class BusinessTurnoverPersenter {
    IBusinessTurnoverBiz iBusinessTurnoverBiz;
    IBusinessTurnoverView iBusinessTurnoverView;

    public BusinessTurnoverPersenter(IBusinessTurnoverView iBusinessTurnoverView) {
        iBusinessTurnoverBiz = IBizFactory.getBusinessTurnoveList();
        this.iBusinessTurnoverView = iBusinessTurnoverView;
    }

    public void getdata(String token,int p,int is_history){
        iBusinessTurnoverBiz.getdata(new BusinessTurnoverListener() {
            @Override
            public void onSuccess(BusinessTurnoverBean businessTurnoverBean) {
                iBusinessTurnoverView.getdata(businessTurnoverBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_history);
    }
    public void getdataRefresh(String token,int p,int is_history){
        iBusinessTurnoverBiz.getdata(new BusinessTurnoverListener() {
            @Override
            public void onSuccess(BusinessTurnoverBean businessTurnoverBean) {
                iBusinessTurnoverView.getdataRefresh(businessTurnoverBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_history);
    }
}
