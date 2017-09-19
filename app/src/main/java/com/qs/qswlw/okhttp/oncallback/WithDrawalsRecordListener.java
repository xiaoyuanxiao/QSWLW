package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.WithDrawalsRecordBean;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public interface WithDrawalsRecordListener extends BaseOnlistener {
    void onSuccess(WithDrawalsRecordBean withDrawalsRecordBean);
}
