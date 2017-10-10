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
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MyBankListBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.ToastUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsBankAdapter extends BaseListAdapter<MyBankListBean.CardListBean> {

    private int position;

    public WithdrawalsBankAdapter(Context context, List<MyBankListBean.CardListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
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
        holder.iv_item_mybanklist_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = i;
                PostDelData(MyApplication.TOKEN,Integer.parseInt(cardListBean.getId()));
            }


        });
        return view;
    }

    /**
     * 删除数据
     * @param token
     * @param id
     */
    private void PostDelData(final String token, final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
                if(mainBean.getSucc()==1){
                    data.remove(position);
                    notifyDataSetChanged();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithdrawalsDel(token,id);
            }
        });
    }

    class ViewHolder {
        TextView tv_item_mybanklist_name;
        TextView tv_item_mybanklist_number;
        ImageView iv_item_mybanklist_right;
        ImageView iv_item_mybanklist_del;
        ImageView tv_item_mybanklist_edit;
    }
}
