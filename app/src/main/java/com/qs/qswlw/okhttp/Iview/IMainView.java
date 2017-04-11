package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBaen;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainView {

    void setTitle(String title);

    void setUnionList(List list);

    void setEntrepList(EntrepBaen list);

    void setAngelList(List list);

    void setChinaList(List<ChinaBean> list);

    void setLuckList(List<ChinaBean> list);

    void setBenefitList(List list);

    void runOnUiThread(Runnable runnable);

}
