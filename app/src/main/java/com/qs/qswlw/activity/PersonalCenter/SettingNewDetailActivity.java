package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;

import com.qs.qswlw.NewDetailBinding;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseDataBindingActivity;
import com.qs.qswlw.bean.SettingNewsBean;
import com.qs.qswlw.utils.DateUtils;

/**
 * Created by xiaoyu on 2017/12/15.
 */

public class SettingNewDetailActivity extends BaseDataBindingActivity {

    private NewDetailBinding newDetailBinding;
    private SettingNewsBean.MessageBean messageBean;

    @Override
    protected int initview() {
        return R.layout.activity_setting_newdetail;
    }

    @Override
    protected void initdatabinding() {
        newDetailBinding = getBind();
        setDataTitle("信息内容");
        setTitleRightimg(R.mipmap.shezhi);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        messageBean = intent.getParcelableExtra("messageBean");
        newDetailBinding.tvItemNewdetailTime.setText(DateUtils.long2date(Long.parseLong(messageBean.getSend_time()) * 1000L));
        newDetailBinding.tvItemNewdetailContent.setText(messageBean.getMessage());

    }
}
