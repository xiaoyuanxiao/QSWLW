package com.qs.qswlw.activity.mall;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.BaseActivity;
import com.qs.qswlw.activity.MainActivity;
import com.qs.qswlw.adapter.AllianceMallGVAdapter;
import com.qs.qswlw.adapter.AllianceMallLVAdapter;
import com.qs.qswlw.utils.ToastUtils;

                                                           /**
 * Created by xiaoyu on 2017/4/24.
 */

public class AllianceMallActivity extends BaseActivity {

    private GridView gv_alliancemall;
    private AllianceMallGVAdapter allianceMallGVAdapter;
    private ListView lv_alliancemall;
    private AllianceMallLVAdapter allianceMallLVAdapter;
    private RadioButton rb_homepage,rb_qs,rb_mall,rb_shoppingCart,rb_mine;
    private EditText edt_search;
    private ImageView iv_search;

    @Override
    public Object initView() {
        return R.layout.activity_alliancemall;
    }

    @Override
    public void initfindviewByid() {
        gv_alliancemall = (GridView) findViewById(R.id.gv_alliancemall);
        lv_alliancemall = (ListView) findViewById(R.id.lv_alliancemall);
        rb_homepage = (RadioButton) findViewById(R.id.rb_homepage);
        rb_qs = (RadioButton) findViewById(R.id.rb_qs);
        rb_mall = (RadioButton) findViewById(R.id.rb_mall);
        rb_shoppingCart = (RadioButton) findViewById(R.id.rb_shoppingCart);
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);
        edt_search = (EditText) findViewById(R.id.edt_search);
        iv_search = (ImageView) findViewById(R.id.iv_search);


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
        rb_homepage.setOnClickListener(this);
        rb_qs.setOnClickListener(this);
        rb_mall.setOnClickListener(this);
        rb_shoppingCart.setOnClickListener(this);
        rb_mine.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        lv_alliancemall.setOnItemClickListener(new LVItemClickListener());
        gv_alliancemall.setOnItemClickListener(new GVItemClickListener());

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
            case R.id.iv_search:
                String s = edt_search.getText().toString();
                if(!"".equals(s)){
                    //调取接口
                }else                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              {
                    ToastUtils.showToast(this,"搜索内容不能为空哦");
                }
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
