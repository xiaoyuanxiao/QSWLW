package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.ListView;

import com.qs.qswlw.R;
import com.qs.qswlw.view.SwipeRefreshView;

/**
 * Created by xiaoyu on 2017/10/11.
 */

public class MerchantSalesReviewTwoFragment extends BaseFragment {
    private SwipeRefreshView swipeRefreshView;
    private ListView lv_sw;
    public static MerchantSalesReviewTwoFragment newInstance() {
        return  new MerchantSalesReviewTwoFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_sw_lv, null);
        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.sw);
        lv_sw = (ListView) inflate.findViewById(R.id.lv_sw);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }
}
