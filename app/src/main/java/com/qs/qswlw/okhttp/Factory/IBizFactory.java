package com.qs.qswlw.okhttp.Factory;

import com.qs.qswlw.okhttp.Moudle.ITestaBiz;
import com.qs.qswlw.okhttp.Moudle.TestaMoudle;

/**
 * Created by 小猴子 on 2017/4/7.
 * <p>
 * <p>
 * 注
 * <p>
 * 所有I开头的JAVA文件皆是接口
 */

public class IBizFactory {
    public static ITestaBiz getItestBiz() {
        return TestaMoudle.getInstans();
    }
}
