package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.AngelRankingBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public interface IAngelRankingView {
    /**
     * 月排行
     *
     * @param list
     */
    void setRankMondayWek(List<AngelRankingBean.SalemanBean> list, int recode);

    void runOnUiThread(Runnable runnable);
}
