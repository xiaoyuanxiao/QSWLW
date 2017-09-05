package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.ValidateOldMemberBean;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IValidateOldMemberView {
    void setValidateOldMemberViewData(ValidateOldMemberBean validateOldMemberBean);
    void runOnUiThread(Runnable runnable);

}
