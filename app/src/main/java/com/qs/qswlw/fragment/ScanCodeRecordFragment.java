package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.ScanCodeRecordAdapter;
import com.qs.qswlw.bean.ScanCodeRecordBean;
import com.qs.qswlw.okhttp.Iview.IScanCodeRecordView;
import com.qs.qswlw.okhttp.Presenter.ScanCodeRecordPersenter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class ScanCodeRecordFragment extends BaseFragment implements IScanCodeRecordView{
    public static int ISOK=1;
    public static int NOOK=0;
    SwipeRefreshView swipeRefreshView;
    private int type = 0;
    private ListView lv_scancoderecord;
    private List<ScanCodeRecordBean.ListBean> listBeen;
    private ScanCodeRecordAdapter scanCodeRecordAdapter;
    private ScanCodeRecordPersenter scanCodeRecordPersenter = new ScanCodeRecordPersenter(this);
    private int page = 1;

    public static ScanCodeRecordFragment newInstance(int type) {//等下
        ScanCodeRecordFragment scanCodeRecordFragment = new ScanCodeRecordFragment();
        scanCodeRecordFragment.setType(type);
        return scanCodeRecordFragment;
    }
    private void setType(int type) {
        this.type = type;
    }


    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_scancoderecord, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_scancoderecord_sw);
        lv_scancoderecord = (ListView) inflate.findViewById(R.id.lv_scancoderecord);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBeen = new ArrayList<>();
        scanCodeRecordAdapter = new ScanCodeRecordAdapter(getActivity(),listBeen);
        lv_scancoderecord.setAdapter(scanCodeRecordAdapter);
        scanCodeRecordPersenter.getdata(MyApplication.TOKEN,page,type);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                scanCodeRecordPersenter.getdata(MyApplication.TOKEN,page,type);
            }
        });
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setData(ScanCodeRecordBean scanCodeRecordBean) {
        List<ScanCodeRecordBean.ListBean> list = scanCodeRecordBean.getList();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            return;
        }
        if (page == 1)
            listBeen.clear();
        listBeen.addAll(list);
        scanCodeRecordAdapter.notifyDataSetChanged();
        page++;
    }
}
