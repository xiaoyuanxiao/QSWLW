package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyBonusBean;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public interface MyBonusListener extends BaseOnlistener {
    void OnSuccess(MyBonusBean myBonusBean);
    void onTokenFail();
}
