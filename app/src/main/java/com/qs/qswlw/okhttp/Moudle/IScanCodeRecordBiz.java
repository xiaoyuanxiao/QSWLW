package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ScanCodeRecordListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface IScanCodeRecordBiz {
    void getData(ScanCodeRecordListener scanCodeRecordListener, String token, int p, int is_ok);

}
