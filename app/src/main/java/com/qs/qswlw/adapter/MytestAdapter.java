package com.qs.qswlw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 小猴子 on 2017/4/9.
 */

public class MytestAdapter extends BaseListAdapter<String> {
    public MytestAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String s = data.get(position);

        return null;


    }
}
