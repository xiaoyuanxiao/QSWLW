package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.RankingBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public interface RankingBaseListener extends BaseOnlistener {
    void onSuccess(List<RankingBean.SingleLogBean> list);
}
