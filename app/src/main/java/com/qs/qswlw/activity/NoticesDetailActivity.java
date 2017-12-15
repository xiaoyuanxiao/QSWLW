package com.qs.qswlw.activity;

import android.content.Intent;
import android.widget.LinearLayout;

import com.qs.qswlw.NoticesDetailBinding;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.NoticesBean;
import com.qs.qswlw.utils.ScreenUtils;

/**
 * Created by xiaoyu on 2017/12/13.
 */

public class NoticesDetailActivity extends BaseDataBindingActivity {

    private NoticesDetailBinding noticesDetailBinding;

    @Override
    protected int initview() {
        return R.layout.activity_noticesdetail;
    }

    @Override
    protected void initdatabinding() {
        noticesDetailBinding = getBind();
        setDataTitle("公告详情");
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        NoticesBean noticesBeen = intent.getParcelableExtra("noticesBeen");
        noticesDetailBinding.tvNoticesTitle.setText(noticesBeen.getIndex_title());
        noticesDetailBinding.tvNoticesContent.setText(noticesBeen.getIndex_content());
        noticesDetailBinding.tvNoticesName.setText(noticesBeen.getIndex_name());
        noticesDetailBinding.tvNoticesDepartment.setText(noticesBeen.getIndex_faburen());
        noticesDetailBinding.tvNoticesTime.setText(noticesBeen.getIndex_time());
        // 获取屏幕信息
        int width = ScreenUtils.getScreenWidth(this)-60;
        noticesDetailBinding.rlDialogmainBg.setLayoutParams(new LinearLayout.LayoutParams(width, width-20));
    }
}
