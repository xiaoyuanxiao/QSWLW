package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.MerchantAuditBean;
import com.qs.qswlw.bean.MerchantAuditClickBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IConsumptionRecordView;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditClickView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionRecordPresenter;
import com.qs.qswlw.okhttp.Presenter.MerchantAuditClickPersenter;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;

import rx.Observable;

import static com.qs.qswlw.R.id.spinner_consumptionrecord_pos;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class ConsumptionRecordActivity extends BaseInfoActivity implements IConsumptionRecordView, IMerchantAuditClickView {

    private ConsumptionRecordPresenter consumptionRecordPresenter = new ConsumptionRecordPresenter(this);
    private TextView consumptionrecord_bottom_one, consumptionrecord_bottom_two, consumptionrecord_bottom_three, consumptionrecord_bottom_four;
    private TextView edt_consumptionrecord_two;
    private RadioButton eb_one, eb_two;
    private View inflate;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> classification_adapter;
    private RadioGroup rg_dialog_consumption;
    private String strClassification;
    private Button btn_selectorfile1, btn_selectorfile2;
    private GenderPopupWindow menuWindow;
    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    private ImageView iv_consumption1, iv_consumption2;
    private String a;
    private Bitmap bitmap;
    private Uri imageUri;
    private TextView tv_isselect_consumptionrecord, tv_isselect_consumptionrecord2;
    private Button btn_sonsumption_confirm;
    private EditText edt_consumptionrecord_id, edt_consumptionrecord_nickname, edt_consumptionrecord_one, edt_consumptionrecord_three, edt_consumptionrecord_four, edt_consumptionrecord_five, edt_consumptionrecord_sex;
    private String ratio_key = "model2";
    private float ratio;
    private String get1;
    private String get2;
    private RelativeLayout rl_consumption;
    private MerchantAuditClickPersenter merchantAuditClickPersenter = new MerchantAuditClickPersenter(this);
    private int type;
    private String get;
    private String get3;
    private MerchantAuditBean.ListBean listBean;
    private String goods_id;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionrecord, null);
        consumptionrecord_bottom_one = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_one);
        consumptionrecord_bottom_two = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_two);
        edt_consumptionrecord_two = (TextView) inflate.findViewById(R.id.edt_consumptionrecord_two);
        spinner = (Spinner) inflate.findViewById(spinner_consumptionrecord_pos);
        btn_selectorfile1 = (Button) inflate.findViewById(R.id.btn_selectorfile1);
        btn_selectorfile2 = (Button) inflate.findViewById(R.id.btn_selectorfile2);
        iv_consumption1 = (ImageView) inflate.findViewById(R.id.iv_consumption1);
        iv_consumption2 = (ImageView) inflate.findViewById(R.id.iv_consumption2);
        tv_isselect_consumptionrecord = (TextView) inflate.findViewById(R.id.tv_isselect_consumptionrecord);
        tv_isselect_consumptionrecord2 = (TextView) inflate.findViewById(R.id.tv_isselect_consumptionrecord2);
        btn_sonsumption_confirm = (Button) inflate.findViewById(R.id.btn_sonsumption_confirm);
        edt_consumptionrecord_id = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_id);
        edt_consumptionrecord_nickname = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_nickname);
        edt_consumptionrecord_one = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_one);
        edt_consumptionrecord_three = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_three);
        edt_consumptionrecord_four = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_four);
        edt_consumptionrecord_five = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_five);
        edt_consumptionrecord_sex = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_sex);
        rl_consumption = (RelativeLayout) inflate.findViewById(R.id.rl_consumption);

        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        String merchantaudit = intent.getStringExtra("merchantaudit");
        listBean = (MerchantAuditBean.ListBean) intent.getSerializableExtra("listBean");
        if ("merchantaudit".equals(merchantaudit)) {
            merchantAuditClickPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(listBean.getId()));
        } else {
            consumptionRecordPresenter.getdata(MyApplication.TOKEN);
        }


        initSpinner();
    }

    private void initSpinner() {
        classification_adapter = ArrayAdapter.createFromResource(this, R.array.dialog_item, android.R.layout.simple_spinner_item);
        classification_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(classification_adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.getSelectedItemPosition();
                strClassification = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_selectorfile1.setOnClickListener(this);
        btn_selectorfile2.setOnClickListener(this);
        edt_consumptionrecord_two.setOnClickListener(this);
        btn_sonsumption_confirm.setOnClickListener(this);
//        eb_one.setOnClickListener(this);
//        eb_two.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edt_consumptionrecord_two:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final AlertDialog dialog = builder.create();
                View alertview = LayoutInflater.from(this).inflate(R.layout.dialog_consumption_percent, null);
                eb_one = (RadioButton) alertview.findViewById(R.id.eb_one);
                eb_two = (RadioButton) alertview.findViewById(R.id.eb_two);
                if (1==type) {
                    eb_one.setText(get3);
                    eb_two.setText(get);
                } else if (2==type) {
                    eb_one.setText(get2 + "%(发票)");
                    eb_two.setText(get1 + "%(B网)");
                }

                rg_dialog_consumption = (RadioGroup) alertview.findViewById(R.id.rg_dialog_consumption);

                rg_dialog_consumption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
                            case R.id.eb_one:
                                ratio_key = "model1";
                                if (1==type) {
                                    ratio = Float.parseFloat(get3);
                                }
                                if (2==type) {
                                    ratio = Float.parseFloat(get2);
                                }
                                dialog.dismiss();
                                edt_consumptionrecord_two.setText(ratio + "%(发票)");
                                break;
                            case R.id.eb_two:
                                ratio_key = "model2";
                                if (1==type) {
                                    ratio = Float.parseFloat(get);
                                }
                                if (2==type) {
                                    ratio = Float.parseFloat(get1);
                                }
                                dialog.dismiss();
                                edt_consumptionrecord_two.setText(ratio + "%(B网)");
                                break;
                        }
                    }
                });
                dialog.setView(alertview);
                dialog.show();
                break;
            case spinner_consumptionrecord_pos:
                break;
            case R.id.btn_selectorfile1:
                showPW("1");
                break;
            case R.id.btn_selectorfile2:
                showPW("2");
                break;
            case R.id.btn_sonsumption_confirm:
                if(1==type){//商家审核进入的
                    postMerchantAuditData();
                }else if(2==type){//消费录单进入的，为嘛写两个接口-_-
                    postData();
                }

                break;
        }
    }


    private String pay_name;
    private String pay_time;
    private String pay_type;
    private float none;
    private float money;
    private int uid;

    /**
     * 提交录单信息
     */
    private void postMerchantAuditData() {

        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {


            @Override
            public void onError(Throwable e) {
                ToastUtils.showToast(e+"");
                Log.e("TAG", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                 ToastUtils.showToast(mainBean.getMsg());
                Log.e("TAG", mainBean + "");
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {

                return retrofit.PostConsumptionData1(MyApplication.TOKEN, Integer.parseInt(listBean.getId()), Integer.parseInt(goods_id), uid, money, ratio, none, ratio_key, pay_type,pay_name,pay_time, Integer.parseInt(edt_consumptionrecord_four.getText().toString()) ,file1, file2);
            }
        });

    }
    /**
     * 提交录单信息
     */
    private void postData() {

        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {


            @Override
            public void onError(Throwable e) {
                Log.e("TAG", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {

                Log.e("TAG", mainBean + "");
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                uid = Integer.parseInt(edt_consumptionrecord_id.getText().toString());
                money = Float.parseFloat(edt_consumptionrecord_three.getText().toString());
                //   ratio = Float.parseFloat(edt_consumptionrecord_two.getText().toString());
                none = Float.parseFloat(edt_consumptionrecord_one.getText().toString());
                pay_type = strClassification;
                pay_time = edt_consumptionrecord_sex.getText().toString();
                //  long l = DateUtils.dateToStamp2();
                pay_name = edt_consumptionrecord_nickname.getText().toString();
                return retrofit.PostConsumptionData(MyApplication.TOKEN, uid, money, ratio, none, ratio_key, pay_type, pay_time, pay_name, file1, file2);
                //  return retrofit.PostConsumptionData(MyApplication.TOKEN,1,20,12,4,"4",pay_type,12345353,"a",file,file);
            }
        });

    }

    private void showPW(String s) {
        a = s;
        menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
        menuWindow.showAtLocation(this.findViewById(R.id.tv_isselect_consumptionrecord), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        menuWindow.setTitleName("选择图片来源");
        menuWindow.setMaleName("拍照或录像");
        menuWindow.setFemaleName("照片图库");
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
            Glide.with(this).load(photo_path).into(equals ? iv_consumption1 : iv_consumption2);
            if (equals) {
                file1 = new File(photo_path);
                iv_consumption1.setVisibility(View.VISIBLE);
            } else {
                file2 = new File(photo_path);
                iv_consumption2.setVisibility(View.VISIBLE);
            }
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
        }
    }

    private File file1;
    private File file2;

    @Override
    public void setConsumptionRecordData(MainBean<ConsumptionRecordBean> consumptionRecordBean) {
        type = 2;
        if (consumptionRecordBean.getSucc() != 1) {
            Intent intent = getIntent();
            String msg = consumptionRecordBean.getMsg();
            intent.putExtra("msg", msg);
            setResult(103, intent);
            finish();
        } else {
            ConsumptionRecordBean result = consumptionRecordBean.getResult();
            String content = result.getContent();
            String replace = content.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "”").replace("&amp;", "&");
            consumptionrecord_bottom_two.setText(Html.fromHtml(replace));
            edt_consumptionrecord_two.setText(result.getRebate_config().getModel2().getGet() + "%(发票)");
            get2 = result.getRebate_config().getModel2().getGet();
            get1 = result.getRebate_config().getModel1().getGet();
            ratio = Float.parseFloat(get2);
            eb_one.setText(get2 + "%(发票)");
            eb_two.setText(get1 + "%(B网)");
        }
    }

    @Override
    public void setData(MerchantAuditClickBean merchantAuditClickBean) {
        type = 1;
        MerchantAuditClickBean.OldListBean old_list = merchantAuditClickBean.getOld_list();
        MerchantAuditClickBean.UserInfoBean user_info = merchantAuditClickBean.getUser_info();
        MerchantAuditClickBean.ModelBean model = merchantAuditClickBean.getModel();
        MerchantAuditClickBean.ModelBean.Model1Bean model1 = merchantAuditClickBean.getModel().getModel1();
        MerchantAuditClickBean.ModelBean.Model2Bean model2 = merchantAuditClickBean.getModel().getModel2();
        goods_id = merchantAuditClickBean.getGoods_id();
        //模式
        get = model1.getGet();
        get3 = model2.getGet();
        edt_consumptionrecord_id.setText(old_list.getId());
        edt_consumptionrecord_nickname.setText(user_info.getNickname());
        edt_consumptionrecord_one.setText(old_list.getNone());  //让利金额
        edt_consumptionrecord_three.setText(old_list.getMoney());   //发票金额
        edt_consumptionrecord_two.setText(merchantAuditClickBean.getModel().getModel2().getGet() + "%(发票)");
        edt_consumptionrecord_four.setText(old_list.getGoods_num() + "");  //商品数量
        edt_consumptionrecord_five.setText(old_list.getPay_name());  //汇款人
        edt_consumptionrecord_sex.setText(old_list.getAdd_time());   //时间
        
    }

}
