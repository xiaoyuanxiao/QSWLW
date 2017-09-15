package com.qs.qswlw.okhttp.Moudle;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RecordListBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.oncallback.RecordListListener;

import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/15.
 */

public class BizRecordList implements IRecordListBiz{
    private static BizRecordList testMoudle;

    public synchronized static BizRecordList getInstans() {
        if (testMoudle == null)
            testMoudle = new BizRecordList();
        return testMoudle;
    }

    @Override
    public void getdata(final RecordListListener recordListListener, final String token, final int p, final String type, final String is_go) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<List<RecordListBean>>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<List<RecordListBean>> recordListBean) {
                List<RecordListBean> result = recordListBean.getResult();
                if (result == null || recordListBean.getStatus() == -1)
                    recordListListener.onFailure(recordListBean.getMsg());
                else
                    recordListListener.onSuccess(result);
            }

            @Override
            public Observable<MainBean<List<RecordListBean>>> getObservable(MyRetroService retrofit) {
                return retrofit.getRecordListData(token,p,type,is_go);
            }
        });
    }
}
