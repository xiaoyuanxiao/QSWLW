package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.qs.qswlw.R;

import java.util.List;

/**
 * Created by xiaoyu on 2017/10/13.
 */

public class MyMallRightLVAdapter extends BaseListAdapter {

    private GridView gridview;

    public MyMallRightLVAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.fg_malldetailright_gv,null);
        gridview = (GridView) view.findViewById(R.id.gridview);
        gridview.setAdapter(new JoinPromotionLuckDrawAdapter(context));
        return view;
    }
}
