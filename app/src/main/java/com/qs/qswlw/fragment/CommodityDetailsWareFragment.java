package com.qs.qswlw.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsWareFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_fg_ware;
    private TextView tv_minus,tv_add;
    private EditText edt_num;
    private int number = 0;
    public static CommodityDetailsWareFragment newInstance() {
        CommodityDetailsWareFragment fragment = new CommodityDetailsWareFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fg_commoditydetailsware, null);
        tv_minus = (TextView) inflate.findViewById(R.id.tv_minus);
        tv_add = (TextView) inflate.findViewById(R.id.tv_add);
        edt_num = (EditText) inflate.findViewById(R.id.edt_num);
        tv_fg_ware = (TextView) inflate.findViewById(R.id.tv_fg_ware);
        String str = edt_num.getText().toString();
        number = Integer.valueOf(str);
        tv_minus.setOnClickListener(this);
        tv_add.setOnClickListener(this);

        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();

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
        switch (view.getId()){
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
