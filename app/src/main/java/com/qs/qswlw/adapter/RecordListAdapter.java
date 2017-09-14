package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qs.qswlw.R;

import java.util.List;

/**
 * Created by xiaoyu on 2017/4/6.
 */

public class RecordListAdapter extends BaseListAdapter {


    public RecordListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(context, R.layout.item_recordlist, null);
        return inflate;
    }
}
