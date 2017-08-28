package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.RankingBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public interface IMainRankingView {
    /**
     * 月排行
     *
     * @param list
     */
    void setRankMondayWek(List<RankingBean.SingleLogBean> list, int recode);

    void runOnUiThread(Runnable runnable);
}
