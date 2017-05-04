package com.qs.qswlw.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/28.
 */

public class CommodityDetailsWareFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_fg_ware;
    private TextView tv_minus, tv_add;
    private EditText edt_num;
    private int number = 0;
    private ImageView iv_top;
    private ScrollView scrollview;
    private ViewPager viewpager_slideview;
    public static CommodityDetailsWareFragment newInstance() {
        CommodityDetailsWareFragment fragment = new CommodityDetailsWareFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.fg_commoditydetailsware, null);
        viewpager_slideview = (ViewPager) inflate.findViewById(R.id.viewpager_slideview);
        tv_minus = (TextView) inflate.findViewById(R.id.tv_minus);
        tv_add = (TextView) inflate.findViewById(R.id.tv_add);
        edt_num = (EditText) inflate.findViewById(R.id.edt_num);
        tv_fg_ware = (TextView) inflate.findViewById(R.id.tv_fg_ware);
        iv_top = (ImageView) inflate.findViewById(R.id.iv_top);
        scrollview = (ScrollView) inflate.findViewById(R.id.scrollview);
        String str = edt_num.getText().toString();
        number = Integer.valueOf(str);
        //默认不弹出软键盘
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        tv_minus.setOnClickListener(this);
        tv_add.setOnClickListener(this);
        iv_top.setOnClickListener(this);


        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2) {//更改对话框中的数量
                edt_num.setText(String.valueOf(number));
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_minus:
                if (number > 1) {
                    number--;
                    handler.sendEmptyMessage(2);
                }
                break;
            case R.id.tv_add:
                number++;
                handler.sendEmptyMessage(2);
                break;
            case R.id.iv_top:
                scrollview.post(new Runnable() {

                    @Override
                    public void run() {
                        scrollview.post(new Runnable() {
                            public void run() {
                                // 滚动至顶部
                                scrollview.fullScroll(ScrollView.FOCUS_UP);
                            }
                        });
                    }
                });
                break;
        }
    }
}
