package com.qs.qswlw.okhttp.Moudle;

import com.google.gson.reflect.TypeToken;
import com.qs.qswlw.okhttp.DataCallBack;
import com.qs.qswlw.okhttp.NetUrl;
import com.qs.qswlw.okhttp.OKhttptUtils;
import com.qs.qswlw.okhttp.oncallback.MainAngelLisenter;
import com.qs.qswlw.okhttp.oncallback.MainBenefitLisenter;
import com.qs.qswlw.okhttp.oncallback.MainChinaLisenter;
import com.qs.qswlw.okhttp.oncallback.MainEntepLisenter;
import com.qs.qswlw.okhttp.oncallback.MainLuckLisenter;
import com.qs.qswlw.okhttp.oncallback.MainUnionLisenter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    private final String index_data = "index_data";
    private final String union = "union";
    private final String entrep = "entrep";
    private final String angel = "angel";
    private final String china = "china";
    private final String luck = "luck";
    private final String benefit = "benefit";

    @Override
    public void getAlert() {


    }

    @Override
    public void getunion(final MainUnionLisenter mainUnionLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, union);
        Type type = new TypeToken<BaseBean<ResultUnionBean<ArrayList<UnionBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultUnionBean<ArrayList<UnionBean>>>>(type) {

                    @Override
                    public void onSuccess(BaseBean<ResultUnionBean<ArrayList<UnionBean>>> data) {
                        List<UnionBean> result = null;
                        try {
                            result =  data.getResult().getUnion();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainUnionLisenter.onFailure("错误信息");
                        else
                            mainUnionLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainUnionLisenter.onFailure("错误信息" + code);
                    }
                });
    }

    @Override
    public void getentrep(final MainEntepLisenter mainEntepLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, entrep);
        Type type = new TypeToken<BaseBean<ResultEntrepBean<EntrepBaen>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultEntrepBean<EntrepBaen>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultEntrepBean<EntrepBaen>> data) {
                        EntrepBaen result = null;
                        try {
                            result = data.getResult().getEntrep();

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
    public void getangel(final MainAngelLisenter mainAngelLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, angel);
        Type type = new TypeToken<BaseBean<ResultChinaBean<ArrayList<AngelBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultChinaBean<ArrayList<AngelBean>>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultChinaBean<ArrayList<AngelBean>>> data) {
                        List<AngelBean> result = null;
                        try {
                            result = data.getResult().getChina();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainAngelLisenter.onFailure("错误信息");
                        else
                            mainAngelLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainAngelLisenter.onFailure("错误信息" + code);
                    }
                });
    }


    @Override
    public void getchina(final MainChinaLisenter mainChinaLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, china);
        Type type = new TypeToken<BaseBean<ResultChinaBean<ArrayList<ChinaBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultChinaBean<ArrayList<ChinaBean>>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultChinaBean<ArrayList<ChinaBean>>> data) {
                        List<ChinaBean> result = null;
                        try {
                            result = data.getResult().getChina();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainChinaLisenter.onFailure("错误信息");
                        else
                            mainChinaLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainChinaLisenter.onFailure("错误信息" + code);
                    }
                });
    }

    @Override
    public void getluck(final MainLuckLisenter mainLuckLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, luck);
        Type type = new TypeToken<BaseBean<ResultChinaBean<ArrayList<LuckBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultChinaBean<ArrayList<LuckBean>>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultChinaBean<ArrayList<LuckBean>>> data) {
                        List<LuckBean> result = null;
                        try {
                            result = data.getResult().getChina();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainLuckLisenter.onFailure("错误信息");
                        else
                            mainLuckLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainLuckLisenter.onFailure("错误信息" + code);
                    }
                });
    }

    @Override
    public void getbenefit(final MainBenefitLisenter mainBenefitLisenter) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(index_data, benefit);
        Type type = new TypeToken<BaseBean<ResultChinaBean<ArrayList<BenefitBean>>>>() {
        }.getType();
        OKhttptUtils.httpPost(NetUrl.baseurl, stringStringHashMap,
                new DataCallBack<BaseBean<ResultChinaBean<ArrayList<BenefitBean>>>>(type) {
                    @Override
                    public void onSuccess(BaseBean<ResultChinaBean<ArrayList<BenefitBean>>> data) {
                        List<BenefitBean> result = null;
                        try {
                            result = data.getResult().getChina();
                        } catch (Exception e) {
                        }
                        if (result == null)
                            mainBenefitLisenter.onFailure("错误信息");
                        else
                            mainBenefitLisenter.onSuccess(result);
                    }

                    @Override
                    public void onFailure(int code) {
                        mainBenefitLisenter.onFailure("错误信息" + code);
                    }
                });
    }
}