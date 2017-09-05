package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.ValidateOldMemberBean;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface ValidateOldMemberListener extends BaseOnlistener{
    void success(ValidateOldMemberBean validateOldMemberBean);
}
