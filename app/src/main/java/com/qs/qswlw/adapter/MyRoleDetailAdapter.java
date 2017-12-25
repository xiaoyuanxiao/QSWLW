package com.qs.qswlw.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qs.qswlw.ItemRoleDetailData;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MyRoleDatailBean;
import com.qs.qswlw.utils.DateUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyRoleDetailAdapter extends BaseRecyleAdapter {

    private ItemRoleDetailData inflate;
    private List<MyRoleDatailBean.UserListBean> userListBeen;

    public MyRoleDetailAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        userListBeen = (List<MyRoleDatailBean.UserListBean>) data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        inflate = DataBindingUtil.inflate(from, R.layout.item_roledetail, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        MyRoleDatailBean.UserListBean userListBean = userListBeen.get(position);

        inflate.tvItemRoledetailTime.setText(DateUtils.stampToDate(Integer.parseInt(userListBean.getVerify_time()) * 1000L));
    }
}
