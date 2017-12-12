package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.okhttp.Moudle.LuckBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainView {

    void setAlertList(Maindatabean.Notices title);

    void setUnionList(List<Maindatabean.Shop> list);

    void setEntrepList(Maindatabean.Current_sales list);

    void setAngelList(List<Maindatabean.Salema> list);

    void setChinaList(List<Maindatabean.Goods> list);

    void setLuckList(List<LuckBean> list);

    void setBenefitList(List<Maindatabean.Area> list);

    void runOnUiThread(Runnable runnable);

}
