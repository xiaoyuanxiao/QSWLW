package com.qs.qswlw.mynet;


import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by buring on 2017/5/26.
 */

public interface MyRetroService {
    @GET("index.php?m=Appapi&c=Index&a=index")
    Observable<TestBean> getCommissionSummaryDaily();

    @GET
    Observable<TestBean> getCommissionSummaryDaily(@Url String url);


    @GET("index.php?m=Appapi&c=Index&a=index")
    Observable<MainBean<Maindatabean>> getALLdata();

    @GET("index.php?m=Appapi&c=Index&a=good_product")
    Observable<MainBean<GoodProductBean>> getGoodproductdata();
}
