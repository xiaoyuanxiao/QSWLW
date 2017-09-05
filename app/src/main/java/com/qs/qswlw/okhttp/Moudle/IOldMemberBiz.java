package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.OldMemberListener;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IOldMemberBiz {
    void getdata(OldMemberListener oldMemberListener, String token,String member_number,String member_type);
}
