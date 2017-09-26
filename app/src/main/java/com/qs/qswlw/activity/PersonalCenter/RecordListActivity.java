package com.qs.qswlw.activity.PersonalCenter;

import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.RecordListAdapter;
import com.qs.qswlw.bean.RecordListBean;
import com.qs.qswlw.okhttp.Iview.IRecordListView;
import com.qs.qswlw.okhttp.Presenter.RecordListPresenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class RecordListActivity extends BaseInfoActivity implements IRecordListView {


    int page = 1;
    SwipeRefreshView swipeRefreshView;
    String tv_recordlist_Text;
    private RelativeLayout rl_recordlist_left, rl_recordlist_right;
    private TextView tv_recordlist_left, tv_recordlist_right;
    private RecordListPresenter recordListPresenter = new RecordListPresenter(this);
    private ListView lv_recordlist;
    private String type="model2";
    private String is_go="0";
    private RecordListAdapter recordListAdapter;
    private  List<RecordListBean> recordListBeanList;
//    /**
//     *  上拉监听
//     */
//    private IXListViewLoadMore mLoadMoreListener = new IXListViewLoadMore() {
//        @Override
//        public void onLoadMore() {
//            Toast.makeText(RecordListActivity.this, "上拉", Toast.LENGTH_SHORT).show();
//            page++;
//            recordListPresenter.getDataRefresh(MyApplication.TOKEN,page,type,is_go);
//        }
//    };

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recordlist, null);
        rl_recordlist_left = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_left);
        rl_recordlist_right = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_right);
        tv_recordlist_left = (TextView) inflate.findViewById(R.id.tv_recordlist_left);
        tv_recordlist_right = (TextView) inflate.findViewById(R.id.tv_recordlist_right);
        lv_recordlist = (ListView) inflate.findViewById(R.id.lv_recordlist);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_recordlist_sw);
//        //上拉监听
//        lv_recordlist.setPullLoadEnable(mLoadMoreListener);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        recordListBeanList = new ArrayList<>();
        recordListAdapter = new RecordListAdapter(RecordListActivity.this,recordListBeanList);
        lv_recordlist.setAdapter(recordListAdapter);
        recordListPresenter.getData(MyApplication.TOKEN,page,type,is_go);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                recordListPresenter.getDataRefresh(MyApplication.TOKEN,page,type,is_go);
            }
        });
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("录单记录");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        //点击radioButton切换到指定页面
        rl_recordlist_left.setOnClickListener(this);
        rl_recordlist_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_recordlist_left:
                showDialog("1");
                break;
            case R.id.rl_recordlist_right:
                showDialog("2");
                break;
        }
    }

    void showDialog(final String a) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View alertview = LayoutInflater.from(RecordListActivity.this).inflate(R.layout.dialog_recordlist, null);
        final RadioButton rb_recordlist_one = (RadioButton) alertview.findViewById(R.id.rb_recordlist_one);
        final RadioButton rb_recordlist_two = (RadioButton) alertview.findViewById(R.id.rb_recordlist_two);
        final Button btn_recordlist_confirm = (Button) alertview.findViewById(R.id.btn_recordlist_confirm);
        final Button btn_recordlist_cancel = (Button) alertview.findViewById(R.id.btn_recordlist_cancel);
        final RadioGroup rg_recordlist_dialog = (RadioGroup) alertview.findViewById(R.id.rg_recordlist_dialog);
        if ("1".equals(a)) {
            rb_recordlist_one.setText("创业模式");
            rb_recordlist_two.setText("创新模式");
            //   tv_recordlist_left.setText();
        } else if ("2".equals(a)) {
            rb_recordlist_one.setText("未审核");
            rb_recordlist_two.setText("已审核");
        }
        rg_recordlist_dialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.rb_recordlist_one:
                        tv_recordlist_Text = rb_recordlist_one.getText().toString();
                        break;
                    case R.id.rb_recordlist_two:
                        tv_recordlist_Text = rb_recordlist_two.getText().toString();
                        break;
                }
            }
        });
        btn_recordlist_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if ("1".equals(a)) {
                    tv_recordlist_left.setText(tv_recordlist_Text);
                    if(tv_recordlist_left.getText().toString().equals("创业模式")){
                        type = "model1";
                    }else if(tv_recordlist_left.getText().toString().equals("创新模式")){
                        type = "model2";
                    }
                } else if ("2".equals(a)) {
                    tv_recordlist_right.setText(tv_recordlist_Text);
                    if(tv_recordlist_right.getText().toString().equals("未审核")){
                        is_go = "0";
                    }else if(tv_recordlist_right.getText().toString().equals("已审核")){
                        is_go = "1";
                    }
                }

                recordListPresenter.getData(MyApplication.TOKEN,page,type,is_go);
            }
        });
        btn_recordlist_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setView(alertview);
        dialog.show();
    }


    @Override
    public void setRecordList(List<RecordListBean> list) {
        recordListBeanList.clear();
        if (list!=null) {
            recordListBeanList.addAll(list);
        }
        recordListAdapter.notifyDataSetChanged();
    }
    @Override
    public void setRecordListRefresh(List<RecordListBean> list) {
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            ToastUtils.showToast("没有更多数据了");
            return;
        }
        recordListBeanList.addAll(list);
        recordListAdapter.notifyDataSetChanged();
        page++;
    }
}
