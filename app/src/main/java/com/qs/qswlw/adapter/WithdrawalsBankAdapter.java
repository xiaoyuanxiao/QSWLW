package com.qs.qswlw.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.WithdrawalsAddActivity;
import com.qs.qswlw.bean.MyBankListBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsBankAdapter extends BaseListAdapter<MyBankListBean.CardListBean> {



    public WithdrawalsBankAdapter(Context context, List<MyBankListBean.CardListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final MyBankListBean.CardListBean cardListBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_withdrawalsbank,null);
            holder.tv_item_mybanklist_name = (TextView) view.findViewById(R.id.tv_item_mybanklist_name);
            holder.tv_item_mybanklist_number = (TextView) view.findViewById(R.id.tv_item_mybanklist_number);
            holder.iv_item_mybanklist_right = (ImageView) view.findViewById(R.id.iv_item_mybanklist_right);
            holder.iv_item_mybanklist_del = (ImageView) view.findViewById(R.id.iv_item_mybanklist_del);
            holder.tv_item_mybanklist_edit = (ImageView) view.findViewById(R.id.tv_item_mybanklist_edit);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_mybanklist_name.setText(cardListBean.getCardxy());
        holder.tv_item_mybanklist_number.setText(cardListBean.getNumber());
        if(i== MyApplication.POSITION ){
            holder.iv_item_mybanklist_right.setVisibility(View.VISIBLE);
        }else{
            holder.iv_item_mybanklist_right.setVisibility(View.GONE);
        }
        holder.tv_item_mybanklist_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WithdrawalsAddActivity.class);
                intent.putExtra("id",cardListBean.getId());
                context.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHolder {
        TextView tv_item_mybanklist_name;
        TextView tv_item_mybanklist_number;
        ImageView iv_item_mybanklist_right;
        ImageView iv_item_mybanklist_del;
        ImageView tv_item_mybanklist_edit;
    }
}
