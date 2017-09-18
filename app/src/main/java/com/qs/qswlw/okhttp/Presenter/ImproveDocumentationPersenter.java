package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ImproveDocumentationBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IImproveDocumentationView;
import com.qs.qswlw.okhttp.Moudle.IImproveDocumentationBiz;
import com.qs.qswlw.okhttp.oncallback.ImproveDocumentationListener;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ImproveDocumentationPersenter {
    IImproveDocumentationBiz iImproveDocumentationBiz;
    IImproveDocumentationView iImproveDocumentationView;

    public ImproveDocumentationPersenter(IImproveDocumentationView iImproveDocumentationView) {
        iImproveDocumentationBiz = IBizFactory.getImproveDocumentationList();
        this.iImproveDocumentationView = iImproveDocumentationView;
    }

    public void getdata(String token){
        iImproveDocumentationBiz.getdata(new ImproveDocumentationListener() {
            @Override
            public void onSuccess(ImproveDocumentationBean improveDocumentationBean) {
                iImproveDocumentationView.setData(improveDocumentationBean);
            }

            @Override
            public void onFailure(String code) {

            }
        },token);
    }
}
