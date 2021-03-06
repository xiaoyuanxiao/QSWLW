package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RecommendedRecordsBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IRecommendRecordView;
import com.qs.qswlw.okhttp.Moudle.IRecommendRecordBiz;
import com.qs.qswlw.okhttp.oncallback.RecommendRecordListener;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/4.
 */

public class RecommendedRecordsPersenter {
    IRecommendRecordBiz iRecommendRecordBiz;
    IRecommendRecordView iRecommendRecordView;

    public RecommendedRecordsPersenter(IRecommendRecordView iRecommendRecordView) {
        iRecommendRecordBiz = IBizFactory.getRecommendRecordsBiz();
        this.iRecommendRecordView = iRecommendRecordView;
    }

    public void getData(String token, int p, String search_name, final String tab_name) {
        iRecommendRecordBiz.getdata(new RecommendRecordListener() {


            @Override
            public void onSuccess(MainBean<List<RecommendedRecordsBean>> list) {
                iRecommendRecordView.setRecommendRecordList(list.getResult(), tab_name);
            }

            @Override
            public void onFailure(String code) {
                Log.e("RecommendedRecordsBean", code);
            }
        }, token, p, search_name, tab_name);
    }

}
