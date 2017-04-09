package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class BizMain implements IMainBiz {
    private static BizMain testMoudle;

    private BizMain() {
    }

    public synchronized static BizMain getInstans() {
        if (testMoudle == null)
            testMoudle = new BizMain();
        return testMoudle;
    }

    @Override
    public void getAlert() {


    }

    private final String index_data = "index_data";
    private final String union = "union";
    private final String entrep = "entrep";

    @Override
    public void getunion() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, union);
    }

    @Override
    public void getentrep(final MainEntepLisenter mainEntepLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, entrep);
        Type type = new TypeToken<BaseBean<EntrepBaen>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<EntrepBaen>>(type) {

                    @Override
                    public void onSuccess(BaseBean<EntrepBaen> data) {
                        EntrepBaen result = null;
                        try {
                            result = data.getResult().getResult();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainEntepLisenter.onFailure("错误信息");
                        else
                            mainEntepLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainEntepLisenter.onFailure("错误信息" + code);
                    }
                });
    }

    @Override
    public void getangel() {

    }

    @Override
    public void getchina() {

    }

    @Override
    public void getluck() {

    }

    @Override
    public void getbenefit() {

    }
}
