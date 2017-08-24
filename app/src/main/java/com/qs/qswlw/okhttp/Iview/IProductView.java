package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.GoodProductBean;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public interface IProductView {


    /**
     * 好评率
     * @param list
     */
    void setRankList(List<GoodProductBean.GoodsRank> list);

    /**
     * 数量
     * @param list
     */
    void setNumList(List<GoodProductBean.GoodsNum> list);

    /**
     * 金额
     * @param list
     */
    void setAmountList(List<GoodProductBean.GoodsAmonut> list);

    void runOnUiThread(Runnable runnable);

}
