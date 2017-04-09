package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class BusinessTurnoverAdapter extends BaseAdapter {
    private Context context;

    public BusinessTurnoverAdapter(Context context) {
        this.context = context;
    }
   public String[] money = {"1000.00","1000.00","1000.00","1000.00","1000.00","1000.00","1000.00","1000.00","1000.00",};
    public String[] contents = {"2017-04_04", "2017-04_04","2017-04_04","2017-04_04","2017-04_04","2017-04_04","2017-04_04","2017-04_04","2017-04_04",};



    @Override
    public int getCount() {
        return contents.length;
    }

    @Override
    public Object getItem(int i) {
        return contents[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item_businessturnover,null);
        TextView tv_data_BusinessTurnover = (TextView) view.findViewById(R.id.tv_data_BusinessTurnover);
        TextView tv_money_BusinessTurnover = (TextView) view.findViewById(R.id.tv_money_BusinessTurnover);
        tv_data_BusinessTurnover.setText(contents[i]);
        tv_money_BusinessTurnover.setText(money[i]);
        return view;
    }
}
