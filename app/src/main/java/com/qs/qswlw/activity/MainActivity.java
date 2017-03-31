package com.qs.qswlw.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qs.qswlw.R;
import com.qs.qswlw.view.imageswitchview.Image3DSwitchView;
import com.qs.qswlw.view.imageswitchview.Image3DView;

/**
 * Created by 小羽 on 2017/3/22.
 */
public class MainActivity extends BaseActivity {
    private Image3DSwitchView imageSwitchView;
    private String[] listViewData = new String[]{
            "test1", "test2", "test3",
            "test4"};
    ImageView iv_main_avater;
    private View view;
    private TextView tv_item_home_head;

    @Override
    public Object initView() {
        return R.layout.activity_main;
    }

    @Override
    public void initfindviewByid() {
        imageSwitchView = (Image3DSwitchView) findViewById(R.id.image_switch_view);
        Image3DView list1 = (Image3DView) findViewById(R.id.list1);
        Image3DView list2 = (Image3DView) findViewById(R.id.list2);
        Image3DView list3 = (Image3DView) findViewById(R.id.list3);
        Image3DView list4 = (Image3DView) findViewById(R.id.list4);
        Image3DView list5 = (Image3DView) findViewById(R.id.list5);
        Image3DView list6 = (Image3DView) findViewById(R.id.list6);
        view = LayoutInflater.from(this).inflate(R.layout.item_home_head, null);
        tv_item_home_head = (TextView) view.findViewById(R.id.tv_item_home_head);
        iv_main_avater = (ImageView) findViewById(R.id.iv_main_avater);


        imageSwitchView.setCurrentImage(1);

        tv_item_home_head.setText("全联盟让利金额排行榜");

        list1.addHeaderView(view);
        list1.setBColor(Color.parseColor("#b82140"));
        list2.setBColor(Color.parseColor("#de2127"));
        list3.setBColor(Color.parseColor("#f3c68b"));
        list4.setBColor(Color.parseColor("#b82141"));
        list5.setBColor(Color.parseColor("#f2989a"));
        list6.setBColor(Color.parseColor("#cd2244"));
        TextView textView2 = new TextView(this);
        textView2.setText("查看全部排名");
        list1.addFooterView(textView2);

        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        list2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        list3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        list4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        list5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
        list6.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listViewData));
//        list1.setAdapter(new MyDataAdapter());
//        list2.setAdapter(new MyDataAdapter());
//        list3.setAdapter(new MyDataAdapter());
//        list4.setAdapter(new MyDataAdapter());
//        list5.setAdapter(new MyDataAdapter());
//        list6.setAdapter(new MyDataAdapter());

        TextView textView22 = new TextView(this);
        textView22.setText("联盟商家排行榜");
        list2.addHeaderView(textView22);


        TextView textView3 = new TextView(this);
        textView3.setText("全联盟创业日值");
        list3.addHeaderView(textView3);

        TextView textView4 = new TextView(this);
        textView4.setText("创业天使创业排名榜");
        list4.addHeaderView(textView4);


        TextView textView5 = new TextView(this);
        textView5.setText("中国好产品排行榜");
        list5.addHeaderView(textView5);


        TextView textView6 = new TextView(this);
        textView6.setText("拼手气促销抽奖名单");
        list6.addHeaderView(textView6);


    }

    @Override
    public void setOnclick() {
        iv_main_avater.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_main_avater:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imageSwitchView.clear();
    }

    private class MyDataAdapter extends BaseAdapter {
        private String[] keys = {"前海公司", "飞腾公司", "前海公司", "飞腾公司", "飞腾公司"};
        private String[] values = {"11111万", "22222万", "33333万", "44444万", "55555万"};

        @Override
        public int getCount() {
            return keys.length;
        }

        @Override
        public Object getItem(int i) {
            return keys[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(MainActivity.this, R.layout.item_home_content, null);
            TextView key = (TextView) inflate.findViewById(R.id.tv_item_home_content_left);
            TextView value = (TextView) inflate.findViewById(R.id.tv_item_home_content_value);
            key.setText(keys[i]);
            value.setText(values[i]);
            return view;
        }
    }
}
