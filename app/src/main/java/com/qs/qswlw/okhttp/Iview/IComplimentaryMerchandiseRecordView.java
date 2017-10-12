package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public interface IComplimentaryMerchandiseRecordView {
    void setdata(ComplimentaryMerchandiseRecordBean complimentaryMerchandiseRecordBean);
    void isgetDataFaile(String meg);
    void setTokenFail();

}
