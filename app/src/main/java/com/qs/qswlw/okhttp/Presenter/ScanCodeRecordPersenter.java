package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ScanCodeRecordBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IScanCodeRecordView;
import com.qs.qswlw.okhttp.Moudle.IScanCodeRecordBiz;
import com.qs.qswlw.okhttp.oncallback.ScanCodeRecordListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ScanCodeRecordPersenter {
    IScanCodeRecordBiz iScanCodeRecordBiz;
    IScanCodeRecordView iScanCodeRecordView;

    public ScanCodeRecordPersenter(IScanCodeRecordView iScanCodeRecordView) {
        iScanCodeRecordBiz = IBizFactory.getScanCodeRecordList();
        this.iScanCodeRecordView = iScanCodeRecordView;
    }
    public void getdata(String token,int p,int is_ok){
        iScanCodeRecordBiz.getData(new ScanCodeRecordListener() {
            @Override
            public void onSuccess(ScanCodeRecordBean scanCodeRecordBean) {
                iScanCodeRecordView.setData(scanCodeRecordBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_ok);
    }

}
