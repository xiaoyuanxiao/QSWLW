package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IConsumptionLimitRechargeView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionLimitRechargePresenter;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitRechargeActivity extends BaseInfoActivity implements IConsumptionLimitRechargeView {
    private ConsumptionLimitRechargePresenter consumptionLimitRechargePresenter = new ConsumptionLimitRechargePresenter(this);
    private ImageView iv_consumptionlimitrecharge_one, iv_consumptionlimitrecharge_two, iv_consumptionlimitrecharge_three;
    private Button btn_selectorfile;
    private GenderPopupWindow menuWindow;
    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    private Uri imageUri;
    private File file;
    private ImageView iv_consumption;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionlimitrecharge, null);
        iv_consumptionlimitrecharge_one = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_one);
        iv_consumptionlimitrecharge_two = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_two);
        iv_consumptionlimitrecharge_three = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_three);
        btn_selectorfile = (Button) inflate.findViewById(R.id.btn_selectorfile);
        iv_consumption = (ImageView) inflate.findViewById(R.id.iv_consumption);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("消费金豆额度充值");
    }

    @Override
    public void initData() {
        super.initData();
        consumptionLimitRechargePresenter.getdata(MyApplication.TOKEN, "taxgold");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_selectorfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_selectorfile:
                showPW();
                break;
        }
    }

    private void showPW() {
        menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
        menuWindow.showAtLocation(this.findViewById(R.id.btn_selectorfile), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
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
            iv_consumption.setVisibility(View.VISIBLE);
            Glide.with(this).load(photo_path).into(iv_consumption);
            file = new File(photo_path);
        } else {
            ToastUtils.showToast(this, "请重新选取图片！");
        }
    }


    @Override
    public void setdata(ConsumptionLimitRechargeBean consumptionLimitRechargeBean) {

        List<ConsumptionLimitRechargeBean.GoodsNumBean> goods_num = consumptionLimitRechargeBean.getGoods_num();
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(0).getOriginal_img()).into(iv_consumptionlimitrecharge_one);
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(1).getOriginal_img()).into(iv_consumptionlimitrecharge_two);
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(2).getOriginal_img()).into(iv_consumptionlimitrecharge_three);

    }
}
