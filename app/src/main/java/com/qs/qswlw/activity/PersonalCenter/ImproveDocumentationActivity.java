package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ImproveCityBean;
import com.qs.qswlw.bean.ImproveDocumentationBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IImproveCityView;
import com.qs.qswlw.okhttp.Iview.IImproveDocumentationView;
import com.qs.qswlw.okhttp.Presenter.ImproveCityPersenter;
import com.qs.qswlw.okhttp.Presenter.ImproveDocumentationPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import rx.Observable;


/**
 * Created by xiaoyu on 2017/3/31.
 */

public class ImproveDocumentationActivity extends BaseInfoActivity implements IImproveDocumentationView, IImproveCityView {

    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    ArrayList<String> provincelist = new ArrayList();
    ArrayList<String> citylist = new ArrayList();
    ArrayList<String> countylist = new ArrayList();
    List<ImproveDocumentationBean.ClistBean> improveDocumentationBeanclist;
    ArrayList<String> classification = new ArrayList();
    String cityID;
    String districtID;
    int CITYCODE = 0x8600;
    int COUNTYCODE = 0x8611;
    int isfrist = 0;
    private Spinner province_spinner, city_spinner, county_spinner;
    private ArrayAdapter<String> province_adapter;
    private ArrayAdapter<String> city_adapter;
    private ArrayAdapter<String> county_adapter;
    private Spinner classification_spinner;
    private ArrayAdapter<String> classification_adapter;
    private TextView tv_startTime, tv_endTime;
    private ImageView iv_UploadBusinessLicense, iv_Storefacade;
    private GenderPopupWindow menuWindow;
    private Bitmap bitmap;
    private Uri imageUri;
    private ImageView pic_uploadBusinessLicense, pic_Storefacade;
    private Calendar mCalendar;
    private String a;
    private ImproveDocumentationPersenter improveDocumentationPersenter = new ImproveDocumentationPersenter(this);
    private EditText edt_improve_name, edt_improve_companyname, edt_improve_mobile, edt_improve_address, edt_improve_catagory;
    private File file1;
    private File file2;
    private List<ImproveDocumentationBean.ThemsBean> thems;
    private List<ImproveCityBean.RegionListBean> city_list_selected;
    private List<ImproveCityBean.RegionListBean> county_list_selected;
    private ImproveCityPersenter improveCityPersenter = new ImproveCityPersenter(this);
    OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                   int arg2, long arg3) {
            String id = null;
            int selectCode = 0;
            switch (arg0.getId()) {
                case R.id.province_spinner:
                    //网络请求市--根据省ID 其他类似
                    if (improveDocumentationBeanclist == null || improveDocumentationBeanclist.size() == 0)
                        return;
                    id = improveDocumentationBeanclist.get(arg2).getId();
                    selectCode = CITYCODE;
                    isfrist++;
                    break;
                case R.id.city_spinner:
                    if (city_list_selected == null || city_list_selected.size() == 0 || arg2 == 0)
                        return;
                    id = city_list_selected.get(arg2 - 1).getId();
                    selectCode = COUNTYCODE;
                    break;
                case R.id.county_spinner:

                    return;
            }
            if (id != null)
                improveCityPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(id), selectCode);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    };
    private Button btn_improved;
    private String id1;
    private String add_time;
    private String province;
    private String cat_id;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_improvedocumentation, null);
        tv_startTime = (TextView) inflate.findViewById(R.id.tv_startTime);
        tv_endTime = (TextView) inflate.findViewById(R.id.tv_endTime);
        iv_UploadBusinessLicense = (ImageView) inflate.findViewById(R.id.iv_UploadBusinessLicense);
        iv_Storefacade = (ImageView) inflate.findViewById(R.id.iv_Storefacade);
        pic_uploadBusinessLicense = (ImageView) inflate.findViewById(R.id.pic_UploadBusinessLicense);
        pic_Storefacade = (ImageView) inflate.findViewById(R.id.pic_Storefacade);
        edt_improve_name = (EditText) inflate.findViewById(R.id.edt_improve_name);
        edt_improve_companyname = (EditText) inflate.findViewById(R.id.edt_improve_companyname);
        edt_improve_mobile = (EditText) inflate.findViewById(R.id.edt_improve_mobile);
        edt_improve_address = (EditText) inflate.findViewById(R.id.edt_improve_address);
        edt_improve_catagory = (EditText) inflate.findViewById(R.id.edt_improve_catagory);
        btn_improved = (Button) inflate.findViewById(R.id.btn_improved);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("完善商家资料");
    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner();
        loadManagementClassificationSpinner();
        improveDocumentationPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_startTime.setOnClickListener(this);
        tv_endTime.setOnClickListener(this);
        iv_UploadBusinessLicense.setOnClickListener(this);
        iv_Storefacade.setOnClickListener(this);
        btn_improved.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_startTime:
                showTimePickerDialog(tv_startTime);
                break;
            case R.id.tv_endTime:
                showTimePickerDialog(tv_endTime);
                break;
            case R.id.iv_UploadBusinessLicense:
                showPW("1");
                break;
            case R.id.iv_Storefacade:
                showPW("2");
                break;
            case R.id.btn_improved:
                String shop_name = edt_improve_name.getText().toString().trim();
                String company_name = edt_improve_companyname.getText().toString().trim();
                String shop_tel = edt_improve_mobile.getText().toString().trim();
                String address = edt_improve_address.getText().toString().trim();
                String category = edt_improve_catagory.getText().toString().trim();
                String starttime = tv_startTime.getText().toString().trim();
                String endtime = tv_endTime.getText().toString().trim();
                String timetype = "MM:dd";
                List<String> spinerIds = getSpinerIds();
                if (file1 == null) {
                    ToastUtils.showToast("请上传营业执照");
                } else if (file1 == null) {
                    ToastUtils.showToast("请上传门店照");
                } else if (shop_name.equals("")) {
                    ToastUtils.showToast("请填写店铺名称");
                } else if (company_name.equals("")) {
                    ToastUtils.showToast("请填写店铺商号");
                } else if (shop_tel.equals("")) {
                    ToastUtils.showToast("请填写店铺联系电话");
                } else if (address.equals("")) {
                    ToastUtils.showToast("请填写店铺地址");
                } else if (category.equals("")) {
                    ToastUtils.showToast("请填写店铺主营业务");
                } else if (spinerIds.size() < 4) {
                    ToastUtils.showToast("没有选择完全");
                } else {
                    postData(MyApplication.TOKEN, Integer.parseInt(id1), file1, file2, shop_name, company_name, shop_tel, Integer.parseInt(spinerIds.get(0))
                            , Integer.parseInt(spinerIds.get(1)), Integer.parseInt(spinerIds.get(2)), address, Integer.parseInt(spinerIds.get(3)), category,
                            timetype, timetype, starttime, endtime, add_time, MyApplication.NICKNAME, MyApplication.MOBILE, Integer.parseInt(MyApplication.ID));
                }
                break;
        }
    }

    private void postData(final String token, final int id, final File file1, final File file2, final String shop_name, final String company_name,
                          final String shop_tel, final int province, final int city, final int district, final String address, final int cat_id, final String category,
                          final String start, final String end, final String starttime, final String endtime, final String add_time, final String name, final String mobile,
                          final int business_id) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("postData", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.postImproveCommit(token, id, file1, file2, shop_name, company_name, shop_tel, province, city, district, address, cat_id,
                        category, start, end, starttime, endtime, add_time, name, mobile, business_id);
            }
        });


    }

    private void showTimePickerDialog(final TextView tv) {
        mCalendar = Calendar.getInstance();

        TimePickerDialog dialog = new TimePickerDialog(ImproveDocumentationActivity.this, new TimePickerDialog.OnTimeSetListener() {

            int mHour;
            int mMinute;

            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                //更新EditText控件时间 小于10加0
                tv.setText(new StringBuilder()
                        .append(mHour < 10 ? "0" + mHour : mHour).append(":")
                        .append(mMinute < 10 ? "0" + mMinute : mMinute));
            }
        }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
        dialog.show();
    }

    private void showPW(String s) {
        a = s;
        menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
        menuWindow.showAtLocation(this.findViewById(R.id.iv_UploadBusinessLicense), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        menuWindow.setTitleName("选择图片来源");
        menuWindow.setMaleName("拍照或录像");
        menuWindow.setFemaleName("照片图库");
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String photo_path = null;
        switch (requestCode) {
            //选择照片
            case CHOOSE_PICTURE:
                if (data != null) {
                    imageUri = data.getData();
                    photo_path = ImageTools.uri2File(imageUri, this);
                }
                break;
            case CAMERA:
                photo_path = imageUri.getPath();
                break;
        }
        if (photo_path != null) {
            //图片处理\
            boolean equals = a.equals("1");
            Glide.with(this).load(photo_path).into(equals ? pic_uploadBusinessLicense : pic_Storefacade);

            if (equals) {
                file1 = new File(photo_path);
            } else {
                file2 = new File(photo_path);
            }
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
        }
    }

    /**
     * 经营分类spinner
     */
    private void loadManagementClassificationSpinner() {
        classification_spinner = (Spinner) findViewById(R.id.classification_spinner);
        classification_adapter = getSpinerAdapter(classification);
        select(classification_spinner, classification_adapter);
        classification_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification_spinner.setAdapter(classification_adapter);
    }

    private List<String> getSpinerIds() {
        ArrayList<String> strings = new ArrayList<>();
        int selectedItemPosition = province_spinner.getSelectedItemPosition();
        String id = improveDocumentationBeanclist.get(selectedItemPosition).getId();
        strings.add(id);
        int cityselectedItemPosition = city_spinner.getSelectedItemPosition();
        if (cityselectedItemPosition != 0) {
            String id2 = city_list_selected.get(cityselectedItemPosition - 1).getId();
            strings.add(id2);
        }
        int countyselectedItemPosition = county_spinner.getSelectedItemPosition();
        if (countyselectedItemPosition >0) {
            String id3 = county_list_selected.get(countyselectedItemPosition - 1).getId();
            strings.add(id3);
        }
        int classselectedItemPosition = classification_spinner.getSelectedItemPosition();
        String id4 = thems.get(classselectedItemPosition).getId();
        strings.add(id4);
        return strings;
    }

    private void loadSpinner() {
        province_spinner = (Spinner) findViewById(R.id.province_spinner);
        city_spinner = (Spinner) findViewById(R.id.city_spinner);
        county_spinner = (Spinner) findViewById(R.id.county_spinner);
        province_adapter = getSpinerAdapter(provincelist);
        city_adapter = getSpinerAdapter(citylist);
        county_adapter = getSpinerAdapter(countylist);
        select(province_spinner, province_adapter);
        select(county_spinner, county_adapter);
        select(city_spinner, city_adapter);

    }

    private void nothiChangAdapter(ArrayAdapter adapter) {
        adapter.notifyDataSetChanged();
    }

    private ArrayAdapter getSpinerAdapter(ArrayList<String> args) {
        return new ArrayAdapter<>(this, R.layout.simple_spinner_item1, args);
    }

    private ArrayAdapter getSpinerAdapter(String[] args) {
        return new ArrayAdapter<>(this, R.layout.simple_spinner_item1, args);
    }

    private void select(Spinner spin, ArrayAdapter<String> adapter) {
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(onItemSelectedListener);
    }

    /**
     * 接口回调
     *
     * @param improveDocumentationBean
     */
    @Override
    public void setData(ImproveDocumentationBean improveDocumentationBean) {
        ImproveDocumentationBean.InfoBean info = improveDocumentationBean.getInfo();
        if (info != null) {
            Glide.with(this).load(ReHttpUtils.getBaseUrl() + info.getPhoto()).into(pic_Storefacade);//店铺门店照
            Glide.with(this).load(ReHttpUtils.getBaseUrl() + info.getLicense()).into(pic_uploadBusinessLicense);//营业执照
            edt_improve_name.setText(info.getName());//店铺名称
            edt_improve_companyname.setText(info.getCompany_name());//店铺商号
            edt_improve_mobile.setText(info.getMobile());//电话
            edt_improve_address.setText(info.getAddress());//地址
            edt_improve_catagory.setText(info.getCategory());//商品分类
            id1 = info.getId();//id
            add_time = info.getAdd_time();
            //省ID
            province = info.getProvince();
            cityID = info.getCity();//市ID
            districtID = info.getDistrict();// 区ID
            cat_id = improveDocumentationBean.getInfo().getCat_id();
        }
        tv_startTime.setText("08:00");//开始时间
        tv_endTime.setText("20:00");//结束时间
        improveDocumentationBeanclist = improveDocumentationBean.getClist();//省级列表
        for (ImproveDocumentationBean.ClistBean clistBean : improveDocumentationBeanclist) {
            provincelist.add(clistBean.getName());
        }
        province_adapter.notifyDataSetChanged();
        for (int i = 0; i < improveDocumentationBeanclist.size(); i++) {
            if (improveDocumentationBeanclist.get(i).getId().equals(province)) {
                province_spinner.setSelection(i);
                break;
            }
        }
        thems = improveDocumentationBean.getThems();
        for (ImproveDocumentationBean.ThemsBean themsBean : thems) {
            String id = themsBean.getId();
            if (id.equals(cat_id)) {
                classification_spinner.setSelection(Integer.parseInt(cat_id));
            }
            classification.add(themsBean.getName());
        }
        classification_adapter.notifyDataSetChanged();
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }

    private void selectxxx() {

    }

    @Override
    public void setSelecteddata(ImproveCityBean improveCityBean, int code) {
        if (code == CITYCODE) {
            citylist.clear();
            citylist.add("请选择市");
            int k = 0;
            city_list_selected = improveCityBean.getRegion_list();
            for (int i = 0; i < city_list_selected.size(); i++) {
                ImproveCityBean.RegionListBean regionListBean = city_list_selected.get(i);
                citylist.add(regionListBean.getName());
                if (regionListBean.getId().equals(cityID) && isfrist == 1)
                    k = i + 1;
            }
            city_adapter.notifyDataSetChanged();
            city_spinner.setSelection(k);

        } else if (code == COUNTYCODE) {
            countylist.clear();
            countylist.add("请选择区");
            county_list_selected = improveCityBean.getRegion_list();
            int k = 0;
            for (int i = 0; i < county_list_selected.size(); i++) {
                ImproveCityBean.RegionListBean regionListBean = county_list_selected.get(i);
                countylist.add(regionListBean.getName());
                if (regionListBean.getId().equals(districtID) && isfrist == 1)
                    k = i + 1;
            }
            county_adapter.notifyDataSetChanged();
            county_spinner.setSelection(k);
        }
    }

    //上传图片
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_female:
                    //选择图片
                    Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(picture, CHOOSE_PICTURE);
                    break;
                case R.id.tv_male:
                    //选择拍照
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() / 1000 + "userLogo.jpg"));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CAMERA);
                    break;
            }
            menuWindow.dismiss();
        }
    }


}