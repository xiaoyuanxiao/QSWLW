package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.bean.MySliverBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMySliverBeanView;
import com.qs.qswlw.okhttp.Moudle.IMySliverBeanBiz;
import com.qs.qswlw.okhttp.oncallback.MySliverBeanListener;

import java.util.List;

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

    private List<MySliverBean.SingleLogBean> single_log;

    public void getdata(int p) {
        iMySliverBeanBiz.getdata(new MySliverBeanListener() {
            @Override
            public void onSuccess(MySliverBean mySliverBean) {
                iMySliverBeanView.setMySliverBeancountData(mySliverBean.getSilver_count());
                single_log = mySliverBean.getSingle_log();
                iMySliverBeanView.setMySliverBeanListData(single_log);
            }

            @Override
            public void onFailure(String code) {
                iMySliverBeanView.isgetDataFaile(code);
            }
        }, MyApplication.TOKEN, p);
    }

    public void getaddData(int a) {
        int page = (a + 1) % 20;
        getdata(page);
    }
}
