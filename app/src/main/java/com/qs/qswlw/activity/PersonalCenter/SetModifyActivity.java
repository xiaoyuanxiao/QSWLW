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
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.utils.FileUtil;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;

/**
 * Created by xiaoyu on 2017/4/20.
 */

public class SetModifyActivity extends BaseInfoActivity {

    private RelativeLayout rl_set_avater;
    private GenderPopupWindow menuWindow;
    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    private Bitmap bitmap;
    private Uri imageUri;
    private ImageView iv_set_avater;
    private RelativeLayout rl_userName;
    private TextView tv_userName;
    private Intent intent;
    private String name;
    private Button btn_retrievePassword;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_setmodify, null);
        rl_set_avater = (RelativeLayout) inflate.findViewById(R.id.rl_set_avater);
        iv_set_avater = (ImageView) inflate.findViewById(R.id.iv_set_avater);
        rl_userName = (RelativeLayout) inflate.findViewById(R.id.rl_userName);
        tv_userName = (TextView) inflate.findViewById(R.id.tv_userName);
        btn_retrievePassword = (Button) inflate.findViewById(R.id.btn_retrievePassword);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("个人资料");
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        rl_set_avater.setOnClickListener(this);
        rl_userName.setOnClickListener(this);
        btn_retrievePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.rl_set_avater:
                //修改头像
                menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
                menuWindow.showAtLocation(this.findViewById(R.id.edit_info), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                menuWindow.setTitleName("选择图片来源");
                menuWindow.setFemaleName("相册");
                menuWindow.setMaleName("拍照");
                break;
            case R.id.rl_userName:
                intent = new Intent(this, ChangeUserNameActivity.class);
                intent.putExtra("userName", tv_userName.getText().toString());
                startActivityForResult(intent, 200);
                break;
            case R.id.btn_retrievePassword:
                intent = new Intent(this,RetrievePasswordActivity.class);
                startActivity(intent);
                break;
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
                        try{
                            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                            cursor.moveToFirst();
                            photo_path = cursor.getString(column_index);
                        }catch (Exception e){
                            e.printStackTrace();
                            ToastUtils.showToast(this,"选取的图片异常！");
                        }
                    }
                    if (photo_path!=null){
                        //上传图片到服务器
                        new Thread(new SaveThread(photo_path)).start();
                    }else {
                        ToastUtils.showToast(this,"请重新选取图片！");
                    }
                    break;
                case 200:
                    name = data.getStringExtra("back");
                    tv_userName.setText(name);
                    break;
            }
        }
        switch (requestCode) {
            case CAMERA:
                File f = new File(Environment.getExternalStorageDirectory(), "userLogo.jpg");
                String path = f.getPath();
                new Thread(new SaveThread(path)).start();
                break;

        }
    }

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
            try{
                scanBitmap.getByteCount();
            }catch (Exception e){
                e.printStackTrace();
                ToastUtils.showToast(SetModifyActivity.this,"图片处理异常！");
            }
            if (scanBitmap != null) {//如果图片存在的话
                try {
                    bitmap = scanBitmap;
                    imageUri = Uri.fromFile(FileUtil.saveBitmap(scanBitmap));
                    File file = new File(ImageTools.uri2File(imageUri,SetModifyActivity.this));
                    Message message = handler.obtainMessage();
                    message.what = 1;
                    handler.sendMessage(message);

//                    Map<String, Object> map = new HashMap<>();
//                    // map.put("userId", ServerApi.USER_ID);
//                    map.put("userId", ServerApi.USER_ID);
//                    String data = GsonUtils.toJson(map);
//                    String sign = dataDealWith(data);
//                    String fileName = "";
//                        fileName = "userAvatar";
//                    } else if (ServerApi.USER_TYPE.equals("1")) {
//                        fileName = "staffAvatar";
//                    }
//                    String url = "";
//                    if (ServerApi.USER_TYPE.equals("0")) {
//                        url = ServerApi.returnUrl(ServerApi.Api.CUSTOMER_USER_AVATER, new GETParams().put("data", data).put("partner", Constant.PARTNER).put("sign", sign));
//                    } else if (ServerApi.USER_TYPE.equals("1")) {
//                        url = ServerApi.returnUrl(ServerApi.Api.CUSTOMER_CUSTOMER_AVATER, new GETParams().put("data", data).put("partner", Constant.PARTNER).put("sign", sign));
//                    }
//                    BitmapFactory.Options opt = new BitmapFactory.Options();
//                    opt.inJustDecodeBounds = true;
//                    BitmapFactory.decodeFile(file.getAbsolutePath(), opt);
//                    mNetworkRequester.multipartRequest(new MultipartJsonRequest(url, fileName, file,
//                            new NetworkRequester.ResponseListener() {
//                                @Override
//                                public void onSuccessful(JSONObject json) {
//                                    user_picture_set.setImageBitmap(bitmap);//上传成功更改ImageV上的图片
//                                    ToastUtils.showToast(CustomerInformationActivity.this, json.optString("message"));
//                                }
//
//                                @Override
//                                public void onFailed(String msg) {
//                                    ToastUtils.showToast(CustomerInformationActivity.this, msg);
//                                }
//                            }));
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
                    iv_set_avater.setImageBitmap(bitmap);
                    break;
            }
        }

    };
}
