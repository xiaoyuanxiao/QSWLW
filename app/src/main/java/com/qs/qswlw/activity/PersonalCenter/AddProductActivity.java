package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.utils.DialogUtils;

/**
 * Created by xiaoyu on 2017/5/11.
 */

public class AddProductActivity extends BaseInfoActivity {

    private Spinner addproduct_spinner,addproductclassify_spinner;
    private TextView addproduct_model,addproduct_promise;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_addproduct, null);
        addproductclassify_spinner = (Spinner) inflate.findViewById(R.id.addproductclassify_spinner);
        addproduct_model = (TextView) inflate.findViewById(R.id.addproduct_model);
        addproduct_promise = (TextView) inflate.findViewById(R.id.addproduct_promise);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("添加商品");

    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        addproduct_model.setOnClickListener(this);
        addproduct_promise.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.addproduct_model:
                DialogUtils.showDidlog(this,new String[]{"20%"},addproduct_model);
                break;
            case R.id.addproduct_promise:
                DialogUtils.showDidlog(this,new String[]{"7天无理由条件退换货","15天有条件退换货(咨询商家)"},addproduct_promise);
                break;
        }
    }


}
