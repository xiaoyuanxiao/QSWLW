package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.LoginActivity;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.SetModifyBean;
import com.qs.qswlw.manager.UserManage;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.ISetModifyView;
import com.qs.qswlw.okhttp.Presenter.SetModifyPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/20.
 */

public class SetModifyActivity extends BaseInfoActivity implements ISetModifyView {

    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    private RelativeLayout rl_set_avater;
    private GenderPopupWindow menuWindow;
    private Bitmap bitmap;
    private Uri imageUri;
    private ImageView iv_set_avater;
    private RelativeLayout rl_userName;
    private Intent intent;
    private String name;
    private SetModifyPersenter setModifyPersenter = new SetModifyPersenter(this);
    private TextView tv_setmodify_id, tv_setmodify_userName, tv_setmodify_phone;
    private File file;
    private Button btn_setpassword, btn_settwopassword, btn_retrievePassword;
    private AlertDialog dialog;
    private int type;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_setmodify, null);
        rl_set_avater = (RelativeLayout) inflate.findViewById(R.id.rl_set_avater);
        iv_set_avater = (ImageView) inflate.findViewById(R.id.iv_set_avater);
        rl_userName = (RelativeLayout) inflate.findViewById(R.id.rl_userName);
        btn_retrievePassword = (Button) inflate.findViewById(R.id.btn_retrievePassword);
        tv_setmodify_id = (TextView) inflate.findViewById(R.id.tv_setmodify_id);
        tv_setmodify_userName = (TextView) inflate.findViewById(R.id.tv_setmodify_userName);
        tv_setmodify_phone = (TextView) inflate.findViewById(R.id.tv_setmodify_phone);
        btn_setpassword = (Button) inflate.findViewById(R.id.btn_setpassword);
        btn_settwopassword = (Button) inflate.findViewById(R.id.btn_settwopassword);
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
        setModifyPersenter.getdata(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID));
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        rl_set_avater.setOnClickListener(this);
        rl_userName.setOnClickListener(this);
        btn_retrievePassword.setOnClickListener(this);
        btn_setpassword.setOnClickListener(this);
        btn_settwopassword.setOnClickListener(this);
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
                intent.putExtra("userName", tv_setmodify_userName.getText().toString());
                startActivityForResult(intent, 200);
                break;
            case R.id.btn_retrievePassword:
                intent = new Intent(this, RetrievePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_setpassword:
                showDilog(0);
                break;
            case R.id.btn_settwopassword:
                showDilog(1);
                break;
        }

    }

    private void showDilog(final int type) {
        this.type = type;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        dialog = builder.create();
        View alertview = LayoutInflater.from(SetModifyActivity.this).inflate(R.layout.dialog_modifypassword, null);
        TextView tv_modifypassword_close = (TextView) alertview.findViewById(R.id.tv_modifypassword_close);
        final EditText edt_modifypassword_old = (EditText) alertview.findViewById(R.id.edt_modifypassword_old);
        final EditText edt_modifypassword_new = (EditText) alertview.findViewById(R.id.edt_modifypassword_new);
        final EditText edt_modifypassword_confirmnew = (EditText) alertview.findViewById(R.id.edt_modifypassword_confirmnew);
        Button btn_modifypassword_cancel = (Button) alertview.findViewById(R.id.btn_modifypassword_cancel);
        Button btn_modifypassword_confirm = (Button) alertview.findViewById(R.id.btn_modifypassword_confirm);
        btn_modifypassword_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        tv_modifypassword_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_modifypassword_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newpassword = edt_modifypassword_new.getText().toString();
                String newpassword2 = edt_modifypassword_confirmnew.getText().toString();
                String oldpassword = edt_modifypassword_old.getText().toString();
                if(oldpassword.equals("")||newpassword.equals("")||newpassword2.equals("")){
                    ToastUtils.showToast("密码不能为空");
                }if(!newpassword.equals(newpassword2)){
                    ToastUtils.showToast("两次密码不一致，请重新输入");
                }else{
                    postData(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),oldpassword,newpassword,newpassword2,type);
                }

            }
        });
        dialog.setView(alertview);
        dialog.show();

        Window dialogWindow = dialog.getWindow();
        WindowManager m = this.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height = p.width; // 高度设置为屏幕的0.6，根据实际情况调整
        dialogWindow.setAttributes(p);

    }

    /**
     * 修改密码设置
     * @param token
     * @param user_id
     * @param pass
     * @param password
     * @param repassword
     */
    private void postData(final String token, final int user_id, final String pass, final String password, final String repassword, final int type) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("ThrowableModify",e+"");
            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
                if(mainBean.getStatus()==1&type==0){
                    dialog.dismiss();
                    UserManage.getInstance().clearUserInfo(SetModifyActivity.this);
                    startActivity(new Intent(SetModifyActivity.this, LoginActivity.class));
                    ActivityManagerUtils.getInstance().finishActivityclass(SetModifyActivity.class);
                    ActivityManagerUtils.getInstance().finishActivityclass(BusinessSettingActivity.class);
                }else if(mainBean.getStatus()==1&type==1){
                    dialog.dismiss();
                }

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.getPasswordData(token,user_id,pass,password,repassword,type);
            }
        });

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
            //图片处理,上传头像
            //  Glide.with(this).load(photo_path).into(iv_set_avater);
            file = new File(photo_path);
            postAvater(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID), file);
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
        }
    }

    private void postAvater(final String token, final int user_id, final File images) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("postAvater", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.getUserAvaterData(token, user_id, images);
            }
        });


    }

    @Override
    public void setData(SetModifyBean setModifyBean) {
        tv_setmodify_id.setText(setModifyBean.getUser_id());
        tv_setmodify_userName.setText(setModifyBean.getNickname());
        tv_setmodify_phone.setText(setModifyBean.getMobile());

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
