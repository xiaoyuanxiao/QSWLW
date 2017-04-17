package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/17.
 */

public class ChinaPraiseRateAdapter extends BaseAdapter {
    private String[] a = {"138.00","139.00","140.00","141.00","142.00","143.00","144.00"};
    private Context context;

    public ChinaPraiseRateAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public Object getItem(int i) {
        return a[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(context, R.layout.item_chinagoodproduct, null);
        return inflate;
    }
}
