package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.Maindatabean;
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
        ReHttpUtils.initRetro("http://192.168.1.191/");//这个无所谓 我们有一个默认的了
        ReHttpUtils.instans().httpRequestMain/**这是单线程 测试多线程 不好看结果*/(new HttpSubCribe<MainBean<Maindatabean>>() {


            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(MainBean<Maindatabean> s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable<MainBean<Maindatabean>> getObservable(MyRetroService retrofit) {
                /**
                 *
                 */
                return retrofit.getALLdata();//参数 不是乱写的。。。。你说乱写的  只要格式对上 。。。我什么时候说过呵呵
            }
        });


    }
}
