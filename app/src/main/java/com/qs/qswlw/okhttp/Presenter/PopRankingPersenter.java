package com.qs.qswlw.okhttp.Presenter;

import android.util.Log;

import com.qs.qswlw.bean.PopRankingBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IPopRankingView;
import com.qs.qswlw.okhttp.Moudle.IPopRankingBiz;
import com.qs.qswlw.okhttp.oncallback.PopRankingListener;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class PopRankingPersenter {
    private IPopRankingBiz iPopRankingBiz;
    private IPopRankingView iPopRankingView;

    public PopRankingPersenter(IPopRankingView iPopRankingView) {
        iPopRankingBiz = IBizFactory.getPopRankingList();
        this.iPopRankingView = iPopRankingView;
    }
    public void getdata(String role,String time_slot){
        iPopRankingBiz.getdata(new PopRankingListener() {
            @Override
            public void onFailure(String code) {
                Log.e("PopRankingPersenter",code);
            }

            @Override
            public void onSuccess(PopRankingBean popRankingBean) {
                iPopRankingView.setData(popRankingBean);
            }
        },role,time_slot);
    }
}
