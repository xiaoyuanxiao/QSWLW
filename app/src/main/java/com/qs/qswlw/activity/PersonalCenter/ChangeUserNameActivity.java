package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.utils.StringUtils;
import com.qs.qswlw.utils.ToastUtils;

import java.util.regex.Pattern;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/5/10.
 */

public class ChangeUserNameActivity extends BaseInfoActivity {
    //匹配非表情符号的正则表达式
    private final String reg = "^([a-z]|[A-Z]|[0-9]|[\u2E80-\u9FFF]){3,}|@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?|[wap.]{4}|[www.]{4}|[blog.]{5}|[bbs.]{4}|[.com]{4}|[.cn]{3}|[.net]{4}|[.org]{4}|[http://]{7}|[ftp://]{6}$";
    private EditText edt_change_userName;
    private String userName;
    private TextView tv_title_right;
    //是否重置了EditText的内容
    private boolean resetText;
    private Pattern pattern = Pattern.compile(reg);
    //输入表情前的光标位置
    private int cursorPos;
    //输入表情前EditText中的文本
    private String tmp;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_changeusername, null);
        edt_change_userName = (EditText) inflate.findViewById(R.id.edt_change_userName);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("用户名编辑");
        tv_titlebar_right.setText("保存");
    }

    @Override
    public void initData() {
        super.initData();
        userName = getIntent().getStringExtra("userName");
        edt_change_userName.setText(userName);
        edt_change_userName.setSelection(edt_change_userName.getText().length());

    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_titlebar_right:
                editUserName();
                break;
        }
    }

    private void editUserName() {
        String ss=edt_change_userName.getText().toString().trim();
        final String name1= StringUtils.containsEmoji(ss);
        Intent intent = new Intent();
        intent.putExtra("back", name1);
        setResult(RESULT_OK, intent);
        finish();
        
        postUserName(MyApplication.TOKEN, Integer.parseInt(MyApplication.ID),name1);
    }

    private void postUserName(final String token, final int user_id, final String username) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("postUserName",e+"");
            }

            @Override
            public void onNext(MainBean mainBean) {
                Log.e("mainBean",mainBean+"");
                ToastUtils.showToast(mainBean.getMsg());
            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.getUserNameData(token,user_id,username);
            }
        });
    }

}
