package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.INoticesView;
import com.qs.qswlw.okhttp.Moudle.INoticesBiz;
import com.qs.qswlw.okhttp.oncallback.NoticesListener;

import java.util.List;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public class NoticesPresenter {
    private INoticesView iNoticesView;
    private INoticesBiz iNoticesBiz;

    public NoticesPresenter(INoticesView iNoticesView) {
        iNoticesBiz = IBizFactory.getNoticesList();
        this.iNoticesView = iNoticesView;
    }

    public void getdata(){
        iNoticesBiz.getdata(new NoticesListener() {


            @Override
            public void onSuccess(MainBean<List<NoticesBean>> noticesBeanList) {
                iNoticesView.setData(noticesBeanList.getResult());
            }

            @Override
            public void onFailure(String code) {
                Log.e("NoticesPresenter",code);
            }
        });
    }
}
