package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.bean.GoodProductBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.ProductBaseListener;

import java.lang.reflect.Type;

/**
 * Created by xiaoyu on 2017/8/24.
 */

public class BizGoodProduct implements IProductBiz {
    private static BizGoodProduct testMoudle;

    private BizGoodProduct() {
    }

    public synchronized static BizGoodProduct getInstans() {
        if (testMoudle == null)
            testMoudle = new BizGoodProduct();
        return testMoudle;
    }

    public void getdata(final ProductBaseListener baseOnlistener) {
        Type type = new TypeToken<MainBean<GoodProductBean>>() {
        }.getType();
        OKhttptUtils.httpget(NetUrl.GOODPRODUCT,
                new DataCallBack<MainBean<GoodProductBean>>(type) {
                    @Override
                    public void onSuccess(MainBean<GoodProductBean> data) {
                        GoodProductBean result = data.getResult();
                        baseOnlistener.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        baseOnlistener.onFailure(code + "");
                    }
                });
    }


}
