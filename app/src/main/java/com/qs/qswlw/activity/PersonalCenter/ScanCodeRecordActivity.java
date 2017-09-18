package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ScanCodeRecordAdapter;
import com.qs.qswlw.bean.ScanCodeRecordBean;
import com.qs.qswlw.okhttp.Iview.IScanCodeRecordView;
import com.qs.qswlw.okhttp.Presenter.ScanCodeRecordPersenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/18.
 */

public class ScanCodeRecordActivity extends BaseInfoActivity implements IScanCodeRecordView {
    SwipeRefreshView swipeRefreshView;
    private ListView lv_scancoderecord;
    private List<ScanCodeRecordBean.ListBean> listBeen;
    private ScanCodeRecordAdapter scanCodeRecordAdapter;
    private ScanCodeRecordPersenter scanCodeRecordPersenter = new ScanCodeRecordPersenter(this);
    private int page = 1;
    private int is_ok = 0;
    private TextView tv_scancoderecord_left,tv_scancoderecord_right;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_scancoderecord, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_scancoderecord_sw);
        lv_scancoderecord = (ListView) inflate.findViewById(R.id.lv_scancoderecord);
        tv_scancoderecord_left = (TextView) inflate.findViewById(R.id.tv_scancoderecord_left);
        tv_scancoderecord_right = (TextView) inflate.findViewById(R.id.tv_scancoderecord_right);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("扫码录单详情");
    }

    @Override
    public void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        scanCodeRecordAdapter = new ScanCodeRecordAdapter(this,listBeen);
        lv_scancoderecord.setAdapter(scanCodeRecordAdapter);
        scanCodeRecordPersenter.getdata(MyApplication.TOKEN,page,is_ok);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                scanCodeRecordPersenter.getdataRefresh(MyApplication.TOKEN,page,is_ok);
            }
        });
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_scancoderecord_left.setOnClickListener(this);
        tv_scancoderecord_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_scancoderecord_left:
                setTopColor(tv_scancoderecord_left,tv_scancoderecord_right);
                is_ok = 1;
                scanCodeRecordPersenter.getdata(MyApplication.TOKEN,page,is_ok);
                break;
            case R.id.tv_scancoderecord_right:
                setTopColor(tv_scancoderecord_right,tv_scancoderecord_left);
                is_ok = 0;
                scanCodeRecordPersenter.getdata(MyApplication.TOKEN,page,is_ok);
                break;
        }
    }
    private void setTopColor(TextView tv,TextView tv1){
        tv.setTextColor(this.getResources().getColor(R.color.white));
        tv.setBackgroundColor(this.getResources().getColor(R.color.red));
        tv1.setTextColor(this.getResources().getColor(R.color.red));
        tv1.setBackgroundColor(this.getResources().getColor(R.color.white));
    }
    @Override
    public void setData(ScanCodeRecordBean scanCodeRecordBean) {
        List<ScanCodeRecordBean.ListBean> list = scanCodeRecordBean.getList();
        listBeen.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        listBeen.addAll(list);
        scanCodeRecordAdapter.notifyDataSetChanged();


    }

    @Override
    public void setDataRefresh(ScanCodeRecordBean scanCodeRecordBean) {
        List<ScanCodeRecordBean.ListBean> list = scanCodeRecordBean.getList();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        listBeen.addAll(list);
        scanCodeRecordAdapter.notifyDataSetChanged();

        page++;
    }
}
