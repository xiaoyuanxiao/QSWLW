package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;

import rx.Observable;

import static junit.framework.Assert.assertEquals;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class Test {
    @org.junit.Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        ReHttpUtils.initRetro("http://www.qiansheng.com/");//这个无所谓 我们有一个默认的了
        ReHttpUtils.instans().httpRequestMain/**这是单线程  因为测试多线程 不好看结果*/(new HttpSubCribe<MainBean<VenturegoldBean>>() {


            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(MainBean<VenturegoldBean> s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable<MainBean<VenturegoldBean>> getObservable(MyRetroService retrofit) {
                /**
                 * 要测试哪个接口 这里就 改成对应的方法
                 * 跟你正常使用是一模一样的 使用
                 */
                return retrofit.getMyGoldData("111",1,"1","1","1");
            }
        });


    }
}
