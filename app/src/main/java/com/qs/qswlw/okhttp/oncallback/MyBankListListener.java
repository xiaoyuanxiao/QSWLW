package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.MyBankListBean;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public interface MyBankListListener extends BaseOnlistener {
    void onSuccess(MyBankListBean myBankListBean);
}
