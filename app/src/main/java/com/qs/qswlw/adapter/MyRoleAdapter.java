package com.qs.qswlw.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qs.qswlw.ItemRoleData;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MyRoleBean;
import com.qs.qswlw.utils.DateUtils;
import com.qs.qswlw.utils.RoleJudgeUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyRoleAdapter extends BaseRecyleAdapter {

    private ItemRoleData inflate;
    private List<MyRoleBean.LogsBean> logsBeen;

    public MyRoleAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        logsBeen = (List<MyRoleBean.LogsBean>) data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        inflate = DataBindingUtil.inflate(from, R.layout.item_role, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        MyRoleBean.LogsBean logsBean = logsBeen.get(position);

        inflate.tvItemRoleNew.setText(RoleJudgeUtil.roleJudeg(logsBean.getUp_yuan_role()));
        inflate.tvItemRoleOld.setText(RoleJudgeUtil.roleJudeg(logsBean.getUp_to_role()));
        inflate.tvItemRoleTime.setText(DateUtils.stampToDate(Integer.parseInt(logsBean.getUp_time()) * 1000L));
    }
}
