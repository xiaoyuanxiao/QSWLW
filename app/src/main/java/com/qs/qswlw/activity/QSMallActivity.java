package com.qs.qswlw.activity;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.QSGuessGVAdapter;
import com.qs.qswlw.adapter.QSHotGVAdapter;
import com.qs.qswlw.adapter.QSNewGVAdapter;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class QSMallActivity extends BaseActivity {

    private GridView gv_qsmall,gv_new_qsmall,gv_hot_qsmall,gv_guess_qsmall;
    private RadioButton rb_qsmall_homepage,rb_qsmall_qs,rb_qsmall,rb_qsmall_ShoppingCart,rb_qsmall_mine;

    @Override
    public Object initView() {
        return R.layout.activity_qsmall;
    }

    @Override
    public void initfindviewByid() {
        gv_qsmall = (GridView) findViewById(R.id.gv_qsmall);
        gv_new_qsmall = (GridView) findViewById(R.id.gv_new_qsmall);
        gv_hot_qsmall = (GridView) findViewById(R.id.gv_hot_qsmall);
        gv_guess_qsmall = (GridView) findViewById(R.id.gv_guess_qsmall);
        rb_qsmall_homepage = (RadioButton) findViewById(R.id.rb_qsmall_homepage);
        rb_qsmall_qs = (RadioButton) findViewById(R.id.rb_qsmall_qs);
        rb_qsmall = (RadioButton) findViewById(R.id.rb_qsmall);
        rb_qsmall_ShoppingCart = (RadioButton) findViewById(R.id.rb_qsmall_ShoppingCart);
        rb_qsmall_mine = (RadioButton) findViewById(R.id.rb_qsmall_mine);

    }

    @Override
    public void initData() {
        super.initData();
        gv_qsmall.setAdapter(new AllianceMallGVAdapter(this));
        gv_new_qsmall.setAdapter(new QSNewGVAdapter(this));
        gv_hot_qsmall.setAdapter(new QSHotGVAdapter(this));
        gv_guess_qsmall.setAdapter(new QSGuessGVAdapter(this));
    }

    @Override
    public void setOnclick() {
        rb_qsmall_homepage.setOnClickListener(this);
        rb_qsmall_qs.setOnClickListener(this);
        rb_qsmall.setOnClickListener(this);
        rb_qsmall_ShoppingCart.setOnClickListener(this);
        rb_qsmall_mine.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_qsmall_homepage:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.rb_qsmall_qs:
                startActivity(new Intent(this,QSMallActivity.class));
                finish();
                break;
            case R.id.rb_qsmall:
                startActivity(new Intent(this,AllianceMallActivity.class));
                finish();
                break;
            case R.id.rb_qsmall_ShoppingCart:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                finish();
                break;
            case R.id.rb_qsmall_mine:
                break;
        }

    }
}
