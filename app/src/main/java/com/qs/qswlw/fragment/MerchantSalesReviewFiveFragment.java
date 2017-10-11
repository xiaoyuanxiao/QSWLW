package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.view.SwipeRefreshView;

/**
 * Created by xiaoyu on 2017/10/11.
 */

public class MerchantSalesReviewFiveFragment extends BaseFragment {
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_sw;

    public static MerchantSalesReviewFiveFragment newInstance() {
        return  new MerchantSalesReviewFiveFragment();
    }



    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_sw_lv, null);
        View inflate1 = View.inflate(getActivity(), R.layout.item_head_add, null);
        lv_sw = (ListView) inflate.findViewById(R.id.lv_sw);
        lv_sw.addHeaderView(inflate1);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
