package com.qs.qswlw.activity.PersonalCenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ConsumptionLimitAdapter;
import com.qs.qswlw.bean.ConsumptionLimitBean;
import com.qs.qswlw.okhttp.Iview.IConsumptionLimitView;
import com.qs.qswlw.okhttp.Presenter.ConsumptionLimitPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/25.
 */

public class ConsumptionLimitActivity extends BaseInfoActivity implements IConsumptionLimitView {

    SwipeRefreshView swipeRefreshView;
    int page = 1;
    private TextView tv_consumptionlimit_three,tv_consumptionlimit_tagold;
    private ListView lv_consumptionlimit;
    private ConsumptionLimitAdapter consumptionLimitAdapter;
    private List<ConsumptionLimitBean.ListBean> listBeen;
    private ConsumptionLimitPersenter consumptionLimitPersenter = new ConsumptionLimitPersenter(this);
    private LinearLayout ll_click;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_consumptionlimit, null);
        lv_consumptionlimit = (ListView) inflate.findViewById(R.id.lv_consumptionlimit);
        View inflate1 = View.inflate(this, R.layout.item_head_consumptionlimit, null);
        lv_consumptionlimit.addHeaderView(inflate1);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_consumptionlimit_sw);
        ll_click = (LinearLayout) inflate.findViewById(R.id.ll_click);
        tv_consumptionlimit_three = (TextView) inflate1.findViewById(R.id.tv_consumptionlimit_three);
        tv_consumptionlimit_tagold = (TextView) inflate1.findViewById(R.id.tv_consumptionlimit_tagold);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("消费金豆额度");
    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        consumptionLimitAdapter = new ConsumptionLimitAdapter(this,listBeen);
        lv_consumptionlimit.setAdapter(consumptionLimitAdapter);
        consumptionLimitPersenter.getdata(MyApplication.TOKEN,page);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                consumptionLimitPersenter.getdata(MyApplication.TOKEN,page);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_consumptionlimit_three.setOnClickListener(this);
        ll_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_consumptionlimit_three:
                showDidlog();
                break;
            case R.id.ll_click:
                Intent intent = new Intent(this, ConsumptionLimitRechargeActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showDidlog() {


         /*
         * 设置单选items
         * */
        final String[] items = {"类型","消费","充值"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);//内部使用构建者的设计模式

        builder.setSingleChoiceItems(items, -1,new DialogInterface.OnClickListener() {//第二个参数是设置默认选中哪一项-1代表默认都不选


            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv_consumptionlimit_three.setText(items[which]);
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
        builder.create().show();//创建对象
    }


    @Override
    public void setdata(ConsumptionLimitBean consumptionLimitBean) {
        List<ConsumptionLimitBean.ListBean> list = consumptionLimitBean.getList();
        ConsumptionLimitBean.ShopBean shop = consumptionLimitBean.getShop();
        swipeRefreshView.setLoading(false);
        tv_consumptionlimit_tagold.setText(shop.getTagold());
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        listBeen.addAll(list);
        consumptionLimitAdapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }
}
