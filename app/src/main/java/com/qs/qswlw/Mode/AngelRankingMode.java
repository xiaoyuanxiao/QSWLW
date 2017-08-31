package com.qs.qswlw.Mode;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.AngelRankingActivity;
import com.qs.qswlw.adapter.AngelRankingAdapter;
import com.qs.qswlw.bean.AngelRankingBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoyu on 2017/4/5.
 */

public class AngelRankingMode extends BaseMode {
    private ListView lv_sub_unionmonthranking;
    private int code = 100;
    List<AngelRankingBean.SalemanBean> data;

    public AngelRankingMode(Context context, int code) {
        super(context);
        this.code = code;

    }
    public int getCode(){
        return code;
    }
    AngelRankingAdapter angelRankingAdapter;

    @Override
    protected View initView() {
        View inflate = View.inflate(context, R.layout.sub_unionmonthranking, null);
        lv_sub_unionmonthranking = (ListView) inflate.findViewById(R.id.lv_sub_unionmonthranking);
        data = new ArrayList<AngelRankingBean.SalemanBean>();

        angelRankingAdapter = new AngelRankingAdapter(context, data);
        lv_sub_unionmonthranking.setAdapter(angelRankingAdapter);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        if (isthis && data != null && data.size() != 0) {
            return;
        }
        ((AngelRankingActivity) context).angelRankingPresenter.getdata(code);//自身的请求
    }

    boolean isthis = true;

    public void setdata(List<AngelRankingBean.SalemanBean> data, int recode) {//然后就到了这里
        isthis = (recode == code);//recode  是请求时用的数值-  和本身页面的数值做对比  不是第一次recode是0， 是携带的0 code是多少//
        //正常的是  自己发出的请求 coade 是多少 就回传会是多少--所以 isthis 标识 的是是否加载了非本页面的数据
        this.data.clear();
        this.data.addAll(data);
        angelRankingAdapter.notifyDataSetChanged();
    }
}
