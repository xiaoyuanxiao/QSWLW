package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.ReceivingAddressDatabinding;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.bean.ReceivingAddressBean;
import com.qs.qswlw.okhttp.Iview.IReceivingAddressView;
import com.qs.qswlw.okhttp.Presenter.ReceivingAddressPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;

import java.util.List;


/**
 * Created by xiaoyu on 2017/3/29.
 */

public class ReceivingAddress1Activity extends BaseDataBindingActivity implements IReceivingAddressView,View.OnClickListener {


    PopupWindow popupWindow;
    private ReceivingAddressDatabinding receivingAddressDatabinding;
    private ReceivingAddressPersenter receivingAddressPersenter = new ReceivingAddressPersenter(this);
    private String provinceName,cityName,districtName,twonName;
    private LinearLayout pw_commoditydetails_one,pw_commoditydetails_two,pw_commoditydetails_three,pw_commoditydetails_four;

    @Override
    protected int initview() {
        return R.layout.activity_receivingaddress1;
    }

    @Override
    protected void initdatabinding() {
        receivingAddressDatabinding = getBind();
        setTitleBg(R.color.red);
        setTitleName("地址管理");
        setTitleRightimg(R.mipmap.oo_03);
        baseInfoData.ivTitlebarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPw(baseInfoData.ivTitlebarRight);
            }
        });
    }



    private void showPw(ImageView v) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pw_commoditydetails, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, 200, RelativeLayout.LayoutParams.WRAP_CONTENT);
        pw_commoditydetails_one = (LinearLayout) layout.findViewById(R.id.pw_commoditydetails_one);
        pw_commoditydetails_two = (LinearLayout) layout.findViewById(R.id.pw_commoditydetails_two);
        pw_commoditydetails_three = (LinearLayout) layout.findViewById(R.id.pw_commoditydetails_three);
        pw_commoditydetails_four = (LinearLayout) layout.findViewById(R.id.pw_commoditydetails_four);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.TOP | Gravity.RIGHT, 10, 120);
        pw_commoditydetails_one.setOnClickListener(this);
        pw_commoditydetails_two.setOnClickListener(this);
        pw_commoditydetails_three.setOnClickListener(this);
        pw_commoditydetails_four.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        receivingAddressPersenter.getData(MyApplication.TOKEN, Integer.parseInt(MyApplication.CYZXID));
    }

    @Override
    public void setdata(ReceivingAddressBean receivingAddressBean) {
        ReceivingAddressBean.AddressBean address = receivingAddressBean.getAddress();
        receivingAddressDatabinding.setAddressBean(address);
        List<ReceivingAddressBean.ProvinceBean> province = receivingAddressBean.getProvince();
        List<ReceivingAddressBean.CityBean> city = receivingAddressBean.getCity();
        List<ReceivingAddressBean.DistrictBean> district = receivingAddressBean.getDistrict();
        List<ReceivingAddressBean.TwonBean> twon = receivingAddressBean.getTwon();
        String province1 = address.getProvince();
        String city1 = address.getCity();
        String district1 = address.getDistrict();
        String twon1 = address.getTwon();
        for (int i = 0; i < province.size(); i++) {
            if (province.get(i).getId().equals(province1)) {
                provinceName = province.get(i).getName();
                break;
            }
        }
        for (int i = 0; i < city.size(); i++) {
            if (city.get(i).getId().equals(city1)) {
                cityName = city.get(i).getName();
                break;
            }
        }
        for (int i = 0; i < district.size(); i++) {
            if (district.get(i).getId().equals(district1)) {
                districtName = district.get(i).getName();
                break;
            }
        }
        for (int i = 0; i < twon.size(); i++) {
            if (twon.get(i).getId().equals(twon1)) {
                twonName = twon.get(i).getName();
                break;
            }
        }
        receivingAddressDatabinding.etAddress.setText(provinceName+"  "+cityName+districtName+twonName);
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pw_commoditydetails_one:

                break;
            case R.id.pw_commoditydetails_two:

                break;
            case R.id.pw_commoditydetails_three:

                break;
            case R.id.pw_commoditydetails_four:

                break;

        }
    }
}
