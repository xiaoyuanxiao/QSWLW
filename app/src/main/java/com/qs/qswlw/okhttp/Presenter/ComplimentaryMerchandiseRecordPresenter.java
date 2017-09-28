package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IComplimentaryMerchandiseRecordView;
import com.qs.qswlw.okhttp.Moudle.IComplimentaryMerchandiseRecordBiz;
import com.qs.qswlw.okhttp.oncallback.ComplimentaryMerchandiseRecordListener;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class ComplimentaryMerchandiseRecordPresenter {
    IComplimentaryMerchandiseRecordBiz iComplimentaryMerchandiseRecordBiz;
    IComplimentaryMerchandiseRecordView iComplimentaryMerchandiseRecordView;

    public ComplimentaryMerchandiseRecordPresenter(IComplimentaryMerchandiseRecordView iComplimentaryMerchandiseRecordView) {
        iComplimentaryMerchandiseRecordBiz = IBizFactory.getComplimentaryMerchandiseRecordList();
        this.iComplimentaryMerchandiseRecordView = iComplimentaryMerchandiseRecordView;
    }

    public void getdata(String token,int p,int is_review){
        iComplimentaryMerchandiseRecordBiz.getdata(new ComplimentaryMerchandiseRecordListener() {
            @Override
            public void onSuccess(ComplimentaryMerchandiseRecordBean complimentaryMerchandiseRecordBean) {
                iComplimentaryMerchandiseRecordView.setdata(complimentaryMerchandiseRecordBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token,p,is_review);
    }
}
