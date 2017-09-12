package com.qs.qswlw.activity.PersonalCenter;

import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.ConsumptionRecordBean;
import com.qs.qswlw.okhttp.Iview.IConsumptionRecordView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionRecordPresenter;
import com.qs.qswlw.view.GenderPopupWindow;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class ConsumptionRecordActivity extends BaseInfoActivity implements IConsumptionRecordView {

    private TextView edt_twentypercent;
    private Button btn_selectorfile;
 //   private static final String[] PLANETS = new String[]{"20%", "10%"};
   private GenderPopupWindow menuWindow;
    private ConsumptionRecordPresenter consumptionRecordPresenter = new ConsumptionRecordPresenter(this);
    private TextView consumptionrecord_bottom_one,consumptionrecord_bottom_two,consumptionrecord_bottom_three,consumptionrecord_bottom_four;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionrecord, null);
        consumptionrecord_bottom_one = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_one);
        consumptionrecord_bottom_two = (TextView) inflate.findViewById(R.id.consumptionrecord_bottom_two);
        edt_twentypercent = (TextView) inflate.findViewById(R.id.edt_twentypercent_consumptionrecord);
        btn_selectorfile = (Button) inflate.findViewById(R.id.btn_selectorfile);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        consumptionRecordPresenter.getdata(MyApplication.TOKEN);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        edt_twentypercent.setOnClickListener(this);
        btn_selectorfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.edt_twentypercent_consumptionrecord:
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
            case R.id.btn_selectorfile:
                menuWindow = new GenderPopupWindow(this, new MyOnClickListener());
                menuWindow.showAtLocation(this.findViewById(R.id.tv_isselect_consumptionrecord), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                menuWindow.setTitleName("选择文件");
                menuWindow.setFemaleName("拍照或录像");
                menuWindow.setMaleName("照片图库");
                break;
        }
    }


    @Override
    public void setConsumptionRecordData(ConsumptionRecordBean consumptionRecordBean) {
        String content = consumptionRecordBean.getContent();
        String replace = content.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;","”").replace("&amp;", "&");
        consumptionrecord_bottom_two.setText(Html.fromHtml(replace));
    }


    //上传音频文件
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_female:
                    //  pickPhoto();
                    break;
                case R.id.tv_male:
                    //takePhoto();
                    break;
            }
            menuWindow.dismiss();
        }

    }

}
