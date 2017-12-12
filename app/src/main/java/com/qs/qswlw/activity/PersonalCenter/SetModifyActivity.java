package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.R;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;

/**
 * Created by xiaoyu on 2017/4/20.
 */

public class SetModifyActivity extends BaseInfoActivity {

    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    private RelativeLayout rl_set_avater;
    private GenderPopupWindow menuWindow;
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
        switch (v.getId()) {
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
                intent = new Intent(this, RetrievePasswordActivity.class);
                startActivity(intent);
                break;
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
            //图片处理
            Glide.with(this).load(photo_path).into(iv_set_avater);
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
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
