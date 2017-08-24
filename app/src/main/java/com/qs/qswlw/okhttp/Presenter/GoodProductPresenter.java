package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IProductView;
import com.qs.qswlw.okhttp.Moudle.IProductBiz;
import com.qs.qswlw.okhttp.oncallback.ProductBaseListener;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class GoodProductPresenter {

    IProductView iProductView;
    IProductBiz iProductBiz;
    // private List<EntrepBean> e;

    public GoodProductPresenter(IProductView iProductView) {
        iProductBiz = IBizFactory.getProductBiz();
        this.iProductView = iProductView;
    }

    public void getdata() {
        iProductBiz.getdata(new ProductBaseListener() {
            @Override
            public void onSuccess(final GoodProductBean data) {
                iProductView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iProductView.setRankList(data.getGoods_rank_list());
                        iProductView.setNumList(data.getGoods_num_list());
                        iProductView.setAmountList(data.getGoods_amonut_list());
                    }
                });
            }

            @Override
            public void onFailure(String code) {

            }
        });
    }



}
