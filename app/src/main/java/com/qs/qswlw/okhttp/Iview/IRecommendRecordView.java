package com.qs.qswlw.okhttp.Iview;

import com.qs.qswlw.bean.RecommendedRecordsBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface IRecommendRecordView {
    void setRecommendRecordList(List<RecommendedRecordsBean> list, String recode);

    void getdataFaile(String msg);

    void runOnUiThread(Runnable runnable);
}
