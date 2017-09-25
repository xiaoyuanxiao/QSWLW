package com.qs.qswlw.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.WithdrawalsAddActivity;
import com.qs.qswlw.activity.PersonalCenter.WithdrawalsRecordActivity;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.DateUtils;
import com.qs.qswlw.utils.ToastUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordAdapter extends BaseListAdapter<WithDrawalsRecordBean.ListBean> {
    //private int position;
    //private String id;

    public WithdrawalsRecordAdapter(Context context, List<WithDrawalsRecordBean.ListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final WithDrawalsRecordBean.ListBean listBean = data.get(i);
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_withdrawalsrecord, null);
            holder.tv_item_withdrawalsrecord_money = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_money);
            holder.tv_item_withdrawalsrecord_time = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_time);
            holder.tv_item_withdrawalsrecord_modify = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_modify);
            holder.tv_item_withdrawalsrecord_recall = (TextView) view.findViewById(R.id.tv_item_withdrawalsrecord_recall);
            holder.ll_item_withdrawals = (LinearLayout) view.findViewById(R.id.ll_item_withdrawals);
            holder.tv_itemll_withdrawalsrecord_modify = (TextView) view.findViewById(R.id.tv_itemll_withdrawalsrecord_modify);
            holder.tv_itemll_withdrawalsrecord_resubmit = (TextView) view.findViewById(R.id.tv_itemll_withdrawalsrecord_resubmit);
            holder.tv_itemll_withdrawalsrecord_recall = (TextView) view.findViewById(R.id.tv_itemll_withdrawalsrecord_recall);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item_withdrawalsrecord_money.setText(listBean.getMoney());

        holder.tv_item_withdrawalsrecord_time.setVisibility(View.GONE);
        String create_time = listBean.getCreate_time();
//        id = listBean.getId();
        String user_up_fail_info = listBean.getUser_up_fail_info();//1为撤回提现、重新提交状态，0为修改信息状态
        if (user_up_fail_info.equals("1")) {
            holder.ll_item_withdrawals.setVisibility(View.VISIBLE);
            holder.tv_item_withdrawalsrecord_modify.setVisibility(View.GONE);
            holder.tv_itemll_withdrawalsrecord_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WithdrawalsAddActivity.class);
                    intent.putExtra("failId", listBean.getId());
                    intent.putExtra("modify", "modify");
                    ((Activity) context).startActivityForResult(intent, 200);

                }
            });

            holder.tv_itemll_withdrawalsrecord_recall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //    position = i;
                    showDialog(1, "撤回记录将不可以恢复，确定撤回记录吗？", Integer.parseInt(listBean.getId()), i);
                }
            });
            /**
             * 重新提交
             */
            holder.tv_itemll_withdrawalsrecord_resubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //    position = i;
                    showDialog(2, "确认信息已经修改，并重新提交申请吗？", Integer.parseInt(listBean.getId()), i);
                }
            });


        }
        if (user_up_fail_info.equals("0")) {
            holder.tv_item_withdrawalsrecord_modify.setVisibility(View.VISIBLE);
            holder.ll_item_withdrawals.setVisibility(View.GONE);
            holder.tv_item_withdrawalsrecord_modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, WithdrawalsAddActivity.class);
                    intent.putExtra("failId", listBean.getId());
                    intent.putExtra("modify", "modify");
                    ((Activity) context).startActivityForResult(intent, 200);
                }
            });
        }
        holder.tv_item_withdrawalsrecord_recall.setText(DateUtils.date2date(Long.parseLong(create_time) * 1000L));

        return view;
    }

    private void showDialog(final int a, String s, final int id, final int position) {
        final AlertDialog.Builder dialog =
                new AlertDialog.Builder(context);
        dialog.setMessage(s);
        dialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /**
                         *撤回提现
                         */
                        if (a == 1) {
                            RecallWithdrawals(MyApplication.TOKEN, id, position);
                        } else if (a == 2) {
                            ResubmitWithdrawals(MyApplication.TOKEN, id, position);
                        }

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
     * 重新提交
     *
     * @param token
     */
    private void ResubmitWithdrawals(final String token, final int wid, final int position) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("ResubmitWithdrawals", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                String msg = mainBean.getMsg();
                ToastUtils.showToast(msg);
                if (mainBean.getSucc() == 1) {
                    if (context instanceof WithdrawalsRecordActivity)
                    {
                        ((WithdrawalsRecordActivity)context).setFragmentdata(0);
                    }
//                    Intent intent = new Intent(context, WithdrawalsRecordActivity.class);
//                    ((Activity) context).startActivityForResult(intent,100);
                    //这里不刷新自己的数据了，直接去另一个fragment里面刷新数据，去WithDrawalsRecordApplyingFragment
//                    data.remove(position);
//                    notifyDataSetChanged();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostPostWithdrawalsFailedResubmit(token, wid);
            }
        });

    }


    /**
     * 撤销申请
     */
    private void RecallWithdrawals(final String token, final int id, final int position) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {
            @Override
            public void onError(Throwable e) {
                Log.e("RecallWithdrawals", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                String msg = mainBean.getMsg();
                ToastUtils.showToast(msg);
                if (mainBean.getSucc() == 1) {
                    data.remove(position);
                    notifyDataSetChanged();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithdrawaslRecall(token, id);
            }
        });


    }

    class ViewHolder {
        TextView tv_item_withdrawalsrecord_money;
        TextView tv_item_withdrawalsrecord_time;
        TextView tv_item_withdrawalsrecord_modify;
        TextView tv_item_withdrawalsrecord_recall;
        LinearLayout ll_item_withdrawals;
        TextView tv_itemll_withdrawalsrecord_modify;
        TextView tv_itemll_withdrawalsrecord_resubmit;
        TextView tv_itemll_withdrawalsrecord_recall;
    }
}
