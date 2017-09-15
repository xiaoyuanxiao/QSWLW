package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.RecordListBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IRecordListView;
import com.qs.qswlw.okhttp.Moudle.IRecordListBiz;
import com.qs.qswlw.okhttp.oncallback.RecordListListener;

import java.util.List;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public class RecordListPresenter {
    IRecordListBiz iRecordListBiz;
    IRecordListView iRecordListView;

    public RecordListPresenter(IRecordListView iRecordListView) {
        iRecordListBiz = IBizFactory.getRecordList();
        this.iRecordListView = iRecordListView;
    }

    public void getData(String token,int p,String type,String is_go){
        iRecordListBiz.getdata(new RecordListListener() {
            @Override
            public void onSuccess(List<RecordListBean> list) {
                iRecordListView.setRecordList(list);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,type,is_go);
    }
}
