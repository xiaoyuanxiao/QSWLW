package com.qs.qswlw.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.qs.qswlw.BR;
import com.qs.qswlw.NoticesBinding;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.NoticesAdapter;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.okhttp.Iview.INoticesView;
import com.qs.qswlw.okhttp.Presenter.NoticesPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/12.
 */

public class NoticeActivity extends BaseDataBindingActivity implements INoticesView{

    public NoticesAdapter adapter;
    private NoticesBinding noticesBinding;
    private LinearLayoutManager linearLayoutManager;
    private List<NoticesBean> noticesBeen;
    private NoticesPresenter noticesPresenter = new NoticesPresenter(this);
    @Override
    protected int initview() {
        return R.layout.activity_notices;
    }

    @Override
    protected void initdatabinding() {
        noticesBinding = getBind();
        setTitleName("通知公告");
    }


    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        noticesBinding.rvNotices.setLayoutManager(linearLayoutManager);
        noticesPresenter.getdata();

    }

    @Override
    public void setData(List<NoticesBean> noticesBeanList) {
        this.noticesBeen = noticesBeanList;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(R.layout.item_notices, BR.noticesBean);
        adapter = new NoticesAdapter(noticesBeen, map);
        noticesBinding.rvNotices.setAdapter(adapter);
    }

}
