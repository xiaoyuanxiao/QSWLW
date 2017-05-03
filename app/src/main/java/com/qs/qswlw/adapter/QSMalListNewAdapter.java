package com.qs.qswlw.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.qs.qswlw.R;


/**
 * Created by xiaoyu on 2017/4/26.
 */

public class QSMalListNewAdapter extends BaseAdapter implements View.OnClickListener {
    private Context context;
    private int number = 0;
    private EditText edt_num;
    private TextView tv_minus, tv_add;


    public QSMalListNewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = View.inflate(context, R.layout.item_qsmalllist, null);
        edt_num = (EditText) view.findViewById(R.id.edt_num);
        tv_minus = (TextView) view.findViewById(R.id.tv_minus);
        tv_add = (TextView) view.findViewById(R.id.tv_add);
        String str = edt_num.getText().toString();
        number = Integer.valueOf(str);
        tv_minus.setOnClickListener(this);
        tv_add.setOnClickListener(this);
        return view;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2) {//更改对话框中的数量
                edt_num.setText(String.valueOf(number));
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_minus:
                if (number > 1) {
                    number--;
                    handler.sendEmptyMessage(2);
                }
                break;
            case R.id.tv_add:
                number++;
                handler.sendEmptyMessage(2);
                break;
        }
    }


}
