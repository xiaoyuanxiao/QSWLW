package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.WithDrawalsRecordListener;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public interface IWithDrawalsRecordBiz {
    void getdata(WithDrawalsRecordListener withDrawalsRecordListener, String token,int p,String status);
}
