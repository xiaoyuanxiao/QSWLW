package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsAddView;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsAddPersenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsAddActivity extends BaseInfoActivity implements IWithdrawalsAddView {
    ArrayList<String> banklist = new ArrayList<>();

    ArrayList<String> provincelist = new ArrayList();
    ArrayList<String> citylist = new ArrayList();
    private Spinner spinner_bank, spinner_province, spinner_city;
    private ArrayAdapter<String> province_adapter;
    private ArrayAdapter<String> city_adapter;
    private ArrayAdapter<String> bank_adapter;
    List<WithdrawalsAddBean.ClistBean> clistprovince;

    private WithdrawalsAddPersenter withdrawalsAddPersenter = new WithdrawalsAddPersenter(this);
    private EditText edt_withdrawalsadd_name, edt_withdrawalsadd_card, edt_withdrawalsadd_number;
    private List<WithdrawalsAddBean.ClistBean> clist;
    private List<WithdrawalsAddBean.ShiListBean> shi_list;
    private String cardxy;
    private String region;
    private String city;

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
        loadBankSpinner();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if (id != null) {
            withdrawalsAddPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(id));
        } else {
            withdrawalsAddPersenter.getdata(MyApplication.TOKEN, 0);
        }

    }

    private void loadBankSpinner() {
        spinner_bank = (Spinner) findViewById(R.id.spinner_withdrawalsadd_bank);
        banklist.add("请选择转入的银行");
        banklist.add("中国工商银行");
        banklist.add("招商银行");
        banklist.add("中国建设银行");
        banklist.add("中国农业银行");
        banklist.add("中国银行");
        banklist.add("农村商业银行");
        bank_adapter = getSpinerAdapter(banklist);
        select(spinner_bank, bank_adapter);
        bank_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_bank.setAdapter(bank_adapter);

        spinner_bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner_bank.getSelectedItemPosition();
                setSpinnerItemSelectedByValue(spinner_bank,cardxy);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * 根据id值, 设置spinner默认选中:
     * @param spinner
     * @param value
     */
    public static void setSpinnerItemSelectedByValue(Spinner spinner,String value){

        SpinnerAdapter apsAdapter= spinner.getAdapter(); //得到SpinnerAdapter对象
        int k= apsAdapter.getCount();
        for(int i=0;i<k;i++){
            if(value.equals(apsAdapter.getItem(i).toString())){
                spinner.setSelection(i,true);// 默认选中项
                break;
            }
        }
    }


    private void loadSpinner() {
        spinner_province = (Spinner) findViewById(R.id.spinner_withdrawalsadd_province);
        spinner_city = (Spinner) findViewById(R.id.spinner_withdrawalsadd_city);
        province_adapter = getSpinerAdapter(provincelist);
        city_adapter = getSpinerAdapter(citylist);
        select(spinner_province, province_adapter);
        select(spinner_city, city_adapter);
    }

    private void select(Spinner spin, ArrayAdapter<String> adapter) {
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(onItemSelectedListener);
    }
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                   int arg2, long arg3) {
            String id = null;
            int selectCode = 0;
            if (arg2 == 0)
                return;
            switch (arg0.getId()) {
                case R.id.spinner_withdrawalsadd_province:
//                    //网络请求市--根据省ID 其他类似
//                    if (clistprovince == null || clistprovince.size() == 0)
//                        return;
//                    id = clistprovince.get(arg2 - 1).getId();
                   // selectCode = CITYCODE;
                    break;
            }
           // improveCityPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(id), selectCode);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    };

    private ArrayAdapter getSpinerAdapter(ArrayList<String> args) {
        return new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, args);
    }
    private void select(Spinner spin, ArrayAdapter<CharSequence> adapter, int arry) {
        adapter = ArrayAdapter.createFromResource(this, arry, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    @Override
    public void setdata(WithdrawalsAddBean withdrawalsAddBean) {
        WithdrawalsAddBean.InfoBean info = withdrawalsAddBean.getInfo();
        edt_withdrawalsadd_name.setText(info.getName());
        edt_withdrawalsadd_card.setText(info.getCard());
        edt_withdrawalsadd_number.setText(info.getNumber());
        //省级列表
        clist = withdrawalsAddBean.getClist();
        provincelist.add("请选择开户行所在省");
        for (WithdrawalsAddBean.ClistBean clistBean : clist) {
            provincelist.add(clistBean.getName());
        }
        //省级列表
        shi_list = withdrawalsAddBean.getShi_list();
        citylist.add("请选择开户行所在市");
        for (WithdrawalsAddBean.ShiListBean shiListBean : shi_list) {
            citylist.add(shiListBean.getName());
        }
        cardxy = info.getCardxy();
        region = info.getRegion();//省得id
        city = info.getCity();//市的id
    }
}
