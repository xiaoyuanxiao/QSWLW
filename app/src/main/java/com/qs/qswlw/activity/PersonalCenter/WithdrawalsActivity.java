package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.WithdrawalsBean;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsView;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsPersenter;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class WithdrawalsActivity extends BaseInfoActivity implements IWithdrawalsView {

    private ImageView iv_withdrawals_right;
    private TextView tv_html,tv_withdrawals_bank,tv_withdrawals_banknumber
            ,tv_withdrawals_one_right,tv_withdrawals_two,tv_withdrawals_three;
    private WithdrawalsPersenter withdrawalsPersenter = new WithdrawalsPersenter(this);

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_withdrawals, null);
        iv_withdrawals_right = (ImageView) inflate.findViewById(R.id.iv_withdrawals_right);
        tv_withdrawals_three = (TextView) inflate.findViewById(R.id.tv_withdrawals_three);
        tv_html = (TextView) inflate.findViewById(R.id.tv_html);
        tv_withdrawals_bank = (TextView) inflate.findViewById(R.id.tv_withdrawals_bank);
        tv_withdrawals_banknumber = (TextView) inflate.findViewById(R.id.tv_withdrawals_banknumber);
        tv_withdrawals_one_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_one_right);
        tv_withdrawals_two = (TextView) inflate.findViewById(R.id.tv_withdrawals_two);
        tv_withdrawals_three = (TextView) inflate.findViewById(R.id.tv_withdrawals_three);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("提现");
        tv_titlebar_right.setText("提现记录");
    }

    @Override
    public void initData() {
        super.initData();
        withdrawalsPersenter.getdata(MyApplication.TOKEN);
    }

    @Override
    public void setOnclick() {
        super.setOnclick();
        tv_titlebar_right.setOnClickListener(this);
        iv_withdrawals_right.setOnClickListener(this);
        tv_withdrawals_three.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this,WithdrawalsRecordActivity.class));
                break;
            case R.id.iv_withdrawals_right:
                Intent intent = new Intent(this,WithdrawalsBankActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_withdrawals_three:
                showDialog();
                break;
        }
    }
    private RadioGroup rg_dialog_consumption;
    private void showDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View alertview = LayoutInflater.from(this).inflate(R.layout.dialog_consumption_percent, null);
        alertview.findViewById(R.id.eb_two).setVisibility(View.GONE);
        final RadioButton eb_one = (RadioButton) alertview.findViewById(R.id.eb_one);
        eb_one.setText("创新模式(二)");
        rg_dialog_consumption = (RadioGroup) alertview.findViewById(R.id.rg_dialog_consumption);
        rg_dialog_consumption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.eb_one:
                        tv_withdrawals_three.setText(eb_one.getText().toString());
                    break;
                }
                dialog.dismiss();
            }

        });

        dialog.setView(alertview);
        dialog.show();
    }

    @Override
    public void setdata(WithdrawalsBean withdrawalsBean) {
        String content = withdrawalsBean.getContent();
        String replace = content.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "”").replace("&amp;", "&");
        tv_html.setText(Html.fromHtml(replace));
        tv_withdrawals_bank.setText(withdrawalsBean.getBank().getCardxy());
        tv_withdrawals_banknumber.setText(withdrawalsBean.getBank().getNumber());
        tv_withdrawals_one_right.setText(withdrawalsBean.getUser().getGold2()+"颗");
        tv_withdrawals_two.setText(withdrawalsBean.getTotal_count_cash());
    }
}
