package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyOrganizationBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyOrganizationView;
import com.qs.qswlw.okhttp.Moudle.IMyOrganizationBiz;
import com.qs.qswlw.okhttp.oncallback.MyOrganizationListener;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class MyOrganizationPersenter {
    private IMyOrganizationBiz iMyOrganizationBiz;
    private IMyOrganizationView iMyOrganizationView;

    public MyOrganizationPersenter(IMyOrganizationView iMyOrganizationView) {
        iMyOrganizationBiz = IBizFactory.getMyOrganizationList();
        this.iMyOrganizationView = iMyOrganizationView;
    }

    public void getdata(String token,int user_id){
        iMyOrganizationBiz.getdata(new MyOrganizationListener() {
            @Override
            public void onSuccess(MyOrganizationBean myOrganizationBean) {
                iMyOrganizationView.setdata(myOrganizationBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,user_id);
    }
}
