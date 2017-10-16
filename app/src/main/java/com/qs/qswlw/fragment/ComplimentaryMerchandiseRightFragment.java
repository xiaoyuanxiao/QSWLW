package com.qs.qswlw.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.AddProductActivity;
import com.qs.qswlw.adapter.ComplimentaryMerchandiseRecordAdapter;
import com.qs.qswlw.bean.ComplimentaryMerchandiseRecordBean;
import com.qs.qswlw.okhttp.Iview.IComplimentaryMerchandiseRecordView;
import com.qs.qswlw.okhttp.Presenter.ComplimentaryMerchandiseRecordPresenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/9/28.
 */

public class ComplimentaryMerchandiseRightFragment extends BaseFragment implements IComplimentaryMerchandiseRecordView{

    ComplimentaryMerchandiseRecordPresenter complimentaryMerchandiseRecordPresenter = new ComplimentaryMerchandiseRecordPresenter(this);
    int page = 1;
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_complimentarymerchandiseright;
    private List<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> listBean;
    private ComplimentaryMerchandiseRecordAdapter adapter;
    private TextView tv_add;

    public static ComplimentaryMerchandiseRightFragment newInstance() {
        ComplimentaryMerchandiseRightFragment fragment = new ComplimentaryMerchandiseRightFragment();
        return fragment;
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_complimentarymerchandiseright, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_complimentarymerchandiseright_sw);
        lv_complimentarymerchandiseright = (ListView) inflate.findViewById(R.id.lv_complimentarymerchandiseright);
        tv_add = (TextView) inflate.findViewById(R.id.tv_add);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        listBean = new ArrayList<>();
        adapter = new ComplimentaryMerchandiseRecordAdapter(getActivity(),listBean);
        lv_complimentarymerchandiseright.setAdapter(adapter);
        complimentaryMerchandiseRecordPresenter.getdata(MyApplication.TOKEN,page,0);
        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                complimentaryMerchandiseRecordPresenter.getdata(MyApplication.TOKEN,page,0);
            }
        });
    }

    @Override
    protected void setOnclick() {
        tv_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_add:
                startActivity(new Intent(getActivity(), AddProductActivity.class));
                break;
        }
    }

    @Override
    public void setdata(ComplimentaryMerchandiseRecordBean complimentaryMerchandiseRecordBean) {
        List<ComplimentaryMerchandiseRecordBean.GoodsInfoBean> list = complimentaryMerchandiseRecordBean.getGoodsInfo();
        swipeRefreshView.setLoading(false);
        if (list == null || list.size() == 0) {
            swipeRefreshView.setLoadingEnd();
            return;
        }
        listBean.addAll(list);
        adapter.notifyDataSetChanged();
        page++;
    }

    @Override
    public void isgetDataFaile(String meg) {
        swipeRefreshView.setLoading(false);
    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(getActivity());
    }
}
