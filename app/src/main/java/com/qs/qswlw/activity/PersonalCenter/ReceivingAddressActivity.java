package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.PersonalCenter.city.CitySelectActivity;
import com.qs.qswlw.view.cityselect.City;

import java.util.ArrayList;


/**
 * Created by xiaoyu on 2017/3/29.
 */

public class ReceivingAddressActivity extends BaseActivity {

    private ImageView iv_titlebar;
    private TextView tv_titlebar_center;
    private EditText et_consigneeName,et_phone,et_detailedaddress,et_postcode;
    private City city ;
    private ArrayList<City> toCitys;
    private TextView tv_city;
    private Button btn_save;


    @Override
    public Object initView() {
        return R.layout.activity_receivingaddress1;
    }

    @Override
    public void initfindviewByid() {
        iv_titlebar = (ImageView) findViewById(R.id.iv_titlebar);
        tv_titlebar_center = (TextView) findViewById(R.id.tv_titlebar_center);
        et_consigneeName = (EditText) findViewById(R.id.et_consigneeName);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_detailedaddress = (EditText) findViewById(R.id.et_detailedaddress);
        et_postcode = (EditText) findViewById(R.id.et_postcode);
        tv_city = (TextView) findViewById(R.id.tv_city);
        btn_save = (Button) findViewById(R.id.btn_save);


        city = new City();
        toCitys = new ArrayList<City>();
        iv_titlebar.setImageResource(R.mipmap.left);
        tv_titlebar_center.setText("地址管理");


    }

    @Override
    public void setOnclick() {
        tv_city.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_city:
                Intent in = new Intent(this, CitySelectActivity.class);
                in.putExtra("city", city);
                startActivityForResult(in, 1);
                break;
            case R.id.btn_save:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 8){
            if(requestCode == 1){
                city = data.getParcelableExtra("city");
                tv_city.setText(city.getProvince()+" "+city.getCity()+ " "+city.getDistrict());
            }
        }
    }

}
