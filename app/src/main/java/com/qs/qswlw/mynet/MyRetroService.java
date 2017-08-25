package com.qs.qswlw.mynet;


import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
import com.qs.qswlw.bean.RankingBean;

import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    /**
     * 给上注释
     * @return
     */
    @POST("index.php?m=Appapi&c=Index&a=index")
    Observable<MainBean<Maindatabean>> getALLdata();

    @Multipart//这是什么--标注 参数格式 prat 括号里对应的是KEY 后面对应的是 v 那不应该写成这个吗 嗯就是这样，value不用该 到时候传就是是吧 对
    //如果有多个参数-就这样
    @POST("index.php?m=Appapi&c=Index&a=ranking_list4")//头去掉 因为写过了，在那些了
    Observable<MainBean<RankingBean>> getRankingData(@Part("time_slot") String a );

    @POST("index.php?m=Appapi&c=Index&a=good_product")/**括号里面是路径*/
    Observable<MainBean<GoodProductBean>> getGoodproductdata();
    /**
     * 如果 头部不是实用 就是说有一些是特殊的 不一样的 哦哦 如果不是http://qiansheng.com开头的我就全部写 不对  要改成这样
     * 还有
     */
    //Observable<MainBean<GoodProductBean>> getGoodproductdata(@Url String url);//传进来全部的  哦哦
}
