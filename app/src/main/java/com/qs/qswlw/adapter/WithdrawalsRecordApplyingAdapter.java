package com.qs.qswlw.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.DateUtils;
import com.qs.qswlw.utils.ToastUtils;

import java.util.List;

import rx.Observable;

import static com.qs.qswlw.R.id.tv_item_withdrawalsrecord_recall;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordApplyingAdapter extends BaseListAdapter<WithDrawalsRecordBean.ListBean> {

    private String id;
    private int position;

    public WithdrawalsRecordApplyingAdapter(Context context, List<WithDrawalsRecordBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        WithDrawalsRecordBean.ListBean listBean =  data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_withdrawalsrecord,null);
            holder.tv_item_withdrawalsrecord_money = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_money);
            holder.tv_item_withdrawalsrecord_time = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_time);
            holder.tv_item_withdrawalsrecord_recall = (TextView) view.findViewById(tv_item_withdrawalsrecord_recall);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_withdrawalsrecord_money.setText(listBean.getMoney());
        String create_time = listBean.getCreate_time();
        id = listBean.getId(); //id
        holder.tv_item_withdrawalsrecord_time.setText(DateUtils.date2date(Long.parseLong(create_time)*1000L));
        /**
         * 撤销申请
         */
        holder.tv_item_withdrawalsrecord_recall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = i;
                showDialog();
            }


        });
        return view;
    }
    private void showDialog() {
        final AlertDialog.Builder dialog =
                new AlertDialog.Builder(context);
        dialog.setMessage("撤回记录将不可以恢复，确定撤回记录吗？");
        dialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RecallWithdrawals(MyApplication.TOKEN, Integer.parseInt(id));
                    }


                });
        dialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();
    }

    /**
     * 撤销申请
     */
    private void RecallWithdrawals(final String token, final int id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("RecallWithdrawals",e+"");
            }

            @Override
            public void onNext(MainBean mainBean) {
                String msg = mainBean.getMsg();
                ToastUtils.showToast(msg);
                if(mainBean.getSucc()==1){
                    data.remove(position);
                    notifyDataSetChanged();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithdrawaslRecall(token,id);
            }
        });


    }

    class ViewHolder{
        TextView tv_item_withdrawalsrecord_money;
        TextView tv_item_withdrawalsrecord_time;
        TextView tv_item_withdrawalsrecord_recall;
    }
}
