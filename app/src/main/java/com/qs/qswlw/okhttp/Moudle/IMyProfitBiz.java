package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.MyProfitListener;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public interface IMyProfitBiz {
    void getdata(MyProfitListener myProfitListener,String token, int p);

}
