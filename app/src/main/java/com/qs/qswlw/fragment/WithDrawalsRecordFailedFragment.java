package com.qs.qswlw.fragment;

import android.view.View;

import com.qs.qswlw.R;
import com.qs.qswlw.bean.WithDrawalsRecordBean;
import com.qs.qswlw.okhttp.Iview.IWithDrawalsRecordView;

/**
 * Created by xiaoyu on 2017/9/20.
 */

public class WithDrawalsRecordFailedFragment extends BaseFragment implements IWithDrawalsRecordView {
    public static WithDrawalsRecordFailedFragment newInstance() {
        return  new WithDrawalsRecordFailedFragment();
    }
    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.fg_withdrawalsrecord, null);
        return inflate;
    }

    @Override
    protected void setOnclick() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void setdata(WithDrawalsRecordBean withDrawalsRecordBean) {

    }

    @Override
    public void isgetDataFaile(String meg) {

    }
}
