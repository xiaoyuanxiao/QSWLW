package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.RankingBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IRankingView;
import com.qs.qswlw.okhttp.Moudle.IRankingBiz;
import com.qs.qswlw.okhttp.oncallback.RankingBaseListener;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class RankingPresenter {
    IRankingView iRankingView;
    IRankingBiz iRankingBiz;

    public RankingPresenter(IRankingView iRankingView) {
        iRankingBiz = IBizFactory.getRankingBiz();
        this.iRankingView = iRankingView;
    }

    //我改一点
    public void getdata(final int code) {
        //日月是分开请求的
        iRankingBiz.getdata(new RankingBaseListener() {
            @Override
            public void onSuccess(List<RankingBean.SingleLogBean> list) {
                iRankingView.setRankMondayWek(list, code);
            }

            @Override
            public void onFailure(String code) {

            }
        }, code);

    }
}
