package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.ValidateOldMemberBean;
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
        ReHttpUtils.instans().httpRequestMain/**这是单线程  因为测试多线程 不好看结果*/(new HttpSubCribe<MainBean<ValidateOldMemberBean>>() {


            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(MainBean<ValidateOldMemberBean> s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable<MainBean<ValidateOldMemberBean>> getObservable(MyRetroService retrofit) {
                /**
                 * 要测试哪个接口 这里就 改成对应的方法
                 * 跟你正常使用是一模一样的 使用
                 */
                return retrofit.getOldMemberData("1e6e218169ba6c66f63ac90d4e2149b11");
            }
        });


    }
}
