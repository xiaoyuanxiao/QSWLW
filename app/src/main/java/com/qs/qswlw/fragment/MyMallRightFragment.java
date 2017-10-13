package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.MyMallRightLVAdapter;
import com.qs.qswlw.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyu on 2017/10/13.
 */

public class MyMallRightFragment extends BaseFragment {
    SwipeRefreshView swipeRefreshView;
    private ListView lv_malldetailright;


    public static MyMallRightFragment newInstance(){
        return new MyMallRightFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_malldetailright, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.lv_malldetailright_sw);
        lv_malldetailright = (ListView) inflate.findViewById(R.id.lv_malldetailright);
        return inflate;
    }

    @Override
    protected void initData() {
        super.initData();
        final List<Bean> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(new Bean());
        }
        final MyMallRightLVAdapter adapter = new MyMallRightLVAdapter(getActivity(), list);
        lv_malldetailright.setAdapter(adapter);

    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

    public static class Bean {
        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
