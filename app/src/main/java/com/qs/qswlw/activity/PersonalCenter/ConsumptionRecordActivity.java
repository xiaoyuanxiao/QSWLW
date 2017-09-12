package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
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

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IConsumptionRecordView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionRecordPresenter;
import com.qs.qswlw.utils.DialogUtils;
import com.qs.qswlw.utils.FileUtil;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;

import rx.Observable;

import static com.qs.qswlw.R.id.spinner_consumptionrecord_pos;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class ConsumptionRecordActivity extends BaseInfoActivity implements IConsumptionRecordView {

    //   private static final String[] PLANETS = new String[]{"20%", "10%"};
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
        consumptionRecordPresenter.getdata(MyApplication.TOKEN);
        inflate = LayoutInflater.from(this).inflate(R.layout.dialog_consumption_percent, null);
        eb_one = (RadioButton) inflate.findViewById(R.id.eb_one);
        eb_two = (RadioButton) inflate.findViewById(R.id.eb_two);
        rg_dialog_consumption = (RadioGroup) inflate.findViewById(R.id.rg_dialog_consumption);
        rg_dialog_consumption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case 1:
                        ratio_key = "model1";
                        ratio = Float.parseFloat(get1);
                        break;
                    case 2:
                        ratio_key = "model2";
                        ratio = Float.parseFloat(get2);
                        break;
                }
            }
        });
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
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edt_consumptionrecord_two:

                DialogUtils.showDialog(this, inflate);


                /**
                 * ArrayAdapter<String> accountTypesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_type);
                 * accountTypesAdapter.setDropDownViewResource(R.layout.drop_down_item);
                 * spinner.setAdapter(accountTypesAdapter);
                 */
//                View outerView = LayoutInflater.from(this).inflate(R.layout.wheel_view, null);
//                WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
//                //  wv.setOffset(1);
//                wv.setItems(Arrays.asList(PLANETS));
//                wv.setSeletion(0);
//                wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//                    @Override
//                    public void onSelected(int selectedIndex, String item) {
//                        Log.d("tag", "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
//                    }
//                });
//                Dialog dialog = new Dialog(this);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(outerView);
//                //dialog.setPositiveButton("完成", null);
//                //获得当前窗体
//                Window window = dialog.getWindow();
//                //重新设置
//                WindowManager.LayoutParams lp = window.getAttributes();
//                window.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//                dialog.show();
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
                postData();
                break;
        }
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
                int uid = Integer.parseInt(edt_consumptionrecord_id.getText().toString());
                float money = Float.parseFloat(edt_consumptionrecord_three.getText().toString());
             //   ratio = Float.parseFloat(edt_consumptionrecord_two.getText().toString());
                float none = Float.parseFloat(edt_consumptionrecord_one.getText().toString());
                String pay_type = strClassification;
                String pay_time = edt_consumptionrecord_sex.getText().toString();
                //  long l = DateUtils.dateToStamp2();
                String pay_name = edt_consumptionrecord_nickname.getText().toString();
                return retrofit.PostConsumptionData(MyApplication.TOKEN, uid, money, ratio, none, ratio_key, pay_type, pay_time, pay_name, file, file);
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
                    Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "userLogo.jpg"));
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
        if (data != null) {
            switch (requestCode) {
                //选择照片
                case CHOOSE_PICTURE:
                    String photo_path = null;
                    if (isKitKat && DocumentsContract.isDocumentUri(this, data.getData())) {
                        String wholeID = DocumentsContract.getDocumentId(data.getData());
                        String id = wholeID.split(":")[1];
                        String[] column = {MediaStore.Images.Media.DATA};
                        String sel = MediaStore.Images.Media._ID + "=?";
                        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, column,
                                sel, new String[]{id}, null);
                        int columnIndex = cursor.getColumnIndex(column[0]);
                        if (cursor.moveToFirst()) {
                            photo_path = cursor.getString(columnIndex);
                        }
                        cursor.close();
                    } else {
                        String[] projection = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(data.getData(), projection, null, null, null);
                        try {
                            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            cursor.moveToFirst();
                            photo_path = cursor.getString(column_index);
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.showToast(this, "选取的图片异常！");
                        }
                    }
                    if (photo_path != null) {
                        //上传图片到服务器
                        new Thread(new ConsumptionRecordActivity.SaveThread(photo_path)).start();
                    } else {
                        ToastUtils.showToast(this, "请重新选取图片！");
                    }
                    break;
            }
        }
        switch (requestCode) {
            case CAMERA:
                File f = new File(Environment.getExternalStorageDirectory(), "userLogo.jpg");
                String path = f.getPath();
                new Thread(new ConsumptionRecordActivity.SaveThread(path)).start();
                break;

        }
    }

    private File file;

    //上传图片
    private class SaveThread implements Runnable {
        private String path;


        public SaveThread(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            //获取选中图片的路径
            if (TextUtils.isEmpty(path)) {
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true; // 先获取原大小
            Bitmap scanBitmap = BitmapFactory.decodeFile(path, options);
            options.inJustDecodeBounds = false; // 获取新的大小
            int sampleSize = (int) (options.outHeight / (float) 200);
            if (sampleSize <= 0)
                sampleSize = 1;
            options.inSampleSize = sampleSize;
            scanBitmap = BitmapFactory.decodeFile(path, options);
            try {
                scanBitmap.getByteCount();
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtils.showToast(ConsumptionRecordActivity.this, "图片处理异常！");
            }
            if (scanBitmap != null) {//如果图片存在的话
                try {
                    bitmap = scanBitmap;
                    imageUri = Uri.fromFile(FileUtil.saveBitmap(scanBitmap));
                    file = new File(ImageTools.uri2File(imageUri, ConsumptionRecordActivity.this));
                    Message message = handler.obtainMessage();
                    if ("1".equals(a)) {
                        message.what = 1;
                    } else if ("2".equals(a)) {
                        message.what = 2;
                    }

                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    iv_consumption1.setVisibility(View.VISIBLE);
                    iv_consumption1.setImageBitmap(bitmap);
                    break;
                case 2:
                    iv_consumption2.setVisibility(View.VISIBLE);
                    iv_consumption2.setImageBitmap(bitmap);
                    break;
            }
        }

    };

    @Override
    public void setConsumptionRecordData(MainBean<ConsumptionRecordBean> consumptionRecordBean) {
        if(consumptionRecordBean.getSucc()!=1){
            Intent intent = getIntent();
            String msg = consumptionRecordBean.getMsg();
            intent.putExtra("msg",msg);
            setResult(103,intent);
            finish();
        }else{
            ConsumptionRecordBean result = consumptionRecordBean.getResult();
        String content = result.getContent();
        String replace = content.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "”").replace("&amp;", "&");
        consumptionrecord_bottom_two.setText(Html.fromHtml(replace));
        edt_consumptionrecord_two.setText(result.getRebate_config().getModel2().getGet() + "(发票)");
        get2 = result.getRebate_config().getModel2().getGet();
        get1 = result.getRebate_config().getModel1().getGet();
        eb_one.setText( get2 + "%(发票)");
        eb_two.setText(get1 + "%(B网)");
        }


    }


}
