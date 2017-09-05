package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.okhttp.oncallback.ValidateOldMemberListener;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IValidateOldMemberBiz {
    void getdata(ValidateOldMemberListener validateOldMemberListener, String token);
}
