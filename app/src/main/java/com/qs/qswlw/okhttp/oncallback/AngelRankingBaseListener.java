package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.AngelRankingBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public interface AngelRankingBaseListener extends BaseOnlistener {
    void onSuccess(List<AngelRankingBean.SalemanBean> list);
}
