package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qs.qswlw.R;

import java.util.Hashtable;

import static com.qs.qswlw.R.id.iv_QRCode;


/**
 * Created by xiaoyu on 2017/4/3.
 */

public class RecommendActivity extends BaseInfoActivity implements View.OnLongClickListener {

    private ImageView iv_qrCode;
    private PopupWindow popupWindow;
    private TextView tv_recommend_name,tv_recommend_id;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.recommend_activity, null);
        iv_qrCode = (ImageView) inflate.findViewById(iv_QRCode);
        tv_recommend_name = (TextView) inflate.findViewById(R.id.tv_recommend_name);
        tv_recommend_id = (TextView) inflate.findViewById(R.id.tv_recommend_id);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("推荐注册");
        tv_titlebar_right.setText("推荐记录");
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        tv_recommend_name.setText(intent.getStringExtra("nickname"));
        tv_recommend_id.setText(intent.getStringExtra("userid"));

        try {
            Bitmap codeBitmap =   createQRCodeBitmap(intent.getStringExtra("userid"));
            iv_qrCode.setImageBitmap(codeBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成QR图
    private Bitmap createQRCodeBitmap(String text) {
        int QR_WIDTH = 400, QR_HEIGHT = 400;
        try {
            // 需要引入core包
            QRCodeWriter writer = new QRCodeWriter();

            Log.i("TAG", "生成的文本：" + text);
            if (text == null || "".equals(text) || text.length() < 1) {
                return null;
            }

            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //比特矩阵
            BitMatrix bitMatrix = new QRCodeWriter().encode(text,
                    BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            //比特矩阵转颜色数组
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;//黑点
                    } else {
                        pixels[y * QR_WIDTH + x] = 0x00ffffff;//透明点,白点为0xffffffff
                    }

                }
            }

            //解析颜色数组,其他的java平台可以选择其他的API
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
                    Bitmap.Config.ARGB_8888);

            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return bitmap;

        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
        iv_qrCode.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,RecommendedRecordsActivity.class));

                break;

        }
    }

    @Override
    public boolean onLongClick(View view) {
        showpw(iv_qrCode);
        return false;
    }
    private void showpw(ImageView v) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pw_recommend, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
         TextView tv_recommendpw_distinguish = (TextView) layout.findViewById(R.id.tv_recommendpw_distinguish);

        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
        tv_recommendpw_distinguish.setOnClickListener(this);

    }
}
