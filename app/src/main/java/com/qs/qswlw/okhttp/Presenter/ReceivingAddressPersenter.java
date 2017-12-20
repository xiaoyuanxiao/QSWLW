package com.qs.qswlw.okhttp.Presenter;

import com.qs.qswlw.bean.ReceivingAddressBean;
import com.qs.qswlw.okhttp.Factory.IBizFactory;
import com.qs.qswlw.okhttp.Iview.IReceivingAddressView;
import com.qs.qswlw.okhttp.Moudle.IReceivingAddressBiz;
import com.qs.qswlw.okhttp.oncallback.ReceivingAddressListener;

/**
 * Created by xiaoyu on 2017/12/20.
 */

public class ReceivingAddressPersenter {
    private IReceivingAddressBiz iReceivingAddressBiz;
    private IReceivingAddressView iReceivingAddressView;

    public ReceivingAddressPersenter(IReceivingAddressView iReceivingAddressView) {
        iReceivingAddressBiz = IBizFactory.getReceivingAddressList();
        this.iReceivingAddressView = iReceivingAddressView;
    }

    public  void getData(String token,int cyzx_id){
        iReceivingAddressBiz.getdata(new ReceivingAddressListener() {
            @Override
            public void OnSuccess(ReceivingAddressBean receivingAddressBean) {
                iReceivingAddressView.setdata(receivingAddressBean);
            }

            @Override
            public void onTokenFail() {
                iReceivingAddressView.setTokenFail();
            }

            @Override
            public void onFailure(String code) {

            }
        },token,cyzx_id);
    }
}
