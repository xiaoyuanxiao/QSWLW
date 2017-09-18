package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.BusinessTurnoverBean;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public interface IBusinessTurnoverView {
    void getdata(BusinessTurnoverBean businessTurnoverBean);
    void getdataRefresh(BusinessTurnoverBean businessTurnoverBean);
}
