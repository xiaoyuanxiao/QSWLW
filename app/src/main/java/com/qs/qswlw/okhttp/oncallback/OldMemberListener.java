package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.OldMemberBean;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface OldMemberListener extends BaseOnlistener{
    void success(OldMemberBean oldMemberBean);
}
