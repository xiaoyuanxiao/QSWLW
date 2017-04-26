package com.qs.qswlw.activity.mall;

import android.view.View;
import android.widget.ImageView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class ShoppingCartActivity extends BaseActivity {

    private ImageView back;

    @Override
    public Object initView() {
        return R.layout.activity_shoppingcart;
    }

    @Override
    public void initfindviewByid() {
        back = (ImageView) findViewById(R.id.back);

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
}
