package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.AngelRankingBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IAngelRankingView;
import com.qs.qswlw.okhttp.Moudle.IAngelRankingBiz;
import com.qs.qswlw.okhttp.oncallback.AngelRankingBaseListener;

import java.util.List;

/**
 * Created by xiaoyu on 2017/8/25.
 */

public class AngelRankingPresenter {
    IAngelRankingView iAngelRankingView;
    IAngelRankingBiz iAngelRankingBiz;

    public AngelRankingPresenter(IAngelRankingView iAngelRankingView) {
        iAngelRankingBiz = IBizFactory.getAngelRankingBiz();
        this.iAngelRankingView = iAngelRankingView;
    }

    public void getdata(final int code) {
        //日月是分开请求的
        iAngelRankingBiz.getdata(new AngelRankingBaseListener() {
            @Override
            public void onSuccess(List<AngelRankingBean.SalemanBean> list) {

                iAngelRankingView.setRankMondayWek(list, code);
            }

            @Override
            public void onFailure(String code) {

            }
        }, code);

    }
}
