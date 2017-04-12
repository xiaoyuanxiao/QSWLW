package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.AngelBean;
import com.qs.qswlw.okhttp.Moudle.BenefitBean;
import com.qs.qswlw.okhttp.Moudle.ChinaBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBean;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.Moudle.UnionBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IMainView {

    void setAlertList(AlertBean title);

    void setUnionList(List<UnionBean> list);

    void setEntrepList(EntrepBean list);

    void setAngelList(List<AngelBean> list);

    void setChinaList(List<ChinaBean> list);

    void setLuckList(List<LuckBean> list);

    void setBenefitList(List<BenefitBean> list);

    void runOnUiThread(Runnable runnable);

}
