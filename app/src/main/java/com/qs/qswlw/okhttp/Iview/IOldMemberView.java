package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.OldMemberBean;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IOldMemberView {
    void setOldMemberViewData(OldMemberBean oldMemberBean);
    void runOnUiThread(Runnable runnable);

}
