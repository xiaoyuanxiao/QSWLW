package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.RecordListListener;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public interface IRecordListBiz {
    void getdata(RecordListListener recordListListener,String token,int p,String type,String is_go);
}
