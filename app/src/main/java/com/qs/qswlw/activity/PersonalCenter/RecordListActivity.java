package com.qs.qswlw.activity.PersonalCenter;

import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/4/5.
 */

public class RecordListActivity extends BaseInfoActivity {


    private RelativeLayout rl_recordlist_left, rl_recordlist_right;
    private TextView tv_recordlist_left, tv_recordlist_right;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_recordlist, null);
        rl_recordlist_left = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_left);
        rl_recordlist_right = (RelativeLayout) inflate.findViewById(R.id.rl_recordlist_right);
        tv_recordlist_left = (TextView) inflate.findViewById(R.id.tv_recordlist_left);
        tv_recordlist_right = (TextView) inflate.findViewById(R.id.tv_recordlist_right);

        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("录单记录");
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        //点击radioButton切换到指定页面
        rl_recordlist_left.setOnClickListener(this);
        rl_recordlist_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_recordlist_left:
                showDialog("1");
                break;
            case R.id.rl_recordlist_right:
                showDialog("2");
                break;
        }
    }

    String tv_recordlist_Text;

    void showDialog(final String a) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View alertview = LayoutInflater.from(RecordListActivity.this).inflate(R.layout.dialog_recordlist, null);
        final RadioButton rb_recordlist_one = (RadioButton) alertview.findViewById(R.id.rb_recordlist_one);
        final RadioButton rb_recordlist_two = (RadioButton) alertview.findViewById(R.id.rb_recordlist_two);
        final Button btn_recordlist_confirm = (Button) alertview.findViewById(R.id.btn_recordlist_confirm);
        final Button btn_recordlist_cancel = (Button) alertview.findViewById(R.id.btn_recordlist_cancel);
        final RadioGroup rg_recordlist_dialog = (RadioGroup) alertview.findViewById(R.id.rg_recordlist_dialog);
        if ("1".equals(a)) {
            rb_recordlist_one.setText("创新模式");
            rb_recordlist_two.setText("创业模式");
            //   tv_recordlist_left.setText();
        } else if ("2".equals(a)) {
            rb_recordlist_one.setText("已审核");
            rb_recordlist_two.setText("未审核");
        }
        rg_recordlist_dialog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.rb_recordlist_one:
                        tv_recordlist_Text = rb_recordlist_one.getText().toString();
                        break;
                    case R.id.rb_recordlist_two:
                        tv_recordlist_Text = rb_recordlist_two.getText().toString();
                        break;
                }
            }
        });
        btn_recordlist_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if ("1".equals(a)) {
                    tv_recordlist_left.setText(tv_recordlist_Text);
                } else if ("2".equals(a)) {
                    tv_recordlist_right.setText(tv_recordlist_Text);
                }
            }
        });
        btn_recordlist_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setView(alertview);
        dialog.show();
    }


}
