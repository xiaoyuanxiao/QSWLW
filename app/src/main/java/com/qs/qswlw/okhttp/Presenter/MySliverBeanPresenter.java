package com.qs.qswlw.okhttp.Presenter;

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

    public void getdata(String token, int p) {
        iMySliverBeanBiz.getdata(new MySliverBeanListener() {
            @Override
            public void onSuccess(MySliverBean mySliverBean) {
                iMySliverBeanView.setMySliverBeancountData(mySliverBean.getSilver_count());
                single_log = mySliverBean.getSingle_log();
                getaddData(0);
            }

            @Override
            public void onFailure(String code) {

            }
        }, token, p);
    }

    private int addcont = 20;

    public void getaddData(int a) {
        if ((a + addcont) > single_log.size())
            iMySliverBeanView.setMySliverBeanListData(single_log.subList(a, single_log.size()));
        else
            iMySliverBeanView.setMySliverBeanListData(single_log.subList(a, a + addcont));
    }
}
