package com.qs.qswlw.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.qs.qswlw.BR;
import com.qs.qswlw.NoticesBinding;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.BaseRecyleAdapter;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.okhttp.Iview.INoticesView;
import com.qs.qswlw.okhttp.Presenter.NoticesPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public class NoticeActivity extends Activity implements INoticesView{

    public BaseRecyleAdapter adapter;
    private NoticesBinding noticesBinding;
    private LinearLayoutManager linearLayoutManager;
    private List<NoticesBean> noticesBeen;
    private NoticesPresenter noticesPresenter = new NoticesPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticesBinding = DataBindingUtil.setContentView(this, R.layout.activity_notices);
        linearLayoutManager = new LinearLayoutManager(this);
        noticesBinding.rvNotices.setLayoutManager(linearLayoutManager);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_notices, BR.noticesBean);
        adapter = new BaseRecyleAdapter(noticesBeen, map);
        noticesBinding.rvNotices.setAdapter(adapter);
        noticesPresenter.getdata("",0,0);
    }

    @Override
    public void setData(List<NoticesBean> noticesBeanList) {
        this.noticesBeen = noticesBeanList;
    }
}
