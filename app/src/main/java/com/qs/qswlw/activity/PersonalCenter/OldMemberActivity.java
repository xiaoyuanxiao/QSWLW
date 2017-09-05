package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.OldMemberBean;
import com.qs.qswlw.bean.ValidateOldMemberBean;
import com.qs.qswlw.okhttp.Iview.IOldMemberView;
import com.qs.qswlw.okhttp.Iview.IValidateOldMemberView;
import com.qs.qswlw.okhttp.Presenter.OldMemberPresenter;
import com.qs.qswlw.okhttp.Presenter.ValidateOldMemberPresenter;

/**
 * Created by xiaoyu on 2017/5/11.
 */

public class OldMemberActivity extends BaseInfoActivity implements IOldMemberView,IValidateOldMemberView {
    private Spinner spinner_oldmember;
    private ArrayAdapter<CharSequence> classification_adapter;
    private String strClassification;
    private EditText edt_oldmember;
    private Button btn_oldmember;
    private OldMemberPresenter oldMemberPresenter = new OldMemberPresenter(this);
    private ValidateOldMemberPresenter validateOldMemberPresenter = new ValidateOldMemberPresenter(this);
    private String type;
    private LinearLayout ll_top,ll_edtOldMember,ll_oldmember;
    private TextView tv_oldmember_userid,tv_oldmember_name,tv_oldmember_type,tv_oldmember_role,tv_oldmember_id,tv_oldmember_nickname;
    private ImageView iv_setting_avater;


    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_oldmember, null);
        edt_oldmember = (EditText) inflate.findViewById(R.id.edt_oldmember);
        btn_oldmember = (Button) inflate.findViewById(R.id.btn_oldmember);
        ll_top = (LinearLayout) inflate.findViewById(R.id.ll_top);
        ll_edtOldMember = (LinearLayout) inflate.findViewById(R.id.ll_edtOldMember);
        ll_oldmember = (LinearLayout) inflate.findViewById(R.id.ll_oldmember);
        tv_oldmember_userid = (TextView) inflate.findViewById(R.id.tv_oldmember_userid);
        tv_oldmember_name = (TextView) inflate.findViewById(R.id.tv_oldmember_name);
        tv_oldmember_type = (TextView) inflate.findViewById(R.id.tv_oldmember_type);
        tv_oldmember_role = (TextView) inflate.findViewById(R.id.tv_oldmember_role);
        tv_oldmember_id = (TextView) inflate.findViewById(R.id.tv_oldmember_id);
        tv_oldmember_nickname = (TextView) inflate.findViewById(R.id.tv_oldmember_nickname);
        iv_setting_avater = (ImageView) inflate.findViewById(R.id.iv_setting_avater);

        return inflate;
    }
    @Override
    public void setOldMemberViewData(OldMemberBean oldMemberBean) {



    }

    @Override
    public void setValidateOldMemberViewData(ValidateOldMemberBean validateOldMemberBean) {
        if(validateOldMemberBean==null){
            ll_oldmember.setVisibility(View.GONE);
            ll_edtOldMember.setVisibility(View.VISIBLE);
        }else{
            ll_oldmember.setVisibility(View.VISIBLE);
            ll_edtOldMember.setVisibility(View.GONE);
            tv_oldmember_userid.setText("会员编号："+validateOldMemberBean.getOld_userid());
            tv_oldmember_name.setText("会员姓名："+validateOldMemberBean.getOld_user_name());
            tv_oldmember_type.setText("会员类型："+validateOldMemberBean.getOld_user_type().toUpperCase()+"网会员");
        }

    }
    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("验证老会员");
        validateOldMemberPresenter.getData(MyApplication.TOKEN);

    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner();
        tv_oldmember_id.setText("ID:"+ MyApplication.ID);
        tv_oldmember_role.setText(MyApplication.USERROLE);
        tv_oldmember_nickname.setText("昵称："+ MyApplication.NICKNAME);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        btn_oldmember.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_oldmember:

                oldMemberPresenter.getData(MyApplication.TOKEN,edt_oldmember.getText().toString().trim(),type);
                break;
        }
    }

    /**
     * 经营分类spinner
     */
    private void loadSpinner() {
        spinner_oldmember = (Spinner) findViewById(R.id.spinner_oldmember);
        classification_adapter = ArrayAdapter.createFromResource(this, R.array.membertypes_oldmember, android.R.layout.simple_spinner_item);
        classification_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_oldmember.setAdapter(classification_adapter);
        spinner_oldmember.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner_oldmember.getSelectedItemPosition();
                strClassification = spinner_oldmember.getSelectedItem().toString();
                if(i==0){
                    type = "a";
                }else if(i==1){
                    type = "b";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



}