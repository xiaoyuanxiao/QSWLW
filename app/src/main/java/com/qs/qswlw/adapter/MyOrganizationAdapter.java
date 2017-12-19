package com.qs.qswlw.adapter;



import com.qs.qswlw.BR;
import com.qs.qswlw.bean.MyOrganizationBean;
import com.qs.qswlw.utils.RoleJudgeUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/19.
 */

public class MyOrganizationAdapter extends  BaseRecyleAdapter {
    private List<MyOrganizationBean.TuiDataBean> tuiDataBeen;


    public MyOrganizationAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        tuiDataBeen = (List<MyOrganizationBean.TuiDataBean>) data;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        MyOrganizationBean.TuiDataBean tuiDataBean = tuiDataBeen.get(position);
        String s1 = RoleJudgeUtil.roleJudeg(tuiDataBean.getRole());
        holder.dataBinding.setVariable(BR.role,s1);
        holder.dataBinding.setVariable(BR.id,"ID:  "+tuiDataBean.getUser_id());
        holder.dataBinding.setVariable(BR.total,"业绩： "+tuiDataBean.getTotal());



    }
}
