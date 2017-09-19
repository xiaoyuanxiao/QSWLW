package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IWithDrawalsRecordView;
import com.qs.qswlw.okhttp.Moudle.IWithDrawalsRecordBiz;
import com.qs.qswlw.okhttp.oncallback.WithDrawalsRecordListener;

/**
 * Created by xiaoyu on 2017/9/19.
 */

public class WithDrawalsRecordPersenter {
    IWithDrawalsRecordBiz iWithDrawalsRecordBiz;
    IWithDrawalsRecordView iWithDrawalsRecordView;

    public WithDrawalsRecordPersenter(IWithDrawalsRecordView iWithDrawalsRecordView) {
        iWithDrawalsRecordBiz = IBizFactory.getWithdrawalsRecordList();
        this.iWithDrawalsRecordView = iWithDrawalsRecordView;
    }

    public void getdata(String token,int p,String status){
        iWithDrawalsRecordBiz.getdata(new WithDrawalsRecordListener() {
            @Override
            public void onSuccess(WithDrawalsRecordBean withDrawalsRecordBean) {
                iWithDrawalsRecordView.setdata(withDrawalsRecordBean);
            }

            @Override
            public void onFailure(String code) {
                iWithDrawalsRecordView.isgetDataFaile(code);
            }
        },token,p,status);
    }
    public void getdataRefresh(String token,int p,String status){
        iWithDrawalsRecordBiz.getdata(new WithDrawalsRecordListener() {
            @Override
            public void onSuccess(WithDrawalsRecordBean withDrawalsRecordBean) {
                iWithDrawalsRecordView.setdataRefresh(withDrawalsRecordBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,status);
    }
}
