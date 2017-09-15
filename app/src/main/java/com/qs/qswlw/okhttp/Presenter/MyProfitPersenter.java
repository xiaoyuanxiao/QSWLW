package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MyProfitBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMyProfitView;
import com.qs.qswlw.okhttp.Moudle.IMyProfitBiz;
import com.qs.qswlw.okhttp.oncallback.MyProfitListener;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public class MyProfitPersenter {
    IMyProfitBiz iMyProfitBiz;
    IMyProfitView iMyProfitView;

    public MyProfitPersenter(IMyProfitView iMyProfitView) {
        iMyProfitBiz = IBizFactory.getMyProfitList();
        this.iMyProfitView = iMyProfitView;
    }

    public void getData(String token,int p){
        iMyProfitBiz.getdata(new MyProfitListener() {
            @Override
            public void onSuccess(MyProfitBean myProfitBean) {
                iMyProfitView.setMyProfitData(myProfitBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p);
    }
}
