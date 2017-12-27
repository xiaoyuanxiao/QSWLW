package com.qs.qswlw.okhttp.Iview;

import java.util.ArrayList;

/**
 * Created by xiaoyu on 2017/4/7.
 */
public interface ITestaView {

    void setText1(String name1);

    void setListData(ArrayList<String> name1);

    void setImagSrc(String url);

    String getMobile();

    String getPassword();

    void runOnUiThread(Runnable runnable);
}
