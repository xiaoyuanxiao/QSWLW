package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

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
                iRecordListView.isgetDataFaile(code);

            }
        },token,p,type,is_go);
    }
    public void getDataRefresh(String token,int p,String type,String is_go){
        iRecordListBiz.getdata(new RecordListListener() {
            @Override
            public void onSuccess(List<RecordListBean> list) {
                iRecordListView.setRecordListRefresh(list);
            }

            @Override
            public void onFailure(String code) {
                Log.e("Tag",code+"");

            }
        },token,p,type,is_go);
    }
}
