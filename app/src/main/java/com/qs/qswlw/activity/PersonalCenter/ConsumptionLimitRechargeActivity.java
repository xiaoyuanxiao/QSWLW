package com.qs.qswlw.activity.PersonalCenter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionLimitRechargeBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IConsumptionLimitRechargeView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionLimitRechargePresenter;
import com.qs.qswlw.utils.ImageTools;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.GenderPopupWindow;

import java.io.File;
import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitRechargeActivity extends BaseInfoActivity implements IConsumptionLimitRechargeView {
    private ConsumptionLimitRechargePresenter consumptionLimitRechargePresenter = new ConsumptionLimitRechargePresenter(this);
    private ImageView iv_consumptionlimitrecharge_one, iv_consumptionlimitrecharge_two, iv_consumptionlimitrecharge_three;
    private Button btn_selectorfile,btn_confirm;
    private GenderPopupWindow menuWindow;
    private static final int CAMERA = 2003;
    private static final int CHOOSE_PICTURE = 2004;
    private Uri imageUri;
    private File file;
    private ImageView iv_consumption;
    private TextView tv_consumptionlimitrecharge_style;
    private EditText edt_consumptionlimitrecharge_one,edt_consumptionlimitrecharge_two;
    private String recharge_type;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionlimitrecharge, null);
        iv_consumptionlimitrecharge_one = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_one);
        iv_consumptionlimitrecharge_two = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_two);
        iv_consumptionlimitrecharge_three = (ImageView) inflate.findViewById(R.id.iv_consumptionlimitrecharge_three);
        btn_selectorfile = (Button) inflate.findViewById(R.id.btn_selectorfile);
        btn_confirm = (Button) inflate.findViewById(R.id.btn_onsumptionlimitrecharge_confirm);
        iv_consumption = (ImageView) inflate.findViewById(R.id.iv_consumption);
        tv_consumptionlimitrecharge_style = (TextView) inflate.findViewById(R.id.tv_consumptionlimitrecharge_style);
        edt_consumptionlimitrecharge_one = (EditText) inflate.findViewById(R.id.edt_consumptionlimitrecharge_one);
        edt_consumptionlimitrecharge_two = (EditText) inflate.findViewById(R.id.edt_consumptionlimitrecharge_two);
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
        btn_confirm.setOnClickListener(this);
        tv_consumptionlimitrecharge_style.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_selectorfile:
                showPW();
                break;
            case R.id.btn_onsumptionlimitrecharge_confirm:
                String ratio = tv_consumptionlimitrecharge_style.getText().toString();
                String none = edt_consumptionlimitrecharge_one.getText().toString();
                String money = edt_consumptionlimitrecharge_two.getText().toString();
                postData(MyApplication.TOKEN,ratio,none,money,recharge_type,file);
                break;
            case R.id.tv_consumptionlimitrecharge_style:
                showDialog();
                break;
        }
    }

    private void showDialog() {
         /*
         * 设置单选items
         * */
        final String[] items = {"汇入招行","汇入其他银行","刷POS机"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);//内部使用构建者的设计模式

        builder.setSingleChoiceItems(items, -1,new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选


            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv_consumptionlimitrecharge_style.setText(items[which]);
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
        builder.create().show();//创建对象
    }

    private void postData(final String token, final String ratio, final String none, final String money, final String recharge_type, final File remittance) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(MainBean mainBean) {
                ToastUtils.showToast(mainBean.getMsg());

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostConsumptionLimitRecharge(token,ratio,none,money,recharge_type,remittance);
            }
        });

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
        recharge_type = consumptionLimitRechargeBean.getRecharge_type();
        List<ConsumptionLimitRechargeBean.GoodsNumBean> goods_num = consumptionLimitRechargeBean.getGoods_num();
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(0).getOriginal_img()).into(iv_consumptionlimitrecharge_one);
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(1).getOriginal_img()).into(iv_consumptionlimitrecharge_two);
        Glide.with(this).load(ReHttpUtils.getBaseUrl() + goods_num.get(2).getOriginal_img()).into(iv_consumptionlimitrecharge_three);

    }
}
