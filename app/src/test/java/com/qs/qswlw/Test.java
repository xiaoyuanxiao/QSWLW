package com.qs.qswlw;

import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.RecordListBaseBean;
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
        ReHttpUtils.instans().httpRequestMain/**这是单线程  因为测试多线程 不好看结果*/(new HttpSubCribe<MainBean<RecordListBaseBean>>() {


            @Override
            public void onCompleted() {
                System.out.println("onCompleted============");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError============" + e);
            }

            @Override
            public void onNext(MainBean<RecordListBaseBean> s) {
                System.out.println("onNext============" + s);
            }

            @Override
            public Observable<MainBean<RecordListBaseBean>> getObservable(MyRetroService retrofit) {
                /**
                 * 要测试哪个接口 这里就 改成对应的方法
                 * 跟你正常使用是一模一样的 使用--- 祖师拜谢了
                 * 我不是测了吗 可以啊  怎么就拜谢了  那就是这个
                 * 那你告诉我这报错怎么测
                 *
                 */
                return retrofit.getRecordListData("39edbdf5f6363b870ea9c6b555dc4132", 1, "model2", "1");//参数 不是乱写的。。。。你说乱写的  只要格式对上 。。。我什么时候说过呵呵
            }
        });


    }
}
