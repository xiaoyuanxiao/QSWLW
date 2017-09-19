package com.qs.qswlw.activity.PersonalCenter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.WithdrawalsRecordAdapter;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.okhttp.Iview.IWithDrawalsRecordView;
import com.qs.qswlw.okhttp.Presenter.WithDrawalsRecordPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoyu on 2017/4/19.
 */

public class WithdrawalsRecordActivity extends BaseInfoActivity implements IWithDrawalsRecordView{

    private TextView tv_one,tv_two,tv_three,tv_four;
    private View view_one,view_two,view_three,view_four;
    private ListView lv_withdrawalsrecord;
    private PopupWindow popupWindow;
    private WithDrawalsRecordPersenter withDrawalsRecordPersenter = new WithDrawalsRecordPersenter(this);
    int page = 1;
    String status = "";
    private WithdrawalsRecordAdapter withdrawalsRecordAdapter;
    private List<WithDrawalsRecordBean.ListBean> listBeen;
    SwipeRefreshView swipeRefreshView;
    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawalsrecord, null);
        tv_one = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_one);
        tv_two = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_two);
        tv_three = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_three);
        tv_four = (TextView) inflate.findViewById(R.id.tv_withdrawalsrecord_four);
        view_one = (View) inflate.findViewById(R.id.view_withdrawalsrecord_one);
        view_two = (View) inflate.findViewById(R.id.view_withdrawalsrecord_two);
        view_three = (View) inflate.findViewById(R.id.view_withdrawalsrecord_three);
        view_four = (View) inflate.findViewById(R.id.view_withdrawalsrecord_four);
        lv_withdrawalsrecord = (ListView) inflate.findViewById(R.id.lv_withdrawalsrecord);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_withdrawalsrecord_sw);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("提现记录");
        tv_titlebar_right.setText("筛选");
        iv_titlebar_right.setVisibility(View.VISIBLE);
        iv_titlebar_right.setImageResource(R.mipmap.left);

    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        withdrawalsRecordAdapter = new WithdrawalsRecordAdapter(this,listBeen);
        lv_withdrawalsrecord.setAdapter(withdrawalsRecordAdapter);
        withDrawalsRecordPersenter.getdata(MyApplication.TOKEN,page,status);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {

                withDrawalsRecordPersenter.getdataRefresh(MyApplication.TOKEN,page,status);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        tv_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_withdrawalsrecord_one:
                setTopColor(tv_one,tv_two,tv_three,tv_four, view_one,view_two,view_three,view_four);
                status = "audit";
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN,page,status);
                break;
            case R.id.tv_withdrawalsrecord_two:
                setTopColor(tv_two,tv_one,tv_three,tv_four, view_two,view_one,view_three,view_four);
                status = "pre";
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN,page,status);
                break;
            case R.id.tv_withdrawalsrecord_three:
                setTopColor(tv_three,tv_two,tv_one,tv_four, view_three,view_two,view_one,view_four);
                status = "";
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN,page,status);
                break;
            case R.id.tv_withdrawalsrecord_four:
                setTopColor(tv_four,tv_two,tv_three,tv_one, view_four,view_two,view_three,view_one);
                status = "fail";
                withDrawalsRecordPersenter.getdata(MyApplication.TOKEN,page,status);
                break;
            case R.id.ll_titlebar_right:
                showpw(ll_titlebar_right);
                break;
        }
    }




    private void setTopColor(TextView tv1, TextView tv2, TextView tv3,TextView tv4, View view1, View view2, View view3, View view4) {
        tv1.setTextColor(getResources().getColor(R.color.red));
        tv2.setTextColor(getResources().getColor(R.color.text_blue));
        tv3.setTextColor(getResources().getColor(R.color.text_blue));
        tv4.setTextColor(getResources().getColor(R.color.text_blue));
        view1.setBackgroundColor(getResources().getColor(R.color.red));
        view2.setBackgroundColor(getResources().getColor(R.color.view));
        view3.setBackgroundColor(getResources().getColor(R.color.view));
        view4.setBackgroundColor(getResources().getColor(R.color.view));
    }


    private void showpw(LinearLayout v) {
        //加载布局
        LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.pw_withdrawals, null);
        // 实例化popupWindow
        popupWindow = new PopupWindow(layout, 150, LinearLayout.LayoutParams.WRAP_CONTENT);
        //控制键盘是否可以获得焦点
        popupWindow.setFocusable(true);
        //设置popupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //xoff,yoff基于anchor的左下角进行偏移。
        popupWindow.showAtLocation(v, Gravity.RIGHT|Gravity.TOP,0,100);

    }

    /**
     * 切换提现状态的回调
     * @param withDrawalsRecordBean
     */
    @Override
    public void setdata(WithDrawalsRecordBean withDrawalsRecordBean) {
        List<WithDrawalsRecordBean.ListBean> list = withDrawalsRecordBean.getList();
        swipeRefreshView.setLoading(false);//需要吗，没有刷新的时候
        listBeen.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        listBeen.addAll(list);
        withdrawalsRecordAdapter.notifyDataSetChanged();
        page++;
    }

    /**
     * 上拉刷新时的回调
     * @param withDrawalsRecordBean
     */
    @Override
    public void setdataRefresh(WithDrawalsRecordBean withDrawalsRecordBean) {
        List<WithDrawalsRecordBean.ListBean> list = withDrawalsRecordBean.getList();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        listBeen.addAll(list);
        withdrawalsRecordAdapter.notifyDataSetChanged();
        page++;

    }

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }
}
