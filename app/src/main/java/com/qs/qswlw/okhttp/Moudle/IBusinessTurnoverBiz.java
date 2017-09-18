package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.BusinessTurnoverListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface IBusinessTurnoverBiz {
    void getdata(BusinessTurnoverListener businessTurnoverListener, String token, int p, int is_history);
}
