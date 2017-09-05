package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMySliverBeanView;
import com.qs.qswlw.okhttp.Moudle.IMySliverBeanBiz;
import com.qs.qswlw.okhttp.oncallback.MySliverBeanListener;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public class MySliverBeanPresenter {
    IMySliverBeanBiz iMySliverBeanBiz;
    IMySliverBeanView iMySliverBeanView;

    public MySliverBeanPresenter(IMySliverBeanView iMySliverBeanView) {
        iMySliverBeanBiz = IBizFactory.getMySliverBeanBiz();
        this.iMySliverBeanView = iMySliverBeanView;
    }

    public void getdata(String token,int p){
        iMySliverBeanBiz.getdata(new MySliverBeanListener() {
            @Override
            public void onSuccess(MySliverBean mySliverBean) {
                iMySliverBeanView.setMySliverBeancountData(mySliverBean.getSilver_count());
                iMySliverBeanView.setMySliverBeanListData(mySliverBean.getSingle_log());
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p);
    }
}
