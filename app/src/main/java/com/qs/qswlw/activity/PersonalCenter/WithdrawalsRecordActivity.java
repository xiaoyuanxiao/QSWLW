package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsRecordAdapter;


/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordActivity extends BaseInfoActivity {

    private TextView tv_withdrawalsed,tv_withdrawalsing;
    private View view_left,view_right;
    private ListView lv_withdrawalsrecord;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsrecord, null);
        tv_withdrawalsed = (TextView) inflate.findViewById(R.id.tv_withdrawalsed);
        tv_withdrawalsing = (TextView) inflate.findViewById(R.id.tv_withdrawalsing);
        view_left = (View) inflate.findViewById(R.id.view_left);
        view_right = (View) inflate.findViewById(R.id.view_right);
        lv_withdrawalsrecord = (ListView) inflate.findViewById(R.id.lv_withdrawalsrecord);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("提现记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_withdrawalsrecord.setAdapter(new WithdrawalsRecordAdapter(this));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_withdrawalsed.setOnClickListener(this);
        tv_withdrawalsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_withdrawalsed:
                tv_withdrawalsed.setTextColor(getResources().getColor(R.color.red));
                tv_withdrawalsing.setTextColor(getResources().getColor(R.color.black));
                view_left.setVisibility(View.VISIBLE);
                view_left.setBackgroundColor(getResources().getColor(R.color.red));
                view_right.setVisibility(View.INVISIBLE);
                break;
            case R.id.tv_withdrawalsing:
                tv_withdrawalsing.setTextColor(getResources().getColor(R.color.red));
                tv_withdrawalsed.setTextColor(getResources().getColor(R.color.black));
                view_right.setBackgroundColor(getResources().getColor(R.color.red));
                view_right.setVisibility(View.VISIBLE);
                view_left.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
