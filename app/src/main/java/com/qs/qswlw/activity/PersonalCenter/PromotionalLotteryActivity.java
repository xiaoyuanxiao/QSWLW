package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.JoinPromotionLuckDrawAdapter;

/**
 * Created by xiaoyu on 2017/4/18.
 */

public class PromotionalLotteryActivity extends BaseInfoActivity {

    private TextView tv_promotional_join,tv_promotional_win;
    private View view_join,view_win;
    private ListView lv_promotionallottery;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_promotionallottery, null);
        tv_promotional_join = (TextView) inflate.findViewById(R.id.tv_promotional_join);
        tv_promotional_win = (TextView) inflate.findViewById(R.id.tv_promotional_win);
        view_join = (View) inflate.findViewById(R.id.view_join);
        view_win = (View) inflate.findViewById(R.id.view_win);
        lv_promotionallottery = (ListView) inflate.findViewById(R.id.lv_promotionallottery);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("促销抽奖记录");
    }

    @Override
    public void initData() {
        super.initData();
        lv_promotionallottery.setAdapter(new JoinPromotionLuckDrawAdapter(this));

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_promotional_join.setOnClickListener(this);
        tv_promotional_win.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_promotional_join:
                tv_promotional_join.setTextColor(getResources().getColor(R.color.red));
                tv_promotional_win.setTextColor(getResources().getColor(R.color.black));
                view_join.setBackgroundColor(getResources().getColor(R.color.red));
                view_win.setBackgroundColor(getResources().getColor(R.color.view));

                break;
            case R.id.tv_promotional_win:
                tv_promotional_win.setTextColor(getResources().getColor(R.color.red));
                tv_promotional_join.setTextColor(getResources().getColor(R.color.red));
                view_win.setBackgroundColor(getResources().getColor(R.color.red));
                view_join.setBackgroundColor(getResources().getColor(R.color.view));

                break;
        }

    }
}
