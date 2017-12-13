package com.qs.qswlw.adapter;

import android.content.Intent;
import android.view.View;

import com.qs.qswlw.activity.NoticesDetailActivity;
import com.qs.qswlw.bean.NoticesBean;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class NoticesAdapter extends BaseRecyleAdapter implements BaseRecyleAdapter.OnRecycleitemOnClic{
    private List<NoticesBean> noticesBeen;
    public NoticesAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        this.noticesBeen = (List<NoticesBean>) data;
        setOnRecycleitemOnClic(this);
    }

    @Override
    public void onItemClic(View view, int position) {
        Intent intent = new Intent(view.getContext(),NoticesDetailActivity.class);
        NoticesBean noticesBean = noticesBeen.get(position);
        intent.putExtra("noticesBeen",noticesBean);
        view.getContext().startActivity(intent);

    }
}
