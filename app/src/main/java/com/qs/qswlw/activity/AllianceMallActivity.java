package com.qs.qswlw.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.AllianceMallLVAdapter;

/**
 * Created by xiaoyu on 2017/4/24.
 */

public class AllianceMallActivity extends BaseActivity {

    private GridView gv_alliancemall;
    private AllianceMallGVAdapter allianceMallGVAdapter;
    private ListView lv_alliancemall;
    private AllianceMallLVAdapter allianceMallLVAdapter;
    private RadioButton rb_alliancemall_homepage,rb_alliancemall_qs,rb_alliancemall,rb_alliancemall_ShoppingCart,rb_alliancemall_mine;

    @Override
    public Object initView() {
        return R.layout.activity_alliancemall;
    }

    @Override
    public void initfindviewByid() {
        gv_alliancemall = (GridView) findViewById(R.id.gv_alliancemall);
        lv_alliancemall = (ListView) findViewById(R.id.lv_alliancemall);
        rb_alliancemall_homepage = (RadioButton) findViewById(R.id.rb_alliancemall_homepage);
        rb_alliancemall_qs = (RadioButton) findViewById(R.id.rb_alliancemall_qs);
        rb_alliancemall = (RadioButton) findViewById(R.id.rb_alliancemall);
        rb_alliancemall_ShoppingCart = (RadioButton) findViewById(R.id.rb_alliancemall_ShoppingCart);
        rb_alliancemall_mine = (RadioButton) findViewById(R.id.rb_alliancemall_mine);


    }

    @Override
    public void initData() {
        super.initData();
        allianceMallGVAdapter = new AllianceMallGVAdapter(this);
        allianceMallLVAdapter = new AllianceMallLVAdapter(this);
        gv_alliancemall.setAdapter(allianceMallGVAdapter);
        lv_alliancemall.setAdapter(allianceMallLVAdapter);
    }

    @Override
    public void setOnclick() {
        rb_alliancemall_homepage.setOnClickListener(this);
        rb_alliancemall_qs.setOnClickListener(this);
        rb_alliancemall.setOnClickListener(this);
        rb_alliancemall_ShoppingCart.setOnClickListener(this);
        rb_alliancemall_mine.setOnClickListener(this);
        lv_alliancemall.setOnItemClickListener(new LVItemClickListener());
        gv_alliancemall.setOnItemClickListener(new GVItemClickListener());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb_alliancemall_homepage:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.rb_alliancemall_qs:
                startActivity(new Intent(this,QSMallActivity.class));
                finish();
                break;
            case R.id.rb_alliancemall:
                startActivity(new Intent(this,AllianceMallActivity.class));
                finish();
                break;
            case R.id.rb_alliancemall_ShoppingCart:
                startActivity(new Intent(this,ShoppingCartActivity.class));
                finish();
                break;
            case R.id.rb_alliancemall_mine:
                break;
        }

    }

    /**
     * listview的点击事件
     */
    private class LVItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            startActivity(new Intent(AllianceMallActivity.this,AllianceMallDetailActivity.class));
        }
    }

    /**
     * Gridview的点击事件
     */
    private class GVItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }
    }
}
