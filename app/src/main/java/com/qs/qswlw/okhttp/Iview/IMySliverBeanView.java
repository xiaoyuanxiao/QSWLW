package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.MySliverBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/5.
 */

public interface IMySliverBeanView {
    void setMySliverBeancountData(MySliverBean.SilverCountBean slivercountbean);

    void setMySliverBeanListData(List<MySliverBean.SingleLogBean> list);

  //  void isgetDataFaile(String meg);

    void runOnUiThread(Runnable runnable);
}
