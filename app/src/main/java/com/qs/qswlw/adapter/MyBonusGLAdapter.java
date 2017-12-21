package com.qs.qswlw.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qs.qswlw.MyBonusGLData;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MyBonusBean;
import com.qs.qswlw.utils.RoleJudgeUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyu on 2017/12/21.
 */

public class MyBonusGLAdapter extends BaseRecyleAdapter {
    private List<MyBonusBean.ListBean> listBeen;
    private MyBonusGLData inflate;

    public MyBonusGLAdapter(List<?> data, Map<Integer, Integer> hashMap) {
        super(data, hashMap);
        listBeen = (List<MyBonusBean.ListBean>) data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        inflate = DataBindingUtil.inflate(from, R.layout.item_mybonusgl, parent, false);
        return  new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        String role = listBeen.get(position).getRole();
        String s = RoleJudgeUtil.roleJudeg(role);
        inflate.tvItemMybonusType.setText(s+"提成");
        
        
    }
}
