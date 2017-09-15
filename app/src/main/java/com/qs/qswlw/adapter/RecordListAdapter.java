package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.RecordListBean;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class RecordListAdapter extends BaseListAdapter<RecordListBean> {


    public RecordListAdapter(Context context, List<RecordListBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        RecordListBean recordListBean = data.get(i);
        ViewHolder holder;
        if (view == null) {//咦
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.item_recordlist, null);
            holder.btn_ischecked_recordlist = (Button) view.findViewById(R.id.btn_ischecked_recordlist);
            holder.tv_role_recordlist = (TextView) view.findViewById(R.id.tv_role_recordlist);
            holder.tv_id_recordlist = (TextView) view.findViewById(R.id.tv_id_recordlist);
            holder.tv_data_recordlist = (TextView) view.findViewById(R.id.tv_data_recordlist);
            holder.tv_none_recordlist = (TextView) view.findViewById(R.id.tv_none_recordlist);
            holder.tv_money_recordlist = (TextView) view.findViewById(R.id.tv_money_recordlist);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String is_go = recordListBean.getIs_go();
        if ("1".equals(is_go)) {
            holder.btn_ischecked_recordlist.setText("未审核");
        } else if ("2".equals(is_go)) {
            holder.btn_ischecked_recordlist.setText("已审核");
        }
        holder.tv_role_recordlist.setText("消费会员");
        holder.tv_id_recordlist.setText(recordListBean.getUser_id());
        //    holder.union_ranking.setText(singleLogBean.get());
        holder.tv_data_recordlist.setText(recordListBean.getAdd_time());
        holder.tv_none_recordlist.setText(recordListBean.getNone());
        holder.tv_money_recordlist.setText(recordListBean.getMoney());
        return view;
    }

    class ViewHolder {
        Button btn_ischecked_recordlist;
        TextView tv_role_recordlist;
        TextView tv_id_recordlist;
        TextView tv_data_recordlist;
        TextView tv_none_recordlist;
        TextView tv_money_recordlist;

    }
}
