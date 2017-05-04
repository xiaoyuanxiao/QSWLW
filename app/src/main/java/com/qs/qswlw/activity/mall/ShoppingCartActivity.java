package com.qs.qswlw.activity.mall;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class ShoppingCartActivity extends BaseActivity {

    private ImageView back;
    ExpandableListView expandableListView;
    ImageView ivSelectAll;
    TextView btnSettle;
    TextView tvCountMoney;
    TextView tvTitle;
    RelativeLayout rlShoppingCartEmpty;
    RelativeLayout rlBottomBar;

    @Override
    public Object initView() {
        return R.layout.activity_shoppingcart;
    }

    @Override
    public void initfindviewByid() {
        back = (ImageView) findViewById(R.id.back);
        expandableListView=  $(R.id.expandableListView);
        ivSelectAll=    $(R.id.ivSelectAll);
        btnSettle=   $(R.id.btnSettle);
        tvCountMoney=  $(R.id.tvCountMoney);
        rlShoppingCartEmpty=    $(R.id.rlShoppingCartEmpty);
        rlBottomBar=    $(R.id.rlBottomBar);

    }

    @Override
    public void initData() {
        super.initData();
    }



    @Override
    public void setOnclick() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }

    }

    /**
     * 省去类型转换  将此方法写在基类Activity
     */
    protected <T extends View> T $(int id)
    {
        return (T) super.findViewById(id);
    }
}
