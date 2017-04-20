package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.InvestRecordAdapter;

/**
 * Created by xiaoyu on 2017/4/20.
 */

public class GoldWhereaboutsActivity extends BaseInfoActivity {
    private ListView lv_investrecord;
    private TextView tv_venturegold_left,tv_venturegold_center,tv_venturegold_right;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_investrecord, null);
        lv_investrecord = (ListView) inflate.findViewById(R.id.lv_investrecord);
        tv_venturegold_left = (TextView) inflate.findViewById(R.id.tv_venturegold_left);
        tv_venturegold_center = (TextView) inflate.findViewById(R.id.tv_venturegold_center);
        tv_venturegold_right = (TextView) inflate.findViewById(R.id.tv_venturegold_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("金币去向");
        tv_venturegold_left.setText("支出金额");
        tv_venturegold_center.setText("支出类型");
        tv_venturegold_right.setText("支出时间");
    }

    @Override
    public void initData() {
        super.initData();
        lv_investrecord.setAdapter(new InvestRecordAdapter(this));
    }

}
