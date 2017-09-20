package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsAddView;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsAddPersenter;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsAddActivity extends BaseInfoActivity implements IWithdrawalsAddView {
    private Spinner province_spinner;
    private Spinner city_spinner;
    private Spinner county_spinner;
    private Integer provinceId, cityId;
    private ArrayAdapter<CharSequence> province_adapter;
    private String strProvince, strCity, strCounty;
    private ArrayAdapter<CharSequence> city_adapter;
    private WithdrawalsAddPersenter withdrawalsAddPersenter = new WithdrawalsAddPersenter(this);
    private EditText edt_withdrawalsadd_name,edt_withdrawalsadd_card,edt_withdrawalsadd_number;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsadd, null);
        edt_withdrawalsadd_name = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_name);
        edt_withdrawalsadd_card = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_card);
        edt_withdrawalsadd_number = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_number);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("添加银行卡");
    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if(id!=null){
            withdrawalsAddPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(id));
        }else{
            withdrawalsAddPersenter.getdata(MyApplication.TOKEN, 0);
        }

    }

    private void loadSpinner(){
    }

    private void select(Spinner spin, ArrayAdapter<CharSequence> adapter, int arry)
    {
        adapter = ArrayAdapter.createFromResource(this, arry, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        //spin.setSelection(0,true);
    }

    @Override
    public void setdata(WithdrawalsAddBean withdrawalsAddBean) {
        WithdrawalsAddBean.InfoBean info = withdrawalsAddBean.getInfo();
        edt_withdrawalsadd_name.setText(info.getName());
        edt_withdrawalsadd_card.setText(info.getCard());
        edt_withdrawalsadd_number.setText(info.getNumber());
    }
}
