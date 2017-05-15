package com.qs.qswlw.activity.PersonalCenter;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsAddActivity extends BaseInfoActivity {
    private Spinner province_spinner;
    private Spinner city_spinner;
    private Spinner county_spinner;
    private Integer provinceId, cityId;
    private ArrayAdapter<CharSequence> province_adapter;
    private String strProvince, strCity, strCounty;
    private ArrayAdapter<CharSequence> city_adapter;
    private int[] city = {R.array.beijin_province_item, R.array.tianjin_province_item, R.array.heibei_province_item, R.array.shanxi1_province_item, R.array.neimenggu_province_item, R.array.liaoning_province_item, R.array.jilin_province_item, R.array.heilongjiang_province_item, R.array.shanghai_province_item, R.array.jiangsu_province_item, R.array.zhejiang_province_item, R.array.anhui_province_item, R.array.fujian_province_item, R.array.jiangxi_province_item, R.array.shandong_province_item, R.array.henan_province_item, R.array.hubei_province_item, R.array.hunan_province_item, R.array.guangdong_province_item,  R.array.guangxi_province_item, R.array.hainan_province_item, R.array.chongqing_province_item, R.array.sichuan_province_item, R.array.guizhou_province_item, R.array.yunnan_province_item, R.array.xizang_province_item, R.array.shanxi2_province_item, R.array.gansu_province_item, R.array.qinghai_province_item, R.array.linxia_province_item, R.array.xinjiang_province_item, R.array.hongkong_province_item, R.array.aomen_province_item, R.array.taiwan_province_item};
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsadd, null);
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
    }

    private void loadSpinner()
    {
        province_spinner = (Spinner) findViewById(R.id.province_spinner);
        province_spinner.setPrompt("请选择省份");
        province_adapter = ArrayAdapter.createFromResource(this, R.array.province_item, android.R.layout.simple_spinner_item);
        province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        province_spinner.setAdapter(province_adapter);
        //select(province_spinner, province_adapter, R.array.province_item);
        province_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3)
            {
                provinceId = province_spinner.getSelectedItemPosition();
                strProvince = province_spinner.getSelectedItem().toString();
                city_spinner = (Spinner) findViewById(R.id.city_spinner);
                if(true)
                {
                    Log.v("test", "province: "+province_spinner.getSelectedItem().toString()+provinceId.toString());
                    city_spinner = (Spinner) findViewById(R.id.city_spinner);
                    city_spinner.setPrompt("请选择城市");
                    select(city_spinner, city_adapter, city[provinceId]);
                    city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                    {

                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int arg2, long arg3) {
                            cityId = city_spinner.getSelectedItemPosition();
                            strCity = city_spinner.getSelectedItem().toString();
                            Log.v("test", "city: " + city_spinner.getSelectedItem().toString() + cityId.toString());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub

                        }

                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

    }

    private void select(Spinner spin, ArrayAdapter<CharSequence> adapter, int arry)
    {
        adapter = ArrayAdapter.createFromResource(this, arry, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        //spin.setSelection(0,true);
    }
}
