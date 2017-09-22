package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsAddBean;
import com.qs.qswlw.bean.WithdrawalsCityBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsAddView;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsCityView;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsAddPersenter;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsCityPersenter;
import com.qs.qswlw.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static com.qs.qswlw.R.id.spinner_withdrawalsadd_province;

/**
 * Created by xiaoyu on 2017/5/15.
 */

public class WithdrawalsAddActivity extends BaseInfoActivity implements IWithdrawalsAddView, IWithdrawalsCityView {
    ArrayList<String> banklist = new ArrayList<>();

    ArrayList<String> provincelist = new ArrayList();
    ArrayList<String> citylist = new ArrayList();
    private Spinner spinner_bank, spinner_province, spinner_city;
    private ArrayAdapter<String> province_adapter;
    private ArrayAdapter<String> city_adapter;
    private ArrayAdapter<String> bank_adapter;
    //    List<WithdrawalsAddBean.ClistBean> clistprovince;
    private List<WithdrawalsCityBean.ClistBean> city_list_selected;

    private WithdrawalsAddPersenter withdrawalsAddPersenter = new WithdrawalsAddPersenter(this);
    private EditText edt_withdrawalsadd_name, edt_withdrawalsadd_card, edt_withdrawalsadd_number;
    private List<WithdrawalsAddBean.ClistBean> clist;
    private String cardxy;
    private String region;
    private String city;
    private WithdrawalsCityPersenter withdrawalsCityPersenter = new WithdrawalsCityPersenter(this);
    private Button btn_withdrawalsadd_add;
    private int id1;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsadd, null);
        edt_withdrawalsadd_name = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_name);
        edt_withdrawalsadd_card = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_card);
        edt_withdrawalsadd_number = (EditText) inflate.findViewById(R.id.edt_withdrawalsadd_number);
        btn_withdrawalsadd_add = (Button) inflate.findViewById(R.id.btn_withdrawalsadd_add);
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
            id1 = Integer.parseInt(id);
            withdrawalsAddPersenter.getdata(MyApplication.TOKEN, id1);
        } else {
            id1 = 0;
            // withdrawalsAddPersenter.getdata(MyApplication.TOKEN, 0);
        }

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_withdrawalsadd_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_withdrawalsadd_add:
                String cname = edt_withdrawalsadd_name.getText().toString();
                String account = edt_withdrawalsadd_card.getText().toString();
                String cardnumber = edt_withdrawalsadd_number.getText().toString();
                postData(MyApplication.TOKEN, id1, cname, getSpinerIds().get(0), Integer.parseInt(getSpinerIds().get(1)), Integer.parseInt(getSpinerIds().get(2)), account, cardnumber);
                break;
        }
    }

    /**
     * 处理->添加或修改银行卡信息
     *
     * @param token
     * @param id
     * @param cname
     * @param card
     * @param pcity
     * @param ccity
     * @param account
     * @param cardnumber
     */
    private void postData(final String token, final int id, final String cname, final String card, final int pcity, final int ccity, final String account, final String cardnumber) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("RecallWithdrawals", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                String msg = mainBean.getMsg();
                ToastUtils.showToast(msg);
                if(mainBean.getSucc()==1){
                    finish();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithdrawalsAddData(token, id, cname, card, pcity, ccity, account, cardnumber);
            }
        });


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


    }

    private void loadSpinner() {
        spinner_province = (Spinner) findViewById(spinner_withdrawalsadd_province);
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

    OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                   int arg2, long arg3) {
            if (arg2 == 0)
                return;
            switch (arg0.getId()) {
                case R.id.spinner_withdrawalsadd_province://只需要请求市的
                    if (clist == null || clist.size() == 0)
                        return;
                    withdrawalsCityPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(clist.get(arg2 - 1).getId()));
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    };


    private List<String> getSpinerIds() {
        ArrayList<String> strings = new ArrayList<>();
        int bankselectedItemPosition = spinner_bank.getSelectedItemPosition();
        String card = banklist.get(bankselectedItemPosition);
        strings.add(card);

        int selectedItemPosition = spinner_province.getSelectedItemPosition();
        if(selectedItemPosition!=0){
            String id = clist.get(selectedItemPosition-1).getId();
            strings.add(id);
        }
        int cityselectedItemPosition = spinner_city.getSelectedItemPosition();
        if (cityselectedItemPosition != 0) {
            String id2 = city_list_selected.get(cityselectedItemPosition - 1).getId();
            strings.add(id2);
        }



        return strings;
    }


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
        region = info.getRegion();//省得id
        cityID = info.getCity();//市的id
        cardxy = info.getCardxy();
        int k = 0;
        for (int i = 0; i < clist.size(); i++) {
            provincelist.add(clist.get(i).getName());
            if (clist.get(i).getId().equals(region))
                k = i + 1;
        }
        province_adapter.notifyDataSetChanged();
        spinner_province.setSelection(k);
        int i = banklist.indexOf(cardxy);
        spinner_bank.setSelection(i >= 0 ? i : 0);
    }

    String cityID;
    int isfrist = 0;

    @Override
    public void setCitydata(WithdrawalsCityBean withdrawalsCityBean) {

        citylist.clear();
        citylist.add("请选择市");
        int k = 0;
        city_list_selected = withdrawalsCityBean.getClist();
        for (int i = 0; i < city_list_selected.size(); i++) {
            WithdrawalsCityBean.ClistBean regionListBean = city_list_selected.get(i);
            citylist.add(regionListBean.getName());
            if (regionListBean.getId().equals(cityID) && isfrist == 0)
                k = i + 1;
        }
        city_adapter.notifyDataSetChanged();
        spinner_city.setSelection(k);
        isfrist++;
    }
}
