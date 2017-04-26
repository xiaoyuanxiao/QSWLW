package com.qs.qswlw.activity.mall;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.QSGuessGVAdapter;
import com.qs.qswlw.adapter.QSHotGVAdapter;
import com.qs.qswlw.adapter.QSNewGVAdapter;

/**
 * Created by xiaoyu on 2017/4/25.
 */

public class QSMallActivity extends BaseActivity {

    private GridView gv_qsmall,gv_new_qsmall,gv_hot_qsmall,gv_guess_qsmall;
    private RadioButton rb_homepage,rb_qs,rb_mall,rb_shoppingCart,rb_mine;

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
        rb_homepage = (RadioButton) findViewById(R.id.rb_homepage);
        rb_qs = (RadioButton) findViewById(R.id.rb_qs);
        rb_mall = (RadioButton) findViewById(R.id.rb_mall);
        rb_shoppingCart = (RadioButton) findViewById(R.id.rb_shoppingCart);
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);

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
        rb_homepage.setOnClickListener(this);
        rb_qs.setOnClickListener(this);
        rb_mall.setOnClickListener(this);
        rb_shoppingCart.setOnClickListener(this);
        rb_mine.setOnClickListener(this);
        gv_qsmall.setOnItemClickListener(new GVOnItemClickListener());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_homepage:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.rb_qs:
                startActivity(new Intent(this,QSMallActivity.class));
                finish();
                break;
            case R.id.rb_mall:
                startActivity(new Intent(this,AllianceMallActivity.class));
                finish();
                break;
            case R.id.rb_shoppingCart:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                finish();
                break;
            case R.id.rb_mine:
                break;
        }

    }

    private class GVOnItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(QSMallActivity.this,QSMallListActivity.class);
            startActivity(intent);
        }
    }
}
