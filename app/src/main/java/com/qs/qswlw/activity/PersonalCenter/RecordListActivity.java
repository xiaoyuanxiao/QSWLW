package com.qs.qswlw.activity.PersonalCenter;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;
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
    private String type = "model2";
    private String is_go = "0";
    private RecordListAdapter recordListAdapter;
    private List<RecordListBean> recordListBeanList;
    private String[] items;
    private String item;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recordlist, null);
        rl_recordlist_left = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_left);
        rl_recordlist_right = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_right);
        tv_recordlist_left = (TextView) inflate.findViewById(R.id.tv_recordlist_left);
        tv_recordlist_right = (TextView) inflate.findViewById(R.id.tv_recordlist_right);
        lv_recordlist = (ListView) inflate.findViewById(R.id.lv_recordlist);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_recordlist_sw);
        return inflate;
    }

    @Override
    public void initData() {
        super.initData();
        recordListBeanList = new ArrayList<>();
        recordListAdapter = new RecordListAdapter(RecordListActivity.this, recordListBeanList);
        lv_recordlist.setAdapter(recordListAdapter);
        recordListPresenter.getData(MyApplication.TOKEN, page, type, is_go);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                recordListPresenter.getDataRefresh(MyApplication.TOKEN, page, type, is_go);
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
         /*
         * 设置单选items
         * */
        if ("1".equals(a)) {
            items = new String[]{"创业模式", "创新模式"};
        } else if ("2".equals(a)) {
            items = new String[]{"未审核", "已审核"};
        }

        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);//内部使用构建者的设计模式
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if ("1".equals(a)) {
                    tv_recordlist_left.setText(item);
                    if (item.equals("创业模式")) {
                        type = "model1";
                    } else if (item.equals("创新模式")) {
                        type = "model2";
                    }
                } else if ("2".equals(a)) {
                    tv_recordlist_right.setText(item);
                    if (item.equals("未审核")) {
                        is_go = "0";
                    } else if (item.equals("已审核")) {
                        is_go = "1";
                    }
                }
                page = 1;
                recordListPresenter.getData(MyApplication.TOKEN, page, type, is_go);

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                item = items[which];
            }
        });
        builder.create().setCanceledOnTouchOutside(true);
        builder.setCancelable(true);//设置dialog只能通过点击Dialog上的按钮退出，不能通过回退按钮退出关闭Dialog
        builder.create().show();//创建对象

    }

    @Override
    public void setRecordList(List<RecordListBean> list) {
        swipeRefreshView.setLoading(false);
        recordListBeanList.clear();
        if (list != null) {
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

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }
}
