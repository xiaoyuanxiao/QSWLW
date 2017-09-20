package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyBankListView;
import com.qs.qswlw.okhttp.Moudle.IMyBankListBiz;
import com.qs.qswlw.okhttp.oncallback.MyBankListListener;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class MyBankListPersenter {
    IMyBankListBiz iMyBankListBiz;
    IMyBankListView iMyBankListView;

    public MyBankListPersenter(IMyBankListView iMyBankListView) {
        iMyBankListBiz = IBizFactory.getMyBankList();
        this.iMyBankListView = iMyBankListView;
    }

    public void getdata(String token){
        iMyBankListBiz.getdata(new MyBankListListener() {
            @Override
            public void onSuccess(MyBankListBean myBankListBean) {
                iMyBankListView.setdata(myBankListBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }

}
