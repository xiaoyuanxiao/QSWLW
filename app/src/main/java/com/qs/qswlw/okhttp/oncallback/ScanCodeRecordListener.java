package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ScanCodeRecordBean;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface ScanCodeRecordListener extends BaseOnlistener {
    void onSuccess(ScanCodeRecordBean scanCodeRecordBean);
    void onTokenFail();
}
