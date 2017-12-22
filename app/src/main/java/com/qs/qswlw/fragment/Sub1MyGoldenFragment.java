package com.qs.qswlw.fragment;

import com.qs.qswlw.ItemMyGoldenFGData;
import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/12/22.
 */

public class Sub1MyGoldenFragment extends BaseDataBindingFragment {

    private ItemMyGoldenFGData bind;

    @Override
    protected int initview() {
        return R.layout.item_mygolden;
    }

    @Override
    protected void initdatabinding() {
        bind = getBind();

    }

    @Override
    protected void initData() {

    }
}
