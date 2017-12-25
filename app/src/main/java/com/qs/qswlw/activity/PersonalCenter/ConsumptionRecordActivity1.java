package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
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
import com.qs.qswlw.bean.UserIDSearchBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IConsumptionRecordView;
import com.qs.qswlw.okhttp.Iview.IMerchantAuditClickView;
import com.qs.qswlw.okhttp.Iview.IUserIDSearchView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionRecordPresenter;
import com.qs.qswlw.okhttp.Presenter.MerchantAuditClickPersenter;
import com.qs.qswlw.okhttp.Presenter.UserIDSearchPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import rx.Observable;

import static com.qs.qswlw.R.id.spinner_consumptionrecord_pos;

/**
 * Created by xiaoyu on 2017/12/25.
 */

public class ConsumptionRecordActivity1 extends BaseInfoActivity implements IConsumptionRecordView, IMerchantAuditClickView, IUserIDSearchView {

    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    int model1 = 15;
    double model2 = 62.5;
    double model3 = 15;
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
    private ImageView iv_consumption1, iv_consumption2;
    private String aaa;
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
    private String[] items;
    private String pay_name;
    private String pay_time;
    private String pay_type;
    private float none;
    private float money;
    private int uid;
    private File file1;
    private String none1;
    private float money1;
    //  private File file2;
    private UserIDSearchPersenter userIDSearchPersenter = new UserIDSearchPersenter(this);
    private String id;
    private TextView edt_consumptionrecord_cyzz, edt_consumptionrecord_yd;
    private int cyzz;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionrecord1, null);
        consumptionrecord_bottom_one = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_one);
        consumptionrecord_bottom_two = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_two);
        edt_consumptionrecord_two = (TextView) inflate.findViewById(R.id.edt_consumptionrecord_two);
        spinner = (Spinner) inflate.findViewById(spinner_consumptionrecord_pos);
        btn_selectorfile1 = (Button) inflate.findViewById(R.id.btn_selectorfile1);
        //   btn_selectorfile2 = (Button) inflate.findViewById(R.id.btn_selectorfile2);
        iv_consumption1 = (ImageView) inflate.findViewById(R.id.iv_consumption1);
        //  iv_consumption2 = (ImageView) inflate.findViewById(R.id.iv_consumption2);
        tv_isselect_consumptionrecord = (TextView) inflate.findViewById(R.id.tv_isselect_consumptionrecord);
        //    tv_isselect_consumptionrecord2 = (TextView) inflate.findViewById(R.id.tv_isselect_consumptionrecord2);
        btn_sonsumption_confirm = (Button) inflate.findViewById(R.id.btn_sonsumption_confirm);
        edt_consumptionrecord_id = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_id);
        edt_consumptionrecord_nickname = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_nickname);
        edt_consumptionrecord_one = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_one);
        edt_consumptionrecord_three = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_three);
        //    edt_consumptionrecord_four = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_four);
        edt_consumptionrecord_five = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_five);
        edt_consumptionrecord_sex = (EditText) inflate.findViewById(R.id.edt_consumptionrecord_sex);
        rl_consumption = (RelativeLayout) inflate.findViewById(R.id.rl_consumption);
        edt_consumptionrecord_cyzz = (TextView) inflate.findViewById(R.id.edt_consumptionrecord_cyzz);
        edt_consumptionrecord_yd = (TextView) inflate.findViewById(R.id.edt_consumptionrecord_yd);

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

        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd");
        Date curDate =  new Date(System.currentTimeMillis());
        //获取当前时间
        edt_consumptionrecord_sex.setText(formatter.format(curDate));
        initSpinner();
    }

    private void initSpinner() {
        classification_adapter = ArrayAdapter.createFromResource(this, R.array.dialog_item, R.layout.simple_spinner_item1);
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
        //    btn_selectorfile2.setOnClickListener(this);
        edt_consumptionrecord_two.setOnClickListener(this);
        btn_sonsumption_confirm.setOnClickListener(this);
        edt_consumptionrecord_three.setFocusable(false);
        edt_consumptionrecord_nickname.setFocusable(false);
        edt_consumptionrecord_three.setOnClickListener(this);
        edt_consumptionrecord_nickname.setOnClickListener(this);
//        eb_one.setOnClickListener(this);
//        eb_two.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edt_consumptionrecord_two:
                items = new String[]{model1 + "%(发票)", model2 + "%(B网)"};
                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);//内部使用构建者的设计模式
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                ratio_key = "model1";
                                model3 = model1;
                                dialog.dismiss();
                                edt_consumptionrecord_two.setText(model3 + "%(发票)");
                                break;
                            case 1:
                                ratio_key = "model2";
                                model3 = model2;
                                dialog.dismiss();
                                edt_consumptionrecord_two.setText(model3 + "%(B网)");
                                break;
                        }
                        dialog.dismiss();
                    }
                });
                builder.create().setCanceledOnTouchOutside(true);
                builder.setCancelable(true);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
                builder.create().show();//创建对象
//                if (1 == type) {
//                    items = new String[]{get3, get};
//                } else if (2 == type) {
//                    items = new String[]{get2 + "%(发票)", get1 + "%(B网)"};
//                }
//                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);//内部使用构建者的设计模式
//                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which) {
//                            case 0:
//                                ratio_key = "model1";
//                                if (1 == type) {
//                                    ratio = Float.parseFloat(get3);
//                                }
//                                if (2 == type) {
//                                    ratio = Float.parseFloat(get2);
//                                }
//                                dialog.dismiss();
//                                edt_consumptionrecord_two.setText(ratio + "%(发票)");
//                                break;
//                            case 1:
//                                ratio_key = "model2";
//                                if (1 == type) {
//                                    ratio = Float.parseFloat(get);
//                                }
//                                if (2 == type) {
//                                    ratio = Float.parseFloat(get1);
//                                }
//                                dialog.dismiss();
//                                edt_consumptionrecord_two.setText(ratio + "%(B网)");
//                                break;
//                        }
//                        dialog.dismiss();
//                    }
//                });
//                builder.create().setCanceledOnTouchOutside(true);
//                builder.setCancelable(true);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
//                builder.create().show();//创建对象

                break;
            case spinner_consumptionrecord_pos:
                break;
            case R.id.btn_selectorfile1:
                showPW("1");
                break;
            case R.id.edt_consumptionrecord_nickname:
                id = edt_consumptionrecord_id.getText().toString().trim();
                if (id.equals("")) {
                    ToastUtils.showToast("消费者ID不能为空");
                }
                userIDSearchPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(id), Integer.parseInt(MyApplication.ID));
                break;

            case R.id.edt_consumptionrecord_three:
                none1 = edt_consumptionrecord_one.getText().toString();
                money1 = (float) (Float.parseFloat(none1) / model3 * 100);
                edt_consumptionrecord_three.setText(money1 + "");
                edt_consumptionrecord_cyzz.setText("");
                if (Integer.parseInt(MyApplication.ROLE) == 0) {
                    cyzz = (int) money1;
                    if (cyzz < 500) {
                        edt_consumptionrecord_yd.setText(cyzz + "");
                        edt_consumptionrecord_cyzz.setText("0");
                    } else {
                        edt_consumptionrecord_yd.setText(cyzz % 500);
                        edt_consumptionrecord_cyzz.setText(cyzz / 500);
                    }

                } else if (Integer.parseInt(MyApplication.ROLE) > 0) {
                    cyzz = Integer.parseInt(none1);
                    if (cyzz < 500) {
                        edt_consumptionrecord_yd.setText(cyzz + "");
                        edt_consumptionrecord_cyzz.setText("0");
                    } else {
                        edt_consumptionrecord_yd.setText(cyzz % 500);
                        edt_consumptionrecord_cyzz.setText(cyzz / 500);
                    }

                }
                break;
//            case R.id.btn_selectorfile2:
//                showPW("2");
//                break;
            case R.id.btn_sonsumption_confirm:
                if (1 == type) {//商家审核进入的
                    //  postMerchantAuditData();
                } else if (2 == type) {//消费录单进入的
                    //    String money = edt_consumptionrecord_three.getText().toString();
                    //让利金额

                    //   ratio = Float.parseFloat(edt_consumptionrecord_two.getText().toString());
                    pay_type = strClassification;
                    pay_time = edt_consumptionrecord_sex.getText().toString().trim();
                    //  long l = DateUtils.dateToStamp2();
                    pay_name = edt_consumptionrecord_five.getText().toString();
                    if (none1.equals("")) {
                        ToastUtils.showToast("金额不能为空");
                    } else if (pay_name.equals("")) {
                        ToastUtils.showToast("汇款人不能为空");
                    } else if (pay_time.equals("")) {
                        ToastUtils.showToast("支付时间不能为空");
                    } else {

                        postData(MyApplication.TOKEN, Integer.parseInt(id), money1, ratio, Float.parseFloat(none1), ratio_key, pay_type, pay_time, pay_name, file1);
                    }
                }

                break;
        }
    }

//    /**
//     * 提交录单信息
//     */
//    private void postMerchantAuditData() {
//
//        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {
//
//
//            @Override
//            public void onError(Throwable e) {
//                ToastUtils.showToast(e + "");
//                Log.e("TAG", e + "");
//            }
//
//            @Override
//            public void onNext(MainBean mainBean) {
//                ToastUtils.showToast(mainBean.getMsg());
//                Log.e("TAG", mainBean + "");
//            }
//
//            @Override
//            public Observable<MainBean> getObservable(MyRetroService retrofit) {
//
//                return retrofit.PostConsumptionData1(MyApplication.TOKEN, Integer.parseInt(listBean.getId()), Integer.parseInt(goods_id), uid, money, ratio, none, ratio_key, pay_type, pay_name, pay_time, Integer.parseInt(edt_consumptionrecord_four.getText().toString()), file1);
//            }
//        });
//
//    }

    /**
     * 提交录单信息
     */
    private void postData(String token, final int uid, final float money, final float ratio, final float none, final String ratio_key, final String pay_type, final String pay_time,
                          final String pay_name, File remittance) {

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
                return retrofit.PostConsumptionData(MyApplication.TOKEN, uid, money, ratio, none, ratio_key, pay_type, pay_time, pay_name, file1);
                //  return retrofit.PostConsumptionData(MyApplication.TOKEN,1,20,12,4,"4",pay_type,12345353,"a",file,file);
            }
        });

    }

    private void showPW(String s) {
        aaa = s;
        menuWindow = new GenderPopupWindow(this, new ConsumptionRecordActivity1.MyOnClickListener());
        menuWindow.showAtLocation(this.findViewById(R.id.tv_isselect_consumptionrecord), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
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
            boolean equals = aaa.equals("1");
            Glide.with(this).load(photo_path).into(equals ? iv_consumption1 : iv_consumption2);
            if (equals) {
                file1 = new File(photo_path);
                iv_consumption1.setVisibility(View.VISIBLE);
            } else {
//                file2 = new File(photo_path);
//                iv_consumption2.setVisibility(View.VISIBLE);
            }
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
        }
    }

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
        // edt_consumptionrecord_four.setText(old_list.getGoods_num() + "");  //商品数量
        edt_consumptionrecord_five.setText(old_list.getPay_name());  //汇款人
        edt_consumptionrecord_sex.setText(old_list.getAdd_time());   //时间

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }

    @Override
    public void setdata(UserIDSearchBean userIDSearchBean) {
        edt_consumptionrecord_nickname.setText(userIDSearchBean.getData());
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
