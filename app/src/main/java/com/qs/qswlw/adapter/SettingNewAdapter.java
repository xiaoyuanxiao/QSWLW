package com.qs.qswlw.adapter;

import android.content.Intent;
import android.view.View;

import com.qs.qswlw.BR;
import com.qs.qswlw.activity.PersonalCenter.SettingNewDetailActivity;
import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.utils.DateUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class SettingNewAdapter extends BaseRecyleAdapter implements BaseRecyleAdapter.OnRecycleitemOnClic{
    private List<SettingNewsBean.MessageBean> messageBeen;
    public SettingNewAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        messageBeen= (List<SettingNewsBean.MessageBean>) data;
        setOnRecycleitemOnClic(this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String s = "系統管理员　" + DateUtils.date2date(Long.parseLong(messageBeen.get(position).getSend_time()) * 1000L);
        holder.dataBinding.setVariable(BR.time,s);




    }

    @Override
    public void onItemClic(View view, int position) {
        Intent intent = new Intent(view.getContext(),SettingNewDetailActivity.class);
        SettingNewsBean.MessageBean messageBean = messageBeen.get(position);
        intent.putExtra("messageBean",messageBean);
        view.getContext().startActivity(intent);

    }
}
