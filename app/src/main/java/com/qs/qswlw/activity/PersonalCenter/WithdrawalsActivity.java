package com.qs.qswlw.activity.PersonalCenter;

import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.bean.WithdrawalsBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IWithdrawalsView;
import com.qs.qswlw.okhttp.Presenter.WithdrawalsPersenter;
import com.qs.qswlw.utils.ActivityManagerUtils;
import com.qs.qswlw.utils.DialogUtils;
import com.qs.qswlw.utils.ToastUtils;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/4/3.
 */

public class WithdrawalsActivity extends BaseInfoActivity implements IWithdrawalsView {

    private ImageView iv_withdrawals_right;
    private TextView tv_html, tv_withdrawals_bank, tv_withdrawals_banknumber,
            tv_withdrawals_one_right, tv_withdrawals_two_right, tv_withdrawals_three_right,
            tv_withdrawals_four_right,tv_withdrawals_five,tv_withdrawals_sex_right;
    private WithdrawalsPersenter withdrawalsPersenter = new WithdrawalsPersenter(this);
    private Button btn_withdrawals_confirm;
    private EditText edt_withdrawals_password;
    private String model = "model2";
    private RadioGroup rg_dialog_consumption;
    private View inflate;

    @Override
    public View setConetnView() {
        inflate = View.inflate(this, R.layout.activity_withdrawals, null);
        iv_withdrawals_right = (ImageView) inflate.findViewById(R.id.iv_withdrawals_right);
        tv_withdrawals_three_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_three_right);
        tv_html = (TextView) inflate.findViewById(R.id.tv_html);
        tv_withdrawals_bank = (TextView) inflate.findViewById(R.id.tv_withdrawals_bank);
        tv_withdrawals_banknumber = (TextView) inflate.findViewById(R.id.tv_withdrawals_banknumber);
        tv_withdrawals_one_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_one_right);
        tv_withdrawals_two_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_two_right);
        tv_withdrawals_four_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_four_right);
        btn_withdrawals_confirm = (Button) inflate.findViewById(R.id.btn_withdrawals_confirm);
        edt_withdrawals_password = (EditText) inflate.findViewById(R.id.edt_withdrawals_password);
        tv_withdrawals_five = (TextView) inflate.findViewById(R.id.tv_withdrawals_five);
        tv_withdrawals_sex_right = (TextView) inflate.findViewById(R.id.tv_withdrawals_sex_right);

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
        btn_withdrawals_confirm.setOnClickListener(this);
        tv_withdrawals_five.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_titlebar_right:
                startActivity(new Intent(this, WithdrawalsRecordActivity.class));
                break;
            case R.id.iv_withdrawals_right:
                Intent intent = new Intent(this, WithdrawalsBankActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.tv_withdrawals_five:
                DialogUtils.showDidlog(this, new String[]{"创业模式一","创新模式"}, tv_withdrawals_five);
                break;
            case R.id.btn_withdrawals_confirm:
                String s = tv_withdrawals_five.getText().toString();
                if (s.contains("创新模式")) {
                    model = "model2";
                } else if (s.contains("创业模式一")) {
                    model = "model1";
                }
                String money = tv_withdrawals_sex_right.getText().toString().trim();
                String pass = edt_withdrawals_password.getText().toString().trim();
                if (money.equals("")) {
                    ToastUtils.showToast("请输入提现金额");
                }
                if (pass.equals("")) {
                    ToastUtils.showToast("请输入二级密码");
                }else{
                    PostData(MyApplication.TOKEN, Float.parseFloat(money),pass, model);
                }

                break;
        }
    }

    /**
     * 提现申请
     */
    private void PostData(final String token, final float money, final String pass, final String gold_model) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean>() {

            @Override
            public void onError(Throwable e) {
                Log.e("PostData", e + "");
            }

            @Override
            public void onNext(MainBean mainBean) {
                String msg = mainBean.getMsg();
                ToastUtils.showToast(msg);

            }

            @Override
            public Observable<MainBean> getObservable(MyRetroService retrofit) {
                return retrofit.PostWithDrawalsData(token, money, pass, gold_model);
            }
        });


    }


    @Override
    public void setdata(WithdrawalsBean withdrawalsBean) {
        String content = "&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;1.提现请完善个人银行卡资料。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;2.每笔提现扣除你所获得全部金豆5%的手续费。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;3.每笔提现T+2到账。&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;color: rgb(34, 34, 34); white-space: pre-wrap; background-color: rgb(255, 255, 255); font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;咨询电话：400-8071728（工作时间：09:00~17:00）&lt;/span&gt;&lt;/p&gt;&lt;p style=&quot;white-space: normal;&quot;&gt;&lt;span style=&quot;color: rgb(34, 34, 34); white-space: pre-wrap; background-color: rgb(255, 255, 255); font-family: 微软雅黑, &amp;quot;Microsoft YaHei&amp;quot;;&quot;&gt;&lt;/span&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;";
        String replace = content.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "”").replace("&amp;", "&");
        tv_html.setText(Html.fromHtml(replace));
        if(withdrawalsBean.getBank()!=null){
            tv_withdrawals_bank.setText(withdrawalsBean.getBank().getCardxy());
            tv_withdrawals_banknumber.setText(withdrawalsBean.getBank().getNumber());
        }else{
            tv_withdrawals_bank.setText("没有记录");
            tv_withdrawals_banknumber.setText("没有记录");
        }

        if(MyApplication.ROLE.equals("0")){
            inflate.findViewById(R.id.rl_withdrawals_one).setVisibility(View.GONE);
            inflate.findViewById(R.id.rl_withdrawals_two).setVisibility(View.GONE);
            inflate.findViewById(R.id.view_withdrawals_one).setVisibility(View.GONE);
            inflate.findViewById(R.id.view_withdrawals_two).setVisibility(View.GONE);
        }else{
            tv_withdrawals_one_right.setText(withdrawalsBean.getUser().getGold() + "颗");
            tv_withdrawals_two_right.setText(withdrawalsBean.getRawals_count() + "颗");
        }
        tv_withdrawals_three_right.setText(withdrawalsBean.getUser().getGold2() + "颗");
        if(withdrawalsBean.getRawals_count_two()==null){
            tv_withdrawals_four_right.setText( "0颗");
        }else{
            tv_withdrawals_four_right.setText( withdrawalsBean.getRawals_count_two()+"颗");
        }

    }

    @Override
    public void setTokenFail() {
        ActivityManagerUtils.getInstance().tokenfailfg(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 4) {
                withdrawalsPersenter.getdata(MyApplication.TOKEN);
            }
        }
    }
}
