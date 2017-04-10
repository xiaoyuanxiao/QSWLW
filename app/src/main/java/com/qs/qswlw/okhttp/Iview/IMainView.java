package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainView {

    void setTitle(String title);

    void setListdata1(List list);

    void setListdata2(EntrepBaen list);

    void setListdata3(List list);

    void setListdata4(List<ChinaBean> list);

    void setListdata5(List<ChinaBean> list);

    void setListdata6(List list);

    void runOnUiThread(Runnable runnable);

}
