package com.qs.qswlw.okhttp.oncallback;

import com.qs.qswlw.bean.RecommendedRecordsBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public interface RecommendRecordListener extends BaseOnlistener{
    void onSuccess(List<RecommendedRecordsBean.ResultBean>list);
}
