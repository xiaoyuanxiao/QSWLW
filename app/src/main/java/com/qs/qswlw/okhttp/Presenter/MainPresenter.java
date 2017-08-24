package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IMainView;
import com.qs.qswlw.okhttp.Moudle.AlertBean;
import com.qs.qswlw.okhttp.Moudle.EntrepBean;
import com.qs.qswlw.okhttp.Moudle.IMainBiz;
import com.qs.qswlw.okhttp.Moudle.LuckBean;
import com.qs.qswlw.okhttp.oncallback.MainAlertLisenter;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBaseListener;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntrepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MainPresenter {

    IMainView iMainView;
    IMainBiz iMainBiz;
    private List<EntrepBean> e;

    public MainPresenter(IMainView iMainView) {
        iMainBiz = IBizFactory.getMainBiz();
        this.iMainView = iMainView;
    }

    public void getdata() {
        iMainBiz.getALLdata(new MainBaseListener() {
            @Override
            public void onSuccess(MainBean<Maindatabean> list) {
                Maindatabean result = list.getResult();
                List<Maindatabean.Area> area_ranking = result.getArea_ranking();
                Maindatabean.Current_sales current_sales = result.getCurrent_sales();
                List<Maindatabean.Goods> goods_sale_ranking = result.getGoods_sale_ranking();
                List<Maindatabean.Salema> salema_ranking = result.getSalema_ranking();
                List<Maindatabean.Shop> shop_ranking = result.getShop_ranking();
                iMainView.setBenefitList(area_ranking);
                iMainView.setAngelList(salema_ranking);
                iMainView.setChinaList(goods_sale_ranking);
                iMainView.setEntrepList(current_sales);
                iMainView.setUnionList(shop_ranking);
                //iMainView.setLuckList(shop_ranking);
            }

            @Override
            public void onFailure(String code) {
            }
        });
        iMainBiz.getAlert(new MainAlertLisenter() {
            @Override
            public void onSuccess(AlertBean e) {
                iMainView.setAlertList(e);
            }

            @Override
            public void onFailure(String code) {
            }
        });
    }
}
